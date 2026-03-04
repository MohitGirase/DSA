package LeetCode_Daily;

/*
1582. Special Positions in a Binary Matrix

Given an m x n binary matrix mat, return the number of special positions in mat.

A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
 

Example 1:


Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
Output: 1
Explanation: (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
Example 2:


Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
Explanation: (0, 0), (1, 1) and (2, 2) are special positions.
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 100
mat[i][j] is either 0 or 1.

*/
public class Easy_1582 {
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 1){
                    boolean flag = false;
                    for(int k=0; k<n; k++){
                        if(k != i && mat[k][j] == 1){
                            flag = true;
                            break;
                        }
                    }
                    if(flag) break;
                    for(int k=0; k<m; k++){
                        if(k != j && mat[i][k]== 1){
                            flag = true;
                            break;
                        }
                    }
                    if(flag) break;
                    count++;
                }
            }
        }
        return count;
    }
}