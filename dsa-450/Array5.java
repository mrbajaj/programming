/**
 * URL: 
 * Tags: Array
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */
import java.util.Arrays;

 public class Array5{

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] arr = new int[]{-1,2,3,4,-3,-4,5,6};
        sol.rearrangeNegativeFirst(arr); System.out.println(Arrays.toString(arr));
        sol.rearrangePositiveFirst(arr); System.out.println(Arrays.toString(arr));
        
    }
 }

 class Solution{

    public void rearrangePositiveFirst(int[] arr){
        int size = arr.length;

        int neg = 0, nonneg = size - 1;

        while(neg < nonneg){
            if(arr[neg] >= 0){
                neg++;
                continue;
            }

            if(arr[nonneg] < 0){
                nonneg--;
                continue;
            }

            if(arr[neg] < 0 && arr[nonneg] >= 0){
                int tmp = arr[neg];
                arr[neg] = arr[nonneg];
                arr[nonneg] = tmp;
                neg++;
                nonneg--;
            }
        }

    }

    public void rearrangeNegativeFirst(int[] arr){
        int size = arr.length;

        int neg = 0, nonneg = size - 1;

        while(neg < nonneg){
            System.out.println(neg + " " + nonneg);
            if(arr[neg] < 0){
                neg++; continue;
            }

            if(arr[nonneg] >= 0){
                nonneg--; continue;
            }

            if(arr[neg] >= 0 && arr[nonneg] < 0){
                int tmp = arr[neg];
                arr[neg] = arr[nonneg];
                arr[nonneg] = tmp;
                neg++;
                nonneg--;
            }
            
        }
        
    }

 }