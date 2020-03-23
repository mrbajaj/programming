/**
 * URL: https://leetcode.com/problems/excel-sheet-column-title/
 * 
 */
class Problem168{

    public static void main(String[] args) {
        Problem168 obj = new Problem168();
        System.out.println("Ans: " + obj.convertToTitle(1) + "\n"); // A
        System.out.println("Ans: " + obj.convertToTitle(3) + "\n"); // C
        System.out.println("Ans: " + obj.convertToTitle(26) + "\n"); // Z
        System.out.println("Ans: " + obj.convertToTitle(28) + "\n"); // AB
        System.out.println("Ans: " + obj.convertToTitle(52) + "\n"); // AZ
        System.out.println("Ans: " + obj.convertToTitle(701) + "\n"); // ZY
        System.out.println("Ans: " + obj.convertToTitle(1200) + "\n"); // ATD
    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        System.out.println("n:" + n);

        while(n > 0){
            n--;
            
            int rem = n%26;
            System.out.println("n:" + n + "\t rem:" + rem);
            sb.insert(0, (char) (rem+65));

            n /= 26;
        }

        return sb.toString();
    }
            
}