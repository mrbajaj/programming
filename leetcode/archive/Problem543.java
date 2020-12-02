/**
 * URL: https://leetcode.com/problems/diameter-of-binary-tree/submissions/
 * 
 * 
 * Usecase: [4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]
 * Expected: 6
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        
        return val + " ";
    }
}

class Problem543{

    
    public static void main(String[] args) {
        Solution1 sol1 = new Solution1();
        Solution2 sol2 = new Solution2();
        TreeNode root = null;

        System.out.println( sol1.diameterOfBinaryTree(root) );
        System.out.println( sol2.diameterOfBinaryTree(root) );

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println( sol1.diameterOfBinaryTree(root));
        System.out.println( sol2.diameterOfBinaryTree(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println( sol1.diameterOfBinaryTree(root));
        System.out.println( sol2.diameterOfBinaryTree(root));

    }
    
}

class Solution1{
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0; 

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        int ldiameter = diameterOfBinaryTree(root.left);
        int rdiameter = diameterOfBinaryTree(root.right);

        return Math.max(Math.max(ldiameter, rdiameter), leftHeight + rightHeight);
    }

    private int heightOfTree(TreeNode root) {
        if(root == null) return 0;

        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;

    }
}

class Solution2{
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        heightOfTree(root);
        return ans - 1;
    }
    public int heightOfTree(TreeNode node) {
        if (node == null) return 0;
        int L = heightOfTree(node.left);
        int R = heightOfTree(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }
}