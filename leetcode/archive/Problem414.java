/**
 * URL: https://leetcode.com/problems/third-maximum-number/
 * 
 */
class Problem414{
    public static void main(String[] args) {
        Problem414 obj = new Problem414();

        System.out.println(obj.thirdMax(new int[]{1,-2147483648,2}) == -2147483648);

        System.out.println(obj.thirdMax(new int[]{2,1,3}) == 1);

        System.out.println(obj.thirdMax(new int[]{1,2,-2147483648}) == -2147483648);
        
        System.out.println(obj.thirdMax(new int[]{2,2,3,1}) == 1);

        System.out.println(obj.thirdMax(new int[]{6,4,1,2,3,5})  == 4);

        System.out.println(obj.thirdMax(new int[]{9,2,8,6,4,1,7,3,5}) == 7);

        System.out.println(obj.thirdMax(new int[]{1,2}) == 2);

        System.out.println(obj.thirdMax(new int[]{1,1,2}) ==  2);

        System.out.println(obj.thirdMax(new int[]{1,2,3}) == 1);
    
        System.out.println(obj.thirdMax(new int[]{1,2,2,5,3,5}) == 2);
        
    }

    public int thirdMax(int[] nums) {
        int n = nums.length;
        Integer first = null, second = null,  third = null; 
        for(int i = 0; i < n; i++){
            Integer val = Integer.valueOf(nums[i]);

            if ( (first != null && val.equals(first)) ||
                 (second != null && val.equals(second)) ||
                 (third != null && val.equals(third))
            ){
                continue;
            }
            
            if(first == null || val.intValue() > first.intValue()){
                third = second;
                second = first;
                first = val;
            }else if(second == null || val.intValue() > second.intValue()){
                third = second;
                second = val;
            }else if(third == null || val.intValue() > third.intValue()){
                third = val;
            }
        }

        return (second == null || third == null) ? first : third;

    }

    
}