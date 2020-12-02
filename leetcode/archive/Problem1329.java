/**
 * URL: https://leetcode.com/problems/sort-the-matrix-diagonally/
 * 
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Problem1329 {

    public static void main(String[] args) {
        Solution1 sol1 = new Solution1();
        
        int[][] mat = new int[][]{{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        int[][] sorted = sol1.diagonalSort(mat);
        printMatrix(sorted, "Actual");
        printMatrix(sorted, "Sorted");

        System.out.println("-------------------------");

        // mat = new int[][]{{1,1,1,1},{1,2,2,2},{1,2,3,3}};
        // sorted = sol1.diagonalSort(mat);
        // printMatrix(sorted, "Actual");
        // printMatrix(sorted, "Sorted");

    }

    public static void printMatrix(int[][] mat, String message){
        System.out.println(message);
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                System.out.print("\t" + mat[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}

class Solution1{

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        if(m == 1 || n == 1){
            return mat;
        }

        for(int d = m-1; d > (-1 * (n-1)); d--){
            int x, y;
            if(d > 0){ x = d; y = 0;}else if(d < 0) {x = 0; y = -d;}else{x = 0 ; y = 0;}
            List<Integer> list = new ArrayList<>();

            //collect the diagonal elements into list
            int i = x, j = y;
            while(i >= 0 && j >= 0 && i < m && j < n){
                list.add(mat[i][j]);
                i++; j++;
            }
            //sort the list
            Collections.sort(list);
            
            //put the sorted elements into matrix
            i = x; j = y; 
            int k =0;
            while(i >= 0 && j >= 0 && i < m && j < n){
                mat[i][j] = list.get(k);
                i++; j++;
                k++;
            }
        }
     
        return mat;
    }

}