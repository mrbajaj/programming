/**
 * URL: 
 * Tags: 
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

import java.util.PriorityQueue;
import java.util.Collections;

public class Problem1642{
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Expected 4 :: Ans: " + sol.furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1)  );
        System.out.println("Expected 7 :: Ans: " + sol.furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2)  );
        System.out.println("Expected 3 :: Ans: " + sol.furthestBuilding(new int[]{14,3,19,3}, 17, 0)  );
    }
}

/**
 * It is also one of the solution, but it throws TLE
 */
class SolutionRecursive {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
           return rec(heights, heights.length, bricks, ladders, 0);
    }

    private int rec(int[] heights, int N, int bricks, int ladders, int i){
        if(i == N-1){
            return i;
        }
        if(i < N-1 && heights[i] >= heights[i+1]){
            return rec(heights, N, bricks, ladders, i+1);
        }
        int diff = heights[i+1] - heights[i];
        if(ladders == 0 && bricks < diff){
                return i;
        }
        int wL = i, wB = i;
        if(ladders > 0){
            wL = rec(heights, N, bricks, ladders-1, i+1);
        }
        if(bricks > 0){
            wB = rec(heights, N, bricks - diff, ladders, i+1);
        }
        return Math.max(wL, wB);
    }
}

/**
 * using maxHeap
 */
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int diff;
        Integer peek;
        int N = heights.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        for(i = 0; i < N - 1; i++){
            diff = heights[i+1] - heights[i];

            if(diff > 0){
                //support needed
                if(bricks >= diff){
                    bricks = bricks - diff;
                    maxHeap.add(diff);
                }else if(ladders > 0){
                    ladders--;
                    peek = maxHeap.peek();
                    if(peek != null && diff < peek){
                        // consider ladder is used for another max from peek
                        // and remove prev max from heap, add curr diff to heap
                        maxHeap.remove();
                        maxHeap.add(diff);
                        bricks = bricks + peek - diff;
                    }

                }else{
                    // support not available, can not move further
                    return i;
                }
            }
        }
        return i;
    }

}

/**
 * diff = heights[i] - heights[i+1];
            if(diff > 0){
                //need support to go up
                if(diff <= bricks){
                    //use bricks
                    bricks = bricks - diff;
                    maxHeap.add(diff);
                }else if(ladders > 0){
                    //use ladder
                    peek = maxHeap.peek();
                    ladders--;
                    if(peek != null && diff < peek){
                        //use bricks for this step and for prev max step from maxHeap use ladder
                        bricks = bricks + peek - diff;
                        maxHeap.poll();
                        maxHeap.add(diff);
                    }
                }else{
                    return i;
                }

 */