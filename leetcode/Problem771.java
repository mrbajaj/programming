/**
 * URL: https://leetcode.com/problems/jewels-and-stones/
 * 
 */
class Problem771{

    public static void main(String[] args) {
        
        Problem771 obj = new Problem771();

        // String J = "aA";
        // String S = "aAAbbbb";
        // System.out.println("Ans: " + obj.numJewelsInStones(J, S));

        String J = "z";
        String S = "ZZ";
        System.out.println("Ans: " + obj.numJewelsInStones(J, S));

    }

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        
        for(int i = 0; i < S.length() ; i++){
            for(int j = 0; j < J.length(); j++){
                if(J.charAt(j) == S.charAt(i)){
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }
}