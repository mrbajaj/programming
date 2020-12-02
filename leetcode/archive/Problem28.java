/**
 * URL: https://leetcode.com/problems/implement-strstr/
 * 
 */

 class Problem28{

    public static void main(String[] args) {

        Problem28 obj = new Problem28();

        String haystack = "hello", needle = "ll";

        System.out.println("Ans: " + obj.strStr(haystack, needle));

    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
 }
