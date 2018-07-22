package _041_080._062_uniquePaths;

class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] pathsCountTable = new int[m][n];

        for (int i = 0; i < m; i++) {
            pathsCountTable[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            pathsCountTable[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pathsCountTable[i][j] = pathsCountTable[i][j-1] + pathsCountTable[i-1][j];
            }
        }

        return pathsCountTable[m-1][n-1];
    }
}
