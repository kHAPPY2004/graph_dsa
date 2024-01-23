import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class L01_bfs {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for (Integer it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }

        }
        return bfs;

    }

    public static void main(String[] args) {
        // Create a sample graph
        int V = 5; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // Add edges to the graph
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);

        L01_bfs ob = new L01_bfs();
        ArrayList<Integer> result = ob.bfsOfGraph(V, adj);

        // Print the BFS traversal result
        System.out.println("BFS Traversal:");
        for (Integer node : result) {
            System.out.print(node + " ");
        }
    }
}
