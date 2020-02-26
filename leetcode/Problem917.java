/**
 * URL: https://leetcode.com/problems/reverse-only-letters/
 * 
 */
class Problem917{

    public static void main(String[] args) {
        Problem917 obj = new Problem917();

        String S = "ab-cd";
        String SR = obj.reverseOnlyLetters(S);
        System.out.println(SR);
    }

    public String reverseOnlyLetters(String S) {
        char ch[] = S.toCharArray();

        int i = 0;
        int j = S.length()-1;

        while(i < j){
            while( i < j && !isAlphabet(ch[i]) ) {
                i++;
            }
            while( i < j && !isAlphabet(ch[j]) ){
                j--;
            }

            if(i < j){
                char tmp = ch[i];
                ch[i] = ch[j];
                ch[j] = tmp;
            }
            i++;
            j--;
        }


        return new String(ch);
        
    }
    static boolean isAlphabet(char c){
        if( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
            return true;
        }

        return false;
    }
}