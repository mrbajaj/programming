/**
 * URL:: https://leetcode.com/problems/rotate-string/
 * 
 */
class Problem796{

    public static void main(String[] args) {

        Problem796 obj = new Problem796();
        
        System.out.println("Ans: " + obj.rotateString("abcde", "cdeab"));

        System.out.println("Ans: " + obj.rotateString("abcde", "abced"));

        

    }

    public boolean rotateString(String A, String B) {
        if(A.length() != B.length()){
            return false;
        }
        String C = A.concat(A);
        return C.indexOf(B) != -1;
    }
}