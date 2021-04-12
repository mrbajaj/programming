/**
 * URL: https://leetcode.com/problems/deepest-leaves-sum/
 * Tags: Array, BinarySearch
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */
import java.util.Arrays;

public class Problem667{
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Ans:" + Arrays.toString(sol.constructArray(6,3)));
        System.out.println("Ans:" + Arrays.toString(sol.constructArray(3,1)));
    }
}

class Solution {
    /**
     * Eg: n = 6, k = 3;
     * 
     * intial:   k=3  : left = 1, right = 6 :: ans[0,0,0,0,0,0]
     * i=0 : k=3 odd  : ans[6,0,0,0,0,0] :: right-- :: left = 1, right = 5
     * i=1 : k=2 even : ans[6,1,0,0,0,0] :: left++  :: left = 2, right = 5
     * i=2 : k=1 odd  : ans[6,1,5,,0,0] :: right-- :: left = 2, right = 4
     * i=3 : k=1 odd  : ans[6,1,5,4,0,0] :: right-- :: left = 2, right = 3
     * i=4 : k=1 odd  : ans[6,1,5,4,3,0] :: right-- :: left = 2, right = 2
     * i=5 : k=1 odd  : ans[6,1,5,4,3,2] :: right-- :: left = 2, right = 1
     */
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
	    int left = 1;
	    int right = n;
        for(int i = 0; i < n; i++){
	    
	        if(k % 2 == 0)
	            ans[i] = left++;
	        else {
                System.out.print(i + " ");
                ans[i] = right--;
            }
		
	        if(k > 1)
	            k--;
	    }
	    return ans;
    }
}