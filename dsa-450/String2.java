/**
 * URL: https://leetcode.com/problems/valid-palindrome/
 * Tags: LinkedList
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */


 public class String2{

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("aa, b b, aa: " + sol.isPalindrome("aa, b8b, aa") );

        System.out.println("aabbaa: " + sol.isPalindrome("aabbaa") );

        System.out.println("abcba: " + sol.isPalindrome("abcba") );

        System.out.println("aaa: " + sol.isPalindrome("aaa") );

        System.out.println("a: " + sol.isPalindrome("a") );

        System.out.println("ab: " + sol.isPalindrome("ab") );

    }

 }

 class Solution {
    public boolean isPalindrome(String s) {
        
        int i = 0, j = s.length() - 1;
        s = s.toLowerCase();

        while(i<=j){
            int Iascii = (int) s.charAt(i);
            if(! ( (Iascii >= 97 && Iascii <= 122) ||  (Iascii >= 48 && Iascii <= 57) ) ){i++; continue; }

            int Jascii = (int) s.charAt(j);
            if(! ( (Jascii >= 97 && Jascii <= 122) ||  (Jascii >= 48 && Jascii <= 57) ) ){ j--; continue; }

            if( s.charAt(i) != s.charAt(j) ){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}