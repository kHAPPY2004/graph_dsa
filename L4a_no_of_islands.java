
/**
 * Paira
 */
class Paira {
    int first, second;

    public Paira(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class L4a_no_of_islands {
    private static void dfs(int i, int j, int[][] vis, char[][] grid) {
        vis[i][j] = 1;
        int n = grid.length, m = grid[0].length;
        int[][] offsets = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        // traverse the nabiour and mark them

        for (int[] offset : offsets) {
            int nrow = i + offset[0];
            int ncol = j + offset[1];
            if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                vis[nrow][ncol] = 1;
                dfs(nrow, ncol, vis, grid);
            }
        }

    }

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    cnt++;
                    dfs(i, j, vis, grid);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        // Example usage
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };

        L4a_no_of_islands ob = new L4a_no_of_islands();
        int result = ob.numIslands(grid);

        System.out.println("Number of islands: " + result);
    }
}
