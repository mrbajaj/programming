/* Programm to understand basic concepts of arrat
 *
*/
import java.util.*;
import java.util.stream.*;

class MyArray{
    private int a[];
    int size;
    MyArray(int n){
        this.a = new int[n];
        this.size = n;
    }
    
    boolean insert(int value, int index){
        if( index > size || index < 0 ){
            return false;
        }
        this.a[index] = value;

        return true;
    }
    
    boolean unset(int index){
        if(index > size || index < 0 ){
            return false;    
        }
        this.a[index] = 0;
        return true;
    }

    Integer get(int index){
        if( index > size || index < 0 ){
            return null;    
        }
        return this.a[index];
    }
    
    Integer getMin(){
        int min = Integer.MAX_VALUE;
        for (int x : this.a) {
            if(x<min){
                min = x;
            }
        }
        return min;
    }
    
    Integer getMax(){
        int max = Integer.MIN_VALUE;
        for (int x : this.a) {
            if(x>max){
                max = x;
            }
        }
        return max;
    }

    Integer getSum(){
        int sum = 0;
        for (int x : this.a) {
            sum = sum + x;
        }
        return sum;
    }

    void printArray(){
        // System.out.println("Array\t:\t" + this.a.toString());
        System.out.print("[ ");    
        for(int x : this.a){
            System.out.print(x + " ");
        }
        System.out.println("]");    
    }
    
    void reverse(){
        int frwd = 0;
        int bkwd = size-1;
        int tmp;
        while(frwd<bkwd){
            tmp          = this.a[frwd];
            this.a[frwd] = this.a[bkwd];
            this.a[bkwd] = tmp;
            frwd++;
            bkwd--;
        }
    }
}

public class Day1_ArrayPrograms{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n      = sc.nextInt();
        int bound = sc.nextInt();
        MyArray obj = new MyArray(n);
        
        // Random r = new Random();
        for(int i=0; i<n; i++){
            // obj.insert(sc.nextInt(), i);
            obj.insert(new Random().nextInt(bound), i);
        }
        
        System.out.print("Original Array\t:");
        obj.printArray();
        int atpos = new Random().nextInt(n);
        System.out.println("AtPos "+atpos+"\t:" + obj.get(atpos));
        System.out.println("Min\t:" + obj.getMin());
        System.out.println("Max\t:" + obj.getMax());
        System.out.println("Sum\t:" + obj.getSum());
        obj.reverse();
        System.out.print("After Reverse\t:");
        obj.printArray();
        
        
        sc.close();
    }


}