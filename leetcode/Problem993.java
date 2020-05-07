/**
 * URL: https://leetcode.com/problems/cousins-in-binary-tree
 * 
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

class Problem993 {

    public static void main(String[] args) {
        Problem993 obj = new Problem993();
        Solution sol = new Solution();

        
        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(8);
        p.right.left = new TreeNode(10);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.isCousins(p, 8, 10) + "\n");

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(8);
        p.left.right = new TreeNode(11);  
        p.right.right = new TreeNode(10);
        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.isCousins(p, 8, 10) + "\n");

        p = new TreeNode(1);
        p.right = new TreeNode(2);  
        p.right.left = new TreeNode(3);
        p.right.right = new TreeNode(5);
        p.right.left.left = new TreeNode(4);
        p.right.left.left.right = new TreeNode(6);
        
        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.isCousins(p, 5, 3) + "\n");

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
    public boolean isCousins(TreeNode node, Integer a, Integer b) 
    { 
        return ((level(node, a, 1) == level(node, b, 1)) && (!isSibling(node, a, b))); 
    }
    private boolean isSibling(TreeNode node, Integer a, Integer b) 
    { 
        System.out.print("Node Value:" + node + "\t");
        if (node == null) {
            System.out.println("No");
            return false; 
        }
            
  
        if( (node.left != null && node.right != null && node.left.val == a && node.right.val == b) ||  (node.left != null && node.right != null && node.left.val == b && node.right.val == a) ){
            System.out.println("Sibling");
            return true;
        } 
        System.out.println("Check for childs");
        return isSibling(node.left, a, b) ||  isSibling(node.right, a, b);
    } 
  
    private int level(TreeNode node, Integer val, int lev) 
    { 
        // base cases 
        if (node == null) 
            return 0; 
  
        if (node.val == val) 
            return lev; 
  
        // Return level if Node is present in left subtree 
        int l = level(node.left, val, lev + 1); 
        if (l != 0) 
            return l; 
  
        // Else search in right subtree 
        return level(node.right, val, lev + 1); 
    } 
    
    
}