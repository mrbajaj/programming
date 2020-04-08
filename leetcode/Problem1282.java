/**
 * URL: https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 * 
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Problem1282 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Ans: " + sol.groupThePeople(new int[]{3,3,3,3,3,1,3}));
    }
}

class Solution{

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i =0; i < groupSizes.length; i++){
            int key = groupSizes[i];
            List<Integer> list = map.getOrDefault(key , new ArrayList<Integer>());
            list.add(i);
            if(list.size() == key){
                result.add(list);
                map.remove(key);
            }else{
                map.put(key, list);
            }
        }

        return result;
    }

}