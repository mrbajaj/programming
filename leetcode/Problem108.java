/**
 * URL: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 
 */

class Problem108{
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        
        Problem108 obj = new Problem108();
        
        TreeNode root;
        
        root = obj.sortedArrayToBST(new int[]{1,2,3,4});
        obj.printTree(root);

        System.out.println();

        root = obj.sortedArrayToBST(new int[]{1,2,3,4,5,6,7});
        obj.printTree(root);
        System.out.println();
    
        
    }

    public void printTree(TreeNode root){
        if(root == null){
            return;
        }
        printTree(root.left);
        System.out.print(root.val + " " );
        printTree(root.right);

    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTUtil(nums, 0, nums.length);
    }

    public TreeNode sortedArrayToBSTUtil(int[] nums, int L, int H) {

        if(H <= L){
            return null;
        }

        int M = (L + H) / 2;

        TreeNode root = new TreeNode(nums[M]);
        root.left  = sortedArrayToBSTUtil(nums, L, M);
        root.right = sortedArrayToBSTUtil(nums, M+1, H);

        return root;
    }

}