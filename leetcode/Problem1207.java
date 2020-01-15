import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

class Problem1207{

    public static void main(String[] args) {
        Problem1207 obj = new Problem1207();

        System.out.println("Ans: " + obj.containsDuplicate(new int[]{1,2,2,1,1,3}));

        System.out.println("Ans: " + obj.containsDuplicate(new int[]{1,2}));

        System.out.println("Ans: " + obj.containsDuplicate(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
        
        
    }

    public boolean containsDuplicate(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        Set<Integer> set = new HashSet<>();

        for(int a: nums){
            if(map.get(a) != null){
                int count = map.get(a); 
                map.put(a, count + 1);
            }else{
                map.put(a, 1);
            }
        }


        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int val = entry.getValue();

            if(set.contains(val)){
                return false;
            }else{
                set.add(val);
            }

        }

        return true;
        
    }

}