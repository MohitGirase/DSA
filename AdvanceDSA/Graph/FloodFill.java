package AdvanceDSA.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    //Using BFS
    public int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor) {
        // code here
        int n = image.length, m = image[0].length;
        int originalColor = image[sr][sc];
        if(originalColor == newColor) return image;
        
        int[][] dirs = {{0,-1}, {-1,0}, {0,1}, {1,0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr,sc});
        
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            image[row][col] = newColor;
            for(int[] dir: dirs){
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];
                if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && image[nextRow][nextCol] == originalColor){
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
        return image;
    }
    
    public int[][] floodFillDFS(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor != color) {
            dfs(image, sr, sc, oldColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int oldColor, int color) {
        if (image[r][c] == oldColor) {
            image[r][c] = color;

            if (r >= 1) {
                dfs(image, r - 1, c, oldColor, color);
            }

            if (c >= 1) {
                dfs(image, r, c - 1, oldColor, color);
            }

            if (r + 1 < image.length) {
                dfs(image, r + 1, c, oldColor, color);
            }

            if (c + 1 < image[0].length) {
                dfs(image, r, c + 1, oldColor, color);
            }
        }
    }
}
