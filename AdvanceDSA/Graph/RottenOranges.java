package AdvanceDSA.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    //Here I have altered the matrix data. But in real world scenarios we never alter the data provided to us. So, its better to use a 
    // visited array for this task.
    public int orangesRot(int[][] mat) {
        // code here
        int n = mat.length, m = mat[0].length;
        
        int[][] dirs = {{0,-1},{-1,0},{0,1},{1,0}};
        
        int rottenOranges = 0;
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 1) freshOranges++;
                else if(mat[i][j] == 2){
                    rottenOranges++;
                    queue.offer(new int[]{i,j});
                }
            }
        }
        
        if(freshOranges == 0) return 0;
        if(rottenOranges == 0) return -1;
        
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] cell = queue.poll();
                for(int[] dir: dirs){
                    int nextRow = cell[0] + dir[0];
                    int nextCol = cell[1] + dir[1];
                    if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && mat[nextRow][nextCol] == 1){
                        mat[nextRow][nextCol] = 2;
                        freshOranges--;
                        queue.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
            time++;
            if(freshOranges == 0) break;
        }
        if(freshOranges != 0) return -1;
        return time;
    }
}
