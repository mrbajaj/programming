/**
 * URL: https://leetcode.com/problems/shifting-letters/
 * 
 */
class Problem848{
    public static void main(String[] args) {
        Problem848 obj = new Problem848();
        
        System.out.println("Expected: d :=: Ans: " + obj.shiftingLetters("a", new int[]{3}));

        System.out.println("Expected: rpl :=: Ans: " + obj.shiftingLetters("abc", new int[]{3,5,9}));

        System.out.println("Expected: bzvn :=: Ans: " + obj.shiftingLetters("abcd", new int[]{3,5,9,10}));

        System.out.println("Expected: wqqwlcjnkphhsyvrkdod :=: Ans: " + obj.shiftingLetters("mkgfzkkuxownxvfvxasy", new int[]{505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513}));

    }

    public String shiftingLetters(String S, int[] shifts) {
        StringBuilder ans = new StringBuilder();
        
        int lowerStart = 97;
        
        for(int i = 0; i < shifts.length ; i++ ){
            shifts[i] = shifts[i]%26;
        }

        for(int i = shifts.length -2; i >= 0 ; i-- ){
            shifts[i] += shifts[i+1];
        }
        // System.out.println(Arrays.toString(shifts) );

        for(int i=0 ; i< S.length(); i++){
            int x = (int) S.charAt(i) + shifts[i] - lowerStart;
            x = x%26 + lowerStart;
            // System.out.println("##" +String.valueOf((char) x));
            String tmp = Character.toString((char) x);
            ans.append(tmp);
        }
    
        return ans.toString();
    }
}