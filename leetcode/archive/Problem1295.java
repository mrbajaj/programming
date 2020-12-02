/**
 * 
 * URL: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 */
class Problem1295{

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Ans: " + sol.findNumbers(new int[]{12,345,2,6,7896}));
        System.out.println("Ans: " + sol.findNumbers(new int[]{555,901,482,1771}));


    }

    

    
}

class Solution{
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(this.isEvenNumberOfDigits(nums[i])){
                count++;
            }
        }
        return count;
    }

    private boolean isEvenNumberOfDigits(int num){
        int digitCount = 0;
        while(num != 0){
            num /= 10;
            digitCount++;
        }

        if(digitCount % 2 == 0){
            return true;
        }
        return false;
        
    }
}