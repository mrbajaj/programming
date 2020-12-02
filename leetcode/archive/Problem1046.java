/**
 * URL: https://leetcode.com/problems/last-stone-weight/
 * 
 */
import java.util.PriorityQueue;
import java.util.Collections;

public class Problem1046 {
    public static void main(String[] args) {        
        Solution sol = new Solution();
        System.out.println("Ans: " + sol.lastStoneWeight(new Integer[]{2,7,4,1,8,1}));
        System.out.println("Ans: " + sol.lastStoneWeight(new Integer[]{2,7,4,1,8,1,3}));
    }
}

class Solution {
    public int lastStoneWeight(Integer[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < stones.length; i++){
            maxHeap.add(stones[i]);
        }

        while(maxHeap.size() > 1){
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            int diff = first - second;
            if(diff != 0){
                maxHeap.offer(diff);
            }
            
        }

        return (maxHeap.size()==1) ? maxHeap.poll() : 0;
    }
}