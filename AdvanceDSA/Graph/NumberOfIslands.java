/*
Find the number of islands

Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of 'W's (Water) and 'L's (Land). Find the number of islands.

Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

Examples:

Input: grid[][] = [['L', 'L', 'W', 'W', 'W'], 
                ['W', 'L', 'W', 'W', 'L'], 
                ['L', 'W', 'W', 'L', 'L'], 
                ['W', 'W', 'W', 'W', 'W'], 
                ['L', 'W', 'L', 'L', 'W']]
Output: 4
Explanation:
The image below shows all the 4 islands in the grid.
 
Input: grid[][] = [['W', 'L', 'L', 'L', 'W', 'W', 'W'], 
                ['W', 'W', 'L', 'L', 'W', 'L', 'W']]
Output: 2
Expanation:
The image below shows 2 islands in the grid.
 
Constraints:
1 ≤ n, m ≤ 500
grid[i][j] = {'L', 'W'}
 */

package AdvanceDSA.Graph;

public class NumberOfIslands {
    int[][] dirs = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1,-1}};
    
    public int countIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        
        int res = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 'L' && !visited[i][j]){
                    dfs(i, j, grid, visited);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(int row, int col, char[][] grid, boolean[][] visited){
        visited[row][col] = true;
        
        for(int[] dir: dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if(nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length
             && grid[nextRow][nextCol] == 'L' && !visited[nextRow][nextCol]){
                dfs(nextRow, nextCol, grid, visited);
            }
        }
    }

     //T.C -> O(N x M) + O(N x M)

     // Replace dfs with bfs -> works fine
}
