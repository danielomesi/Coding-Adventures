package puzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageUtils {
    public static int squaredColorDifference(int rgb1, int rgb2) {
        int r1 = (rgb1 >> 16) & 0xFF;
        int g1 = (rgb1 >> 8) & 0xFF;
        int b1 = rgb1 & 0xFF;

        int r2 = (rgb2 >> 16) & 0xFF;
        int g2 = (rgb2 >> 8) & 0xFF;
        int b2 = rgb2 & 0xFF;

        int dr = r1 - r2;
        int dg = g1 - g2;
        int db = b1 - b2;

        return dr * dr + dg * dg + db * db;
    }

    public static void showImageInPopUp(BufferedImage image) {
        JFrame frame = new JFrame("Image Preview");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel(new ImageIcon(image));
        frame.getContentPane().add(label, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null); // center on screen
        frame.setVisible(true);
    }

    public static BufferedImage rotateImageBy90Degrees(BufferedImage original, int times) {
        times = times % 4;
        BufferedImage rotated = original;
        for (int i = 0; i < times; i++) {
            rotated = rotateOnceBy90(rotated);
        }
        return rotated;
    }

    public static BufferedImage rotateOnceBy90(BufferedImage original) {
        int width = original.getWidth();
        int height = original.getHeight();
        BufferedImage output = new BufferedImage(height, width, original.getType());
        Graphics2D g2d = output.createGraphics();
        g2d.translate(height / 2.0, width / 2.0);
        g2d.rotate(Math.PI / 2);
        g2d.translate(-width / 2.0, -height / 2.0);
        g2d.drawImage(original, 0, 0, null);
        g2d.dispose();
        return output;
    }

    public static Color computeAverageColorRegion(BufferedImage img, int offsetX, int offsetY, int w, int h) {
        long rSum = 0, gSum = 0, bSum = 0;

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                int rgb = img.getRGB(offsetX + x, offsetY + y);
                Color c = new Color(rgb);
                rSum += c.getRed();
                gSum += c.getGreen();
                bSum += c.getBlue();
            }
        }

        int numPixels = w * h;
        return new Color((int)(rSum / numPixels), (int)(gSum / numPixels), (int)(bSum / numPixels));
    }

    public static double colorDistance(Color c1, Color c2) {
        int dr = c1.getRed() - c2.getRed();
        int dg = c1.getGreen() - c2.getGreen();
        int db = c1.getBlue() - c2.getBlue();
        return Math.sqrt(dr * dr + dg * dg + db * db); // Euclidean distance
    }

    public static Color computeAverageColor(BufferedImage img) {
        long rSum = 0, gSum = 0, bSum = 0;
        int w = img.getWidth();
        int h = img.getHeight();

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                int rgb = img.getRGB(x, y);
                Color c = new Color(rgb);
                rSum += c.getRed();
                gSum += c.getGreen();
                bSum += c.getBlue();
            }
        }

        int numPixels = w * h;
        return new Color((int)(rSum / numPixels), (int)(gSum / numPixels), (int)(bSum / numPixels));
    }
}
