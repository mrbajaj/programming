/**
 * URL: https://leetcode.com/problems/subsets/
 * 
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;


public class Problem78 {
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Ans: " + sol.subsets(new int[]{1,2,3}));



    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Deque<Integer> set = new ArrayDeque<>();

        this.findPowerSet(nums, set, nums.length, result);
       
        return result;
    }

    public void findPowerSet(int[] S, Deque<Integer> set, int n, List<List<Integer>> result)
	{
		// if we have considered all elements
		if (n == 0) {
            // System.out.println(set);
            List<Integer> items = new ArrayList<>();
            
            Iterator<Integer> it = set.iterator();
            while (it.hasNext()) {
                items.add(it.next());
            }
            
            result.add(items);

			return;
        }
        
		// consider nth element
		set.addLast(S[n - 1]);
		this.findPowerSet(S, set, n - 1, result);

		// or don't consider nth element
		set.removeLast();
		this.findPowerSet(S, set, n - 1, result);
	}
}
