import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

/**
 * URL: https://leetcode.com/problems/count-and-say/
 * 
 */
class Problem38{
    public static void main(String[] args) {
        Problem38 obj = new Problem38();

        System.out.println(obj.countAndSay(1).equals("1"));

        System.out.println(obj.countAndSay(2).equals("11"));

        System.out.println(obj.countAndSay(5).equals("111221"));

    }

    public String countAndSay(int n) {
        String baseX = "1";
        if(n == 1){
            return baseX;
        }

        while(n != 1){
            baseX = this.countAndSayRec(baseX);
            n--;
        }
        
        return baseX;
    }


    public String countAndSayRec(String x){
        char[] charArray = x.toCharArray();
        int len = charArray.length;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < len;){
            int currCharCount = 0;
            char currChar = charArray[i];
            while(i < len && charArray[i] == currChar){
                currCharCount++;
                i++;
            }

            sb.append((char)(currCharCount +'0') );
            sb.append(currChar);

            // System.out.println(charArray[i-1] + " ::: " +sb.toString());
        }

        return sb.toString();
    }

}