import java.util.Arrays;

public class L5_flood_fill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        int[][] ans = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            ans[i] = Arrays.copyOf(image[i], image[i].length);
        }
        int[][] offsets = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int n = image.length, m = image[0].length;
        dfs(image, ans, sr, sc, iniColor, color, offsets, n, m);
        return ans;
    }

    private static void dfs(int[][] image, int[][] ans, int sr, int sc, int iniColor, int color, int[][] offsets, int n,
            int m) {
        ans[sr][sc] = color;

        // traverse the nabiour and mark them
        for (int[] offset : offsets) {
            int nrow = sr + offset[0];
            int ncol = sc + offset[1];
            if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && image[nrow][ncol] == iniColor
                    && ans[nrow][ncol] != color) {
                dfs(image, ans, nrow, ncol, iniColor, color, offsets, n, m);
            }
        }

    }

    public static void main(String[] args) {
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        L5_flood_fill ob = new L5_flood_fill();
        int[][] result = ob.floodFill(image, 1, 1, 7);
        // display the result
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.println(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
