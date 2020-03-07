/**
 * URL: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * 
 */

class Problem1008 {

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
        Problem1008 obj = new Problem1008();


        TreeNode root = obj.bstFromPreorder(new int[]{8,5,1,7,10,12}) ;
        obj.printTree(root); System.out.println();
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return this.buildBST(preorder, 0, preorder.length - 1);
    }

    public TreeNode buildBST(int[] preorder, int low, int high){
        // System.out.println("low: " + low + "\thigh: " + high);
        if(low > high){
            return null;
        }

        TreeNode root = new TreeNode(preorder[low]);

        int breakPointIndex = low + 1;
        while(breakPointIndex <= high && preorder[breakPointIndex] < preorder[low]){
            breakPointIndex++;
        }

        // this.printTree(root); System.out.println();

        root.left = buildBST(preorder, low+1, breakPointIndex - 1 );
        root.right = buildBST(preorder, breakPointIndex, high);


        return root;
    }

    public void printTree(TreeNode root) {
        
        if(root == null){
            return;
        }
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
        
    }

}