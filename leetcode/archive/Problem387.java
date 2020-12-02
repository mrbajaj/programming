import java.util.Arrays;

/**
 * URL: https://leetcode.com/problems/first-unique-character-in-a-string/
 * 
 */
class Problem387{
    public static void main(String[] args) {

        Problem387 obj = new Problem387();

        System.out.println("Ans: " +  obj.firstUniqChar("leetcode"));

        System.out.println("Ans: " +  obj.firstUniqChar("loveleetcode"));

        System.out.println("Ans: " +  obj.firstUniqChar("lllll"));

        
    }

    public int firstUniqChar(String s) {
        int MAX = 26;
        int LOWERCASE_ASCII_START = 97;
        int[] freq = new int[MAX];

        for(int i=0; i< s.length(); i++){
            int index = (int)s.charAt(i) - LOWERCASE_ASCII_START;
            freq[index]++;
        }

        for(int i=0; i< s.length(); i++){
            int index = (int)s.charAt(i) - LOWERCASE_ASCII_START;
            if(freq[index] == 1){
                return i;
            }
        }
        
        return -1;


    }
}