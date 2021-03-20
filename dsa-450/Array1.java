
/*
 * 
 * link: https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
 */
import java.util.Arrays;

public class Array1{

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[]{};
        System.out.println(Arrays.toString(sol.reverseIterative(arr)));
        
        arr = new int[]{1};
        System.out.println(Arrays.toString(sol.reverseIterative(arr)));

        arr = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(sol.reverseIterative(arr)));

        arr = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(sol.reverseIterative(arr)));

    }
}

class Solution{
    public int[] reverseIterative(int[] arr){
        int n = arr.length;
        if(n <= 1){
            return arr;
        }
        
        for(int i = 0; i < n/2; i++){
            int tmp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = tmp;
        }
        return arr;
    }
}