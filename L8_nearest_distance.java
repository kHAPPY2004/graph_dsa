import java.util.LinkedList;
import java.util.Queue;

class Cello {
    int x, y, z;

    public Cello(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class L8_nearest_distance {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] ans = new int[rows][cols];
        Queue<Cello> q = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Cello(i, j, 0));
                    visited[i][j] = true;
                } else {
                    visited[i][j] = false;
                }
            }
        }
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!q.isEmpty()) {
            Cello pos = q.remove();
            int row = pos.x;
            int col = pos.y;
            int steps = pos.z;
            ans[row][col] = steps;
            for (int[] dir : directions) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];

                if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && visited[nrow][ncol] == false) {
                    visited[nrow][ncol] = true;
                    q.add(new Cello(nrow, ncol, steps + 1));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int mat[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        L8_nearest_distance ob = new L8_nearest_distance();
        int[][] result = ob.updateMatrix(mat);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.println(result[i][j] + "");
            }
            System.out.println();
        }
    }
}
