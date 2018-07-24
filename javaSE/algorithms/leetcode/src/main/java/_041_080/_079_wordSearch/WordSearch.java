package _041_080._079_wordSearch;

class WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0) {
            return false;
        }

        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (this.search(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, boolean[][] visited, int i, int j, String word, int index) {

        if (index == word.length()) {
            return true;
        }

        int m = board.length;
        int n = board[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;
        if (this.search(board, visited, i+1, j, word, index+1) ||
                this.search(board, visited, i-1, j, word, index+1) ||
                this.search(board, visited, i, j+1, word, index+1) ||
                this.search(board, visited, i, j-1, word, index+1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}
