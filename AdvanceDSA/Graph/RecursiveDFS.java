package AdvanceDSA.Graph;

import java.util.List;
import java.util.ArrayList;

public class RecursiveDFS {
    
    // 1-based indexing
    public List<Integer> dfsInGraph(List<List<Integer>> adj, int start){
        List<Integer> result = new ArrayList<>();
        if (start <= 0 || start >= adj.size()) return result;

        int n = adj.size();
        boolean[] visited = new boolean[n+1];
        dfs(adj, start, visited, result);
        return result;
    }
    public void dfs(List<List<Integer>> adj, int node, boolean[] visited, List<Integer> result){
        visited[node] = true;
        result.add(node);

        for(Integer child: adj.get(node)){
            if(!visited[child]){
                dfs(adj, child, visited, result);
            }
        }
    }
}
