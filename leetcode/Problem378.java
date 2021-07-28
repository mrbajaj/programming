/**
 * 
 */

import java.util.PriorityQueue;
import java.util.Collections;

public class Problem378{
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] matrix = new int[][]{{1,5,9},{10,11,13},{12,13,15}};

        System.out.println("Ans: " + sol.kthSmallest(matrix, 8));
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                pq.add(matrix[i][j]);
                if(pq.size() > k){
                    pq.remove();
                }
            }
        }
        return pq.peek();
    }
}