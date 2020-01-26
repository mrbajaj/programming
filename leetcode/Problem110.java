/**
 * URL: https://leetcode.com/problems/balanced-binary-tree/
 * 
 */

class Problem110 {

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
        Problem110 obj = new Problem110();

        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(3);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.isBalanced(p) + "\n");

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.isBalanced(p) + "\n");
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        
        int lH = height(root.left);
        int rH = height(root.right);

        int weight = lH - rH;
        if(Math.abs(weight) >= 2){
            return false;
        }else{
            boolean lB = isBalanced(root.left);
            boolean rB = isBalanced(root.right);
            return lB && rB;
            /* 
                if(isBalanced(root.left) == true){
                    return isBalanced(root.right);
                }else{
                    return false;
                }
             */
        }
        
    }

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int lH = height(root.left);
        int rH = height(root.right);

        return 1 + Math.max(lH, rH);
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