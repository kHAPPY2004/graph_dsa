import java.util.ArrayList;

/**
 * L3_no._provinces
 */
public class L3_no_provinces {
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adjLs, int vis[]) {
        vis[node] = 1;
        for (Integer it : adjLs.get(node)) {
            if (vis[it] == 0) {
                dfs(it, adjLs, vis);
            }
        }
    }

    public int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        int vis[] = new int[V];
        int cnt = 0;
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                cnt++;
                dfs(i, adj, vis);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        // Example usage
        int V = 4; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize the adjacency matrix
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the adjacency matrix
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(3).add(3); // An isolated vertex

        L3_no_provinces ob = new L3_no_provinces();
        int result = ob.numProvinces(adj, V);

        System.out.println("Number of provinces: " + result);
    }

}
