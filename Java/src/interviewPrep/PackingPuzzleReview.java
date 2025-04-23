package interviewPrep;

import java.util.*;

public class PackingPuzzleReview {

    public static final int[][][] ALL_SHAPES = {
            {
                    {1}
            },
            {
                    {1},
                    {1}
            },
            {
                    {1, 1, 1}
            },
            {
                    {1, 1},
                    {1, 0}
            },
            {
                    {1, 1, 1, 1}
            },
            {
                    {1, 1},
                    {1, 1}
            },
            {
                    {1, 1, 1},
                    {0, 0, 1}
            },
            {
                    {0, 0, 1},
                    {1, 1, 1}
            },
            {
                    {1, 1, 1},
                    {0, 1, 0}
            },
            {
                    {1, 1, 0},
                    {0, 1, 1}
            },
            {
                    {0, 1, 1},
                    {1, 1, 0}
            }
    };

    public static void main(String[] args) {
        int[] pieces = {1, 1, 2, 2, 3, 4, 5};
        //int[] pieces = {8, 1, 2, 2, 3, 4, 5};
        try {
            int[][] result = packingPuzzle(pieces);
            for (int[] row : result) {
                System.out.println(Arrays.toString(row));
            }
        } catch (Exception e) {
            System.out.println("No solution found: " + e.getMessage());
        }
    }


    public static int[][] packingPuzzle(int[] pieces) throws Exception {
        if (pieces.length > 16) {
            throw new Exception("Too many pieces to fit in a 4x4 board");
        }

        int[][] board = new int[4][4];


        if (!solve(board, pieces, 0)) {
            throw new Exception("No solution found");
        }

        return board;
    }


    private static boolean solve(int[][] board, int[] pieces, int index) {
        if (index == pieces.length) {
            return true;
        }

        int pieceId = pieces[index];
        int[][] shape = ALL_SHAPES[pieceId - 1];
        List<int[][]> rotations = getRotations(shape);

        for (int[][] rotation : rotations) {
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    if (canPlace(board, rotation, row, col)) {
                        placePiece(board, rotation, row, col, pieceId);

                        if (solve(board, pieces, index + 1)) {
                            return true;
                        }

                        removePiece(board, rotation, row, col);
                    }
                }
            }
        }

        return false;
    }


    private static boolean canPlace(int[][] board, int[][] shape, int row, int col) {
        int shapeRows = shape.length;
        int shapeCols = shape[0].length;


        if (row + shapeRows > 4 || col + shapeCols > 4) return false;


        for (int i = 0; i < shapeRows; i++) {
            for (int j = 0; j < shapeCols; j++) {
                if (shape[i][j] == 1) {
                    if (board[row + i][col + j] != 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static void placePiece(int[][] board, int[][] shape, int row, int col, int pieceId) {
        int shapeRows = shape.length;
        int shapeCols = shape[0].length;


        for (int i = 0; i < shapeRows; i++) {
            for (int j = 0; j < shapeCols; j++) {
                if (shape[i][j] == 1) {
                    board[row + i][col + j] = pieceId;
                }
            }
        }
    }

    private static void removePiece(int[][] board, int[][] shape, int row, int col) {
        int shapeRows = shape.length;
        int shapeCols = shape[0].length;


        for (int i = 0; i < shapeRows; i++) {
            for (int j = 0; j < shapeCols; j++) {
                if (shape[i][j] == 1) {
                    board[row + i][col + j] = 0;
                }
            }
        }
    }

    private static List<int[][]> getRotations(int[][] shape) {
        List<int[][]> rotations = new ArrayList<>();
        rotations.add(shape);

        for (int i = 0; i < 3; i++) {
            shape = rotate90(shape);
            if (!isDuplicate(rotations, shape)) {
                rotations.add(shape);
            }
        }

        return rotations;
    }

    private static int[][] rotate90(int[][] shape) {
        int rows = shape.length;
        int cols = shape[0].length;
        int[][] rotated = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotated[j][rows - 1 - i] = shape[i][j];
            }
        }
        return rotated;
    }

    private static boolean isDuplicate(List<int[][]> rotations, int[][] newShape) {
        for (int[][] shape : rotations) {
            if (Arrays.deepEquals(shape, newShape)) {
                return true;
            }
        }
        return false;
    }


}
