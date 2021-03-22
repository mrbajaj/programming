
/*
 * 
 * link: https://leetcode.com/problems/search-a-2d-matrix/
 */


public class Matrix2{

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = new int[][]{{1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15,16}};
        System.out.println( sol.searchMatrix(matrix, 4) );
        System.out.println( sol.searchMatrix(matrix, 7) );
        System.out.println( sol.searchMatrix(matrix, 11) );
        System.out.println( sol.searchMatrix(matrix, 17) );

        matrix = new int[][]{{1, 2, 3, 5}};
        System.out.println( sol.searchMatrix(matrix, 5) );

        matrix = new int[][]{{1}};
        System.out.println( sol.searchMatrix(matrix, 3) );

        matrix = new int[][]{{1}};
        System.out.println( sol.searchMatrix(matrix, 0) );

        matrix = new int[][]{};
        System.out.println( sol.searchMatrix(matrix, 4) );
    }
}

class Solution{
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows==0){ return false; }
        int cols = matrix[0].length;

        //decide the row using binary search
        int l = 0 , r = rows-1;
        while(l <= r){
            int m = (l + r) / 2;
            if(matrix[m][0] < target){
                l = m + 1;
            } else if(matrix[m][0] > target){
                r = m - 1;
            }else{
                return true;
            }
        }
        int row = r;
        
        if(row < 0){
            return false;
        }
        //binary search in a row (found in prev step) 
        l = 0 ; r = cols-1;
        while(l <= r){
            int m = (l + r) / 2;
            if(matrix[row][m] < target){
                l = l + 1;
            }else if(matrix[row][m] > target){
                r = r - 1;
            }else{
                return true;
            }
        }

        return false;
    }

    
    
}