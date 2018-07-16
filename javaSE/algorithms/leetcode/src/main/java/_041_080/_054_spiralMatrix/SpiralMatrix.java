package _041_080._054_spiralMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return res;
        }
        int n = matrix[0].length;

        for (int i = 0; i < (Math.min(m, n) + 1)/2; i++) {
            // top
            for (int j = i; j < n - i; j++) {
                res.add(matrix[i][j]);
            }

            // right
            for (int j = i+1; j < m - i; j++) {
                res.add(matrix[j][n-i-1]);
            }

            // bottom
            for (int j = n - i - 2; j >= i && m-i-1 != i ; j--) {
                res.add(matrix[m-i-1][j]);
            }
            
            // left
            for (int j = m - i - 2; j >= i+1 && n-i-1 != i ; j--) {
                res.add(matrix[j][i]);
            }

        }

        return res;
    }

}
