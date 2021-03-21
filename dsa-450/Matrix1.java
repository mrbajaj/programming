
/*
 * 
 * link: https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
 */


public class Matrix1{

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = new int[][]{{1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15,16}};
        sol.printSpiral(matrix);

        matrix = new int[][]{{1, 2, 3, 4}};
        sol.printSpiral(matrix);

        matrix = new int[][]{{1}};
        sol.printSpiral(matrix);

        matrix = new int[][]{};
        sol.printSpiral(matrix);
    }
}

class Solution{
    
    public void printRowWise(int[][] matrix){
        int m = matrix.length;
        if(m == 0){
            System.out.println("EmptyMatrix");
        }else{
            int n = matrix[0].length;
            for(int i = 0 ; i < m; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }
        }
        
        System.out.println("---------------------------");
    }

    public void printSpiral(int[][] matrix){
        int m = matrix.length;
        if(m == 0){
            System.out.println("EmptyMatrix\n---------------------------");
            
            return;
        }
        int n = matrix[0].length;
        int dir = 0, top = 0, down = m-1, left = 0, right = n-1;

        while(top <= down && left <= right){
            if(dir == 0){
                //left to right
                for(int i = left; i <= right; i++){
                    System.out.print(matrix[top][i] + "\t");
                }
                top++;
            } else if(dir == 1){
                //top to down
                for(int i = top; i <= down; i++){
                    System.out.print(matrix[i][right] + "\t");
                }
                right--;
            } else if(dir == 2){
                //right to left
                for(int i = right; i >= left; i--){
                    System.out.print(matrix[down][i] + "\t");
                }
                down--;
            }else if(dir == 3){
                //down to top
                for(int i = down; i >= top; i--){
                    System.out.print(matrix[i][left] + "\t");
                }
                left++;
            }
            System.out.println();
            dir = (dir+1)%4;

        }

    }
    
}