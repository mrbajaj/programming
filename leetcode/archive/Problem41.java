/**
 * URL: https://leetcode.com/problems/first-missing-positive/
 * 
 * Solved in O(logn) time expected was O(n
 * No extar memory is used
 */

 import java.util.Arrays;

class Problem41{

    public static void main(String[] args) {
        Problem41 obj = new Problem41();

        System.out.println("Expected: 1 \t:: Ans: " + obj.firstMissingPositive(new int[]{-1,-1,-2,-3}) + "\n");

        System.out.println("Expected: 2 \t:: Ans: " + obj.firstMissingPositive(new int[]{3,4,-1,1})+ "\n");

        System.out.println("Expected: 3 \t:: Ans: " + obj.firstMissingPositive(new int[]{1,2,0})+ "\n");

        System.out.println("Expected: 1 \t:: Ans: " + obj.firstMissingPositive(new int[]{2, 3, 7, 6, 8, -1, -10, 15})+ "\n");

        System.out.println("Expected: 1 \t:: Ans: " + obj.firstMissingPositive(new int[]{-1,-2,-3,100,101,200,201})+ "\n");

        System.out.println("Expected: 11 \t:: Ans: " + obj.firstMissingPositive(new int[]{-1,1,2,3,4,5,6,7,8,9,10,12})+ "\n");

        System.out.println("Expected: 11 \t:: Ans: " + obj.firstMissingPositive(new int[]{-1,1,2,3,4,5,6,7,8,9,10,10,10,10,12})+ "\n");

        System.out.println("Expected: 3 \t:: Ans: " + obj.firstMissingPositive(new int[]{0,2,2,1,1})+ "\n");

    }

    public int firstMissingPositive(int[] arr) {
        Arrays.sort(arr);

        int i=0, n = arr.length;

        while(i < n && arr[i] <= 0){
            i++;
        }

        if(i == n || arr[i] != 1){
            return 1;
        }

        int prev = arr[i];
        i++;
        while(i < n && (prev == arr[i] - 1 || prev == arr[i] ) ){
            prev = arr[i];
            i++;
        }

        if(i != n){
            return prev + 1;
        }else{
            return arr[n-1] + 1;
        }   
    }
}