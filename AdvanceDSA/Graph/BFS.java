package AdvanceDSA.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    // O-based Indexing
    public List<Integer> bfsInGraph(List<List<Integer>> adj, Integer start){
        List<Integer> result = new ArrayList<>();

        int n = adj.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
                                                      //Important point:  Mark visited at enqueue time.
        while(!queue.isEmpty()){
            Integer parent = queue.poll();
            result.add(parent);

            for(Integer child: adj.get(parent)){
                if(!visited[child]){
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }
        return result;
    }

    //S.C -> O(N) and T.C -> O(N + 2E) and not O(N*2E)
}
