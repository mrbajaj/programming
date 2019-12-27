/**
 * URL: https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 * 
 * 
 * Time Complexity:
 * Space Complexity:
 */

class Problem674{

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,7};

        // int[] nums = new int[]{2,2,2,2,2};

        // int[] nums = new int[0];

        // int[] nums = new int[]{1};

        // int[] nums = new int[]{1,3,5,7};

        System.out.println("Ans: " + findLengthOfLCIS(nums));

    }

    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
       
        int longest = 0, currLongest = 0;
        for(int i=1; i < nums.length; i++){
            System.out.println("i="+i + ":: ");
            if(nums[i-1] < nums[i]){
                System.out.println("\tlongest="+longest +", currLongest="+currLongest);
                currLongest++;
            }else{
                if(longest < currLongest){
                    System.out.println("\t# longest="+longest +", currLongest="+currLongest);
                    longest = currLongest;
                }
                currLongest = 0;
            }
        }

        if(longest < currLongest){
            System.out.println("\t# longest="+longest +", currLongest="+currLongest);
            longest = currLongest;
        }

        return longest+1;
    }
}