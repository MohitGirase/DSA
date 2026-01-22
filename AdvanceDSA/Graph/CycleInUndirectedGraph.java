package AdvanceDSA.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleInUndirectedGraph {
    //Using DFS 
    public boolean isCycleDFS(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(dfs(i,-1, visited, adj)) return true;
            }
        }
        return false;
        
    }
    public boolean dfs(int node, int origin, boolean[] visited, List<List<Integer>> adj){
        visited[node] = true;
        
        for(Integer it: adj.get(node)){
            if(!visited[it]){
                if(dfs(it, node, visited, adj)) return true;
            }else{
                if(it != origin) return true;
            }
        }
        return false;
    }

    //Using BFS
    public boolean isCycleBFS(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(bfs(i, visited, adj)) return true;
            }
        }
        return false;
        
    }
    public boolean bfs(int node, boolean[] visited, List<List<Integer>> adj){
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{node, -1});
        visited[node] = true;
        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int child = pair[0];
            int parent = pair[1];
            for(Integer it: adj.get(child)){
                if(!visited[it]){
                    visited[it] = true;
                    queue.offer(new int[]{it, child});
                }else{
                    if(it != parent) return true;
                }
            }
        }
        return false;
    }
}
