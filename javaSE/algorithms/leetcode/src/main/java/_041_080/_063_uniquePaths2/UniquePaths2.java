package _041_080._063_uniquePaths2;

class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;

        int[][] uniquePathsTable = new int[m][n];
        uniquePathsTable[0][0] = obstacleGrid[0][0] == 1? 0:1;

        for (int i = 1; i < m; i++) {
            uniquePathsTable[i][0] = uniquePathsTable[i-1][0];
            if (obstacleGrid[i][0] == 1) {
                uniquePathsTable[i][0] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            uniquePathsTable[0][i] = uniquePathsTable[0][i-1];
            if (obstacleGrid[0][i] == 1) {
                uniquePathsTable[0][i] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                uniquePathsTable[i][j] = uniquePathsTable[i-1][j] + uniquePathsTable[i][j-1];
                if (obstacleGrid[i][j] == 1) {
                    uniquePathsTable[i][j] = 0;
                }
            }
        }

        return uniquePathsTable[m-1][n-1];
    }
}
