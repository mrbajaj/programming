/**
 * URL: https://leetcode.com/problems/valid-palindrome/
 * 
 */
class Problem125{
    public static void main(String[] args) {

        Problem125 obj = new Problem125();

        System.out.println("Ans: " + obj.isPalindrome("A man, a plan, a canal: Panama") + "\n");

        System.out.println("Ans: " + obj.isPalindrome("race a car"));

        System.out.println("Ans: " + obj.isPalindrome("") + "\n");

        System.out.println("Ans: " + obj.isPalindrome("mayam") + "\n");

        System.out.println("Ans: " + obj.isPalindrome("m") + "\n");

        System.out.println("Ans: " + obj.isPalindrome("ama") + "\n");

        System.out.println("Ans: " + obj.isPalindrome("aabb") + "\n");

        System.out.println("Ans: " + obj.isPalindrome("maam") + "\n");
        

    }

    public boolean isPalindrome(String s) {

        s = s.toLowerCase();
        s = s.replaceAll("\\W+", "");
        
        int i = 0, j = s.length() -1;
        
        while(i < j && s.charAt(i) == s.charAt(j)){
            i++; j--;    
        }
        
        System.out.println(s + " :: " + i + " " + j);
        

        return (i>=j) ? true : false;
        
    }

    public boolean isPalindrome_javaSolution(){
        
        if(s.isEmpty()) return true;
        
        StringBuilder bld = new StringBuilder(s.replaceAll("[^a-zA-Z0-9]", ""));
        
        return bld.toString().equalsIgnoreCase(bld.reverse().toString());

    }
}