import java.util.Arrays;
import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[] = new int[]{1,2,3,4,5,6};
        // rotateRight
        rotateRight(a, 2);
        System.out.println(Arrays.toString(a));
        sc.close();
    }

    public static void rotateRight(int []a, int r){
        r = r%a.length;
        if(r == 0){
            return;
        }

        int tmp = a[a.length-1];

        for(int i=a.length-2; i>=0 ; i--){
            a[i+1] = a[i];
        }
        a[0] = tmp;

        rotateRight(a, r-1);

    }

}

