/**
 * URL: https://practice.geeksforgeeks.org/problems/set-bits0143/1
 * Tags: Stack
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */
import java.util.Stack;

public class BitManipulation1{
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.printBinaryRep(10);
        System.out.println("Ans:" + sol.setBits(10));

        sol.printBinaryRep(6);
        System.out.println("Ans:" + sol.setBits(6));

        sol.printBinaryRep(8);
        System.out.println("Ans:" + sol.setBits(8));
    }
}

class Solution {
    static int setBits(int N) {
        int count = 0;
        while(N != 0){
            if(N % 2 != 0){
                count++;
            }
            N /= 2;
        }
        return count;
    }

    static void printBinaryRep(int N) {
        Stack<Character> stack = new Stack<>();
        while(N != 0){
            if(N % 2 != 0){
                stack.push('1');
            }else{
                stack.push('0');
            }
            N /= 2;
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}