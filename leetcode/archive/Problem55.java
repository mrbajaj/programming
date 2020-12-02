/**
 * URL: https://leetcode.com/problems/jump-game/
 * 
 */
public class Problem55 {

    public static void main(String[] args) {
        Solution2 sol = new Solution2();

        System.out.println("Ans: " + sol.canJump(new int[]{2,0}) + "\n--------------");

        System.out.println("Ans: " + sol.canJump(new int[]{2,3,1,1,4}) + "\n--------------");

        System.out.println("Ans: " + sol.canJump(new int[]{3,2,1,0,4}) + "\n--------------");

        System.out.println("Ans: " + sol.canJump(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}) + "\n--------------");
    }

}

class Solution1 {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int grid[][] = new int[n-1][n];

        for(int i = 0; i < n-1; i++ ){
            for(int j = 0; j < nums[i]; j++){
                int x = i + j + 1;
                if(x < n ){ grid[i][x] = 1; }
            }
        }
        
        this.printGrid(grid, n);
        
        for(int col = 1; col < n; col++ ){
            boolean reachable  = false;
            for(int row = 0; row < n-1; row++){
                // System.out.print(row + "," + col + " ");
                if(grid[row][col] == 1){
                    // System.out.print(" reachable" );
                    reachable = true;
                    break;
                }
            }
            if(reachable == false){
                return false;
            }
            // System.out.println();
        }
        System.out.println();

        return true;
    }

    private void printGrid(int[][] grid, int n){
        
        for(int i = 0; i < n-1; i++ ){
            for(int j = 0; j < n; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

}

class Solution2 {
    //Optimised
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int grid[] = new int[n];

        for(int i = 0; i < n-1; i++ ){
            for(int j = 0; j < nums[i]; j++){
                int x = i + j + 1;
                if(x < n ){ grid[x] = 1; }
            }
        }
        
        this.printGrid(grid, n);
        
        for(int col = 1; col < n; col++ ){
            boolean reachable  = false;
            if(grid[col] == 1){
                reachable = true;
            }
            if(reachable == false){
                return false;
            }
        }
        System.out.println();

        return true;
    }

    private void printGrid(int[] grid, int n){
        
        for(int i = 0; i < n; i++ ){
            System.out.print(grid[i] + " ");
            
        }

        System.out.println();
    }

}