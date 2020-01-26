import java.util.Arrays;

/**
 * URL: https://leetcode.com/problems/sort-array-by-parity/
 * 
 */
class Problem905{

    public static void main(String[] args) {
        Problem905 obj = new Problem905();

        System.out.println("Ans: "+ Arrays.toString( obj.sortArrayByParity(new int[]{3,1,2,4}) ));
    }


    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length -1;

        while(i <= j){
            while( i < A.length && A[i]%2 == 0 ){
                //even
                i++;
            }
            while( j >= 0 && A[j]%2 != 0 ){
                //odd
                j--;
            }

            if(i <= j && i < A.length && j >= 0){
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

        }


        return A;
    }
}