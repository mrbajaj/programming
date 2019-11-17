/**
 * URL:: https://leetcode.com/problems/rotate-string/
 */
class Problem796{

    public static void main(String[] args) {
        String A = "abcde";
        String B = "cdeab"; //"abced";

        System.out.println("Ans: " + rotateString(A, B));
        

    }

    public static boolean rotateString(String A, String B) {
        if(A.length() != B.length()){
            return false;
        }
        String C = A.concat(A);
        return C.indexOf(B) != -1;
    }
}