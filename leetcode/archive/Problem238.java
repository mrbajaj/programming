import java.util.Arrays;

/**
 * URL: https://leetcode.com/problems/product-of-array-except-self/
 * 
 */

class Problem238{
    public static void main(String[] args) {
        
        // Solution1 sol1 = new Solution1();
        // System.out.println("Ans: " + Arrays.toString(sol1.productExceptSelf(new int[]{1,2,3,4,5})) );
        // System.out.println("Ans: " + Arrays.toString(sol1.productExceptSelf(new int[]{1,2})) );
        // System.out.println("Ans: " + Arrays.toString(sol1.productExceptSelf(new int[]{})) );

        // Solution2 sol2 = new Solution2();
        // System.out.println("Ans: " + Arrays.toString(sol2.productExceptSelf(new int[]{1,2,3,4,5})) );
        // System.out.println("Ans: " + Arrays.toString(sol2.productExceptSelf(new int[]{1,2})) );
        // System.out.println("Ans: " + Arrays.toString(sol2.productExceptSelf(new int[]{})) );

        Solution3 sol3 = new Solution3();
        System.out.println("Ans: " + Arrays.toString(sol3.productExceptSelf(new int[]{1,2,3,4,5})) );
        System.out.println("Ans: " + Arrays.toString(sol3.productExceptSelf(new int[]{1,2})) );
        System.out.println("Ans: " + Arrays.toString(sol3.productExceptSelf(new int[]{})) );

    }

    
        
}

/**
 * Using division
 */
class Solution1 {
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
}

/**
 * without division and in O(n).
 */
class Solution2{
    // productExceptSelfWithOutDivision



    public int[] productExceptSelf(int[] nums) {
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
        System.out.println("\n\tforward" + Arrays.toString(forward) );
        System.out.println("\tbackard" + Arrays.toString(backard) );

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
    
}

/**
 * with constant space
 * step0:   nums = 1   2   3   4   5
 * step1:   prods= 1   1   2   6   24
 * step2:
 *  itr1:   prods= 1    1   2   6   24       and     rightProd = 1;
 *  itr1:   prods= 1    1   2   30  24       and     rightProd = 5; 
 *  itr1:   prods= 1    1   40  30  24       and     rightProd = 20; 
 *  itr1:   prods= 1    60  40  30  24       and     rightProd = 60; 
 *  itr1:   prods= 120  60  40  30  24       and     rightProd = 120; 
 */
class Solution3 {
    //productExceptSelfWithOutDivision_Better

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        if(n == 0){
            return nums;
        }
        int[] prods = new int[n];
        
        // step 1 : 
        prods[0] = 1;
        for(int i=1; i< n; i++){
            prods[i] = prods[i-1] * nums[i-1];
        }
        
        System.out.println("\n\tprods" + Arrays.toString(prods) );
        
        int rightProd = 1;
        System.out.println("\n\tprods" + Arrays.toString(prods)  + "\t\trightProd:: " + rightProd);
        for(int i=n-2; i >= 0; i--){
            prods[i] = nums[i+1] * prods[i] * rightProd;
            rightProd = rightProd * nums[i+1];
            System.out.println("\n\tprods" + Arrays.toString(prods)  + "\t\trightProd:: " + rightProd);
        }
        return prods;

    }
}