/**
 * URL: https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 */
class Problem33{
    public static void main(String[] args) {
        Problem33 obj = new Problem33();

        System.out.println("Ans: " + obj.search(new int[]{5,7,9,11,22,25,45,75}, 45 ));
        System.out.println("Ans: " + obj.search(new int[]{5,7,9,11,22,25,45,75}, 75 ));
        System.out.println("Ans: " + obj.search(new int[]{5,7,9,11,22,25,45,75}, 55 ));
        System.out.println("Ans: " + obj.search(new int[]{5,7,9,11,22,25,45,75}, 22 ));
        System.out.println("Ans: " + obj.search(new int[]{5,7,9,11,22,25,45,75}, 11 ));
        System.out.println("Ans: " + obj.search(new int[]{5,7,9,11,22,25,45,75},5 ));
        
        //find pivot
        // System.out.println("Ans: " + obj.search(new int[]{4,5,6,7,0,1,2,3}, 6 ));
        // System.out.println("Ans: " + obj.search(new int[]{2,3,4,5,6,7,0,1}, 6 ));
        // System.out.println("Ans: " + obj.search(new int[]{7,0,1,2,3,4,5,6}, 6 ));
        // System.out.println("Ans: " + obj.search(new int[]{0,1,2,3,4,5,6,7}, 6 ));
        
    }

    public int search(int[] nums, int target) {
        int pivot = this.findPivot(nums, 0, nums.length -1);

        if(pivot == -1){
            return this.binarySearch(nums, 0, nums.length-1, target);
        }

        int ans = this.binarySearch(nums, 0, pivot-1, target);

        if(ans == -1){
            return this.binarySearch(nums, pivot, nums.length-1, target);
        }
        
        return ans;
        // return this.binarySearch(nums, 0, nums.length, target);
    }

    private int findPivot(int[] nums, int lowIndex, int highIndex){
        // System.out.print("lowIndex: " + lowIndex + "\t highIndex: " + highIndex );
        if(nums.length == 0 || lowIndex >= highIndex){
            // System.out.println("\t returning\n" );
            return -1;
        }

        int midIndex = (lowIndex + highIndex) / 2;

        // System.out.println("\tmidIndex : " + midIndex );

        if(midIndex > lowIndex && nums[midIndex - 1] > nums[midIndex]){
            return midIndex;
        }

        if(midIndex < highIndex && nums[midIndex + 1] < nums[midIndex]){
            return midIndex+1;
        }

        int left = this.findPivot(nums, lowIndex, midIndex-1);
        // System.out.println("------------------------");
        if(left == -1){
            return this.findPivot(nums, midIndex+1, highIndex);
        }
        return left;
    }

    private int binarySearch(int[] nums, int lowIndex, int highIndex, int target){
        if(nums.length == 0 || lowIndex > highIndex){
            return -1;
        }

        int mid = (lowIndex+highIndex) / 2;

        if(nums[mid] > target){
            //target is on left side of mid
            return binarySearch(nums, lowIndex, mid - 1, target);
        }else  if(nums[mid] < target){
            // target is on right side of mid
            return binarySearch(nums, mid+1, highIndex, target);
        }else{
            return mid;
        }

    }
}