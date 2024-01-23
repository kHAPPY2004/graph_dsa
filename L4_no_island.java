import java.util.LinkedList;
import java.util.Queue;

/**
 * Pair
 */
class Pair {
    int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class L4_no_island {
    private static void bfs(int i, int j, int[][] vis, char[][] grid) {
        vis[i][j] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        int n = grid.length, m = grid[0].length;
        int[][] offsets = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!q.isEmpty()) {
            Pair current = q.poll();
            int row = current.first;
            int column = current.second;

            // traverse the nabiour and mark them

            for (int[] offset : offsets) {
                int nrow = row + offset[0];
                int ncol = column + offset[1];
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
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
                    bfs(i, j, vis, grid);
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

        L4_no_island ob = new L4_no_island();
        int result = ob.numIslands(grid);

        System.out.println("Number of islands: " + result);
    }
}
