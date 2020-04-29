/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
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