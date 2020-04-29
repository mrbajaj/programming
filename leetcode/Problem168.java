/**
 * URL: https://leetcode.com/problems/excel-sheet-column-title/
 * 
 */
class Problem168{

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println("Ans: A | " + obj.convertToTitle(1) + "\n"); // A
        System.out.println("Ans: C | " + obj.convertToTitle(3) + "\n"); // C
        System.out.println("Ans: Z | " + obj.convertToTitle(26) + "\n"); // Z
        System.out.println("Ans: AB | " + obj.convertToTitle(28) + "\n"); // AB
        System.out.println("Ans: AZ | " + obj.convertToTitle(52) + "\n"); // AZ
        System.out.println("Ans: ZY | " + obj.convertToTitle(701) + "\n"); // ZY
        System.out.println("Ans: ATD | " + obj.convertToTitle(1200) + "\n"); // ATD
    }

  
            
}

class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            n--;
            int r = n % 26;
            sb.insert(0, (char) (r+65));
            n /= 26;
        }
       
        return sb.toString();
    }
}