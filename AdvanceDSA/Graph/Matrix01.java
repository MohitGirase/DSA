package AdvanceDSA.Graph;

import java.util.LinkedList;
import java.util.Queue;

/*

542. 01 Matrix

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two cells sharing a common edge is 1.


Example 1:

Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
 

Note: This question is the same as 1765: https://leetcode.com/problems/map-of-highest-peak/
 */
public class Matrix01 {
    public int[][] updateMatrix(int[][] grid) {
    
        int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        
        int n = grid.length, m = grid[0].length;
        int[][] result = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    result[i][j] = 0;
                }
                
            }
        }
        
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            for(int[] dir: dirs){
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];
                if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && !visited[nextRow][nextCol]){
                    visited[nextRow][nextCol] = true;
                    result[nextRow][nextCol] = result[row][col] + 1;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
        
        return result;
    }

    //I haven't updated the matrix as this is the answer for two more questions:
    // 1. Distance of nearest cell having 1 - GFG
    // 2. Map of Highest Peak - LeetCode
    // Updating matrix means changing provided data (not industry standard)
    
}
