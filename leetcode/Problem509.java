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

    public int fibRec(int N) {
        if(N <= 1){
            return N;
        } else{
            return fib(N-1) + fib(N-2);
        }
    }

    public int fib(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        
        for(int i = 2; i <= n; i++){
            arr[i] = arr[i-2] + arr[i-1];
        }
        return arr[n];
    }

}