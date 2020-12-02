/**
 * URL: https://leetcode.com/problems/to-lower-case/
 * 
 */

class Problem709{
    public static void main(String[] args) {
        Problem709 obj = new Problem709();

        System.out.println("Ans: " + obj.toLowerCase("Hello") + " :: " + obj.toLowerCase_other("Hello"));

        System.out.println("Ans: " + obj.toLowerCase("here") + " :: " + obj.toLowerCase_other("here"));

        System.out.println("Ans: " + obj.toLowerCase("LOVELY") + " :: " + obj.toLowerCase_other("LOVELY"));

    }

    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                int ascci = (int) ch + ( (int)'a' - (int)'Z' + 26 - 1);
                ch = (char) ascci;
            }
            sb.append(String.valueOf(ch));
        }
        return sb.toString();
    }

    public String toLowerCase_other(String str) {
        char[] charArr = str.toCharArray();

        for(int i=0; i < str.length(); i++){
            if(charArr[i] >= 'A' && charArr[i] <= 'Z'){
                charArr[i] = (char) (charArr[i] + 32);
            }
        }
        return String.valueOf(charArr);
    }

    public String toLowerCase_other2(String str) {
        char[] charArr = str.toCharArray();

        for(int i=0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                int ascci = (int) ch + ( (int)'a' - (int)'Z' + 26 - 1);
                ch = (char) ascci;
                charArr[i] = (char) (charArr[i] + 32);
            }
            charArr[i] = ch;
        }
        return String.valueOf(charArr);
    }
}