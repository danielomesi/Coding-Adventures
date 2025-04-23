package puzzle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {
    public static List<Path> getPathsListOfAllPieces(Path piecesDir) throws IOException {
        if (!Files.isDirectory(piecesDir)) {
            throw new FileNotFoundException("Pieces directory not found: " + piecesDir.toAbsolutePath());
        }

        try (Stream<Path> paths = Files.list(piecesDir)) {
            return paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().toLowerCase().endsWith(".png"))
                    .collect(Collectors.toList());
        }
    }

    public static boolean isOverlapping(boolean[][] bitmap, int x, int y, int w, int h) {
        for (int i = x; i < x + w; i++) {
            for (int j = y; j < y + h; j++) {
                if (bitmap[i][j]) return true;
            }
        }
        return false;
    }
}
