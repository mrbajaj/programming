import java.util.*;

class MAGICHF{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for(int t=0; t < testCases; t++){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int s = sc.nextInt();
            int currPos = x;
            for(int i=0; i < s; i++){
                int p = sc.nextInt();
                int q = sc.nextInt();
                if(p==currPos || q == currPos )
                {
                    if(p!=currPos){
                        currPos = p;
                    }else{
                        currPos = q;
                    }
                }
            }
            System.out.println(currPos);
        }
        
    }
}