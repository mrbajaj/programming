/**
 * URL: 
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

class Problem124 {

    public static void main(String[] args) {
        Problem124 obj = new Problem124();
        Solution sol = new Solution();

        TreeNode p = new TreeNode(1);
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

class Solution {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        rec( root);
        return ans;
    }
    private int rec(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftAns = Math.max(0, rec(root.left));
        int rightAns =  Math.max(0, rec(root.right));
        ans = Math.max(ans, leftAns + rightAns + root.val);
        return Math.max(leftAns, rightAns) + root.val;
    }
}