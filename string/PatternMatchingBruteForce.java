import java.util.Arrays;

class PatternMatchingBruteForce{

    public static void main(String[] args) {
        PatternMatchingBruteForce obj = new PatternMatchingBruteForce();
        String T = "abcabcpqabxabcdxy";
        String P = "abcd";
        System.out.println("T: " + T);
        System.out.println("P: " + P);
        int firstIndex = obj.patterMatching(T, P);
        System.out.println(firstIndex + ":\t" + T.substring(firstIndex, firstIndex + P.length()));
        System.out.println("-----------------------------------------");

        T = "aaaaaaaaaab";
        P = "aaab";
        System.out.println("T: " + T);
        System.out.println("P: " + P);
        firstIndex = obj.patterMatching(T, P);
        System.out.println(firstIndex + ":\t" + T.substring(firstIndex, firstIndex + P.length()));
        System.out.println("-----------------------------------------");

        T = "aabcabaabcxaabcabaalqpaabcabaabca";
        P = "aabcabaabca";
        System.out.println("T: " + T);
        System.out.println("P: " + P);
        firstIndex = obj.patterMatching(T, P);
        System.out.println(firstIndex + ":\t" + T.substring(firstIndex, firstIndex + P.length()));
        System.out.println("-----------------------------------------");

        T = "AAAAACAAACAAAA";
        P = "AAACAAAA";
        System.out.println("T: " + T);
        System.out.println("P: " + P);
        firstIndex = obj.patterMatching(T, P);
        System.out.println(firstIndex + ":\t" + T.substring(firstIndex, firstIndex + P.length()));
        
    }

    public int patterMatching(String T, String P){
        int n = T.length();
        int m = P.length();
        int i = 0 ;
        while(i <= n - m){
            int j = 0;
            while(j < m && T.charAt(i+j) == P.charAt(j)){
                j++;
            }

            if(j == m){
                return i;
            }
            i++;
        }


        return -1;
    }

}