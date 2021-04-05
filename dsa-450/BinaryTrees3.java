/**
 * URL: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Tags: Tree
 * 
 * Best Time Complexity:
 * Best Space Complexity:
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

    public String toString() {
        return String.valueOf(this.val);
    }
}

class BinaryTrees3 {

    public static void main(String[] args) {
        BinaryTrees3 obj = new BinaryTrees3();
        Solution sol = new Solution();

        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(3);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.maxDepth(p) + "\n");

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.maxDepth(p) + "\n");
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

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        return 1 + Math.max(maxDepth(root.left) , maxDepth(root.right) );
    }
}