/**
 * URL: https://www.geeksforgeeks.org/building-heap-from-array/
 * Tags: Tree
 * 
 * 
 * During Insertion: Insert Last, Traverse Upward using parent
 * During Deletion: Delete First, Copy Last to First, Traverse Downward using childrens
 * 
 * 
 * for i starting from 0
 * parentIndex(i) => floor[ (i-10 / 2 ]
 * leftChild(i) => 2i + 1
 * rightChild(i) => 2i + 2
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

import java.util.Arrays;

public class Heap1aHeapify{

    public static void main(String[] args) {
        Solution sol = new Solution();

        // int[] heap = sol.createMaxHeap();
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println("Given: " + Arrays.toString(arr));
        sol.maxHeapify(arr);
        System.out.println("Heap: " + Arrays.toString(arr));
        System.out.println("------------------");

        arr = new int[]{4, 10, 3, 5, 1};
        System.out.println("Given: " + Arrays.toString(arr));
        sol.maxHeapify(arr);
        System.out.println("Heap: " + Arrays.toString(arr));
        System.out.println("------------------");

        arr = new int[]{1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        System.out.println("Given: " + Arrays.toString(arr));
        sol.maxHeapify(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));
        System.out.println("------------------");
    
        
        arr = new int[]{7, 10, 4, 3, 20, 15};
        System.out.println("Given: " + Arrays.toString(arr));
        sol.maxHeapify(arr);
        System.out.println("Heap: " + Arrays.toString(arr));
        
    }

}

class Solution{

    /**
     */
    public void maxHeapify(int[] arr){
        int n = arr.length;
        if(n <= 0){
            //Invalid 
            return;
        }
        for(int i = n-1; i >= 0; i--){
            maxHeapifyRecursive(arr, n, i);
        }
     }

     private static void maxHeapifyRecursive(int[] arr, int n, int i){
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
            maxHeapifyRecursive(arr, n, largest);
        }
    }
    
}