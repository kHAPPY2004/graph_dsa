import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class L3a_no_provinces {
    public int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        int vis[] = new int[V];
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                cnt++;
                q.add(i);
            }
            while (!q.isEmpty()) {
                int node = q.poll();
                vis[node] = 1;
                for (Integer it : adj.get(node)) {
                    if (vis[it] == 0) {
                        q.add(it);
                    }
                }
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

        L3a_no_provinces ob = new L3a_no_provinces();
        int result = ob.numProvinces(adj, V);

        System.out.println("Number of provinces: " + result);
    }
}
