/**
 * URL: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Note: solved but not the optimal solution
 * Time Complexity:
 * Space Complexity:
 */
import java.util.Scanner;

class Problem3{

    public static void main(String[] args) {
        Problem3 obj = new Problem3();
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine(); //abcabcbb

        int maxLen = obj.lengthOfLongestSubstring(s);

        System.out.println(maxLen); // 3

        sc.close();
    }

    public int lengthOfLongestSubstring(String s) {
        int strLen = s.length();

        int maxLen = 0, curLen = 0;

        for(int i = 0; i < strLen; i++ ){
            for(int j = i + maxLen; j < strLen; j++){
                // System.out.print(s.substring(i, j+1) + "\t");
                if( this.isValidSubstring(s, i, j)){
                    // System.out.println("Valid");
                    curLen = j - i + 1;
                    if(maxLen < curLen){
                        maxLen = curLen;
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

    public boolean isValidSubstring(String str, int start, int end){
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