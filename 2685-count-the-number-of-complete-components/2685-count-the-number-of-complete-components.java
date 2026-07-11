class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int vertex = 0; vertex < n; vertex++) {
            graph[vertex] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int completeCount = 0;
        Set<Integer> visited = new HashSet<>();
        for (int vertex = 0; vertex < n; vertex++) {
            if (visited.contains(vertex)) continue;
            int[] componentInfo = new int[2];
            dfs(vertex, graph, visited, componentInfo);
            if (componentInfo[0] * (componentInfo[0] - 1) == componentInfo[1]) {
                completeCount++;
            }
        }
        return completeCount;
    }
    private void dfs(
        int curr,
        List<Integer>[] graph,
        Set<Integer> visited,
        int[] componentInfo
    ) {
        visited.add(curr);
        componentInfo[0]++; 
        componentInfo[1] += graph[curr].size(); 
        for (int next : graph[curr]) {
            if (!visited.contains(next)) {
                dfs(next, graph, visited, componentInfo);
            }
        }
    }
}