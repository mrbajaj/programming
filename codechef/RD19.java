import java.io.*;
import java.util.*;

class RD19{

    // public int gcd(int n1, int n2){
    //     for(int i = 1; i <= n1 && i <= n2; ++i)
    //     {
    //         // Checks if i is factor of both integers
    //         if(n1 % i==0 && n2 % i==0)
    //             gcd = i;
    //     }
    //     return gcd;
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int testCase=0; testCase<t; testCase++){
            int n = sc.nextInt();
            int deletions = 0;
            int[] seq = new int[n];

            for(int i=0; i<n; i++){
                seq[i] = sc.nextInt();
            }
            // System.out.printf("Original arr[] : %s\n",Arrays.toString(seq));
            Arrays.sort(seq);
            // System.out.printf("Sorted arr[] : %s\n",Arrays.toString(seq));
            for(int i=0; i<n-1 ; i++) {
                for(int j=i+1; j<n ; j++){
                    if(seq[i] == 1){
                        continue;
                    }
                    if(seq[j]%seq[i] == 0){
                        deletions +=1;
                        seq[i] = -1;
                        break;
                    }
                }
            }
            // System.out.printf("Modified arr[] : %s\n",Arrays.toString(seq));
            if(deletions >= n){
                deletions = -1;
            }
            if((n - deletions) == 1 && seq[0] != 1){
                deletions = -1;
            }
            System.out.printf("%d\n",deletions);
        }

        sc.close();
    }

}



// https://www.cc.com/MAY18B/problems/RD19
/*  The greatest common divisor (GCD) of a sequence is the greatest positive integer which divides each element of this sequence.

    You are given a sequence A of positive integers with size N. You are allowed to delete up to N−1 elements from this sequence. (I.e., you may delete any number of elements, including zero, as long as the resulting sequence is non-empty.)

    Please find the minimum number of elements which have to be deleted so that the GCD of the resulting sequence would be equal to 1, or determine that it is impossible.
*/