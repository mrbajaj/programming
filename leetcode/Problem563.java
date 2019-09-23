/**
 * 
 * URL: https://leetcode.com/problems/binary-tree-tilt/discuss/360530/Java-solution
 * 
 */
class Problem563{

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
        Problem563 obj = new Problem563();

        // Test1
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(3);

        // Test2
        TreeNode root = new TreeNode(1);
        root = new TreeNode(4);  
        root.left = new TreeNode(2);  
        root.right = new TreeNode(9);  
        root.left.left = new TreeNode(3);  
        root.left.right = new TreeNode(8);  
        root.right.right = new TreeNode(7);  
        
        
        int x = obj.findTilt(root);
        System.out.println(x);
    }
    
    int tilt = 0;
    public int findTilt(TreeNode root) {
        findTiltRec(root);
        return tilt;
    }

    public int findTiltRec(TreeNode root) {
        
        if(root == null){
            return 0;
        }

        int left = findTiltRec(root.left);
        int right = findTiltRec(root.right) ;

        tilt += Math.abs(left - right);

        return left + right + root.val;

    }

}