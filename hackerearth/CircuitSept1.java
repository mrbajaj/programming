import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.util.*;

class CircuitSept1{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(); //total travel distance
        int x = sc.nextInt(); //everyday default travel 
        int n = sc.nextInt(); // exceptions
        Integer day, dist;
        
        Map<Integer,Integer> dayDist = new HashMap<Integer,Integer>();
        for(int i=0; i<n;i++){
            day = sc.nextInt();
            dist = sc.nextInt();
            dayDist.put(day, dist);
        }
        int rem = s;
        day = 1;
        while (rem > 0) {
            dist = dayDist.get(day);
            if(dist == null){
                rem = rem - x;
            }else{
                rem = rem - dist;
            }
            System.out.println(rem);    
            day = day+1;
        }
        System.out.println(day-1);

        sc.close();

    }
}