/**
 * 
 */
class Problem268{

    public static void main(String[] args) {
        Problem268 obj = new Problem268();

        System.out.println("Ans: " + obj.missingNumber(new int[]{3,0,1}));


        System.out.println("Ans: " + obj.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));

        System.out.println("Ans: " + obj.missingNumber(new int[]{}));

        System.out.println("Ans: " + obj.missingNumber(new int[]{0,2}));
        

    }

    public int missingNumber(int[] nums) {
        
        int n = nums.length;
        int requiredSum = (n * (n+1) ) / 2;

        int actualSum = 0;
        for(int i=0; i < n; i++){
            actualSum += nums[i];
        }
    
        // System.out.println("requiredSum: "+ requiredSum + "\tactualSum" + actualSum);
        
        return requiredSum - actualSum;
        
    }
}