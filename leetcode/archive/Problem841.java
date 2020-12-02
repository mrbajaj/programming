
/**
 * URL: https://leetcode.com/problems/keys-and-rooms/
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;


class Problem841{

    public static void main(String[] args) {
        
        Problem841 obj = new Problem841();

        ArrayList<ArrayList<Integer> > rooms1 = new ArrayList<ArrayList<Integer> >(); 
        rooms1.add(new ArrayList<Integer>(){{add(1);}});
        rooms1.add(new ArrayList<Integer>(){{add(2);}});
        rooms1.add(new ArrayList<Integer>(){{add(3);}});
        rooms1.add(new ArrayList<Integer>());
        System.out.println( rooms1 );
        System.out.println("Ans: " + obj.canVisitAllRooms(rooms1) + "\n");
        
        ArrayList<ArrayList<Integer> > rooms2 = new ArrayList<ArrayList<Integer> >(); 
        rooms2.add(new ArrayList<Integer>(){{add(1); add(3);}});
        rooms2.add(new ArrayList<Integer>(){{add(3); add(0); add(1);}});
        rooms2.add(new ArrayList<Integer>(){{add(2);}});
        rooms2.add(new ArrayList<Integer>(){{add(0);}});
        System.out.println( rooms2 );
        System.out.println("Ans: " + obj.canVisitAllRooms(rooms2) + "\n");

        // [[4],[3],[],[2,5,7],[1],[],[8,9],[],[],[6]]

        ArrayList<ArrayList<Integer> > rooms3 = new ArrayList<ArrayList<Integer> >(); 
        rooms3.add(new ArrayList<Integer>(){{add(4);}});
        rooms3.add(new ArrayList<Integer>(){{add(3);}});
        rooms3.add(new ArrayList<Integer>());
        rooms3.add(new ArrayList<Integer>(){{add(2); add(5); add(7);}});
        rooms3.add(new ArrayList<Integer>(){{add(1);}});
        rooms3.add(new ArrayList<Integer>());
        rooms3.add(new ArrayList<Integer>(){{add(8);add(9);}});
        rooms3.add(new ArrayList<Integer>());
        rooms3.add(new ArrayList<Integer>());
        rooms3.add(new ArrayList<Integer>(){{add(6);}});
        
        System.out.println( rooms3 );
        System.out.println("Ans: " + obj.canVisitAllRooms(rooms3) + "\n");

        
    }

    public boolean canVisitAllRooms(ArrayList<ArrayList<Integer>> rooms) {

        boolean[] unlocked = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);

        while(!queue.isEmpty()){

            int curr = queue.remove();

            unlocked[curr] = true;

            for( Integer key : rooms.get(curr) ){
                if(unlocked[key] == false){
                    queue.add(key);
                }
                
            }
        }

        System.out.println(Arrays.toString(unlocked));
        for(boolean x : unlocked){
            if(x == false){
                return false;
            }
        }
        return true;

    }

}