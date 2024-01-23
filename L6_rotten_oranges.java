
import java.util.LinkedList;
import java.util.Queue;

/**
 * L6_rotten_oranges
 */
/**
 * Cell
 */
class Cell {
    int x, y, t;

    public Cell(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}

public class L6_rotten_oranges {

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Cell> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int cuntFresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Cell(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1)
                    cuntFresh++;
            }
        }

        int[][] offsets = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int time = 0, cnt = 0;
        while (!q.isEmpty()) {
            int sr = q.peek().x;
            int sc = q.peek().y;
            int nt = q.peek().t;
            time = Math.max(nt, time);
            q.remove();
            for (int[] offset : offsets) {
                int nrow = sr + offset[0];
                int ncol = sc + offset[1];
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && grid[nrow][ncol] == 1
                        && vis[nrow][ncol] == 0) {
                    q.add(new Cell(nrow, ncol, nt + 1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }
        if (cnt != cuntFresh)
            return -1;
        return time;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 2 } };
        L6_rotten_oranges ob = new L6_rotten_oranges();
        int result = ob.orangesRotting(grid);
        System.out.println("minimum number of minutes: " + result);

    }
}