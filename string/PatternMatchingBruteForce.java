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


    public int[] getPrefixArray(String P){
        int M = P.length();
        int[] psT = new int[M];
        
        int i = 1;
        int len = 0;

        psT[0] = len;
        while (i < M) { 
            if (P.charAt(i) == P.charAt(len)) { 
                len++; 
                psT[i] = len; 
                i++; 
            } else { 
                if (len != 0) { 
                    len = psT[len - 1]; 
                } 
                else { 
                    psT[i] = len; 
                    i++; 
                } 
            } 
        } 
       
        return psT;
    }
}