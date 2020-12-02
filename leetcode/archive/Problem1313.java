/**
 * URL: https://leetcode.com/problems/decompress-run-length-encoded-list/
 * 
 */
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Problem1313{

    public static void main(String[] args) {
        Problem1313 obj = new Problem1313();

        System.out.println("Ans: " + Arrays.toString( obj.decompressRLElist(new int[]{1,2,3,4})));

    }

    public int[] decompressRLElist(int[] nums) {
        List<Integer> ans = new ArrayList<>();
       
        for(int i=0; i<nums.length; i+=2){
            int freq = nums[i];
            int val = nums[i+1];
            for(int j=0; j < freq; j++){
                ans.add(val);
            }
        }
        int[] arr = new int[ans.size()];
       
        for(int i=0; i< ans.size(); i++){
            arr[i] = ans.get(i);
        }
       
        return arr;
       
    }
}