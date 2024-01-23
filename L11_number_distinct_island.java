import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Pairu {
    int first, second;

    public Pairu(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class L11_number_distinct_island {
    private static void dfs(int i, int j, int[][] vis, char[][] grid, ArrayList<Integer> al, int row0, int col0) {
        vis[i][j] = 1;
        Queue<Pairu> q = new LinkedList<>();
        q.add(new Pairu(i, j));
        int n = grid.length, m = grid[0].length;
        int[][] offsets = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!q.isEmpty()) {
            Pairu current = q.poll();
            int row = current.first;
            int column = current.second;

            // add the pairs to arraylist
            al.add(row - row0, column - col0);

            // traverse the nabiour and mark them
            for (int[] offset : offsets) {
                int nrow = row + offset[0];
                int ncol = column + offset[1];
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Pairu(nrow, ncol));
                }
            }
        }
        System.out.println(al.toString());
    }

    public int noi(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet<ArrayList<Integer>> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    ArrayList<Integer> al = new ArrayList<>();
                    dfs(i, j, vis, grid, al, i, j);
                    hs.add(al);
                }
            }
        }
        System.out.println(hs.toString());
        return hs.size();
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '1', '1' },
                { '1', '0', '0', '0', '0' },
                { '0', '0', '0', '1', '1' },
                { '1', '1', '0', '1', '0' }
        };
        L11_number_distinct_island ob = new L11_number_distinct_island();
        int result = ob.noi(grid);
        System.out.println("Number of distinct islands: " + result);
    }
}
