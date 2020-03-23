/**
 * URL: https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 * 
 */

import java.util.List;
import java.util.ArrayList;

class Problem1379 {

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
        Problem1379 obj = new Problem1379();

        TreeNode original = new TreeNode(7);
        original.left = new TreeNode(4);
        original.right = new TreeNode(3);
        original.right.left = new TreeNode(6);
        original.right.right = new TreeNode(19);

        TreeNode cloned = new TreeNode(7);
        cloned.left = new TreeNode(4);
        cloned.right = new TreeNode(3);
        cloned.right.left = new TreeNode(6);
        cloned.right.right = new TreeNode(19);
        
        TreeNode target = original.right;
        
        TreeNode cloneTarget = obj.getTargetCopy(original, cloned, target);
        if(cloneTarget != null){
            System.out.println("Ans: " + cloneTarget.val + "\n");
        }else{
            System.out.println("Ans: " + null + "\n");
        }
        
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode orginalTarget) {
        if(original == null){
            return null;
        }

        if(original == orginalTarget){
            return cloned;
        }
        TreeNode left = this.getTargetCopy(original.left, cloned.left, orginalTarget);
        return (left != null) ? left : this.getTargetCopy(original.right, cloned.right, orginalTarget);
    }

    public final TreeNode getTargetCopy2(final TreeNode original, final TreeNode cloned, final TreeNode orginalTarget) {
        if(original == null){
            return null;
        }

        if(original == orginalTarget){
            return cloned;
        }
        TreeNode left = this.getTargetCopy(original.left, cloned.left, orginalTarget);
        TreeNode right = this.getTargetCopy(original.right, cloned.right, orginalTarget);
        return (left != null) ? left : right;
    }

    public final TreeNode getTargetCopy3(final TreeNode original, final TreeNode cloned, final TreeNode orginalTarget) {
        List<TreeNode> cloneTarget = new ArrayList<>();

        this.helperRecursive(original, cloned, orginalTarget, cloneTarget);
        
        return cloneTarget.get(0);
    }
    private final void helperRecursive(final TreeNode original, final TreeNode cloned, final TreeNode orginalTarget, List<TreeNode> cloneTarget) {
        if(original == null){
            return;
        }

        if(original == orginalTarget){
            cloneTarget.add(cloned);
            return;
        }
        this.helperRecursive(original.left, cloned.left, orginalTarget, cloneTarget);
        this.helperRecursive(original.right, cloned.right, orginalTarget, cloneTarget);

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