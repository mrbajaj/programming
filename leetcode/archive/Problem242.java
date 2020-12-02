/**
 * URL: https://leetcode.com/problems/valid-anagram/
 * 
 */
class Problem242{

    public static void main(String[] args) {
        Problem242 obj = new Problem242();
        
        System.out.println("Ans: " + obj.isAnagram("anagram", "nagaram"));
        System.out.println("Ans: " + obj.isAnagram("rat", "car"));
        
    }

    public boolean isAnagram(String s, String t) {
        int MAX_CHARS = 26;
        
        
        int[] counter = new int[MAX_CHARS];

        if(s.length() != t.length()){
            return false;
        }

        for(int i=0; i < s.length(); i++){
            int x = (int)s.charAt(i) - 97;
            counter[x]++;
        }

        for(int i=0; i < t.length(); i++){
            int x = (int)t.charAt(i) - 97;
            counter[x]--;
        }

        for(int i=0; i<MAX_CHARS; i++){
            if(counter[i] != 0){
                return false;
            }
        }
        
        return true;
    }

}
