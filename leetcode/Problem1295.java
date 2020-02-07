/**
 * 
 * URL: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 */
class Problem1295{

    public static void main(String[] args) {
        Problem1295 obj = new Problem1295();

        System.out.println("Ans: " + obj.findNumbers(new int[]{12,345,2,6,7896}));
        System.out.println("Ans: " + obj.findNumbers(new int[]{555,901,482,1771}));
    }

    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i=0; i< nums.length; i++){
            count = (this.isEvenNumer(nums[i])) ? count + 1 : count;
        }

        return count;
    }

    public boolean isEvenNumer(int num){
        int numOfDigits = 0;
        while(num != 0){
            numOfDigits++;
            num /= 10;
        }
        return (numOfDigits % 2 == 0)? true : false;
    }
}