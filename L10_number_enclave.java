public class L10_number_enclave {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int vis[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!(i > 0 && i < rows - 1 && j != 0 && j != cols - 1) && grid[i][j] == 1 && vis[i][j] != 1) {
                    dfs(grid, vis, i, j, rows, cols);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid, int vis[][], int i, int j, int rows, int cols) {
        vis[i][j] = 1;
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int[] dir : directions) {
            int childI = i + dir[0];
            int childJ = j + dir[1];

            if (childI >= 0 && childI < rows && childJ >= 0 && childJ < cols &&
                    grid[childI][childJ] == 1 && vis[childI][childJ] != 1) {
                dfs(grid, vis, childI, childJ, rows, cols);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // int[][] grid = {
        // { 0, 0, 0, 1, 1 },
        // { 0, 0, 1, 1, 0 },
        // { 0, 1, 0, 0, 0 },
        // { 0, 1, 1, 0, 0 },
        // { 0, 0, 0, 1, 1 }
        // };
        int[][] grid = {
                { 0, 1, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 }
        };
        L10_number_enclave ob = new L10_number_enclave();
        int result = ob.numEnclaves(grid);
        System.out.println("Number of Enclaves: " + result);
    }
}
