package _041_080._059_spiralMatrix2;

class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int count = 1;
        for (int i = 0; i < (n+1)/2 ; i++) {
            // top
            for (int j = i; j < n - i; j++) {
                matrix[i][j] = count++;
            }

            // right
            for (int j = i + 1; j < n - i; j++) {
                matrix[j][n-i-1] = count++;
            }

            // bottom
            for (int j = n - i - 2; j >= i ; j--) {
                matrix[n-i-1][j] = count++;
            }

            // left
            for (int j = n - i - 2; j > i ; j--) {
                matrix[j][i] = count++;
            }
        }

        return matrix;
    }
}
