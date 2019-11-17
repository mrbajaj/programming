/**
 * 
 * URL: https://leetcode.com/problems/same-tree/
 * 
 */
class Problem100{

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
        Problem100 obj = new Problem100();
       
        // Test1
        // TreeNode p = new TreeNode(1);
        // p.left = new TreeNode(2);
        // p.right = new TreeNode(3);
        // TreeNode q = new TreeNode(1);
        // q.left = new TreeNode(2);
        // q.right = new TreeNode(3);

        // Test2
        TreeNode p = new TreeNode(1);
        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);
        TreeNode q = new TreeNode(1);
        q = new TreeNode(4);  
        q.left = new TreeNode(2);  
        q.right = new TreeNode(9);  
        q.left.left = new TreeNode(3);  
        q.left.right = new TreeNode(8);  
        q.right.right = new TreeNode(7);  
        
        
        System.out.println("And: " + obj.isSameTree(p,q));
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeRec(p, q);
    }

    public static boolean isSameTreeRec(TreeNode p, TreeNode q) {
        
        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        if(p.val != q.val){
            return false;
        }

        if(isSameTreeRec(p.left, q.left) && isSameTreeRec(p.right, q.right)){
            return true;
        }else{
            return false;
        }
    }

}