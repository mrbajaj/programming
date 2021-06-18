/**
 * URL: https://leetcode.com/problems/richest-customer-wealth/
 * Tags: Medium, Array, Queue
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */


class Problem1672{

    public static void main(String[] args) {
        Solution sol = new Solution();

        int ans = sol.maximumWealth(new int[][]{{1,2,3},{3,2,1}});
        System.out.println("Ans:" + ans);
    }
}

class Solution {
    public int maximumWealth(int[][] accounts) {
        if(accounts.length == 0){
            return 0;
        }
        int max = 0;
        for(int i = 0; i < accounts.length; i++){
            int sum = 0;
            for(int j = 0; j < accounts[0].length; j++){
                sum += accounts[i][j];
            }
            if(max < sum){
                max = sum;
            }
        }
        return max;
    }
}