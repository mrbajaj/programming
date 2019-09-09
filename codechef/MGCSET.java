import java.util.*;
import java.lang.*;

public class MGCSET{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0; t < testCases; t++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] arr = new int[n];
			int count = 0;
			for(int i=0; i < n; i++){
				arr[i] = sc.nextInt();
				if(arr[i] % m == 0){
					count++;
				}
			}
			int result = (int)Math.pow(2,count) - 1;
			System.out.println(result);
		}

	}
}