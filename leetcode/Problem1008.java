/**
 * URL: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
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
}


public class Problem1008 {

    
    public static void main(String[] args) {
        Solution sol = new Solution();


        TreeNode root = sol.bstFromPreorder(new int[]{8,5,1,7,10,12}) ;
        
    }

}


class Solution {
    
    public TreeNode bstFromPreorder(int[] preorder) {
        
        return this.helper(preorder, 0, preorder.length -1);
    }

    public TreeNode helper(int[] preorder, int s, int e){
        if(s > e){
            return null;
        }
        if(s >= preorder.length || e >= preorder.length){
            return null;
        }
        // System.out.print("s " + s + "\te " + e + "\troot: " + preorder[s]);
        TreeNode root = new TreeNode(preorder[s]);
        

        int mid = s+1;
        while(mid <= e && preorder[mid] < preorder[s]){
            mid++;
        }
        // System.out.println("\tmid " + mid);
        root.left = this.helper(preorder, s+1, mid-1);
        root.right = this.helper(preorder, mid, e);
        return root;
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