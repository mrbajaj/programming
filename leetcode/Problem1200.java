/**
 * 
 * URL: https://leetcode.com/problems/minimum-absolute-difference/
 * 
 * Time Complexity: O(nlogn + n) = O(nlogn)
 * Space Complexity: O(1)
 */
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;;

class Problem1200{

    public static void main(String[] args) {
        Problem1200 obj = new Problem1200();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        List<List<Integer>> pairs = obj.minimumAbsDifference(arr);
        System.out.println(pairs.toString());
        sc.close();
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