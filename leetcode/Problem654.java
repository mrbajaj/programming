/**
 * URL: https://leetcode.com/problems/maximum-binary-tree/
 * 
 */
class Problem654{

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
        
    }

    public static void main(String[] args) {
        Problem654 obj = new Problem654();

        TreeNode root = obj.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        obj.printTree( root );
        System.out.println();

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return MBTRec(nums, 0, nums.length-1);
    }

    public TreeNode MBTRec(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        
        int mi=start;
        for(int i=start;i<=end;i++) {
            if(nums[i]> nums[mi]) {
                mi=i;
            }
        }
        TreeNode root = new TreeNode(nums[mi]);
        root.left = MBTRec(nums, start, mi - 1);
        root.right = MBTRec(nums, mi + 1, end);
           
        return root;
    }

    public void printTree(TreeNode root){
        if(root == null){
            return;
        }
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }
}