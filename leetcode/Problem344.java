import java.util.Arrays;

/**
 * URL: https://leetcode.com/problems/reverse-string/
 * 
 */
class Problem344{

    public static void main(String[] args) {
        
        Problem344 obj = new Problem344();

        char[] s = new char[]{'a','b','c','d','H'};
        obj.reverseString( s );
        System.out.println("Ans: " +  Arrays.toString(s));
        
    }

    public void reverseString(char[] s) {
        
        int i = 0, j = s.length -1;

        while(i < j){
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
    }
}