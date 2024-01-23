import java.util.ArrayList;
import java.util.List;

public class L14_eventual_state {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int vis[] = new int[graph.length];
        int pathvis[] = new int[graph.length];
        int check[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == 0) {
                System.out.println("up" + i);
                dfs(i, graph, vis, pathvis, check);

            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (check[i] == 1)
                safeNodes.add(i);
        }
        return safeNodes;
    }

    private boolean dfs(int node, int[][] graph, int[] vis, int[] pathvis, int[] check) {
        vis[node] = 1;
        pathvis[node] = 1;
        check[node] = 0;
        for (int it : graph[node]) {
            if (vis[it] == 0) {
                System.out.println(it);
                if (dfs(it, graph, vis, pathvis, check)) {
                    return true;
                }
            } else if (pathvis[it] == 1) {
                return true;
            }
        }
        check[node] = 1;
        pathvis[node] = 0;
        return false;

    }

    public static void main(String[] args) {
        int[][] graph = {
                { 1, 2 },
                { 2, 3 },
                { 5 },
                { 0 },
                { 5 },
                {},
                {},
        };
        L14_eventual_state ob = new L14_eventual_state();
        List<Integer> result = ob.eventualSafeNodes(graph);
        System.out.println("Directed graph is : " + result.toString());
    }
}
