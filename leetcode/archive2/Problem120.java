/**
 * URL: https://leetcode.com/problems/triangle/
 * Tags: Stack
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

import java.util.List;
import java.util.ArrayList;

public class Problem120{
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> triangle  = asList( asList(2), asList(3,4), asList(6,5,7), asList(4,1,2,8) );
        
        System.out.println(sol.minimumTotal(triangle));
    }

    public static <T> List<T> asList(T ... items) {
        List<T> list = new ArrayList<T>();
        for (T item : items) {
            list.add(item);
        }

        return list;
    }
}

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        return minPath(triangle, n, 0, 0);
    }

    public int minPath(List<List<Integer>> triangle, int n, int level, int index){
        System.out.print(level + " " + index);
        if(level >= n - 1 || index > level){
            System.out.println();
            return Integer.MAX_VALUE;
        }
        System.out.println("*");

        return triangle.get(level).get(index) +  Math.min(minPath(triangle, n , level + 1, index), minPath(triangle, n, level+1, index + 1));

    }
}