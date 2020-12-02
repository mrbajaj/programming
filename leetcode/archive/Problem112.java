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

class Problem112 {

    public static void main(String[] args) {
        Problem112 obj = new Problem112();
        Solution sol = new Solution();

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.hasPathSum(p, 1) + "\n");

        p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.hasPathSum(p, 4) + "\n");

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.hasPathSum(p, 5) + "\n");

        p = new TreeNode(5);  
        p.left = new TreeNode(4);  
        p.right = new TreeNode(8);  
        p.left.left = new TreeNode(11);  
        p.right.left = new TreeNode(13);
        p.right.right = new TreeNode(4);
        p.left.left.left = new TreeNode(7);  
        p.left.left.right = new TreeNode(2);  
        p.right.right.right = new TreeNode(1);


        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.hasPathSum(p, 22) + "\n");
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        return this.helper(root, sum);
    }
    private boolean helper(TreeNode root, int sum) {
        if(root == null){
            System.out.print("*" + sum + "\n");
            return false;
        }
        sum = sum - root.val;

        if(sum == 0 && root.left == null && root.right == null){
            return true;
        }

        boolean left = helper(root.left, sum);
        boolean right = helper(root.right, sum);

        // sum = sum + root.val;
        return left || right;
    }
}