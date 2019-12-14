
/**
 * URL: https://leetcode.com/problems/fizz-buzz/ 
 * 
 */
import java.util.ArrayList;
import java.util.List;

class Problem412 {

    public static void main(String[] args) {
        int n = 15;

        System.out.println("Ans: " + fizzBuzz(n));

    }

    public static List<String> fizzBuzz(int n) {
        List<String> response = new ArrayList<>();
        for(int i=1; i <= n; i++){
            if(i%3 == 0 && i%5 == 0){
                response.add("FizzBuzz");
            }else if(i%3 == 0){
                response.add("Fizz");
            }else if(i%5 == 0){
                response.add("Buzz");
            }else{
                response.add(Integer.toString(i));
            }
        }
        return response;
    }
}