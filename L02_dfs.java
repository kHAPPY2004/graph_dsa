import java.util.ArrayList;

public class L02_dfs {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        vis[0] = true;
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0, vis, adj, ls);
        return ls;
    }

    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {
        vis[node] = true;
        ls.add(node);
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj, ls);
            }

        }
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(4);
        adj.get(1).add(0);
        adj.get(2).add(0);
        adj.get(3).add(4);
        adj.get(4).add(0);
        adj.get(4).add(3);

        L02_dfs ob = new L02_dfs();
        ArrayList<Integer> result = ob.dfsOfGraph(V, adj);

        // Print the BFS traversal result
        System.out.println("DFS Traversal:");
        for (Integer node : result) {
            System.out.print(node + " ");
        }
    }
}
