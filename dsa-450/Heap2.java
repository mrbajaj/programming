/**
 * URL: https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
 * Tags: 
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */
import java.util.Arrays;

public class Heap2{

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[]{7, 10, 4, 3, 20, 15};
        System.out.println("Given: " + Arrays.toString(arr));
        sol.heapSort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));
        
        arr = new int[]{10,7,5,4,2,1};
        System.out.println("\nGiven: " + Arrays.toString(arr));
        sol.heapSort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));

        arr = new int[]{1,3,4,6,7,10};
        System.out.println("\nGiven: " + Arrays.toString(arr));
        sol.heapSort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));
        
    }

}

class Solution{
    public static void heapSort(int[] arr) 
    { 
        int n = arr.length;
        if(n <= 0){
            //Invalid 
            return;
        }
        for(int i = n-1; i >= 0; i--){
            maxHeapify(arr, n, i);
        }
        System.out.println("Heap: " + Arrays.toString(arr));
        
        int heapSize = n;
        
        while(heapSize > 0 && heapSize >= 0){
            int tmp = arr[0];
            arr[0] = arr[heapSize-1];
            arr[heapSize-1] = tmp;
            maxHeapify(arr, heapSize - 1, 0);
            heapSize--;
        }
    } 

    private static void maxHeapify(int[] arr, int n, int i){
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;
        if(left < n && arr[left] > arr[largest]){
            largest = left;
        }
        if(right < n && arr[right] > arr[largest]){
            largest = right;
        }
        if(i != largest){
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            maxHeapify(arr, n, largest);
        }
    }
}
