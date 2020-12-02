/**
 * URL: 
 * 
 */

class Problem1315 {

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
        Problem1315 obj = new Problem1315();

        TreeNode p = new TreeNode(6);  
        p.left = new TreeNode(7);  
        p.right = new TreeNode(8);  
        p.left.left = new TreeNode(2);  
        p.left.right = new TreeNode(7);  
        p.right.left = new TreeNode(1);
        p.right.right = new TreeNode(3);
        p.left.left.left = new TreeNode(9);  
        p.left.right.left = new TreeNode(1);  
        p.left.right.right = new TreeNode(4);
        p.right.right.right = new TreeNode(5);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.sumEvenGrandparent(p) + "\n");
    }

    public int sumEvenGrandparent(TreeNode root) {
        if(root == null){
            return 0;
        }
        int sum = 0;

        if(root.val % 2 == 0){
            sum += (root.left != null && root.left.left != null) ? root.left.left.val : 0;
            sum += (root.left != null && root.left.right != null) ? root.left.right.val : 0;
            sum += (root.right != null && root.right.left != null) ? root.right.left.val : 0;
            sum += (root.right != null && root.right.right != null) ? root.right.right.val : 0;
        }
        
        int leftSum = (root.left != null) ? sumEvenGrandparent(root.left) : 0;
        int rightSum = (root.right != null) ? sumEvenGrandparent(root.right) : 0;

        return sum + leftSum + rightSum;
        
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