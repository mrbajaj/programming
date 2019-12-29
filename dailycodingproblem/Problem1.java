import java.util.ArrayList;
import java.util.List;

/**
 * Good morning! Here's your coding interview problem for today.
 * This problem was recently asked by Google.
 * Given a list of numbers and a number k, 
 * return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * 
 * Bonus: Can you do this in one pass?
 */

public class Problem1{

    public static void main(String[] args) {
        Problem1 obj = new Problem1();

        System.out.println("Ans: " + obj.isPairExistsWithSumK(new int[]{10,15,3,7}, 17));
        
        System.out.println("Ans: " + obj.isPairExistsWithSumK(new int[]{10,15,3,7}, 2));
        
    }

    public boolean isPairExistsWithSumK(int[] arr, int k){
        List<Integer> diff = new ArrayList<>();

        for(int x: arr){
            if(diff.contains(x)){
                return true;
            }else{
                diff.add(k - x);
            }
        }


        return false;
    }

    

}
