/**
 * URL: https://leetcode.com/problems/group-anagrams/
 * 
 */
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

class Problem49{
    public static void main(String[] args) {
        Problem49 obj = new Problem49();
        
        List<List<String>> ansSorting = obj.groupAnagrams_sorting(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        List<List<String>> ansHashing = obj.groupAnagrams_hashing(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        
        System.out.println(ansSorting);
        System.out.println(ansHashing);

    }
    
    public List<List<String>> groupAnagrams_hashing(String[] strs) {
        List<List<String>> ans = new ArrayList<List<String>>();

        Map<Integer, ArrayList<String>> map = new HashMap<>();

        for(String str : strs){
            int[] freq = new int[26];
            for(int i = 0; i < str.length(); i++){
                freq[str.charAt(i) - 'a'] += 1;
            }

            int hashcode = Arrays.hashCode(freq);

            if(map.containsKey(hashcode)){
                ArrayList<String> grouped = map.get(hashcode);
                grouped.add(str);
                map.put(hashcode, grouped);
            }else{
                ArrayList<String> grouped = new ArrayList<>();
                grouped.add(str);
                map.put(hashcode, grouped);
            }
        }

        Set<Integer> keys = map.keySet();
        for(Integer key :  keys){
            ans.add(map.get(key));
        }

        return ans;
    }


    public List<List<String>> groupAnagrams_sorting(String[] strs) {
        List<List<String>> ans = new ArrayList<List<String>>();

        Map<String, ArrayList<String>> map = new HashMap<>();

        for(String str : strs){
            
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if(map.containsKey(sorted)){
                ArrayList<String> grouped = map.get(sorted);
                grouped.add(str);
                map.put(sorted, grouped);
            }else{
                ArrayList<String> grouped = new ArrayList<>();
                grouped.add(str);
                map.put(sorted, grouped);
            }
        }

        Set<String> keys = map.keySet();

        for(String key :  keys){
            ans.add(map.get(key));
        }

        return ans;
    }
}
