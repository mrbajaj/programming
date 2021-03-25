/**
 * URL: https://leetcode.com/problems/search-in-a-binary-search-tree/
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

class BinarySearchTrees1 {

    public static void main(String[] args) {
        Tree obj = new Tree();
        Solution sol = new Solution();

        TreeNode p = new TreeNode(4);
        p.right = new TreeNode(7);
        p.right.left = new TreeNode(5);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.searchBST(p, 5) + "\n");

        p = new TreeNode(10);  
        p.left = new TreeNode(5);  
        p.right = new TreeNode(15);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(20);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.searchBST(p, 8) + "\n");
        System.out.println("Ans: " + sol.searchBST(p, 25) + "\n");
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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val){
            return root;
        }
        
        if(root.val < val){
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }

    }
}