import java.util.Arrays;
import java.util.Stack;

public class L15_topologic_sort {
    private int[] topoSort(int[][] graph) {
        int[] vis = new int[graph.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == 0) {
                dfs(i, graph, vis, stack);
            }
        }
        int ans[] = new int[graph.length];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop();
        }
        return ans;
    }

    private void dfs(int node, int[][] graph, int[] vis, Stack<Integer> stack) {
        vis[node] = 1;
        for (int it : graph[node]) {
            if (vis[it] == 0) {
                dfs(it, graph, vis, stack);
            }
        }
        stack.push(node);
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
        L15_topologic_sort ob = new L15_topologic_sort();
        int[] result = ob.topoSort(graph);
        System.out.println("Directed graph is : " + Arrays.toString(result));
    }
}
