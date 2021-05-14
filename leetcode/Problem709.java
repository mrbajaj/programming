/**
 * URL: 
 * Tags: LinkedList
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class Problem709{

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Ans:" + sol.toLowerCase("Hello"));

        System.out.println("Ans:" + sol.toLowerCase("LOVELY"));
    }

}

class Solution {
    public String toLowerCase(String str) {
         char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++)
            if ('A' <= a[i] && a[i] <= 'Z')
                a[i] = (char) (a[i] - 'A' + 'a');
        return new String(a);
        
    }
}