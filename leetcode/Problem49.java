/**
 * URL: https://leetcode.com/problems/group-anagrams/
 * 
 */
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem49{
    public static void main(String[] args) {
        Solution1 sol1 = new Solution1();
        Solution2 sol2 = new Solution2();
        Solution3 sol3 = new Solution3();
        
        List<List<String>> ansSorting = sol1.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(ansSorting);
        
        List<List<String>> ansCustomKey = sol2.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(ansCustomKey);

        List<List<String>> ansHashing = sol3.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(ansHashing);

    }
}


class Solution1 {
    //sorting
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();

        Map<String, List<String>> groups = new HashMap<>();

        for(String str : strs){
            String key = this.sortString(str);
            List<String> list = groups.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            groups.put(key,list);
        }

        Set<String> keys = groups.keySet();

        for(String key: keys){
            result.add(groups.get(key));
        }

        return result;

    }

    public String sortString(String inputString) 
    { 
        // convert input string to char array 
        char tempArray[] = inputString.toCharArray(); 
          
        // sort tempArray 
        Arrays.sort(tempArray); 
          
        // return new sorted string 
        return new String(tempArray); 
    } 
}

class Solution2{
    //CustomKey
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();

        Map<String, List<String>> groups = new HashMap<>();

        for(String str : strs){
            String key = this.customKey(str);
            List<String> list = groups.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            groups.put(key,list);
        }

        Set<String> keys = groups.keySet();

        for(String key: keys){
            result.add(groups.get(key));
        }

        return result;
    }

    public String customKey(String inputString){
        int[] freq = new int[26];

        for(int i=0; i<inputString.length(); i++){
            int index = inputString.charAt(i) - 'a';
            freq[index]++;
        }

        return Arrays.stream(freq)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("#"));

    }

}

class Solution3{
    //hashing : TLE
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<Integer> covered = new ArrayList<>();

        for(int i = 0; i < strs.length; i++){
            if(covered.contains(i)){
                continue;
            }
            String str = strs[i];
            List<String> currList = new ArrayList<String>();
            currList.add(str);
            covered.add(i);
            for(int j = i+1; j< strs.length; j++){
                if(!covered.contains(j) && this.isAnagram(str, strs[j])){
                    currList.add(strs[j]);
                    covered.add(j);
                }
            }
            result.add(currList);
        }

        return result;
    }

    public boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        
        int[] freq = new int[26];

        for(int i=0; i<str1.length(); i++){
            int index = str1.charAt(i) - 'a';
            freq[index]++;
        }

        for(int i=0; i<str1.length(); i++){
            int index = str2.charAt(i) - 'a';
            freq[index]--;
        }

        for(int i=0; i< freq.length; i++){
            if(freq[i] != 0){
                return false;
            }
        }

        return true;
    }
    
}

