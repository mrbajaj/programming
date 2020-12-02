/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * 
 * Did linear search for searching row and item, we can use binary search to further improve complexity
 * 
 * this solution is O(m+n)
 * 
 */
class Problem74{
    public static void main(String[] args) {
        Problem74 obj = new Problem74();
        
        
        int[][] empty = new int[][]{{}};
        int[][] nocolumn = new int[][]{};
        System.out.println("Searching: 1 ::: \tAns:" + obj.searchMatrix(empty, 1) + "\n");
        System.out.println("Searching: 1 ::: \tAns:" + obj.searchMatrix(nocolumn, 1) + "\n");

        int[][] matrix = {
            {2,   3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}, };
        System.out.println("Searching: 1 ::: \tAns:" + obj.searchMatrix(matrix, 1) + "\n");
        System.out.println("Searching: 3 ::: \tAns:" + obj.searchMatrix(matrix, 3) + "\n");
        System.out.println("Searching: 16 ::: \tAns:" + obj.searchMatrix(matrix, 16) + "\n");
        System.out.println("Searching: 54 ::: \tAns:" + obj.searchMatrix(matrix, 54) + "\n");

    }


    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null){
            return false;
        }
        int rows = matrix.length;
        if(rows == 0) return false;
        
        int cols = matrix[0].length;
        if(cols == 0) return false;
        
        //find row
        int i = 0;
        while(i < rows && matrix[i][cols-1] < target){
            i++;
        }
        if(i == rows){
            // System.out.println("Not present");
            return false;
        }

        //find item
        int j = 0;
        while(j < cols && matrix[i][j] != target){
            j++;
        }
        if(j == cols){
            // System.out.println("Not present");
            return false;
        }
        
        // System.out.println("Available at :[" + i + "][" + j + "]");
        

        return true;

    }

}