/**
 * URL: https://leetcode.com/problems/monotonic-array/
 * 
 */
class Problem896{

    public static void main(String[] args) {
        // int[] A = new int[]{1,2,2,3};
        // int[] A = new int[]{6,5,4,4};
        // int[] A = new int[]{1,3,2};
        // int[] A = new int[]{1,2,4,5};
        // int[] A = new int[]{1,1,1};
        // System.out.println("Ans: " + isMonotonic(A);
        
        System.out.println("Ans: " + isMonotonic(new int[]{1,2,2,3}) + "");
        System.out.println("Ans: " + isMonotonic(new int[]{6,5,4,4}) + "");
        System.out.println("Ans: " + isMonotonic(new int[]{1,2,3}) + "");
        System.out.println("Ans: " + isMonotonic(new int[]{1,2,4,5}) + "");
        System.out.println("Ans: " + isMonotonic(new int[]{1,1,1}) + "");
        System.out.println("Ans: " + isMonotonic(new int[]{3,1,4,1,1}) + "");
        System.out.println("Ans: " + isMonotonic(new int[]{9,5,6,9}) + "");

    }

    public static boolean isMonotonic(int[] A) {
        Boolean isInc;
        int i = 0;
        while(i < A.length-1 && A[i] == A[i+1]){
            i++;
        }

        if(i == A.length-1){
            // System.out.println("All Same : i=" +  i);
            return true;
        }else{
            // System.out.println("Decide Inc or Dec : i=" +  i);
            isInc = (A[i] < A[i+1]) ? true : false;
        }

        if(isInc){
            while(i < A.length-1 && A[i] <= A[i+1]){
                i++;
            }
        }else{
            while(i < A.length-1 && A[i] >= A[i+1]){
                i++;
            }
        }

        if(i == A.length-1){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isMonotonicOld(int[] A) {
        Boolean isInc;

        int i = 0;
        while(i < A.length-1){
            if(A[i] == A[i+1]){
                i++;
                continue;
            }else{
                break;
            }
        }

        System.err.println(i);

        if(i == A.length-1){
            return true;
        }else{
            isInc = (A[i] < A[i+1])? true : false;
        }

        if(isInc){
            while(A[i] <= A[i+1] && i < A.length-1){
                i++;
            }
        }else{
            while(A[i] >= A[i+1] && i < A.length-1){
                i++;
            }
        }
        
        if(i == A.length-1){
            return true;
        }else{
            return false;
        }
    }
}