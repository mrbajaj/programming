/**
 * URL: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 * 
 */

class Problem1342{

    public static void main(String[] args) {
        Problem1342 obj = new Problem1342();

        System.out.println("Ans: " + obj.numberOfSteps(14));

    }

    public int numberOfSteps(int n) {
        int count = 0;

        while(n != 0){

            if(n % 2 == 0){
                n = n/2;
            }else{
                n--;
            }
            count++;
        }


        return count;
    }
}