import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L16_kahns_algo {
    private int[] topoSort(int[][] graph) {
        int[] indegree = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int it : graph[i]) {
                indegree[it]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int topo[] = new int[graph.length];
        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo[i++] = node;
            // node is topo sort
            // remove it from indegree
            for (int j : graph[node]) {
                indegree[j]--;
                if (indegree[j] == 0) {
                    queue.add(j);
                }
            }
        }
        return topo;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {},
                {},
                { 3 },
                { 1 },
                { 0, 1 },
                { 0, 2 },
        };

        L16_kahns_algo ob = new L16_kahns_algo();
        int[] result = ob.topoSort(graph);
        System.out.println("Directed graph is : " + Arrays.toString(result));
    }
}
