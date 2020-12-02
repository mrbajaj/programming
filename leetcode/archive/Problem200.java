/**
 * URL: https://leetcode.com/problems/number-of-islands/
 * 
 */
public class Problem200 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        // char[][] grid1 = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid2 = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

        // System.out.println("Ans: " + sol.numIslands(grid1));
        System.out.println("Ans: " + sol.numIslands(grid2));
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int islandCount = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    islandCount++;
                    this.markVisited(grid, i, j, m, n); // bfs approach
                }
            }
        }
        return islandCount;
    }

    private void markVisited(char[][] grid, int i, int j, int m, int n ){
        System.out.println(i + " " + j);
        if(i < 0 || j < 0 || i >= m  || j >= n){
            System.out.println("\t out of range");
            return;
        }
        System.out.println();
        if(grid[i][j] == '1'){
            grid[i][j] = '0';
            markVisited(grid, i-1, j, m, n); 
            markVisited(grid, i+1, j, m, n); 
            markVisited(grid, i, j-1, m, n); 
            markVisited(grid, i, j+1, m, n); 
        }
        return;
    }
}