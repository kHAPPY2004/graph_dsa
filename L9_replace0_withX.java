public class L9_replace0_withX {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int vis[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!(i > 0 && i < rows - 1 && j != 0 && j != cols - 1) && board[i][j] == 'O' && vis[i][j] != 1) {
                    dfs(board, vis, i, j, rows, cols);
                }
            }
        }
        // for (int i = 0; i < vis.length; i++) {
        // for (int j = 0; j < vis[0].length; j++) {
        // System.out.println(vis[i][j]);
        // }
        // System.out.println();
        // }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public boolean dfs(char[][] board, int vis[][], int i, int j, int rows, int cols) {
        vis[i][j] = 1;
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int[] dir : directions) {
            int childI = i + dir[0];
            int childJ = j + dir[1];

            if (childI >= 0 && childI < rows && childJ >= 0 && childJ < cols &&
                    board[childI][childJ] == 'O' && vis[childI][childJ] != 1) {
                dfs(board, vis, childI, childJ, rows, cols);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // char[][] board = {
        // { 'X', 'X', 'X', 'X' },
        // { 'X', 'O', 'O', 'X' },
        // { 'X', 'X', 'O', 'X' },
        // { 'X', 'O', 'X', 'X' }
        // };
        char[][] board = {
                { 'x', 'x', 'x', 'x', 'x' },
                { 'x', '0', '0', 'x', '0' },
                { 'x', 'x', '0', 'x', '0' },
                { 'x', '0', 'x', '0', 'x' },
                { '0', '0', 'x', 'x', 'x' },
        };
        L9_replace0_withX ob = new L9_replace0_withX();
        ob.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.println(board[i][j]);
            }
            System.out.println();
        }
    }
}
