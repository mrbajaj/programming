/**
 * URL: https://leetcode.com/problems/string-compression/
 */
class Problem443{
    public static void main(String[] args) {
        Problem443 obj = new Problem443();
        System.out.println("Ans: " + obj.compress(new char[]{'a','a','b','b','b','c','c','c','c'}) + "\n");

        System.out.println("Ans: " + obj.compress(new char[]{'a','b'}) + "\n");

        System.out.println("Ans: " + obj.compress(new char[]{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','b'}) + "\n");
    }

    public int compress(char[] chars) {
        int strLen = 0;
        if(chars.length == 0){
            return strLen;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<chars.length; i++){
            int currCount = 0;
            char currChar = chars[i];
            while(i<chars.length && chars[i] == currChar){
                currCount++;
                i++;
            }
            i--;

            strLen += 1;
            sb.append(String.valueOf(currChar));
            if(currCount > 1){
                String currCountStr = String.valueOf(currCount);
                strLen += currCountStr.length();
                sb.append(currCountStr);
            }

        }

        for(int i = 0; i< sb.length(); i++){
            chars[i] = sb.charAt(i);
        }
        // System.out.println(sb.toString());
        // System.out.println(String.valueOf(chars));
        return strLen;
    }

}