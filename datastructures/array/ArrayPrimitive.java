import java.io.*;
import java.util.*;

public class ArrayPrimitive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        // 1D array
        int[] arr = new int[N];
        
        // iterate using normal for loop
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        
        // iterate using for each
        System.out.print("Using for-each:\t");    
        for(int x : arr){
            System.out.format("%d ",x);    
        }
        System.out.println();    

        // print reverse in reverse
        System.out.print("Reverse:\t");    
        for(int i=N-1; i>=0; i--){
            System.out.format("%d ",arr[i]);
        }
        System.out.println();    

        sc.close();
    }
}