import java.util.LinkedList;
import java.util.Queue;

class Cells {
    int x, y, a, b;

    public Cells(int x, int y, int a, int b) {
        this.x = x;
        this.y = y;
        this.a = a;
        this.b = b;
    }
}

public class L7_detect_cycle {
    public boolean containsCycle(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && bfs(grid, i, j, visited, rows, cols)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean bfs(char[][] grid, int i, int j, boolean[][] visited, int rows, int cols) {
        Queue<Cells> q = new LinkedList<>();
        q.add(new Cells(i, j, -1, -1));
        char c = grid[i][j];

        while (!q.isEmpty()) {
            Cells pos = q.remove();
            int currI = pos.x;
            int currJ = pos.y;
            int parentI = pos.a;
            int parentJ = pos.b;

            if (visited[currI][currJ]) {
                return true; // Cycle detected
            }

            visited[currI][currJ] = true;

            int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

            for (int[] dir : directions) {
                int childI = currI + dir[0];
                int childJ = currJ + dir[1];

                if (childI >= 0 && childI < rows && childJ >= 0 && childJ < cols &&
                        grid[childI][childJ] == c && !(childI == parentI && childJ == parentJ)) {
                    q.add(new Cells(childI, childJ, currI, currJ));
                }
            }
        }

        return false; // No cycle detected
    }

    public static void main(String[] args) {
        L7_detect_cycle solution = new L7_detect_cycle();

        char[][] grid1 = {
                {'a', 'a', 'a', 'a'},
                {'a', 'b', 'b', 'a'},
                {'a', 'b', 'b', 'a'},
                {'a', 'a', 'a', 'a'}
        };
        System.out.println("Example 1: " + solution.containsCycle(grid1)); // Output: true

        char[][] grid2 = {
                {'c', 'c', 'c', 'a'},
                {'c', 'd', 'c', 'c'},
                {'c', 'c', 'e', 'c'},
                {'f', 'c', 'c', 'c'}
        };
        System.out.println("Example 2: " + solution.containsCycle(grid2)); // Output: true

        char[][] grid3 = {
                {'a', 'b', 'b'},
                {'b', 'z', 'b'},
                {'b', 'b', 'a'}
        };
        System.out.println("Example 3: " + solution.containsCycle(grid3)); // Output: false
    }
}
