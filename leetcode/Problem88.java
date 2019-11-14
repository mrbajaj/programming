import java.util.Arrays;

class Problem88{
    
    public static void main(String[] args) {
        // int m = 5, n = 6;
        // int[] nums1 = new int[m+n];
        // int[] nums2 = new int[]{3,5,8,10,11,14};
        // nums1[0] = 1; nums1[1] = 4; nums1[2] = 6; nums1[3] = 9; nums1[4] = 15;

        // int m = 3, n = 3;
        // int[] nums1 = new int[m+n];
        // int[] nums2 = new int[]{2,5,6};
        // nums1[0] = 1; nums1[1] = 2; nums1[2] = 3;

        int m = 1, n = 0;
        int[] nums1 = new int[m+n];
        int[] nums2 = new int[n];
        nums1[0] = 1;

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    
        
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if(n == 0){
            return;
        }
        
        int size = m + n;
        for(int i=m-1, j = size-1 ; i >= 0; i--, j--){
            nums1[j] = nums1[i];
            nums1[i] = 0;
        }
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));

        int curr =0;
        for(int i=n, j=0; curr < size && j < n;){
            System.out.print("i="+i+" j="+j);
            // System.out.print(" ::\tnums1="+nums1[i]+" nums2="+nums2[j]);
            if( i < size && nums1[i] <= nums2[j]){
                nums1[curr] = nums1[i];
                System.out.print(" :: case1 \t");
                i++;
            }else{
                nums1[curr] = nums2[j];
                System.out.print(" :: case2 \t");
                j++;
            }
            System.out.println(Arrays.toString(nums1));
            curr++;
        }
    }

}