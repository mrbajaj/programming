import java.util.Arrays;

/**
 * URL:
 * 
 */

class Problem171{

    public static void main(String[] args) {
        // String s = "A";
        // String s = "AA";
        // String s = "CZ";
        // String s = "ABZ";
        String s = "ZY";


        System.out.println("Ans: " + titleToNumber(s));
    }

    public static int titleToNumber(String s) {
        int value = 0;
        char[] charArr = s.toCharArray();
        int n = charArr.length;

        // System.out.println("Reversed:: " + Arrays.toString(charArr));

        for(int i=0; i < n / 2; i++){
            char tmp = charArr[i];
            charArr[i] = charArr[n-i-1];
            charArr[n-i-1] = tmp;
        }

        for(int i=0; i< n; i++){
            int x = (int) charArr[i] - 65 + 1;
            // System.out.println("Char: " + charArr[i] + " = " + x);
            value = value + ( x * (int)(Math.pow(26, i)) );
        }

        // System.out.println("Reversed:: " + Arrays.toString(charArr));

        return value;
    }
}

