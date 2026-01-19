package AdvanceDSA.Graph;

import java.util.ArrayList;
import java.util.List;

//For 1-based indexing of nodes

public class EdgesToGraphRepresentation {

    public int[][] edgesToAdjacencyMatrix(int[][] edges, int nodes){
        int[][] graph = new int[nodes+1][nodes+1];

        for(int[] edge: edges){
            int u = edge[0], v = edge[1];
            graph[u][v] = 1;    // For weighted graphs -> instead of 1 store the weight
            graph[v][u] = 1;   // In case of undirected graph only
        }

        return graph;
    }

    public List<List<Integer>> edgesToAdjacencyList(int[][] edges, int nodes){

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=nodes; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);  // For weighted graphs -> store a pair {v,w} where v -> node and w -> weight
            graph.get(v).add(u);  // In case of undirected graph only
        }

        return graph;
    }
}
