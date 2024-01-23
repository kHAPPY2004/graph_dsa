public class L7a_detect_cycle {
    public boolean containsCycle(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && dfs(grid, i, j, visited, -1, -1, rows, cols)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, int i, int j, boolean[][] visited, int parentI, int parentJ, int rows,
            int cols) {
        char c = grid[i][j];

        if (visited[i][j]) {
            return true; // Cycle detected
        }

        visited[i][j] = true;

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int[] dir : directions) {
            int childI = i + dir[0];
            int childJ = j + dir[1];

            if (childI >= 0 && childI < rows && childJ >= 0 && childJ < cols &&
                    grid[childI][childJ] == c && !(childI == parentI && childJ == parentJ)) {
                if (dfs(grid, childI, childJ, visited, i, j, rows, cols)) {
                    return true; // If a cycle is detected in any direction, return true
                }
            }
        }

        return false; // No cycle detected
    }

    public static void main(String[] args) {
        L7a_detect_cycle solution = new L7a_detect_cycle();

        char[][] grid1 = {
                { 'a', 'a', 'a', 'a' },
                { 'a', 'b', 'b', 'a' },
                { 'a', 'b', 'b', 'a' },
                { 'a', 'a', 'a', 'a' }
        };
        System.out.println("Example 1: " + solution.containsCycle(grid1)); // Output: true

        char[][] grid2 = {
                { 'c', 'c', 'c', 'a' },
                { 'c', 'd', 'c', 'c' },
                { 'c', 'c', 'e', 'c' },
                { 'f', 'c', 'c', 'c' }
        };
        System.out.println("Example 2: " + solution.containsCycle(grid2)); // Output: true

        char[][] grid3 = {
                { 'f', 'a', 'a', 'c', 'b' },
                { 'e', 'a', 'a', 'e', 'c' },
                { 'c', 'f', 'b', 'b', 'b' },
                { 'c', 'e', 'a', 'b', 'e' },
                { 'f', 'e', 'f', 'b', 'f' }
        };
        System.out.println("Example 3: " + solution.containsCycle(grid3)); // Output: false
    }
}
