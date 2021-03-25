/*
 * 
 * link: https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1#
 *
 */

 import java.util.ArrayList;

public class SortingSearching1{

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.find(new long[]{1, 3, 5, 5, 5, 5, 67, 123, 125}, 9, 5));

        System.out.println(sol.find(new long[]{1,1,1,1,1,1}, 6, 1));

        System.out.println(sol.find(new long[]{1}, 1, 1));
    }
}

class Solution{

    ArrayList<Long> find(long arr[], int n, int x)
    {
        ArrayList<Long> indexes = new ArrayList<Long>();
        
        int i = 0;
        while(i<n && arr[i] != x){
            i++;
        }
        
        if(i != n){
            indexes.add(Long.valueOf(i));
            
            while(i<n && arr[i] == x){
                i++;
            }
            indexes.add(Long.valueOf(i) - 1L);
            return indexes;
        }
        
        
        indexes.add(-1L);
        indexes.add(-1L);
        return indexes;
    }
}