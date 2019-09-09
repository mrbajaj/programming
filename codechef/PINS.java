import java.util.*;
import java.lang.*;
import java.math.BigInteger;

public class PINS{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0; t < testCases; t++){
            int n = sc.nextInt();
            int halfN=n/2;
            if(n%2 == 0){
                // even
                BigInteger big = BigInteger.valueOf(10).pow(n - halfN);
                System.out.println("1 " + big);
                // System.out.println("1 " + (long)Math.pow(10, n - halfN ) );
            }else{
                BigInteger big = BigInteger.valueOf(10).pow(n - halfN - 1);
                System.out.println("1 " + big);
                // System.out.println("1 " + (long)Math.pow(10,(n - halfN - 1) ) );   
            }
		}
        sc.close();
	}
}