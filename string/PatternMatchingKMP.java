import java.util.Arrays;

class PatternMatchingKMP{

    public static void main(String[] args) {
        PatternMatchingKMP obj = new PatternMatchingKMP();
        String T = "abcabcpqabxabcdxy";
        String P = "abcd";
        int[] psT = obj.getPrefixArray(P);
        System.out.println("T: " + T);
        System.out.println("P: " + P);
        System.out.println(Arrays.toString(psT));
        int firstIndex = obj.patterMatching(T, P, psT);
        System.out.println(firstIndex + ":\t" + T.substring(firstIndex, firstIndex + P.length()));
        System.out.println("-----------------------------------------");

        T = "aaaaaaaaaab";
        P = "aaab";
        int[] psT2 = obj.getPrefixArray(P);
        System.out.println("T: " + T);
        System.out.println("P: " + P);
        System.out.println(Arrays.toString(psT2));
        firstIndex = obj.patterMatching(T, P, psT2);
        System.out.println(firstIndex + ":\t" + T.substring(firstIndex, firstIndex + P.length()));
        System.out.println("-----------------------------------------");

        T = "aabcabaabcxaabcabaalqpaabcabaabca";
        P = "aabcabaabca";
        
        int[] psT3 = obj.getPrefixArray(P);
        System.out.println("T: " + T);
        System.out.println("P: " + P);
        System.out.println(Arrays.toString(psT3));
        firstIndex = obj.patterMatching(T, P, psT3);
        System.out.println(firstIndex + ":\t" + T.substring(firstIndex, firstIndex + P.length()));
        System.out.println("-----------------------------------------");

        T = "AAAAACAAACAAAA";
        P = "AAACAAAA";
        int[] psT4 = obj.getPrefixArray(P);
        System.out.println("T: " + T);
        System.out.println("P: " + P);
        System.out.println(Arrays.toString(psT4));
        firstIndex = obj.patterMatching(T, P, psT4);
        System.out.println(firstIndex + ":\t" + T.substring(firstIndex, firstIndex + P.length()));


        T = "PQRSPQRSPQRSPQRSPQRSPQRS";
        P = "AAACAAAA";
        int[] psT5 = obj.getPrefixArray(P);
        System.out.println("T: " + T);
        System.out.println("P: " + P);
        System.out.println(Arrays.toString(psT5));
        firstIndex = obj.patterMatching(T, P, psT5);
        if(firstIndex != -1){
            System.out.println(firstIndex + ":\t" + T.substring(firstIndex, firstIndex + P.length()));
        }else{
            System.out.println("Not Found");
        }
        
        
    }

    public int patterMatching(String T, String P, int[] lps){
        int N = T.length();
        int M = P.length();
        int i =0, j = 0;
        while(i < N && j < M){
            
            if(T.charAt(i) == P.charAt(j)){
                i++;
                j++;
            }else{

                if(j == 0){
                    i++;
                }else{

                    j = lps[j-1];

                }
            }
        
        }
        if(j == M){
            return i - M;
        }

        return -1;
    }


    public int[] getPrefixArray(String P){
        int M = P.length();
        int lps[] = new int[M];

        int j = 0, i = 1;
        lps[0] = 0;
        while(i < M){

            if(P.charAt(i) == P.charAt(j)){
                lps[i] = j + 1;
                j++; i++;
            }else{
                if(j == 0){
                    lps[i] = 0;
                    i++;
                }else{
                    j = lps[j-1];

                }   

            }

        }
        return lps;
    }

    // int n = T.length(), m = P.length();
    //     int i =0, j = 0 ;
    //     while(i < n){
            
    //         while(j < m && T.charAt(i) == P.charAt(j)){
    //             i++;
    //             j++;
    //         }

    //         if(j == m){
    //             return i - m;
    //         }else{
    //             if(j > 0){
    //                 j = psT[j-1];
    //             }else{
    //                 i++;
    //             }
    //         }
    //     }


    //     return -1;
}

