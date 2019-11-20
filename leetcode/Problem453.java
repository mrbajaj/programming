
/**
 * URL: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 * 
 * 
 */
import java.util.Arrays;

class Problem453{

    public static void main(String[] args) {
        // int[] nums = new int[]{1,2,3};

        // int[] nums = new int[]{1,4,5,7,11};

        int[] nums = new int[]{83,86,77,15,93,35,86,92,49,21};

        

        System.out.println("Ans: " + minMoves(nums));
    }

    public static int minMoves(int[] nums){
        if (nums.length == 0) 
          return 0;
        
        int min = Arrays.stream(nums)
                        .parallel()
                        .min()
                        .getAsInt();

        
        return Arrays.stream(nums)
                        .parallel()
                        .map((val)->(val-min))
                        .sum();
    }

    public static int minMove_TLE(int[] nums) {
        int moves = 0;

        int n = nums.length;
        Arrays.sort(nums);
        
        while(!allSame(nums, n)){
            System.out.println("Making it same" + Arrays.toString(nums));
            // make all same
            
            int max = nums[n-1], min = nums[0];
            int diff =  max - min;
        
            for(int i=0; i < n-1; i++){
               nums[i] += diff;
            }

            
            int index = n-1;

            int x=n-2;
            while(max < nums[x]){
                index=x;
                x--;
            }

            for(int i = n-1; i > index; i--){
                nums[i] = nums[i-1];
            }
            nums[index] = max;

            moves+=diff;
        }

        System.out.println("All same" + Arrays.toString(nums));

        

        return moves;
    }

    public static boolean allSame(int[] nums, int n){
        if(n == 1){
            return true;
        }
        for(int i =1; i< n; i++){
            if(nums[i-1] != nums[i]){
                System.out.println("\tNot Same:" + nums[i-1] + ", "  + nums[i]);
                return false;
            }
        }

        return true;
    }
}