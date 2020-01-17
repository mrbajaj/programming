/**
 * URL: https://leetcode.com/problems/palindrome-number/
 * 
 */

class Problem9{

    public static void main(String[] args) {
        Problem9 obj = new Problem9();
        System.out.println("Ans: " + obj.isPalindrome(121));
        System.out.println("Ans: " + obj.isPalindrome(-121));
    }

    public boolean isPalindrome(int x) {
        char[] arr = String.valueOf(x).toCharArray();
       
        int i = 0, j = arr.length -1;
       
        while(i < j){
            if(arr[i] != arr[j]){
                return false;
            }
            i++;
            j--;
        }
       
        return true;
    }

    public boolean isPalindrome_better(int x) {
        
        if(x < 0){
            return false;
        }
        int r = 0;
       
        int tmp = x;
        while( tmp != 0){
            r = r * 10 + tmp % 10;
            tmp = tmp / 10;
        }
       
        return x == r;
    }
}