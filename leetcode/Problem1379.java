/**
 * URL: 
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

class Problem1379 {

    public static void main(String[] args) {
        Problem1379 obj = new Problem1379();
        Solution sol = new Solution();
        
        TreeNode target = new TreeNode(3);

        TreeNode p = new TreeNode(10);
        p.left = new TreeNode(5);
        p.left.left = target;
        p.right = new TreeNode(15);
        p.right.right = new TreeNode(18);

        obj.printTree(p); System.out.println();

        TreeNode q = new TreeNode(11);
        q.left = new TreeNode(6);
        q.left.left = new TreeNode(4);
        q.right = new TreeNode(16);
        q.right.right = new TreeNode(19);

        obj.printTree(q); System.out.println();

        System.out.println("Ans: " + sol.getTargetCopy(p, q, target) + "\n");
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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == target){
            return cloned;
        }
        if(original == null){
            return null;
        }
        TreeNode found = getTargetCopy(original.left, cloned.left, target);
        if(found != null){
            return found;
        }
        return getTargetCopy(original.right, cloned.right, target);
    }
}