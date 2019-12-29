import java.util.Arrays;

/**
 * Good morning! Here's your coding interview problem for today.
 * This problem was asked by Uber.
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * 
 * Follow-up: what if you can't use division?
 */
class Problem2{

    public static void main(String[] args) {
        Problem2 obj = new Problem2();

        System.out.println("Ans: " + Arrays.toString(obj.productArray( new int[]{1,2,3,4,5})));

        System.out.println("Ans: " + Arrays.toString(obj.productArrayWithoutDiv( new int[]{1,2,3,4,5})));

        System.out.println("Ans: " + Arrays.toString(obj.productArrayWithoutDiv( new int[]{2,3,4,5,6})));
    }

    public int[] productArray(int[] arr){
        int n = arr.length;
        int[] prodArr = new int[n];

        int prod = 1;

        for(int i=0; i<n; i++){
            prod *= arr[i];
        }

        for(int i=0; i<n; i++){
            prodArr[i] = prod / arr[i];
        }

        return prodArr;
    }

    public int[] productArrayWithoutDiv(int[] arr){

        int n = arr.length;
        int[] prodArr = new int[n];

        int[][] memoize = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(i==j){
                    // diagonal
                    memoize[i][j] = arr[i];
                }
                else{
                    memoize[i][j] = memoize[i][j-1] * arr[j];
                    memoize[j][i] = memoize[i][j-1] * arr[j];
                }
            }
        }

        // for(int i =0; i<n; i++){
        //     System.out.println(Arrays.toString(memoize[i]));
        // }

        
        for(int i = 0; i < n; i++){
            if(i == 0){
                prodArr[i] = memoize[i+1][n-1];
            }else if( i != n-1){
                prodArr[i] = memoize[0][i-1] * memoize[i+1][n-1];
            }else{
                prodArr[i] = memoize[0][i-1];
            }
            
        }

        return prodArr;

    }
}
