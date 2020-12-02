/**
 * URL: https://leetcode.com/problems/number-complement/
 * 
 */
public class Problem476 {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Ans:" + sol.findComplement(8));

    }
}

class Solution {
    public int findComplement(int num) {
        
        String binary = this.getBinaryComplement(num);

        int x = 0, len = binary.length();

        for(int p = len - 1, q = 0; p >= 0; p--, q++){
            int i =  Integer.parseInt(String.valueOf(binary.charAt(p)));
            x = x + (i * (int) Math.pow(2, q));
        }

        return x;
    }

    private String getBinaryComplement(int num){
        StringBuilder binary = new StringBuilder();

        while(num > 0){
            String b = (num % 2 == 0) ? "1" : "0";
            binary.append(b);
            num /= 2;
        }
        binary.reverse();
        
        return binary.toString();
    }
}