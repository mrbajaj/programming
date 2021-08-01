/**
 * URL: https://leetcode.com/problems/making-a-large-island/
 * 
 * 
 */
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Problem827{
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = new int[][]{{0,1,0,0},{0,1,1,0},{0,1,0,0},{1,0,1,0}};
        // int[][] grid = new int[][]{{1,1},{1,0}};
        // int[][] grid = new int[][]{{1,1},{1,1}};
        // int[][] grid = new int[][]{{0},{0}};

        System.out.println("Ans: " + sol.largestIsland(grid));

    }
}
class Solution {
    public int largestIsland(int[][] grid) {
        boolean noZero = true;
        int[] ap = new int[2];
        int m = grid.length;
        if(m == 0){
            return 0;
        }
        int n = grid[0].length, unique = 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    traverseIsland(grid, map, unique, m, n, i, j );
                    unique++;
                }
                if(grid[i][j] == 0){
                    noZero = false;
                }
            }
        }
        if(noZero && map.size() == 1){
            return map.get(2);
        }
        int max = 0, currMax;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                currMax = 0;
                Set<Integer> set = new HashSet<>();
                if(grid[i][j] == 0){
                    set.add(getAreaId(grid, map, m, n, i, j+1));
                    set.add(getAreaId(grid, map, m, n, i+1, j));
                    set.add(getAreaId(grid, map, m, n, i, j-1));
                    set.add(getAreaId(grid, map, m, n, i-1, j));
                    currMax = 1;
                    for(Integer aId : set){
                        if(aId != 0){
                            currMax = currMax + map.get(aId);
                        }
                    }
                }
                if(max < currMax){
                    ap[0] = i; ap[1] = j;
                    max = currMax;
                }
            }
            System.out.println();
        }

        System.out.println(map);
        System.out.println(Arrays.toString(ap));
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        
        return max;
    }
    private static  int getAreaId(int[][] grid, Map<Integer, Integer> map, int m, int n, int i, int j){
        if(isInBoundry(m, n, i, j) && grid[i][j] != 0){
            // System.out.println(i + " " + j + ", unique=" + grid[i][j] + ", area=" + map.get(grid[i][j]));
            return grid[i][j];
        }
        return 0;
    }
    private static void traverseIsland(int[][] grid, Map<Integer, Integer> map, int unique, int m, int n, int i, int j ){
        if( isInBoundry(m, n, i, j) && grid[i][j] == 1){
            Integer x = map.get(unique);
            if(x == null){
                map.put(unique, 1);
            }else{
                map.put(unique, x + 1);
            }
            grid[i][j] = unique;
            traverseIsland(grid, map, unique, m, n, i, j+1);
            traverseIsland(grid, map, unique, m, n, i+1, j);
            traverseIsland(grid, map, unique, m, n, i, j-1);
            traverseIsland(grid, map, unique, m, n, i-1, j);
        }
    }

    private static boolean isInBoundry(int m, int n, int i, int j){
        if(i >=  0 && j >= 0 && i < m && j < n){
            return true;
        }
        return false;
    }
}