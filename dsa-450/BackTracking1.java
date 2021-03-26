/**
 * URL: https://leetcode.com/problems/search-in-a-binary-search-tree/
 * Tags: Tree
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

import java.util.ArrayList;


public class BackTracking1{

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] matrix = new int[][]{{1, 0, 0, 0},
                    {1, 1, 0, 1}, 
                    {1, 1, 0, 0},
                    {0, 1, 1, 1}};
        System.out.println( sol.findPath(matrix, 4) + "\n" );  

        int[][] matrix2 = new int[][]{{1, 0},
                    {1, 0}};
        System.out.println( sol.findPath(matrix2, 2) + "\n" );  

        int[][] matrix4 = new int[][]{{1, 0, 0, 0},
                    {1, 1, 0, 1},
                    {1, 1, 0, 0},
                    {0, 1, 1, 1}};
        System.out.println( sol.findPath(matrix4, 4) + "\n" );

        int[][] matrix5 = new int[][]{{1, 0, 1, 1, 1},
                    {1, 1, 1, 0, 1},
                    {0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 1}};
        System.out.println( sol.findPath(matrix5, 5) + "\n" );  
           

    }
    
}

class Solution {
    private static ArrayList<String> ans = new ArrayList<String>();

    public static ArrayList<String> findPath(int[][] matrix, int n) {
        String s = "";
        boolean[][] visited = new boolean[n][n];
        ans.clear();
        maze(matrix, 0, 0, n, visited, s);

        return ans;

    }

    private static void maze(int[][] matrix, int x, int y, int n, boolean[][] visited, String s){
        if(x == n-1 && y == n-1 && matrix[x][y] == 1){
            // System.out.println(s + "\tx:" + x + "\ty:" + y);
            ans.add(s);
            return;
        }
        
        if(isValid(matrix, x, y, n, visited)){
            visited[x][y] = true;
            // move down
            maze(matrix, x+1, y, n, visited, s + "D");

            // move left
            maze(matrix, x, y-1, n, visited, s + "L");

            // move right
            maze(matrix, x, y+1, n, visited, s + "R");

            // move up
            maze(matrix, x-1, y, n, visited, s + "U");

            visited[x][y] = false;
        }
    }
    
    private static boolean isValid(int[][] matrix, int x, int y, int n, boolean[][] visited){
        if(x >= 0 && y >= 0 && x < n && y < n && matrix[x][y] == 1 && visited[x][y] == false){
            return true;
        }
        return false;
    }
}