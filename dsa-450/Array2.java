
/*
 * 
 * link: https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
 */
import java.util.Arrays;

public class Array2{

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[]{};
        System.out.println("Max:" + sol.max(arr));
        System.out.println("Min:" + sol.min(arr));
        
        arr = new int[]{1};
        System.out.println("Max:" + sol.max(arr));
        System.out.println("Min:" + sol.min(arr));

        arr = new int[]{1,2,3,4};
        System.out.println("Max:" + sol.max(arr));
        System.out.println("Min:" + sol.min(arr));

        arr = new int[]{1,2,3,4,5};
        System.out.println("Max:" + sol.max(arr));
        System.out.println("Min:" + sol.min(arr));

    }
}

class Solution{
    public int max(int[] arr){
        int n = arr.length;
        if(n < 1){
            return -1;
        }
        int max = arr[0];
        for(int i = 1; i < n; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    public int min(int[] arr){
        int n = arr.length;
        if(n < 1){
            return -1;
        }
        int min = arr[0];
        for(int i = 1; i < n; i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }
}