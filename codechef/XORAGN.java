import java.io.*;
import java.util.*;

class XORAGN{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long t = sc.nextInt();
        for(int testCase=0; testCase < t ; testCase++){
            int size = sc.nextInt();
            long[] a = new long[size];
            // int[] b = new int[size*size];
            long x;
            // int k = 0;
            long ans=0;
            for(int i=0; i<size; i++){
                a[i] = sc.nextInt();
            }
            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    // b[k] = a[i] + a[j];
                    x = a[i] + a[j];
                    
                    ans = ans ^ x;

                    // k++;
                }
            }
            // System.out.printf("Array a: %s\n", Arrays.toString(a));
            // System.out.printf("Array b: %s\n", Arrays.toString(b));
            System.out.println(ans);
        }
        sc.close();
    }
}


// https://www.cc.com/MAY18B/problems/XORAGN
/*
Input:
    1
    2
    1 2


Output:
    6
*/