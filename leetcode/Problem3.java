/**
 * URL: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
import java.util.Scanner;

class Problem3{

    public static void main(String[] args) {
        Problem3 obj = new Problem3();
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int maxLen = obj.lengthOfLongestSubstring(s);

        System.out.println(maxLen);

        sc.close();
    }

    public int lengthOfLongestSubstring(String s) {
        int strLen = s.length();

        int maxLen = 0, curLen = 0, startIndex = -1;

        for(int i = 0; i < strLen; i++ ){
            for(int j = i + maxLen; j < strLen; j++){
                // System.out.print(s.substring(i, j+1) + "\t");
                if( isValidSubstring(s, i, j)){
                    // System.out.println("Valid");
                    curLen = j - i + 1;
                    if(maxLen < curLen){
                        maxLen = curLen;
                        startIndex = i;
                    }
                    
                }else{
                    // System.out.println("Invalid");
                    break;
                }
            }
        }
        // System.out.println("Starting Index: " + startIndex);
        return maxLen;
    }

    public static boolean isValidSubstring(String str, int start, int end){
        int[] charCount = new int[256];
        
        for(int i = start; i <= end; i++){
            int index = (int)str.charAt(i);;
            charCount[index]++;
        }

        for(int i=0; i<charCount.length; i++){
            if(charCount[i] >1){
                return false;
            }
        }
        return true;
    }
}