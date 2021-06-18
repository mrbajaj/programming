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

class Problem617 {

    public static void main(String[] args) {
        Problem617 obj = new Problem617();
        Solution sol = new Solution();

        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(3);

        obj.printTree(p); System.out.println();
        
        TreeNode q = new TreeNode(4);  
        q.left = new TreeNode(2);  
        q.right = new TreeNode(9);  
        q.left.left = new TreeNode(3);  
        q.left.right = new TreeNode(8);  
        q.right.right = new TreeNode(7);

        obj.printTree(q); System.out.println();
        System.out.println("Ans: \n");
        TreeNode ans = sol.mergeTrees(p,q);
        obj.printTree(ans); System.out.println();
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }

        TreeNode newNode = new TreeNode(0);
        if(root1 != null && root2 != null){
            newNode.val += root1.val;
            newNode.val += root2.val;
            newNode.left = mergeTrees(root1.left, root2.left);
            newNode.right = mergeTrees(root1.right, root2.right);
        }else if(root1 != null){
            newNode.val += root1.val;
            newNode.left = mergeTrees(root1.left, null);
            newNode.right = mergeTrees(root1.right, null);
        }else{
            newNode.val += root2.val;
            newNode.left = mergeTrees(null, root2.left);
            newNode.right = mergeTrees(null, root2.right);
        }
        return newNode;
    }
}