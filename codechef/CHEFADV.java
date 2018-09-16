import java.util.*;

class CHEFADV{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for(int t=0; t< testCases; t++){
            int nk = sc.nextInt();
            int mp = sc.nextInt();
            int xk = sc.nextInt();
            int yp = sc.nextInt();
            int k=1;
            int p=1;
            // System.out.format("%d %d %d %d\n\n",nk,mp,xk,yp);
            while(k < nk){
                k = k + xk;
            }
            while(p < mp){
                p = p + yp;
            }
            if(k == nk && p == mp){
                System.out.println("Chefirnemo");
                continue;
            }
            // System.out.format("%d %d\n\n",k,p);
            k=2; p=2;
            while(k < nk){
                k = k + xk;
            }
            while(p < mp){
                p = p + yp;
            }
            if(k == nk && p == mp){
                System.out.println("Chefirnemo");
            }else{
                System.out.println("Pofik");
            }
        }
    }


}