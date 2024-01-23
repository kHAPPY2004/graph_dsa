import java.util.LinkedList;
import java.util.Queue;

/**
 * L12_bipartite
 */
public class L12_bipartite {

    public boolean isBipartite(int[][] graph) {
        int[] vis = new int[graph.length];
        for (int i = 0; i < vis.length; i++) {
            vis[i] = -1;
        }
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == -1) {
                if (check(i, graph, vis) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Boolean check(int i, int[][] graph, int vis[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int it : graph[node]) {
                if (vis[it] == -1) {
                    vis[it] = 1 - vis[node];
                    System.out.println(vis[it]);
                    q.add(it);
                } else if (vis[it] == vis[node]) {
                    return false;
                }
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
        L12_bipartite ob = new L12_bipartite();
        boolean result = ob.isBipartite(graph);
        System.out.println("Is graph bipartite: " + result);
    }
}