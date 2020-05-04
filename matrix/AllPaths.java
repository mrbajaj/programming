/**
 * 
 * 
 */
import java.util.Arrays;

public class AllPaths{
    public static void main(String[] args) {
        Solution sol = new Solution();
        int mat[][] = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int m = mat.length;
        int n = mat[0].length;
        sol.printMatrix(mat, m, n, 0, 0, new int[m+n-1], 0);
    }
}

class Solution{
    public void printMatrix(int mat[][], int m, int n,  int i, int j, int path[], int idx) { 
        path[idx] = mat[i][j]; 

        if (i == m - 1) { 
            // Reached the bottom of the matrix so we are left with only option to move right 
            for (int k = j + 1; k < n; k++) { 
                path[idx + k - j] = mat[i][k]; 
            } 
            System.out.println(Arrays.toString(path));
        } else if (j == n - 1) { 
            // Reached the right corner of the matrix we are left with only the downward movement. 
            for (int k = i + 1; k < m; k++) { 
                path[idx + k - i] = mat[k][j]; 
            } 
            System.out.println(Arrays.toString(path));
        } else{
            // Print all the paths that are possible after moving down 
            printMatrix(mat, m, n, i + 1, j, path, idx + 1); 

            // Print all the paths that are possible after moving right 
            printMatrix(mat, m, n, i, j + 1, path, idx + 1); 
        }
        
    } 
}