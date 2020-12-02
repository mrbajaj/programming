import java.util.Set;
import java.util.HashSet;

/**
 * URL: https://leetcode.com/problems/happy-number/submissions/ 
 * 
 */

 class Problem202{

    public static void main(String[] args) {
        Problem202 obj = new Problem202();

        System.out.println("Ans:  " + obj.isHappy(19) + "\n");
        

        System.out.println("Ans:  " + obj.isHappy(1234555) + "\n");
        

        
    }

    public boolean isHappy(int n) {
        int check = n;

        Set<Integer> visited = new HashSet<>();

        while(!visited.contains(check) ){
        // while(check != 1 || n%10 == 0 || !visited.contains(check) ){
            visited.add(check);

            int x = check, rem;
            int newnum = 0;

            while(x != 0){
                rem  =  x % 10;
                newnum = newnum + rem*rem;
                x = x/10;
            }

            check = newnum;
        }

        System.out.println(visited);
        if(check == 1){
            return true;
        }else{
            return false;
        }
        
        
    }



 }