/**
 * URL: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 * 
 */

class Problem1342{

    public static void main(String[] args) {
        Solution1 sol1 = new Solution1();
        Solution2 sol2 = new Solution2();
        Solution3 sol3 = new Solution3();

        System.out.println("Ans: " + sol1.numberOfSteps(14));
        System.out.println("Ans: " + sol2.numberOfSteps(14));
        System.out.println("Ans: " + sol3.numberOfSteps(14));

    }

    
}

class Solution1{
    public int numberOfSteps(int n) {
        // iterative
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

class Solution2{
    // recursive
    public int numberOfSteps(int n) {
        if(n == 0){
            return 0;
        }
        if(n % 2 == 0){
            return 1 + numberOfSteps(n/2);
        }else{
            return 1 + numberOfSteps(n-1);
        }
    }
}

class Solution3{
    // bit manipulation
    public int numberOfSteps(int n) {
        // TODO
        return 0;
    }
}