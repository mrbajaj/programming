import java.util.*;

public class SPELLBOB{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for(int t=0; t < testCases; t++){
            String front = sc.next();
            String back = sc.next();
            String frontback = front + back;
            boolean flag = false;
            List<String> possible = new ArrayList<String>();
            possible.add("bbo"); possible.add("bob"); possible.add("obb");

            String check;
            //012
            check = frontback.substring(0, 1) + frontback.substring(1, 2) + frontback.substring(2, 3);  if(possible.contains(check)){ flag = true; }
            //045
            check = frontback.substring(0, 1) + frontback.substring(4, 5) + frontback.substring(5, 6);  if(possible.contains(check)){ flag = true; }
            //015
            check = frontback.substring(0, 1) + frontback.substring(1, 2) + frontback.substring(5, 6);  if(possible.contains(check)){ flag = true; }
            //042
            check = frontback.substring(0, 1) + frontback.substring(4, 5) + frontback.substring(2, 3);  if(possible.contains(check)){ flag = true; }
            //345
            check = frontback.substring(3, 4) + frontback.substring(4, 5) + frontback.substring(5, 6);  if(possible.contains(check)){ flag = true; }
            //342
            check = frontback.substring(3, 4) + frontback.substring(4, 5) + frontback.substring(2, 3);  if(possible.contains(check)){ flag = true; }
            //312
            check = frontback.substring(3, 4) + frontback.substring(1, 2) + frontback.substring(2, 3);  if(possible.contains(check)){ flag = true; }
            //315
            check = frontback.substring(3, 4) + frontback.substring(1, 2) + frontback.substring(5, 6);  if(possible.contains(check)){ flag = true; }

            
            if(flag){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
        sc.close();
    }
}