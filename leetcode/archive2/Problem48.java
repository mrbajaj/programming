/**
 * URL: 
 * Tags: Matrix
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */
import java.util.Arrays;

public class Problem48{

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] matrix = new int[][]{ {1,2,3},{4,5,6},{7,8,9} }; int N =3;

        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }

        sol.rotate(matrix);
    }
 }

 class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        System.out.println("transpose");
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
        for(int i = 0; i < N; i++){
            int j =0, k = N-1;
            while(j < k){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = tmp;
                j++;
                k--;
            }
        }
        System.out.println("rotate");
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    
}