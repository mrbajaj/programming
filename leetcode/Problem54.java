/**
 * URL: 
 * Tags: Matrix
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */
import java.util.List;
import java.util.ArrayList;

 class Problem54{

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> ans = sol.spiralOrder(matrix);

        System.out.println("Ans: " + ans.toString());

    }

    
 }

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        
        int n = matrix.length, m = matrix[0].length;
        
        int top = 0, bottom = n-1, left = 0, right = m-1, dir = 0;
        
        while(top <= bottom && left <= right){
            //left to right
            if(dir == 0){
                for(int i = left; i <= right; i++){
                    ans.add(matrix[top][i]);
                }
                top++;
            }
            
            //top to bottom
            if(dir == 1){
                for(int i = top; i <= bottom; i++){
                    ans.add(matrix[i][right]);
                }
                right--;
            }
            
            //right to left
            if(dir == 2){
                for(int i = right; i>= left; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            //bottom to top
            if(dir == 3){
                for(int i = bottom; i>=top; i--){
                    ans.add(matrix[i][left]);
                }
                left++;  
            }
            dir = (dir+1)%4;
        }
        
        return ans;
    }
}