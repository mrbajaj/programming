import java.util.Arrays;

/**
 * URL: https://leetcode.com/problems/product-of-array-except-self/
 * 
 */

class Problem238{
    public static void main(String[] args) {
        
        Problem238 obj = new Problem238();

        System.out.println("Ans: " + Arrays.toString(obj.productExceptSelf(new int[]{1,2,3,4,5})) );

        System.out.println("Ans: " + Arrays.toString(obj.productExceptSelfWithOutDivision(new int[]{1,2,3,4,5})) );
        System.out.println("Ans: " + Arrays.toString(obj.productExceptSelfWithOutDivision(new int[]{1,2})) );
        System.out.println("Ans: " + Arrays.toString(obj.productExceptSelfWithOutDivision(new int[]{})) );

        // System.out.println("Ans: " + Arrays.toString(obj.productExceptSelfWithOutDivision_Better(new int[]{1,2,3,4,5})) );
        // System.out.println("Ans: " + Arrays.toString(obj.productExceptSelfWithOutDivision_Better(new int[]{1,2})) );
        // System.out.println("Ans: " + Arrays.toString(obj.productExceptSelfWithOutDivision_Better(new int[]{})) );

    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prods = new int[n];

        int allProd = 1;

        for(int x : nums){
            allProd *= x;
        }
        
        for(int i=0; i< n; i++){
            prods[i] = allProd / nums[i];
        }

        return prods;

    }

    public int[] productExceptSelfWithOutDivision(int[] nums) {
        int n = nums.length;
        
        if(n == 0){
            return nums;
        }
        int[] forward = new int[n];
        int[] backard = new int[n];
        int[] prods = new int[n];
        

        
        forward[0]  = nums[0];
        for(int i=1; i< n; i++){
            forward[i] = forward[i-1] * nums[i];
        }

        backard[n-1] = nums[n-1];
        for(int i=n-2; i >= 0; i--){
            backard[i] = backard[i+1] * nums[i];
        }

        for(int i = 0; i < n ; i++){
            if(i == 0){
                prods[i] = backard[i+1];
            }else if( i == n-1){
                prods[i] = forward[i-1];
            }else{
                prods[i] = forward[i-1] * backard[i+1];
            }
        }
        

        return prods;

    }

    public int[] productExceptSelfWithOutDivision_Better(int[] nums) {
        
        //TODO

        return nums;

    }
        
}