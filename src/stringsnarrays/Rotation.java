package stringsnarrays;

public class Rotation {
    public static void main(String[] args) {
        //int[][] matrix = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
        int[][] matrix = {{1, 1, 1, 1, 1, 1}, {2, 2, 2, 2, 2, 2}, {3, 3, 3, 3, 3, 3}, {4, 4, 4, 4, 4, 4}, {5, 5, 5, 5, 5, 5}, {6, 6, 6, 6, 6, 6}};
        //matrix = rotate90(matrix);
        rotate90Inplace(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    static int[][] rotate90(int[][] matrix) {
        if (matrix == null || matrix.length != matrix[0].length) {
            return null;
        }
        int n = matrix.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j =0; j < n; j++) {
                result[j][n - i - 1] = matrix[i][j];
            }
        }
        return result;
    }

    static void rotate90Inplace(int[][] matrix) {
        if (matrix == null || matrix.length != matrix[0].length) {
            return;
        }
        int n = matrix.length;
        int buffer;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - i - 1; j++) {
                buffer = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = buffer;
            }
        }
    }
}
