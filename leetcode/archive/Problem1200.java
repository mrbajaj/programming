/**
 * 
 * URL: https://leetcode.com/problems/minimum-absolute-difference/
 * 
 * Time Complexity: O(nlogn + n) = O(nlogn)
 * Space Complexity: O(1)
 */
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;;

class Problem1200{

    public static void main(String[] args) {
        Problem1200 obj = new Problem1200();
        
        System.out.println("Ans: " + obj.minimumAbsDifference(new int[]{4,2,1,3}));

        System.out.println("Ans: " + obj.minimumAbsDifference(new int[]{1,3,6,10,15}));

        System.out.println("Ans: " + obj.minimumAbsDifference(new int[]{3,8,-10,23,19,-4,-14,27}));
     
        
        
        
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> pairs = new ArrayList<>();
        Arrays.sort(arr); // O(nlogn)
        Integer minDiff = Integer.MAX_VALUE;

        // O(n)
        for(int i=0; i < arr.length - 1; i++){
            //int diff = arr[i+1] - arr[i]; 
            int a = arr[i], b = arr[i+1]; 
            int diff = b - a;
            if(diff < minDiff){
                minDiff = diff;
                pairs.clear();
            }

            if(diff == minDiff){
                List<Integer> pair = new ArrayList<>();
                pair.add(a);
                pair.add(b);
                pairs.add(pair);
            }
        }

        return pairs;
    }
}