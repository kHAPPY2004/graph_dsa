
public class L12_bipartite_dfs {
    public boolean isBipartite(int[][] graph) {
        int[] vis = new int[graph.length];
        for (int i = 0; i < vis.length; i++) {
            vis[i] = -1;
        }
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == -1) {
                if (dfs(i, 0, graph, vis) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Boolean dfs(int i, int col, int[][] graph, int vis[]) {
        vis[i] = col;
        for (int it : graph[i]) {
            if (vis[it] == -1) {
                if (dfs(it, 1 - col, graph, vis) == false)
                    return false;

            } else if (vis[it] == col) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 1, 3 },
                { 0, 2 },
                { 1, 3 },
                { 0, 2 }
        };
        L12_bipartite_dfs ob = new L12_bipartite_dfs();
        boolean result = ob.isBipartite(graph);
        System.out.println("Is graph bipartite: " + result);
    }
}
