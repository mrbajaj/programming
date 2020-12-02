import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * URL: https://leetcode.com/problems/squares-of-a-sorted-array/
 * 
 */

class Problem977{

    public static void main(String[] args) {
        Problem977 obj = new Problem977();

        int[] arr = {-4,-1,0,3,10};

        int[] ans = obj.sortedSquares(arr);

        

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(ans));
        

    }

    public int[] sortedSquares(int[] arr) {
        return Arrays.stream(arr)
        .map(a -> a*a)
        .sorted()
        .toArray();    
    }
}