import java.util.Arrays;

/**
 * URL: https://leetcode.com/problems/3sum-closest/
 * 
 */

class Problem16{

    public static void main(String[] args) {
        
        Problem16 obj = new Problem16();

        System.out.println("Ans: " + obj.threeSumClosest(new int[]{-1,2,1,-4} , 1) );

        System.out.println("Ans: " + obj.threeSumClosest(new int[]{-4,-2,1,-5, 4,-3, 3, 2} , 1) );

        System.out.println("Ans: " + obj.threeSumClosest(new int[]{1,1,-1,-1,3} , -1) );

        System.out.println("Ans: " + obj.threeSumClosest(new int[]{1,1,-1} , 2) );

    }

    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);

        int n = nums.length, p, q, r;
        int sum, closestSum = nums[n-1] + nums[n-2] + nums[n-3];
        
        for(int i =0; i < n - 2; i++){
            p = i;
            q = i+1;
            r = n-1;

            while(q < r){

                sum = nums[p] + nums[q] + nums[r];
                
                if(Math.abs(target - sum) < Math.abs(target - closestSum)){
                    closestSum = sum;
                }

                if(sum > target){
                    r--;
                }else{
                    q++;
                    
                }

            }

        }

        return closestSum;
     
        
    }
}
