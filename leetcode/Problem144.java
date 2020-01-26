/**
 * URL: 
 * 
 */

 import java.util.ArrayList;
 import java.util.List;

class Problem144 {

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
        Problem144 obj = new Problem144();

        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(3);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.preorderTraversal(p) + "\n");

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.preorderTraversal(p) + "\n");
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        this.preorderTraversal_util(root, ans );
        return ans;
    }
    
    public void preorderTraversal_util(TreeNode root, List<Integer> ans) {
        if(root == null){
            return;
        }
        ans.add(root.val);
        this.preorderTraversal_util(root.left, ans );
        this.preorderTraversal_util(root.right, ans );
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