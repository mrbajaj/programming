/**
 * URL: 
 * 
 */

class Tree {

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
        Tree obj = new Tree();

        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(3);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.func(p) + "\n");

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.func(p) + "\n");
    }

    public int func(TreeNode root){
        // TODO
        return 1;
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