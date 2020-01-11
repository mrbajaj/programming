import java.util.Arrays;
/**
 * Good morning! Here's your coding interview problem for today.
 * This problem was asked by Stripe.
 * Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
 * 
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 * 
 * You can modify the input array in-place.
 */

 class Problem4{

    public static void main(String[] args) {
        Problem4 obj = new Problem4();

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