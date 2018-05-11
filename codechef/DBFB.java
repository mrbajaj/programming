import java.util.*;
import java.io.*;
import java.lang.*;


class DBFB{
    public int max(int a, int b){
        if(a < b){
            return b;
        }
        return a;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        DBFB obj = new DBFB();
        int t = sc.nextInt();

        for(int testCase=0; testCase < t; testCase ++){
            int m = sc.nextInt();
            int n = sc.nextInt();
            long[] a = new long[m];
            long[] b = new long[n];
            for(int i=0; i<m;i++){
                a[i] = sc.nextLong();
            }
            for(int i=0; i<n;i++){
                b[i] = sc.nextLong();
            }
            long result = 0;

            for(int i=0; i<m; i++){
                for(int j=0; j<m; j++){
                    int size = obj.max(2,n);
                    long[] fib = new long[size];
                    fib[0]=a[i];
                    fib[1]=b[j];
                    for(int k=2; k<n; k++){
                        fib[k] = fib[k-1] + fib[k-2];
                    }
                    result = result + fib[n-1];
                }
            }
            System.out.println(result);
        }

        sc.close();
    }
}