/**
 * 
 */
import java.util.Arrays;

public class Problem189 {

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        
        int[] arr = new int[]{1,2,3,4,5,6,7};
        sol.rotate(arr, 3);
        System.out.println("Ans:" + Arrays.toString(arr) );

    }

}
class Solution1 {
    // Time: O(n) , Space: O(k)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] tmp = new int[k];
        System.out.println("K:" + k );
        if(k == 0){ return; }

        for(int i = n - 1, j = k - 1; i >= 0 && j >=0; i--,  j--  ){
            tmp[j] = nums[i];
        }

        for(int i = n - k - 1, j = n -1; i >= 0; i--, j--){
            nums[j] = nums[i];
        }

        for(int i = 0; i < k; i++){
            nums[i] = tmp[i];
        }

        System.out.println("Tmp:" + Arrays.toString(tmp) );
    }
}

class Solution2 {
    // Time: O(n * k) , Space: O(1)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        System.out.println("K:" + k );
        if(k == 0){ return; }

        for(int i = 0; i < k; i++){
            this.rotateRight(nums, n);
        }
    }

    public void rotateRight(int[] nums, int n) {
        int tmp = nums[n-1];
        
        for(int i = n-2; i >= 0; i--){
            nums[i+1] = nums[i];
        }
        nums[0] = tmp;
        System.out.println("Rotate by one:" + Arrays.toString(nums) );
    }
}