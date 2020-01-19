import java.io.*;
import java.util.*;

public class MinHeap {

    public static void main(String[] args) {

        MinHeap obj = new MinHeap();
        
        Scanner sc =  new Scanner(System.in);

        List<Integer> minHeap = new ArrayList<>();

        for(int item : new int[]{4,3,1,2,7}){
            obj.insert(item, minHeap);
        }
        int N = sc.nextInt();
        int tmp = N;
        Integer item;
        
        while(tmp-- != 0){
            int query = sc.nextInt();

            switch (query) { 
                case 1:
                    // Insert given item
                    item = sc.nextInt();
                    obj.insert(item, minHeap);
                    obj.printMin(minHeap);
                    break; 
                case 2:
                    // Delete given item
                    item = sc.nextInt();
                    obj.deleteItem(item, minHeap);
                    obj.printMin(minHeap);
                    break;
                case 3: 
                    // Print
                    obj.printMin(minHeap);
                    break;
                case 4:
                    // Delete top item
                    item = obj.deleteMin(minHeap);
                    System.out.println("Deleted top item: " + item);
                    obj.printMin(minHeap);
                    break;
                default: 
                    break; 
            } 

            
        }

        sc.close();
    }

    public void insert(int item, List<Integer> minHeap){
        minHeap.add(item);
        int currIndex = minHeap.size() -1;

        int parentIndex =  this.getParentIndex(currIndex);

        while(parentIndex >= 0 && minHeap.get(currIndex) < minHeap.get(parentIndex)){
            Collections.swap(minHeap, currIndex, parentIndex);
        
            currIndex = parentIndex;
            parentIndex =  this.getParentIndex(currIndex);

        }

    }

    public void deleteItem(int item, List<Integer> minHeap){
        if(minHeap.isEmpty()){
            System.out.println("Heap is empty");
            return;
            
        }
        
        int currIndex = minHeap.indexOf(item);

        //last item to be replaced with root and remove last item
        int lastIndex = minHeap.size() - 1;
        Collections.swap(minHeap, currIndex, lastIndex);
        minHeap.remove(lastIndex);

        //heapify
        int leftIndex = this.getLeftChildIndex(currIndex);
        int rightIndex = this.getRightChildIndex(currIndex);

        if(leftIndex >= minHeap.size() || rightIndex >= minHeap.size()){
            return;
        }

        int childMinIndex = (minHeap.get(leftIndex) < minHeap.get(rightIndex) ) ? leftIndex : rightIndex;

        while(minHeap.get(currIndex) > minHeap.get(childMinIndex)){
            Collections.swap(minHeap, currIndex, childMinIndex);

            currIndex = childMinIndex;

            leftIndex = this.getLeftChildIndex(currIndex);
            rightIndex = this.getRightChildIndex(currIndex);

            if( leftIndex >= minHeap.size() || rightIndex >= minHeap.size() ){
                break;
            }
            childMinIndex = (minHeap.get(leftIndex) < minHeap.get(rightIndex) ) ? leftIndex : rightIndex;

        }
        

    }

    public Integer deleteMin(List<Integer> minHeap){
        if(minHeap.size() == 1){
            return minHeap.remove(0);
            
        }
        if(minHeap.isEmpty()){
            System.out.println("Heap is empty");
            return -1;
        }

        int currIndex = 0;
        
        //to item to be deleted
        int item = minHeap.get(currIndex);
        
        //last item to be replaced with root and remove last item
        int lastIndex = minHeap.size() - 1;
        Collections.swap(minHeap, currIndex, lastIndex);
        minHeap.remove(lastIndex);

        //heapify
        int leftIndex = this.getLeftChildIndex(currIndex);
        int rightIndex = this.getRightChildIndex(currIndex);

        if(leftIndex >= minHeap.size() || rightIndex >= minHeap.size()){
            return item;
        }

        int childMinIndex = (minHeap.get(leftIndex) < minHeap.get(rightIndex) ) ? leftIndex : rightIndex;

        while(minHeap.get(currIndex) > minHeap.get(childMinIndex)){
            Collections.swap(minHeap, currIndex, childMinIndex);

            currIndex = childMinIndex;

            leftIndex = this.getLeftChildIndex(currIndex);
            rightIndex = this.getRightChildIndex(currIndex);

            if( leftIndex >= minHeap.size() || rightIndex >= minHeap.size() ){
                break;
            }
            childMinIndex = (minHeap.get(leftIndex) < minHeap.get(rightIndex) ) ? leftIndex : rightIndex;

        }
        

        return item;
    }


    public void printMin(List<Integer> minHeap){
        if(!minHeap.isEmpty()){
            System.out.println("Min: " +  minHeap.get(0) + "\t out of :: " + minHeap);
        }else{
            System.out.println("Heap is empty");
        }
        System.out.println();
    }

    public int getParentIndex(int index){
        // considering zero indexed array
        return (index - 1) / 2;
    }

    public int getLeftChildIndex(int index){
        // considering zero indexed array
        return 2 * index + 1;
    }

    public int getRightChildIndex(int index){
        // considering zero indexed array
        return 2 * index + 2;
    }

    // rough() {
    //     int size = minHeap.size();
    //     Integer item = minHeap.get(0);
    //     Collections.swap(minHeap, 0, size-1);
    //     minHeap.remove(size -1);

    //     int currIndex = 0;
    //     int leftIndex = this.getLeftChildIndex(currIndex);
    //     int rightIndex = this.getRightChildIndex(currIndex);
    //     System.out.println("*curr : " + minHeap.get(currIndex));
    //     System.out.println("*left : " + minHeap.get(leftIndex));
        
        
    //     if(rightIndex >= minHeap.size() || leftIndex >= minHeap.size()){
    //         return item;
    //     }
    //     int minChildIndex = (minHeap.get(leftIndex) < minHeap.get(rightIndex) ) ? leftIndex : rightIndex;

    //     System.out.println("*right : " + minHeap.get(rightIndex));
    //     System.out.println("*min : " + minHeap.get(minChildIndex));

    //     while(minHeap.get(minChildIndex) < minHeap.get(currIndex)){
    //         System.out.println("Swapping");
    //         System.out.println("curr : " + minHeap.get(currIndex));
    //         System.out.println("left : " + minHeap.get(leftIndex));
    //         System.out.println("right : " + minHeap.get(rightIndex));
    //         System.out.println("min : " + minHeap.get(minChildIndex));
    //         Collections.swap(minHeap, minChildIndex, currIndex);

    //         currIndex = minChildIndex;
    //         leftIndex = this.getLeftChildIndex(currIndex);
    //         rightIndex = this.getRightChildIndex(currIndex);

    //         if(rightIndex > minHeap.size() || leftIndex > minHeap.size()){
    //             break;
    //         }

    //         minChildIndex = (minHeap.get(leftIndex) < minHeap.get(rightIndex) ) ? leftIndex : rightIndex;

    //     }

    //     System.out.println("Test: " + minHeap);


    // }
}



