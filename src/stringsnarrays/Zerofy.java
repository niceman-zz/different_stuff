package stringsnarrays;

public class Zerofy {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 0, 3, 3}, {4, 4, 4, 4}};
        setZeros(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }

    static void setZeros(int[][] mtrx) {
        if (mtrx == null || mtrx.length == 0) {
            return;
        }
        boolean[] vertical = new boolean[mtrx.length];
        boolean[] horizontal = new boolean[mtrx[0].length];
        for (int i = 0; i < mtrx.length; i++) {
            for (int j = 0; j < mtrx[i].length; j++) {
                if (mtrx[i][j] == 0) {
                    vertical[i] = true;
                    horizontal[j] = true;
                }
            }
        }
        for (int i = 0; i < mtrx.length; i++) {
            for (int j = 0; j < mtrx[i].length; j++) {
                if (vertical[i] || horizontal[j]) {
                    mtrx[i][j] = 0;
                }
            }
        }
    }
}
