import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * URL: https://leetcode.com/problems/pancake-sorting/
 * 
 * 
 */
class Problem969{

    public static void main(String[] args) {
        Problem969 obj = new Problem969();

        List<Integer> listOfK = obj.pancakeSort(new int[]{3,2,4,1});
        System.out.println(listOfK);

    }

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> listOfK  = new ArrayList<>();

        for(int itr = 0; itr < A.length; itr++){

            // System.out.print("Iteration " + itr + " ::\t" + Arrays.toString(A) + "::\t");
            if(isSorted(A)){
                return listOfK;
            }
            int K = this.maxIndexInRange(A, 0, A.length - 1 - itr);
            listOfK.add(K + 1);
            A = this.flipArrayForGivenRange(A, 0, K);
            // System.out.print("maxK: =>" + K + " " + Arrays.toString(A));

            if(isSorted(A)){
                return listOfK;
            }

            K = A.length - 1 - itr;
            listOfK.add(K + 1);
            A = this.flipArrayForGivenRange(A, 0, K);
            // System.out.print("\tfullK: =>" + K + " "  + Arrays.toString(A) + "\n");;

        }

        return listOfK;
    }

    public boolean isSorted(int[] A){
        for(int i = 0; i <  A.length - 1; i++){
            if(A[i] > A[i+1]){
                return false;
            }
        }

        return true;
    }

    public int maxIndexInRange(int[] A, int start, int end){
        if(end >= A.length){
            return -1;
        }
        int max = A[start];
        int maxIndex = start;
        for(int i = start + 1; i <= end; i++){
            if(max <= A[i]){
                max = A[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public int[] flipArrayForGivenRange(int[] A, int start, int end){
        if(start < 0 && end >= A.length){
            return A;
        }
        int i = start;
        int j = end;
        while(i < j){
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
            i++;
            j--;
        }
        return A;
    }

}