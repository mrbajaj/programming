/**
 * URL: https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 * 
 */
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

class Problem1283{

    public static void main(String[] args) {
        Problem1283 obj = new Problem1283();

        System.out.println("Ans: " + obj.groupThePeople(new int[]{3,3,3,3,3,1,3}) + "\n");

        System.out.println("Ans: " + obj.groupThePeople(new int[]{2,1,3,3,3,2}) + "\n");

    }


    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        Map<Integer, List<Integer>> sizeToListOfIdsMap = new HashMap<>();

        for(int i =0; i < groupSizes.length ; i++){
            int s = groupSizes[i];
            List<Integer> listOfIds;
            if(sizeToListOfIdsMap.containsKey(s)){
                listOfIds = sizeToListOfIdsMap.get(s);
                listOfIds.add(i);
                sizeToListOfIdsMap.put(s, listOfIds);
            }else{
                listOfIds = new ArrayList<>();
                listOfIds.add(i);
                sizeToListOfIdsMap.put(s, listOfIds);
            }
        }

        for(Map.Entry<Integer, List<Integer>> entry : sizeToListOfIdsMap.entrySet()){

            int size = entry.getKey();

            if(size == entry.getValue().size()){
                ans.add(entry.getValue());
            }else{
                for(int i =0; i < entry.getValue().size() / size ; i++){
                    ans.add(entry.getValue().subList(size *i , size * i + size));
                }
            }

        }

        return ans;
    }



    // public List<List<Integer>> groupThePeople_test(int[] groupSizes) {
    //     List<List<Integer>> ans = new ArrayList<List<Integer>>();

    //     Map<Integer, Integer> countMap = new HashMap<>();

    //     for(int s: groupSizes){
    //         if(countMap.containsKey(s)){
    //             int x = countMap.get(s);
    //             countMap.put(s, x+1);
    //         }else{
    //             countMap.put(s, 1);
    //         }
    //     }

    //     Set<Integer> sizes = countMap.keySet();

    //     System.out.println(countMap);

    //     for(Integer size : sizes){
    //         int val = countMap.get(size);
    //         countMap.put(size, val/size);
    //     }
    //     System.out.println(countMap);
    //     System.out.println(Arrays.toString(groupSizes) );


    //     for(int i = 0; i< groupSizes.length; i++){

    //     }

        

    //     return ans;
    // }

}