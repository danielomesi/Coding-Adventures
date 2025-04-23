package puzzle;


import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;

//Daniel Omesi


public class SolveJigsaw {

    static class Match {
        Point location;
        int width, height;
        int rotation; // in degrees: 0, 90, 180, 270
        double score;

        Match(Point location, int width, int height, int rotation, double score) {
            this.location = location;
            this.width = width;
            this.height = height;
            this.rotation = rotation;
            this.score = score;
        }
    }

    public static final String SMALL_PICTURE_PATH = "small-picture.png";
    public static final String PIECES_DIRECTORY_NAME = "small-pieces";
    public static final AtomicInteger matchesCounter = new AtomicInteger(0);


    public static void main(String[] args) throws Exception {
        Path baseDir = Paths.get("Java","src", "puzzle");
        Path picturePath = baseDir.resolve(SMALL_PICTURE_PATH);
        Path piecesDir = baseDir.resolve(PIECES_DIRECTORY_NAME);

        List<Path> piecesPath = Utils.getPathsListOfAllPieces(piecesDir);
        System.out.println("Loaded " + piecesPath.size() + " piece images.");
        System.out.println("Solving jigsaw from picture: " + picturePath.toAbsolutePath());


        solveJigsaw(picturePath, piecesPath);
    }

    public static void solveJigsaw(Path picturePath, List<Path> piecesPaths) throws Exception {
        if (picturePath == null || !Files.exists(picturePath)) {
            throw new IllegalArgumentException("Picture path is missing or invalid.");
        }
        if (piecesPaths == null || piecesPaths.isEmpty()) {
            throw new IllegalArgumentException("No pieces provided.");
        }
        BufferedImage mainImage = ImageIO.read(picturePath.toFile());
        System.out.printf("Size of main image is %dx%d",mainImage.getWidth(),mainImage.getHeight());
        List<Match> matches = new ArrayList<>();
        boolean[][] bitmapUsed = new boolean[mainImage.getWidth()][mainImage.getHeight()];
        double maxMseThreshold = 2000;

        piecesPaths.parallelStream().forEach(piecePath -> {
            try {
                processPiece(piecePath, mainImage, bitmapUsed, matches, maxMseThreshold);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });


        int expectedArea = mainImage.getWidth() * mainImage.getHeight();
        int matchedArea = matches.stream().mapToInt(m -> m.width * m.height).sum();
        System.out.println("There are " + matches.size() + " matches in pieces" + "out of " + piecesPaths.size() + " pieces.");

        if (matchedArea < expectedArea) {
            System.out.println("Not enough pieces to cover the image. Missing area.");
        } else if (matchedArea > expectedArea) {
            throw new RuntimeException("Too many pieces — total area exceeds image.");
        }

        // Optional: draw and save marked image
        BufferedImage output = new BufferedImage(mainImage.getWidth(), mainImage.getHeight(), mainImage.getType());
        Graphics2D g2d = output.createGraphics();
        g2d.drawImage(mainImage, 0, 0, null);
        g2d.setColor(Color.WHITE);
        for (Match match : matches) {
            g2d.drawRect(match.location.x, match.location.y, match.width, match.height);
        }
        g2d.dispose();

        File outputFile = new File("solved-output.png");
        ImageIO.write(output, "png", outputFile);
        System.out.println("Output image written to: " + outputFile.getAbsolutePath());
    }


    private static void processPiece(Path piecePath, BufferedImage mainImage,
                                     boolean[][] bitmapUsed, List<Match> matches, double maxMseThreshold) throws Exception {
        long startProcess,endProcess;
        startProcess = System.nanoTime();
        System.out.println("Processing piece: " + piecePath.getFileName());
        BufferedImage pieceImage = ImageIO.read(piecePath.toFile());
        Match match = findBestMatchByMSE(mainImage, pieceImage, bitmapUsed, maxMseThreshold);
        endProcess = System.nanoTime();

        if (match == null) {
            System.out.println("⚠️  No match found for piece: " + piecePath.getFileName() + " — skipping.");
            return;
        }

        // 👇 Synchronize access to shared data
        synchronized (bitmapUsed) {
            for (int i = match.location.x; i < match.location.x + match.width; i++) {
                for (int j = match.location.y; j < match.location.y + match.height; j++) {
                    bitmapUsed[i][j] = true;
                }
            }
        }

        synchronized (matches) {
            matches.add(match);
        }

        int matchNum = matchesCounter.incrementAndGet(); // atomic
        System.out.printf("Match #%d at x=%d, y=%d, width=%d, height=%d (rotation=%d°, score=%.2f," +
                        "total matching process time: %.2f seconds)/n",
                matchNum, match.location.x, match.location.y, match.width,
                match.height, match.rotation, match.score,(endProcess - startProcess)/ 1_000_000_000.0);
    }



    static Match findBestMatchByMSE(BufferedImage mainImage, BufferedImage piece, boolean[][] bitmapUsed , double maxMseThreshold) {
        BufferedImage[] rotations = new BufferedImage[]{
                piece,
                ImageUtils.rotateImageBy90Degrees(piece, 1),
                ImageUtils.rotateImageBy90Degrees(piece, 2),
                ImageUtils.rotateImageBy90Degrees(piece, 3)
        };

        Match bestOverallMatch = null;
        double bestOverallScore = Double.MAX_VALUE;
        long startTotal,startRotation,startMSECompute,midRotation,endMSECompute,endRotation,endTotal;
        startTotal = System.nanoTime();

        System.out.printf("🔍 Searching a match for a piece of size %dx%d...\n", piece.getWidth(), piece.getHeight());

        for (int r = 0; r < rotations.length; r++) {
            startRotation = System.nanoTime();
            BufferedImage rotated = rotations[r];
            int pieceWidth = rotated.getWidth();
            int pieceHeight = rotated.getHeight();
            int maxX = mainImage.getWidth() - pieceWidth;
            int maxY = mainImage.getHeight() - pieceHeight;
            final int currentRotation = r;

            List<Point> candidatePoints = new ArrayList<>();
            for (int x = 0; x <= maxX; x += 1) {
                for (int y = 0; y <= maxY; y += 1) {
                    if (!Utils.isOverlapping(bitmapUsed, x, y, pieceWidth, pieceHeight)) {
                        candidatePoints.add(new Point(x, y));
                    }

                }
            }
            midRotation = System.nanoTime();

            System.out.printf("In piece (size %dx%d) rotated by %d° there were %d candidates found (time to find candidates: %.2f seconds)%n",
                    pieceWidth, pieceHeight, r * 90, candidatePoints.size(), (midRotation - startRotation) / 1_000_000_000.0);


            Match bestRotationMatch = null;
            double bestRotationScore = Double.MAX_VALUE;

            System.out.printf("Finding the best point from the candidates of piece (size %dx%d) rotated by %d°...%n",
                    pieceWidth, pieceHeight, r * 90);
            ;
            startMSECompute = System.nanoTime();
            final double earlyExitThreshold = bestOverallScore; // copy the current best
            Color pieceAvg =  ImageUtils.computeAverageColor(rotated);
            Optional<Match> best = candidatePoints.parallelStream()
                    .map(pt -> {
                        Color regionAvg =  ImageUtils.computeAverageColorRegion(mainImage, pt.x, pt.y, pieceWidth, pieceHeight);
                        if (ImageUtils.colorDistance(pieceAvg, regionAvg) > 50) { // tune this threshold!
                            return null;
                        }
                        double mse = computeMse(mainImage, rotated, pt.x, pt.y,earlyExitThreshold);
                        if (mse <= maxMseThreshold) {
                            return new Match(pt, pieceWidth, pieceHeight, currentRotation * 90, mse);
                        } else {
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .min(Comparator.comparingDouble(m -> m.score));

            if (best.isPresent()) {
                Match match = best.get();
                if (match.score == 0.0) {
                    return match; // perfect match, stop everything
                }
                if (match.score < bestOverallScore) {
                    bestOverallScore = match.score;
                    bestOverallMatch = match;
                    System.out.printf("  ✅ New best match: x=%d, y=%d, rot=%d°, MSE=%.2f (piece:%dx%d rotated by %d)\n",
                            match.location.x, match.location.y, match.rotation, match.score,pieceWidth,pieceHeight,r*90);
                }
            }

            endMSECompute = System.nanoTime();
            System.out.printf("⏱️Time for best MSE Computation: %.2f seconds (piece:%dx%d rotated by %d)\n",
                    (endMSECompute - startMSECompute) / 1_000_000_000.0,pieceWidth,pieceHeight,r*90);
            if (bestRotationMatch != null) {
                Match match = bestRotationMatch;
                if (match.score < bestOverallScore) {
                    bestOverallMatch = match;
                    bestOverallScore = match.score;
                    System.out.printf("  ✅ New best match: x=%d, y=%d, rot=%d°, MSE=%.2f (piece:%dx%d rotated by %d)\n",
                            match.location.x, match.location.y, match.rotation, match.score,pieceWidth,pieceHeight,r*90);
                }
            }
        }

        if (bestOverallMatch == null) {
            System.out.println("❌ No match found under threshold.");
        } else {
            System.out.printf("🏁 Final match: x=%d, y=%d, rot=%d°, MSE=%.2f\n",
                    bestOverallMatch.location.x, bestOverallMatch.location.y, bestOverallMatch.rotation, bestOverallMatch.score);
        }

        return bestOverallMatch;
    }

    private static double computeMse(BufferedImage main, BufferedImage piece, int offsetX, int offsetY, double earlyExitThreshold) {
        int w = piece.getWidth();
        int h = piece.getHeight();
        long totalError = 0;
        int numPixels = w * h;

        for (int ix = 0; ix < w; ix++) {
            for (int iy = 0; iy < h; iy++) {
                int mainRGB = main.getRGB(offsetX + ix, offsetY + iy);
                int pieceRGB = piece.getRGB(ix, iy);
                totalError += ImageUtils.squaredColorDifference(mainRGB, pieceRGB);

                // 💥 Early stop if we're already worse than the current best
                if ((double) totalError / numPixels > earlyExitThreshold) {
                    return Double.MAX_VALUE;
                }
            }
        }

        return (double) totalError / numPixels;
    }



}
