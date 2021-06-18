public class Problem329{

    public static void main(String[] args) {
        SolutionRecursion sol = new SolutionRecursion();

        int[][] matrix = new int[][]{
            {9,9,4},
            {6,6,8},
            {2,1,1}};
        System.out.println("Ans: " + sol.longestIncreasingPath(matrix));

        matrix = new int[][]{
            {3,4,5},
            {3,2,6},
            {2,2,1}};
        System.out.println("Ans: " + sol.longestIncreasingPath(matrix));

        matrix = new int[][]{{1}};
        System.out.println("Ans: " + sol.longestIncreasingPath(matrix));

        // matrix = new int[][]{{0,1,2,3,4,5,6,7,8,9},{19,18,17,16,15,14,13,12,11,10},{20,21,22,23,24,25,26,27,28,29},{39,38,37,36,35,34,33,32,31,30},{40,41,42,43,44,45,46,47,48,49},{59,58,57,56,55,54,53,52,51,50},{60,61,62,63,64,65,66,67,68,69},{79,78,77,76,75,74,73,72,71,70},{80,81,82,83,84,85,86,87,88,89},{99,98,97,96,95,94,93,92,91,90},{100,101,102,103,104,105,106,107,108,109},{119,118,117,116,115,114,113,112,111,110},{120,121,122,123,124,125,126,127,128,129},{139,138,137,136,135,134,133,132,131,130},{0,0,0,0,0,0,0,0,0,0}};
        // System.out.println("Ans: " + sol.longestIncreasingPath(matrix));
    }
}

class SolutionMemoization {
    boolean[][] visited;
    int[][] dp;
    int longestPathLen;
    public int longestIncreasingPath(int[][] matrix) {
        longestPathLen = -1;
        int m = matrix.length; if(m == 0){ return 0; }
        int n = matrix[0].length;

        visited = new boolean[m][n];
        dp = new int[m][n];
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                visited[i][j] = false;
                dp[i][j] = 0;
            }
        }
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                int curr = longestIncreasingPathUtil(matrix, m, n, i, j, visited);
                longestPathLen = Math.max(longestPathLen, curr);
            }
        }
        for(int i = 0; i < m; i ++){
            System.out.print("\t");
            for(int j = 0; j < n; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }

        return longestPathLen + 1;
    }

    private int longestIncreasingPathUtil(int[][] matrix,int m, int n, int i, int j, boolean[][] visited){
        if(!isValidNode(m, n, i, j, visited) || longestPathLen == m * n){
            System.out.println("m*n = " + m + "*" + n + ":\tNot a valid node " + i + " " +  j + " " + visited[i][j]);
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }

        visited[i][j] = true;
        int max = 0, curr;
        if(isValidNode(m,n,i,j+1,visited) && matrix[i][j+1] > matrix[i][j]){
            curr = 1 + longestIncreasingPathUtil(matrix, m, n, i, j+1, visited);
            max = Math.max(max, curr);
        }
        //down
        if(isValidNode(m,n,i+1,j,visited) && matrix[i+1][j] > matrix[i][j]){
            curr = 1 + longestIncreasingPathUtil(matrix, m, n, i+1, j, visited);
            max = Math.max(max, curr);
        }
        //left
        if(isValidNode(m,n,i,j-1,visited) && matrix[i][j-1] > matrix[i][j]){
            curr = 1 + longestIncreasingPathUtil(matrix, m, n, i, j-1, visited);
            max = Math.max(max, curr);
        }
        //up
        if(isValidNode(m,n,i-1,j,visited) && matrix[i-1][j] > matrix[i][j]){
            curr = 1 + longestIncreasingPathUtil(matrix, m, n, i-1, j, visited);
            max = Math.max(max, curr);
        }

        if(max > dp[i][j]){
            dp[i][j] = max;
        }

        visited[i][j] = false;

        return max;

    }

    private boolean isValidNode(int m, int n, int i, int j, boolean[][] visited){
        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j] == true){
            //ArrayOutOfBound , AlradyVisited
            return false;
        }
        
        return true;
    }
}

class SolutionRecursion {
    boolean[][] visited;
    int longestPathLen;
    public int longestIncreasingPath(int[][] matrix) {
        longestPathLen = -1;
        int m = matrix.length; if(m == 0){ return 0; }
        int n = matrix[0].length;

        visited = new boolean[m][n];
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                visited[i][j] = false;
            }
        }
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                longestPathLen = Math.max(longestPathLen, longestIncreasingPathUtil(matrix, m, n, i, j, visited));
            }
        }

        return longestPathLen + 1;
    }

    private int longestIncreasingPathUtil(int[][] matrix,int m, int n, int i, int j, boolean[][] visited){
        if(!isValidNode(m, n, i, j, visited) || longestPathLen == m * n){
            System.out.println("m*n = " + m + "*" + n + ":\tNot a valid node " + i + " " +  j + " " + visited[i][j]);
            return 0;
        }
        
        visited[i][j] = true;
        int max = 0, curr;
        if(isValidNode(m,n,i,j+1,visited) && matrix[i][j+1] > matrix[i][j]){
            curr = 1 + longestIncreasingPathUtil(matrix, m, n, i, j+1, visited);
            max = Math.max(max, curr);
        }
        //down
        if(isValidNode(m,n,i+1,j,visited) && matrix[i+1][j] > matrix[i][j]){
            curr = 1 + longestIncreasingPathUtil(matrix, m, n, i+1, j, visited);
            max = Math.max(max, curr);
        }
        //left
        if(isValidNode(m,n,i,j-1,visited) && matrix[i][j-1] > matrix[i][j]){
            curr = 1 + longestIncreasingPathUtil(matrix, m, n, i, j-1, visited);
            max = Math.max(max, curr);
        }
        //up
        if(isValidNode(m,n,i-1,j,visited) && matrix[i-1][j] > matrix[i][j]){
            curr = 1 + longestIncreasingPathUtil(matrix, m, n, i-1, j, visited);
            max = Math.max(max, curr);
        }

        visited[i][j] = false;

        return max;

    }

    private boolean isValidNode(int m, int n, int i, int j, boolean[][] visited){
        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j] == true){
            //ArrayOutOfBound , AlradyVisited
            return false;
        }
        
        return true;
    }
}

class Solution {
    boolean[][] visited;
    int[][] dp;
    int longestPathLen;
    public int longestIncreasingPath(int[][] matrix) {
        longestPathLen = 0;
        int m = matrix.length; if(m == 0){ return 0; }
        int n = matrix[0].length;

        visited = new boolean[m][n];
        dp = new int[m][n];
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                visited[i][j] = false;
                dp[i][j] = 0;
            }
        }
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(longestPathLen == m * n){
                    return longestPathLen;
                }
                longestIncreasingPathUtil(matrix, m, n, i, j, visited, 1);
            }
        }
        for(int i = 0; i < m; i ++){
            System.out.print("\t");
            for(int j = 0; j < n; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }

        return longestPathLen;
    }

    private void longestIncreasingPathUtil(int[][] matrix,int m, int n, int i, int j, boolean[][] visited, int currPathLen){
        if(!isValidNode(m, n, i, j, visited) || longestPathLen == m * n){
            System.out.println("m*n = " + m + "*" + n + ":\tNot a valid node " + i + " " +  j + " " + visited[i][j]);
            return;
        }
        if(dp[i][j] != 0){
            // System.out.print(dp[i][j] + " ");
            // if(longestPathLen < dp[i][j] + currPathLen){
                // longestPathLen = dp[i][j] + currPathLen;
            // }
            // return;
        }
        if(longestPathLen < currPathLen){
            longestPathLen = currPathLen;
            dp[i][j] = currPathLen;
        }

        visited[i][j] = true;
        //right
        if(isValidNode(m,n,i,j+1,visited) && matrix[i][j+1] > matrix[i][j]){
            longestIncreasingPathUtil(matrix, m, n, i, j+1, visited, currPathLen+1);
        }
        //down
        if(isValidNode(m,n,i+1,j,visited) && matrix[i+1][j] > matrix[i][j]){
            longestIncreasingPathUtil(matrix, m, n, i+1, j, visited, currPathLen+1);
        }
        //left
        if(isValidNode(m,n,i,j-1,visited) && matrix[i][j-1] > matrix[i][j]){
            longestIncreasingPathUtil(matrix, m, n, i, j-1, visited, currPathLen+1);
        }
        //up
        if(isValidNode(m,n,i-1,j,visited) && matrix[i-1][j] > matrix[i][j]){
            longestIncreasingPathUtil(matrix, m, n, i-1, j, visited, currPathLen+1);
        }

        visited[i][j] = false;

    }

    private boolean isValidNode(int m, int n, int i, int j, boolean[][] visited){
        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j] == true){
            //ArrayOutOfBound , AlradyVisited
            return false;
        }
        
        return true;
    }
}