/**
 * URL: https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1#
 * Tags: 
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class SearchingAndSorting23{
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Ans: " + sol.kthElement(new int[]{2, 3, 6, 7, 9}, new int[]{1, 4, 8, 10}, 5, 4, 5));
    }

}

class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        int i = 0, j = 0;
        int[] index = new int[2];
        
        while(i < n && j < m && k > 0){
            if(arr1[i] <= arr2[j]){
                index[0] = 1; index[1] = i;
                i++;
            }else{
                index[0] = 2; index[1] = j;
                j++;
            }
            k--;
        }
        
        while(i < n && k > 0){
            index[0] = 1; index[1] = i;
            i++;
            k--;
        }
        
        while(j < m && k > 0){
            index[0] = 2; index[1] = j;
            j++;
            k--;
        }
        
        if(k == 0){
            return (index[0] == 1) ? arr1[index[1]] : arr2[index[1]];
        }else{
            return -1;
        }
        
    }
}