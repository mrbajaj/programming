/**
 * URL: 
 * 
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class Problem124 {

    public static void main(String[] args) {
        Problem124 obj = new Problem124();
        Solution2 sol = new Solution2();

        TreeNode p = new TreeNode(-3);
        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.maxPathSum(p) + "\n");

        p = new TreeNode(1);
        p.right = new TreeNode(2);
        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.maxPathSum(p) + "\n");

        p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(3);
        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.maxPathSum(p) + "\n");

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.maxPathSum(p) + "\n");
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

class Solution1 {
    // works for only positive numbers binary tree
    int maxPathSum;
    public int maxPathSum(TreeNode root) {
        maxPathSum = 0;
        this.pathSum(root);
        return maxPathSum;
    }

    private int pathSum(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = pathSum(root.left);
        int right =  pathSum(root.right);
        maxPathSum = Math.max(maxPathSum, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}

class Solution2 {
    // works for only positive and negative numbers binary tree
    int maxPathSum;
    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        this.pathSum(root);
        return maxPathSum;
    }

    private int pathSum(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int left = Math.max(0, pathSum(root.left) ); // here we are using the max with zero to handle negative numbers
        int right =  Math.max(0, pathSum(root.right) );  // here we are using the max with zero to handle negative numbers
        maxPathSum = Math.max(maxPathSum, left + right + root.val);
        return Math.max(left, right) + root.val; // we can either consider left+curr or right+curr while returning

    }
}