
import java.util.*;
import java.lang.*;
import java.io.*;

class SubArrSum
{
    public static void main (String[] args)
	 {
    	Scanner sc = new Scanner(System.in);
    	int tc = sc.nextInt();
    	for(int t=0; t<tc; t++){
            int N = sc.nextInt();
            int S = sc.nextInt();

            int[] a = new int[N];
            for(int i=0; i < N; i++){
                a[i] = sc.nextInt();
            }

            int start = -1, end = -1, csum = 0;

            for(int i=0;i < N; i++){
                csum = a[i];
                // System.out.println("i = " + i + " | csum = " + csum);
                if(start != -1){
                    break;
                }
                for(int j=i+1; j < N; j++){
                    // System.out.println("\tj = " + j + " | csum = " + csum);
                    csum += a[j];

                    if(csum > S){
                        break;
                        // System.out.println("\t\tinside");
                    }
                    
                    // System.out.println("\tj = " + j + " | csum = " + csum);
                    if(csum == S){
                        start = i;
                        end = j;
                        // System.out.println("\t\tbreaking");
                        break;
                    }
                }
            }

            if(start == -1){
                System.out.println(-1);
            }else{
                start +=1; end +=1;
                System.out.println(start + " " + end);
            }
        }
        sc.close();
    }
    
}