/**
 * URL: https://leetcode.com/problems/fibonacci-number/
 * 
 */
class Problem509{

    public static void main(String[] args) {
        Problem509 obj = new Problem509();

        System.out.println("Ans: " + obj.fib(0));
        System.out.println("Ans: " + obj.fib(1));
        System.out.println("Ans: " + obj.fib(2));
        System.out.println("Ans: " + obj.fib(3));
        System.out.println("Ans: " + obj.fib(10));

    }

    public int fib(int N) {
        if(N <= 1){
            return N;
        } else{
            return fib(N-1) + fib(N-2);
        }
    }

}