class Problem35{

    public static void main(String[] args) {
        Problem35 obj = new Problem35();

        System.out.println(obj.searchInsert(new int[]{1,3,5,6}, 5) == 2);
        
        System.out.println(obj.searchInsert(new int[]{1,3,5,6}, 2) == 1);

        System.out.println(obj.searchInsert(new int[]{1,3,5,6}, 7) == 4);

        System.out.println(obj.searchInsert(new int[]{1,3,5,6}, 0) == 0);

    }

    public int searchInsert(int[] nums, int target) {
    
        int i = 0;
        while(i < nums.length && nums[i] < target){
            i++;
        }
        // System.out.println(i);

        return i;
    }
}