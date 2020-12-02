/**
 * URL: https://leetcode.com/problems/flood-fill/
 * 
 */

 public class Problem733 {
    Solution sol = new Solution();

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        System.out.println("Ans: "  +  sol.floodFill(image, 1, 1, 2));
        
        for(int i =0 ; i < image.length; i++){
            for(int j = 0; j < image[0].length; j++){
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int m = image.length;
        int n = image[0].length;
        int oldColor = image[sr][sc];
        // System.out.println("m:" + m + " n:" + n);
        this.helper(image, sr, sc, oldColor, newColor, m, n);

        return image;
    }

    private void helper(int[][] image, int sr, int sc, int oldColor, int newColor, int m, int n){
        // System.out.println(sr + " " + sc);

        if(sr < 0 || sc < 0 || sr >= m || sc >= n){
            return;
        }

        if(image[sr][sc] != oldColor || image[sr][sc] == newColor){
            return;
        }
        
        image[sr][sc] = newColor;
        helper(image, sr+1, sc, oldColor, newColor, m, n);
        helper(image, sr-1, sc, oldColor, newColor, m, n);
        helper(image, sr, sc+1, oldColor, newColor, m, n);
        helper(image, sr, sc-1, oldColor,  newColor, m, n);


        return;
    }

    
}