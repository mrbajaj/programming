/**
 * URL: https://leetcode.com/problems/same-tree/
 * 
 */
class Problem104{

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
        Problem104 obj = new Problem104();
       
        // Test1
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        
        System.out.println("Ans: " + obj.maxDepth(p));

        // Test2
         p = new TreeNode(1);
        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);
        
        
        System.out.println("Ans: " + obj.maxDepth(p));
    }
    
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ld = maxDepth(root.left);
        int rd = maxDepth(root.right);
        return Math.max(ld,rd) + 1;
    }

}