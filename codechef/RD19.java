import java.io.*;
import java.util.*;

class RD19{
    
    public int max(int[] arr, int n){
        // returns the max value from the array
        int x = arr[0];
        for(int i=1; i<n; i++){
            if(x < arr[i]){
                x = arr[i];
            }
        }
        return x;
    }
    public int min(int[] arr, int n){
        // returns the max value from the array
        int x = arr[0];
        for(int i=1; i<n; i++){
            if(x > arr[i]){
                x = arr[i];
            }
        }
        return x;
    }

    public Set<Integer> getFactors(int x){
        Set<Integer> factors = new HashSet<Integer>();
        for(int i=2; i<=x; i++){
            while(x%i==0){
                factors.add(i);
                x = x/i;
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RD19 obj = new RD19();
        int t = sc.nextInt();

        for(int testCase=0; testCase<t; testCase++){
            int n = sc.nextInt();
            int max,min,deletions = 0;
            int[] seq = new int[n];
            Set<Integer> factorsList;
            

            for(int i=0; i<n; i++){
                seq[i] = sc.nextInt();
            }
            // System.out.printf("Original arr[] : %s\n",Arrays.toString(seq));
            max = obj.max(seq, n);
            min = obj.min(seq, n);
            
            boolean[] factorFlag = new boolean[max+1];
            

            for(int i=0; i<n; i++){
                factorsList = obj.getFactors(seq[i]);
                for (Integer factor : factorsList) {
                    // System.out.format("%d\t",factor);
                    if(factorFlag[factor]){
                        seq[i] = -1;
                        deletions +=1;
                        break;
                    }else{
                        factorFlag[factor] = true;
                    }
                }
                // System.out.println("x");
            }
            
            // for(int i=2; i<max ; i++) {
            //     // i is a devisor from 2 to max
            //     for(int j=0; j<n ; j++){
            //         // j is elements of array
            //         if(seq[j]%i == 0){
            //             // need to delete this element because the gcd is i which is greater than 2
            //             deletions +=1;
            //             seq[j] = -1;
            //         }
            //     }
            // }
            System.out.printf("Modified arr[] : %s\n",Arrays.toString(seq));
            // System.out.printf("factorFlag b: %s\n", Arrays.toString(factorFlag));
            if(deletions >= n){
                deletions = -1;
            }
            if((n - deletions) == 1 && min != 1){
                // System.out.print("here");
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