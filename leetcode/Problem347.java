/**
 * URL: https://leetcode.com/problems/top-k-frequent-elements/
 * 
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Collections;


public class Problem347 {
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Integer> ans = sol.topKFrequent(new int[]{7,7,7,8,8,9}, 2);
        System.out.println(ans);
    }

}

class Solution{
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<Integer>();

        Map<Integer, Integer> freq = new HashMap<>();
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i=0; i< nums.length;i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println(freq);

        Map<Integer, List<Integer>> freqVsItems = new HashMap<>();
        Set<Integer> items = freq.keySet();
        for(Integer item: items){
            int f = freq.get(item);
            List<Integer> x = freqVsItems.getOrDefault(f, new ArrayList<Integer>());
            x.add(item);
            freqVsItems.put(f, x);
        }
        System.out.println(freqVsItems);
        
        ArrayList<Integer> keyList = new ArrayList<Integer>(freqVsItems.keySet());
        Collections.sort(keyList, Collections.reverseOrder());

        for(Integer key : keyList){
            List<Integer> values = freqVsItems.get(key);
            for(Integer val : values){
                if(ans.size() < k){
                    ans.add(val);
                }
            }
        }

        
    
        return ans;
    }
}

