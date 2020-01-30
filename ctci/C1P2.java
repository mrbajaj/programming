/**
 * Chapter 1 : Problem 2
 *  Check Permutation
 * 
 * 
 * Leetcode: [242] https://leetcode.com/problems/valid-anagram/
 * 
 */

class C1P2{

    private static final int ASCII = 256;
    public static void main(String[] args) {
        C1P2 obj = new C1P2();

        System.out.println("Ans: " + obj.checkPermutation("dog", "god"));

        System.out.println("Ans: " + obj.checkPermutation("amyru","mayur"));

        System.out.println("Ans: " + obj.checkPermutation("mmm","ppp"));
        
    }

    public boolean checkPermutation(String p, String q){
        if(p.length() != q.length()){
            return false;
        }

        int[] freq = new int[ASCII];

        for(int i=0; i<p.length(); i++ ){
            int index = (int) p.charAt(i);
            freq[index]++;
        }

        for(int i=0; i<q.length(); i++ ){
            int index = (int) q.charAt(i);
            if(freq[index] <= 0){
                return false;
            }
            freq[index]--;
        }

        return true;
    }
}

