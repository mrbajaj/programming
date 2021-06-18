/**
 * URL: https://leetcode.com/problems/merge-two-binary-trees/
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

public class Problem617 {

    public static void main(String[] args) {
        Problem617 obj = new Problem617();
        Solution2 sol = new Solution2();

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(3);  
        p.right = new TreeNode(2);  
        p.left.left = new TreeNode(5);  
        
        obj.printTree(p); System.out.println();

        TreeNode q = new TreeNode(2);  
        q.left = new TreeNode(1);  
        q.right = new TreeNode(3);  
        q.left.right = new TreeNode(4);  
        q.right.right = new TreeNode(7);

        obj.printTree(p); System.out.println();

        System.out.println("Ans: \n");
        TreeNode r = sol.mergeTrees(p, q);
        obj.printTree(r); System.out.println();
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return null;
        }

        TreeNode newNode;
        if(t1 != null && t2 != null){
            newNode = new TreeNode(t1.val + t2.val);
            newNode.left = mergeTrees(t1.left, t2.left);
            newNode.right = mergeTrees(t1.right, t2.right);    
        }else if(t1 != null){
            newNode = t1;
            newNode.left = mergeTrees(t1.left, null);
            newNode.right = mergeTrees(t1.right, null);
        }else{
            newNode = t2;
            newNode.left = mergeTrees(null, t2.left);
            newNode.right = mergeTrees(null, t2.right);
        }
        return newNode;
    }
}

class Solution2{
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return null;
        }

        if(t1 != null && t2 != null){
            t1.val = t1.val + t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        }else if(t1 != null){
            t1.left = mergeTrees(t1.left, null);
            t1.right = mergeTrees(t1.right, null);
            return t1;
        }else{
            t2.left = mergeTrees(null, t2.left);
            t2.right = mergeTrees(null, t2.right);
            return t2;
        }
    }
}