import java.util.Set;
import java.util.HashSet;

class Problem217{

    public static void main(String[] args) {
        Problem217 obj = new Problem217();

        System.out.println("Ans: " + obj.containsDuplicate(new int[]{1,2,3,1}));

        System.out.println("Ans: " + obj.containsDuplicate(new int[]{1,2,3,4,5,6,7}));

        System.out.println("Ans: " + obj.containsDuplicate(new int[]{1,2,3,4,5,6,7,7}));
        
        
    }

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int a: nums){
            if(set.contains(a)){
                return true;
            }else{
                set.add(a);
            }
        }

        return false;
        
        
    }

}