import java.util.Arrays;

/**
 * URL: https://leetcode.com/problems/xor-queries-of-a-subarray/
 * 
 */

 class Problem1310{

    public static void main(String[] args) {
        Problem1310  obj = new Problem1310();

        int[] arr = new int[]{1,3,4,8};
        int[][] queries = new int[][]{{0,1},{1,2},{0,3},{3,3}};
        System.out.println("Ans: " + Arrays.toString( obj.xorQueries(arr, queries)));
        
    }
         
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int[] ans = new int[queries.length];
        for(int q = 0; q < queries.length; q++){
            System.out.println("Query: ");
            int i = queries[q][0];
            ans[q] = arr[i]; i++;
            for(; i <= queries[q][1]; i++){
                System.out.print("\t" + ans[q] + "\t" + arr[i]);
                ans[q] = ans[q] ^ arr[i];
                System.out.println("\t" + ans[q]);
            }
            System.out.println("---------------");
        }
        return ans;
        
    }
 }