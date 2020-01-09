/**
 * URL: https://leetcode.com/problems/diameter-of-binary-tree/submissions/
 * 
 * 
 * Usecase: [4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]
 * Expected: 6
 */
class Problem543{

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            
            return val + " ";
        }
    }

    public static void main(String[] args) {
        Problem543 obj = new Problem543();
        TreeNode root = null;

        System.out.println( obj.diameterOfBinaryTree(root) );

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println( obj.diameterOfBinaryTree(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println( obj.diameterOfBinaryTree(root));

    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        int lheight = heightOfBinaryTree(root.left);
        int rheight = heightOfBinaryTree(root.right);

        int ldiameter = diameterOfBinaryTree(root.left);
        int rdiameter = diameterOfBinaryTree(root.right);

        return Math.max(lheight + rheight, Math.max(ldiameter, rdiameter ) );

    }

    public int heightOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right));
        
    }
    
}