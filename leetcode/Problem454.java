/**
 * URL: https://leetcode.com/problems/4sum-ii/
 * 
 */

import java.util.HashMap;
import java.util.Map;

 class Problem454{

    public static void main(String[] args) {
        Problem454 obj = new Problem454();

        int A[] = {1,2};
        int B[] = {-2,-1};
        int C[] = {-1,2};
        int D[] = {0,2};
        System.out.println("Ans: " + obj.fourSumCount(A, B, C, D));
        System.out.println("Ans: " + obj.fourSumCount_Bruteforce(A, B, C, D));
    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;

        int N = A.length;
        Map<Integer, Integer> abSumFreq = new HashMap<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int sum = A[i] + B[j];
                abSumFreq.put(sum, abSumFreq.getOrDefault(sum, 0) + 1);
            }    
        }

        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int sum = C[i] + D[j];
                if(abSumFreq.containsKey(-sum)){
                    count += abSumFreq.get(-sum);
                }
            }    
        }

        return count;  
    }

    public int fourSumCount_Bruteforce(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;

        int N = A.length;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    for(int l = 0; l < N; l++){
                        if(A[i] + B[j] + C[k] + D[l] == 0) {
                            count++;
                        }
                    }
                }
            }    
        }

        return count;   
    }
 }