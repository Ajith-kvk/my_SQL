class Solution {
    private List<Integer>[] graph;
    private boolean[] visited;
    private int nodes;
    private int degreeSum;

    public int countCompleteComponents(int n, int[][] edges) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        visited = new boolean[n];
        int complete = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                nodes = 0;
                degreeSum = 0;
                dfs(i);

                int edgeCount = degreeSum / 2;
                int expected = nodes * (nodes - 1) / 2;

                if (edgeCount == expected) {
                    complete++;
                }
            }
        }

        return complete;
    }

    private void dfs(int node) {
        visited[node] = true;
        nodes++;
        degreeSum += graph[node].size();

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}