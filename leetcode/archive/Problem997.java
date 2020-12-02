/**
 * 
 */
public class Problem997 {
    public static void main(String[] args) {
        Solution1 sol1 = new Solution1();
        Solution2 sol2 = new Solution2();

        System.out.println("Ans: " + sol1.findJudge(2,new int[][]{{1,2}}));
        System.out.println("Ans: " + sol1.findJudge(3,new int[][]{{1,3},{2,3}}));
        System.out.println("Ans: " + sol1.findJudge(3,new int[][]{{1,3},{2,3},{3,1}}));
        System.out.println("Ans: " + sol1.findJudge(3,new int[][]{{1,2},{2,3}}));
        System.out.println("Ans: " + sol1.findJudge(4,new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}}));
        
        System.out.println("Ans: " + sol2.findJudge(2,new int[][]{{1,2}}));
        System.out.println("Ans: " + sol2.findJudge(3,new int[][]{{1,3},{2,3}}));
        System.out.println("Ans: " + sol2.findJudge(3,new int[][]{{1,3},{2,3},{3,1}}));
        System.out.println("Ans: " + sol2.findJudge(3,new int[][]{{1,2},{2,3}}));
        System.out.println("Ans: " + sol2.findJudge(4,new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}}));

    } 
}

class Solution1 {
    public int findJudge(int N, int[][] trust) {
        boolean[][] grid = new boolean[N][N];

        for(int i = 0; i < trust.length; i++ ){
            int a = trust[i][0], b = trust[i][1];

            grid[a-1][b-1] = true;
        }

        for(int i = 0; i < N; i++){
            boolean isEverybodyTrustI = this.checkEverybodyTrustOnI(grid, i, N);
            boolean isITrustNobody = this.checkITrustsNobody(grid, i, N);

            if(isEverybodyTrustI && isITrustNobody){
                return i+1;        
            }
        }

        return -1;
    }

    private boolean checkEverybodyTrustOnI(boolean[][] grid, int i, int N){
        for(int j = 0; j < N; j++){
            if(grid[j][i] == false && i != j){
                return false;
            }
        }
        return true;
    }
    private boolean checkITrustsNobody(boolean[][] grid, int i, int N){
        for(int j = 0; j < N; j++){
            if(grid[i][j] == true){
                return false;
            }
        }
        return true;
    }
}

class Solution2 {
    // using the trust count
    public int findJudge(int N, int[][] trust) {

        int[] trustCount = new int[N+1];

        for(int[] person: trust){
            trustCount[person[0]]--;
            trustCount[person[1]]++;
        }

        for(int i = 1;i < trustCount.length;i++){
            if(trustCount[i] == N-1) return i;
        }
        return -1;

    }
}