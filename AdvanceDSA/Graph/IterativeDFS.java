package AdvanceDSA.Graph;

import java.util.*;


public class IterativeDFS {
    public List<Integer> dfsInGraph(List<List<Integer>> adj, int start){
        List<Integer> result = new ArrayList<>();
        int n = adj.size();
        boolean[] visited = new boolean[n+1]; //1-based indexing -> n+1

        Stack<Integer> stack = new Stack();
        visited[start] = true;
        stack.push(start);

        while(!stack.isEmpty()){
            int node = stack.pop();
            result.add(node);
            List<Integer> children = adj.get(node);
            int size = children.size();
            for(int i=size-1; i>=0; i++){
                int child = children.get(i);
                if(!visited[child]){
                    visited[child] = true;
                    stack.push(child);
                }
            }
        }
        return result;
    }   
}
