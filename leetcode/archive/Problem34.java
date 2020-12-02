import java.util.Arrays;

/**
 * URL: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 
 * solved with O(logn + k) complexity where n is number of elements in array
 * and k is number of occurances of target elemenets in that array
 * 
 * further it can also be solved with O(logn) by sapartely finding only first and last ocuurance of target element
 * 
 */
class Problem34{
    
    public static void main(String[] args) {

        Problem34 obj = new Problem34();
        
        System.out.println("Ans: " + Arrays.toString(obj.searchRange(new int[]{5,7,7,8,8,10}, 8)) +"\n");

        System.out.println("Ans: " + Arrays.toString(obj.searchRange(new int[]{5,7,7,8,8,10}, 6)) +"\n");

        System.out.println("Ans: " + Arrays.toString(obj.searchRange(new int[]{5,5,7,7,8,8,10}, 5)) +"\n");

    }

    public int[] searchRange(int[] nums, int target) {

        int anyIndex = this.binarySearch(nums, target, 0, nums.length-1);
        if(anyIndex == -1){
            return new int[]{anyIndex,anyIndex};
        }

        System.out.println(anyIndex);

        int firstIndex = anyIndex;
        int lastIndex = anyIndex;

        int i = anyIndex;
        while(i >= 0 && i < nums.length && nums[i] == target){
            firstIndex = i;
            i--;
        }

        i = anyIndex;
        while(i >= 0 && i < nums.length && nums[i] == target){
            lastIndex = i;
            i++;
        }
        
        
        return new int[]{firstIndex,lastIndex};
    }

    public int binarySearch(int[] nums, int target, int low, int high){
        if(low > high){
            return -1;
        }
        int mid = low + (high - low)/2;

        if(nums[mid] < target){
            return binarySearch(nums, target, mid+1, high);
        }else if(nums[mid] > target) {
            return binarySearch(nums, target, low, mid -1);
        }else {
            return mid;
        }
    }


}
