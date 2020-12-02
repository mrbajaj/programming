/**
 * URL: https://leetcode.com/problems/check-if-it-is-a-straight-line/
 * 
 */
public class Problem1232 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] coordinates = new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};

        System.out.println("Ans: " + sol.checkStraightLine(coordinates) + "\n");

    }

}

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
    
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];

        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];

        int dx = x1 - x0, dy = y1 - y0; 

        for(int i = 0; i < coordinates.length; i++){
            int x = coordinates[i][0], y = coordinates[i][1]; 
            if (dx * (y - y1) != dy * (x - x1)){
                return false;
            }
        }
        
        return true;

    }
}