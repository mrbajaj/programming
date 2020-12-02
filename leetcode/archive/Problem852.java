class Problem852{
    public static void main(String[] args) {
        Problem852 obj = new Problem852();

        System.out.println("Ans: " + obj.peakIndexInMountainArray(new int[]{0,1,0}));

        System.out.println("Ans: " + obj.peakIndexInMountainArray(new int[]{0,2,1,0}));

        System.out.println("Ans: " + obj.peakIndexInMountainArray(new int[]{0,2,3,4,1,0}));

    }

    public int peakIndexInMountainArray(int[] A) {
        int i = 0;
        
        while(A[i] < A[i+1]){
            i++;
        }
        return i;
    }
}