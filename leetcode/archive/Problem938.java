/**
 * URL: 
 * 
 */

class Problem938 {

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
        Problem938 obj = new Problem938();

        TreeNode p = new TreeNode(20);
        p.left = new TreeNode(10);
        p.right = new TreeNode(30);
        p.left.left = new TreeNode(5);
        p.left.right = new TreeNode(15);
        p.right.left = new TreeNode(25);
        p.right.right = new TreeNode(35);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.rangeSumBST(p, 5 , 35) + "\n");

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.rangeSumBST(p, 2, 7) + "\n");
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null){
            return 0;
        }
        int curr = 0, left = 0, right = 0;
        if(root.val >= L && root.val <= R){
            curr = root.val;
        }
        if(root.left != null){
            left = rangeSumBST(root.left, L, R);
        }

        if(root.right != null){
            right = rangeSumBST(root.right, L, R);
        }
        return curr + left + right;
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