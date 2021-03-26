/**
 * URL: https://www.geeksforgeeks.org/building-heap-from-array/
 * Tags: Tree
 * 
 * 
 * During Insertion: Insert Last, Traverse Upward using parent
 * during Deletion: Delete First, Copy Last to First, Traverse Downward using childrens
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

public class Heap1{

    public static void main(String[] args) {
        Solution sol = new Solution();

        // int[] heap = sol.createMaxHeap();
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] heap = sol.createMaxHeapFromArray(arr);
        System.out.println(Arrays.toString(arr) + "\n\theap: " + Arrays.toString(heap));
        sol.heapSort(heap);
        System.out.println();

        arr = new int[]{4, 10, 3, 5, 1};
        heap = sol.createMaxHeapFromArray(arr);
        System.out.println(Arrays.toString(arr) + "\n\theap: " + Arrays.toString(heap));
        sol.heapSort(heap);
        System.out.println();

        arr = new int[]{1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        heap = sol.createMaxHeapFromArray(arr);
        System.out.println(Arrays.toString(arr) + "\n\theap: " + Arrays.toString(heap));
        sol.heapSort(heap);
        System.out.println();

    }

}

class Solution{

    /**
     * Insert element one by one at the last position in heap
     * Then move the last element to it's appropriate position in heap (by comparing it with it's parent)
     */
    public int[] createMaxHeapFromArray(int[] arr){
        int N = arr.length;
        int[] heap = new int[N];

        for(int i = 0; i < N; i++){
            heap[i] = arr[i];
            // System.out.print("Insert: " + arr[i] + "\t");
            // System.out.print(Arrays.toString(heap) + "\t");
            

            // make sure heap is MaxHeap after insertion
            int tempIndex = i; // insertIndex
            int parentIndex = (tempIndex-1) / 2;
            while(i != 0 && parentIndex >= 0 && heap[tempIndex] > heap[parentIndex]){
                // System.out.print(" | t: " + tempIndex + " p: " + parentIndex + " ");
                
                //swap
                int tmp = heap[parentIndex];
                heap[parentIndex] = heap[tempIndex];
                heap[tempIndex] = tmp;
                
                //check if parent of current is greater than current
                tempIndex = parentIndex;
                parentIndex = (tempIndex-1) / 2;
            }
            // System.out.println("\t" + Arrays.toString(heap) + "\n");
        }

        return heap;
    }

    /**
     * delete top element : print 
     * move last element at first place 
     * heapify
     * 
     * Note: keep track of remining elements in heap
     */
    public void heapSort(int[] heap){
        int N = heap.length;
        int lastIndex = heap.length - 1;


        for(int i = 0; i < N; i++){
            // System.out.print(heap[0] + " ");
            int tmp = heap[0];
            heap[0] = heap[lastIndex];
            heap[lastIndex] = tmp;

            //Heapify: Traverse Downward using childrens to place first element at appropriate position
            int currIndex = 0;
            while(true){
                int leftIndex = 2 * currIndex + 1;
                int rightIndex = 2 * currIndex + 2;
                // System.out.print("leftIndex:" + leftIndex + "\t rightIndex:" + rightIndex);

                int max = heap[currIndex];
                int maxIndex = currIndex;

                //check max with left
                if(leftIndex < lastIndex && max < heap[leftIndex]){
                    max = heap[leftIndex];
                    maxIndex = leftIndex;
                }
                //check max with right
                if(rightIndex < lastIndex && max < heap[rightIndex]){
                    max = heap[rightIndex];
                    maxIndex = rightIndex;
                }

                if(maxIndex == currIndex){
                    // System.out.println("\tBreaked");
                    break;
                }

                heap[maxIndex] = heap[currIndex];
                heap[currIndex] = max;
                currIndex = maxIndex;

                // System.out.println("\tHeap: " + Arrays.toString(heap));
            }


            lastIndex--;
        }
        // System.out.println();

        System.out.print("\tSorted: " + Arrays.toString(heap) + "\n");
    }

    
}