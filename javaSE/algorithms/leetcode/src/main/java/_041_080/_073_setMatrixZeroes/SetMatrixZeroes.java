package _041_080._073_setMatrixZeroes;

class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColumnZero = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstRowZero = true;
                    }
                    
                    if (j == 0) {
                        firstColumnZero = true;
                    }
                    
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (firstRowZero) {
            for (int i = 0; i < n; i++)
            {
                matrix[0][i] = 0;
            }
        }

        if (firstColumnZero) {
            for (int i = 0; i < m; i++)
            {
                matrix[i][0] = 0;
            }
        }
    }
}
