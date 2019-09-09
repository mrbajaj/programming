import java.text.DecimalFormat;
import java.util.*;
import java.lang.*;

class NAICHEF{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int testCase=0; testCase<t; testCase++){
            int n = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
            double a_count=0, b_count=0;
            int x;
            for(int i=0; i<n; i++){
                x = sc.nextInt();
                if(x == a){ a_count +=  1;}
                if(x == b){ b_count += 1;}
            }
            double prob = (a_count/n) * (b_count/n);
            System.out.format("%.6g%n",prob);

        }
        sc.close();
    }
}

