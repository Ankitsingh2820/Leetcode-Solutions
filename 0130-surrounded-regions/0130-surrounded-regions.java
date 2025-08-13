class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int row = board.length;
        int col = board[0].length;

        // Step 1: Mark border-connected 'O's
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0);
            dfs(board, i, col - 1);
        }
        for (int j = 0; j < col; j++) {
            dfs(board, 0, j);
            dfs(board, row - 1, j);
        }

        // Step 2: Flip and restore
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        int row = board.length;
        int col = board[0].length;

        if (r < 0 || c < 0 || r >= row || c >= col || board[r][c] != 'O') {
            return;
        }

        board[r][c] = '#'; // Mark safe cell
        dfs(board, r - 1, c);
        dfs(board, r + 1, c);
        dfs(board, r, c - 1);
        dfs(board, r, c + 1);
    }
}
