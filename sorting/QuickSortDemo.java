import java.util.Arrays;

public class QuickSortDemo{
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 4, 6, 2};
        int[] b = new int[]{33, 55, 22, 66, 44, 11};
        int[] c = new int[]{10, 20, 30, 40, 50, 60, 70};
        int[] d = new int[]{70, 60, 50, 40, 30, 20, 10};
        
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));

        quickSort(b, 0, a.length-1);
        System.out.println(Arrays.toString(b));
        
        quickSort(c, 0, a.length-1);
        System.out.println(Arrays.toString(c));

        quickSort(c, 0, a.length-1);
        System.out.println(Arrays.toString(d));
    }

    public static void quickSort(int[] a, int s, int e){
        int i = s, j = e; 
        int m = (int) (Math.random() * (e - s)) + s; // index of pivot elelemt is taken randomly

        int v = a[m]; // v is the pivot element
        
        try{
            while(i <= j){
                
                while(a[i] < v){
                    //traverse right till the elements are smaller than pivot
                    i++;
                }
                while(a[j] >  v){
                    //traverse left till the elements are greater than pivot
                    j--;
                }
                
                if( i <= j){
                    // swap the ith (greater than pivot) and jth (smaller than pivot) elements
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                    i++; j--; // shift i and j one step forward and backward respectively
                }
            }
            
            
            if(s < j)
                quickSort(a, s, j); // sort the elements on the left side of the pivot
            if(i < e)
                quickSort(a, j+1, e); // sort the elements on the right side of pivot
        }catch(Exception exception){
            exception.printStackTrace();
        }
        
    }
}

