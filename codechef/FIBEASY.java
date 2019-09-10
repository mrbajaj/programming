import java.util.Arrays;
import java.util.Scanner;

class FIBEASY{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- != 0){
            int N = sc.nextInt();
            
            int r = getSpecialResult(N);
            
            System.out.println(r);
        }

        sc.close();
    }

    public static int getSpecialResult(int N){

        int a[] = new int[N];
        a[0] = 0; a[1] = 1;
        for(int i= 2; i < N; i++){
            a[i] = (a[i-1] + a[i-2])% 10;
        }
        // System.out.println(Arrays.toString(a));
        
        for(int j = 0; j < log2(N); j++){
            int x=0;
            for(int i = 1; i < N; i+=2){
                a[x] = a[i];
                x++;
            }
            // System.out.println(Arrays.toString(a));
        }
        return a[0];
    }

    public static int log2(int x){
        return (int) (Math.log(x) / Math.log(2));
    }
    
}