/**
 * Leftmost Column with at Least a One
 * 
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
 * You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
 * BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
 * BinaryMatrix.dimensions() returns a list of 2 elements [rows, cols], which means the matrix is rows * cols.
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
 * For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.
 * 
 */
import java.util.List;
import java.util.ArrayList;
interface BinaryMatrix{
    public int get(int row, int col);
    public List<Integer> dimensions();
}

class Test1 implements BinaryMatrix{
    int[][] grid;
    public int get(int row, int col) {
        int[][] grid = new int[4][4];
        grid = new int[][]{ {0,0,0,1},
                            {0,0,1,1},
                            {0,0,0,0},
                            {0,1,1,1}};
        return grid[row][col];
    }
    public List<Integer> dimensions() {
        List<Integer> dimensions = new ArrayList<>();
        dimensions.add(4);
        dimensions.add(4);
        return dimensions;
    }
};

class Test2 implements BinaryMatrix{
    int[][] grid;
    public int get(int row, int col) {
        int[][] grid = new int[5][5];
        grid = new int[][]{ {0,0,0,0,1},
                            {0,0,0,1,1},
                            {0,0,1,1,1},
                            {0,0,1,1,1},
                            {0,0,1,1,1}};
        return grid[row][col];
    }
    public List<Integer> dimensions() {
        List<Integer> dimensions = new ArrayList<>();
        dimensions.add(5);
        dimensions.add(5);
        return dimensions;
    }
};

   
public class ProblemDay21April2020Leetcode{
    public static void main(String[] args) {
        BinaryMatrix binaryMatrix = new Test2();

        Solution2 sol = new Solution2();

        System.out.println("Ans: " + sol.leftMostColumnWithOne(binaryMatrix));
    }
}

class Solution1 {
    //bruteforce : failed You made too many calls to BinaryMatrix.get().
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    
        List<Integer> d = binaryMatrix.dimensions();
        int rows = d.get(0);
        int cols = d.get(1);

        for(int j = 0; j < cols; j++ ){
            for(int i = 0; i < rows; i++){
                if(binaryMatrix.get(i,j) == 1){
                    return j;
                }
            }
        }
        return -1;

    }
}

class Solution2 {
    // making of sorted row property: we can use binary search to know leftmost one in the row
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    
        List<Integer> d = binaryMatrix.dimensions();
        int rows = d.get(0);
        int cols = d.get(1);
        
        int leftMostColumn = cols;
        for(int i = 0; i < rows; i++){
            int currRowLeftMost = this.binarySearch(binaryMatrix, cols, i, 0, cols -1);

            if(currRowLeftMost < leftMostColumn){
                leftMostColumn = currRowLeftMost;
            }
            System.out.println("checking for row: " + i + " -> " + currRowLeftMost + "\t:: " + leftMostColumn + "\n------------------");
        }

        return (leftMostColumn == cols) ? -1 : leftMostColumn;

    }
    private int binarySearch(BinaryMatrix binaryMatrix, int cols, int i, int s, int e){
        if(s > e){
            System.out.println("s: "+s + "\te: "+e + "\treturning ");
            return cols;
        }

        int j = s + ((e - s) /2);
        System.out.print("s: "+s + "\te: "+e + "\tmid: " + j);

        if(binaryMatrix.get(i, j) == 1){
            // check in left if not available then give curr
            System.out.println("\tone");
            int left = binarySearch(binaryMatrix, cols, i, s, j-1);
            return (left < j)? left : j;
            
        }else{
            System.out.println("\t*");
            return binarySearch(binaryMatrix, cols, i, j+1, e);
            // return -1;
        }


    }
}