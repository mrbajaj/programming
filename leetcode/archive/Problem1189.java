/**
 * URL: https://leetcode.com/problems/maximum-number-of-balloons/
 * 
 */
import java.util.Scanner;

class Problem1189{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        Problem1189 obj = new Problem1189();

        int count = obj.maxNumberOfBalloons(text.toLowerCase());

        System.out.println("Ans: " + count);

        sc.close();
    }

    public int maxNumberOfBalloons(String text) {
        int[] charCount = new int[26];

        for(int i=0; i < text.length(); i++){
            int ascii = (int)text.charAt(i);
            int index = ascii - 97;
            charCount[index]++;
        }
        int count = 0;
        while(charCount[1] >=1 && charCount[0] >=1 && charCount[11] >= 2  && charCount[14] >= 2  && charCount[13] >= 1){
            charCount[1]--; //b
            charCount[0]--; //a
            charCount[11]--; charCount[11]--; //ll
            charCount[14]--; charCount[14]--; //oo
            charCount[13]--; //n
            count++;   
        }
        return count;
    }    
}