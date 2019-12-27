import java.util.Arrays;

/**
 * URL: 
 * 
 */

class Problem4{

    public static void main(String[] args) {
        Problem4 obj = new Problem4();

        System.out.println("Ans: " + obj.findMedianSortedArrays(new int[]{1,2}, new int[]{2}) + "\n");

        System.out.println("Ans: " + obj.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}) + "\n");

        System.out.println("Ans: " + obj.findMedianSortedArrays(new int[]{1,2}, new int[]{}) + "\n");
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int count = m + n;
        int[] merged = new int[m+n];
        int i =0 , j = 0,  k = 0;

        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                merged[k] = nums1[i];
                i++;
            }else{
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i<m){
            merged[k] = nums1[i];
            i++;
            k++;
        }

        while(j<n){
            merged[k] = nums2[j];
            j++;
            k++;
        }

        System.out.println(Arrays.toString(merged));
        if(count % 2 == 0){
            // even count
            int x = (count-1) / 2;
            int y = (count) / 2;

            System.out.println("Index:: " + x + ", " + y + ",\t count:" + count);
            System.out.println("Even:: " + merged[x] + ", " + merged[y]);

            return ( (double)merged[x] + merged[y] ) / 2;
            
        }else{
            // odd count
            System.out.println("Odd:: " + merged[count/2]);
            return merged[count/2];
        }

    }
}