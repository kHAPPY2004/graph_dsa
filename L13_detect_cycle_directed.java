public class L13_detect_cycle_directed {
    public boolean isCyclic(int[][] graph) {
        int vis[] = new int[graph.length];
        int pathvis[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == 0 && dfs(i, graph, vis, pathvis)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, int[][] graph, int[] vis, int[] pathvis) {
        vis[node] = 1;
        pathvis[node] = 1;
        for (int it : graph[node]) {
            if (vis[it] == 0) {
                if (dfs(it, graph, vis, pathvis)) {
                    return true;
                }
            } else if (pathvis[it] == 1) {
                return true;
            }
        }
        pathvis[node] = 0;
        return false;

    }

    public static void main(String[] args) {
        int[][] graph = {
                { 1 },
                { 2 },
                { 3, 6 },
                { 4 },
                { 5 },
                {},
                { 4 },
                { 8 },
                { 9 },
                { 7 }
        };
        L13_detect_cycle_directed ob = new L13_detect_cycle_directed();
        boolean result = ob.isCyclic(graph);
        System.out.println("Directed graph is : " + result);
    }
}
