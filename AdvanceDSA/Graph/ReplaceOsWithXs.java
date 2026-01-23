package AdvanceDSA.Graph;

public class ReplaceOsWithXs {
    int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
    public void fill(char[][] grid) {
        // Code here
        int n = grid.length, m = grid[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            if(grid[i][0] == 'O' && !visited[i][0]){
                dfs(i, 0, visited, grid);
            }
            if(grid[i][m-1] == 'O' && !visited[i][m-1]){
                dfs(i, m-1, visited, grid);
            }
        }
        for(int j=0; j<m; j++){
            if(grid[0][j] == 'O' && !visited[0][j]){
                dfs(0, j, visited, grid);
            }
            if(grid[n-1][j] == 'O' && !visited[n-1][j]){
                dfs(n-1, j, visited, grid);
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 'O' && !visited[i][j]){
                    grid[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(int row, int col, boolean[][] visited, char[][] grid){
        
        visited[row][col] = true;

        for(int[] dir: dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if(nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length && !visited[nextRow][nextCol] && grid[nextRow][nextCol] == 'O'){
                 dfs(nextRow, nextCol, visited, grid);
            }
        }
    }
}
