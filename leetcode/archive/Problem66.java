/**
 * URL: https://leetcode.com/problems/plus-one/
 * 
 */


import java.util.Arrays;
 
class Problem66{

    public static void main(String[] args) {
        int[] digits = new int[]{1,2,3};
        // int[] digits = new int[]{9,9,9};
        
        // int[] digits = new int[]{4,3,2,1};
        // int[] digits = new int[]{4,5,9,9};
        // int[] digits = new int[]{0};

        System.out.println("Ans" + Arrays.toString( plusOne(digits) ));

    }

    public static int[] plusOne(int[] digits) {
        int[] plusOne;
    
        int i = digits.length-1;
        while(i >= 0){
            if(digits[i] == 9){
                digits[i] = 0;
                i--;
            }else{
                break;
            }
        }
        if(i==-1){
            plusOne = new int[digits.length + 1];
            plusOne[0] = 1;
        }else{
            plusOne = digits;
            plusOne[i] = digits[i] + 1;
        }

        return plusOne;
        
    }
}