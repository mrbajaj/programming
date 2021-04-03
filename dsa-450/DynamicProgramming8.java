/**
 * URL: https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
 * Tags: 
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class DynamicProgramming8{

    public static void main(String[] args) {
        SolutionRecursive solR = new SolutionRecursive();
    
        System.out.println("Ans: " + solR.equalPartition(4, new int[]{1, 5, 11, 5}));
        System.out.println("Ans: " + solR.equalPartition(4, new int[]{1, 5, 11, 5}));
        System.out.println("Ans: " + solR.equalPartition(3, new int[]{1, 3, 5}));
        System.out.println("Ans: " + solR.equalPartition(40, new int[]{27, 24, 10, 36, 6, 13, 5, 4, 12, 21, 18, 38, 16, 9, 35, 14, 29, 30, 3, 22, 20, 34, 37, 25, 17, 15, 8, 28, 11, 19, 33, 23, 32, 40, 26, 0, 1, 31, 2, 6}));
        // System.out.println("Ans: " + sol.equalPartition(99, new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100}));     
        
        System.out.println("--------");

        SolutionMemoized sol = new SolutionMemoized();
    
        System.out.println("Ans: " + sol.equalPartition(4, new int[]{1, 5, 11, 5}));
        System.out.println("Ans: " + sol.equalPartition(4, new int[]{1, 5, 11, 5}));
        System.out.println("Ans: " + sol.equalPartition(3, new int[]{1, 3, 5}));
        System.out.println("Ans: " + sol.equalPartition(40, new int[]{27, 24, 10, 36, 6, 13, 5, 4, 12, 21, 18, 38, 16, 9, 35, 14, 29, 30, 3, 22, 20, 34, 37, 25, 17, 15, 8, 28, 11, 19, 33, 23, 32, 40, 26, 0, 1, 31, 2, 6}));
    }
}

class SolutionRecursive{
    static int equalPartition(int N, int arr[])
    {
        int totalSum = 0;
        for(int i = 0; i < N; i++){
            totalSum += arr[i];
        }
        if(totalSum % 2 == 0){
            //even sum
            int partitionSum = totalSum / 2;
            boolean ans = subsetSum(N, arr, 0, partitionSum);
            if(ans == true){
                return 1;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
        
    }

    static boolean subsetSum(int N, int[] arr, int i, int sum){
        if(sum == 0){
            return true;
        }
        if(i >= N){
            return false;
        }
        return subsetSum(N, arr, i+1, sum - arr[i]) || subsetSum(N, arr, i+1, sum);
    }
}

class SolutionMemoized{
    static boolean dp[][];
    static int equalPartition(int N, int arr[])
    {
        int totalSum = 0;
        int S = 0;
        for(int i = 0; i < N; i++){
            totalSum += arr[i];
        }
        if(totalSum % 2 == 0){
            //even sum
            S = totalSum / 2;
            dp = new boolean[N+1][S+1];
            boolean ans = subsetSum(N, arr, 0, S);

            // for(int i =0; i<=N ; i++){
            //     for(int j = 0; j <= S; j++){
            //         if(dp[i][j] == true){
            //             System.out.print(i + " " + j + "#");
            //         }
            //     }
            // }

            if(ans == true){
                return 1;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }

    static boolean subsetSum(int N, int[] arr, int i, int sum){
        if(sum == 0){
            return true;
        }
        if(i < 0 || i >= N){
            //ArrayIndexOutOfBoundsException
            return false;
        }
        if(dp[i][sum] == true){
            return true;
        }
        
        if(arr[i] <= sum){
            //include or exclude
            return subsetSum(N, arr, i+1, sum - arr[i]) || subsetSum(N, arr, i+1, sum);
        }else{
            //can not include
            return subsetSum(N, arr, i+1, sum);
        }
    }
}