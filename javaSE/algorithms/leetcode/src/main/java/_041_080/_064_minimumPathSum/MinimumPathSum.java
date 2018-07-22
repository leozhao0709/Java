package _041_080._064_minimumPathSum;

class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }

        int n = grid[0].length;

        int[][] sumTable = new int[m][n];

        sumTable[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            sumTable[i][0] = sumTable[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            sumTable[0][i] = sumTable[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sumTable[i][j] = Math.min(sumTable[i-1][j], sumTable[i][j-1]) + grid[i][j];
            }
        }

        return sumTable[m-1][n-1];
    }
}
