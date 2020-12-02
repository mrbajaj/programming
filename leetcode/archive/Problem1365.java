import java.util.Arrays;

/**
 * 
 * 
 */
class Problem1365{

    public static void main(String[] args) {
        Problem1365 obj = new Problem1365();
        
        System.out.println("Ans: " + Arrays.toString(obj.smallerNumbersThanCurrent(new int[]{8,1,2,2,3})) );
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i =0 ;i < nums.length; i++){
            int smallCount = 0;
            for(int j = 0; j < nums.length; j++){
                if(i != j && nums[i] > nums[j]){
                    smallCount++;
                }
            }
            ans[i] = smallCount;

        }
        
        return ans;
    }
}