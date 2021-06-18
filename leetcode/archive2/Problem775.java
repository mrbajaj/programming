/**
 * URL: https://leetcode.com/problems/global-and-local-inversions/
 * Tags: Medium, Array, Queue
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class Problem775{

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Ans: " + sol.isIdealPermutation(new int[]{1,0,2}));
        System.out.println("Ans: " + sol.isIdealPermutation(new int[]{1,2,0}));
        System.out.println("Ans: " + sol.isIdealPermutation(new int[]{2,1,0}));

    }
}

//Bruteforce solution: Throws TLE
class SolutionBruteForce {
    public boolean isIdealPermutation(int[] A) {
        int N = A.length;
        int global = 0, local = 0;
        for(int i = 0; i < N-1; i++){
            if(A[i] > A[i+1]){
                local++;
            }
            for(int j = i+1; j < N; j++){
                if(A[i] > A[j]){
                    global++;
                }
            }
        }
        return global == local;
    }
}

/**
 * No need to check local inversion..
 * because every local inversion is also a gloabl inversion
 * 
 * we only need to find any usecase where it is global inversion but not local
 */
class Solution {
    public boolean isIdealPermutation(int[] A) {
        int N = A.length;
        for(int i = 0; i < N-1; i++){
            for(int j = i+2; j < N; j++){
                if(A[i] > A[j]){
                    return false;
                }
            }
        }
        return  true;
    }
}