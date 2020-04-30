/**
 * URL: 
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

class ProblemDay30April2020Leetcode {

    public static void main(String[] args) {
        ProblemDay30April2020Leetcode obj = new ProblemDay30April2020Leetcode();
        Solution sol = new Solution();

        TreeNode p = new TreeNode(0);
        p.left = new TreeNode(1);
        p.right = new TreeNode(0);
        p.left.left = new TreeNode(0);
        p.left.right = new TreeNode(1);
        p.right.left = new TreeNode(0);
        p.left.left.right = new TreeNode(1);
        p.left.right.left = new TreeNode(0);
        p.left.right.right = new TreeNode(0);
        

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.isValidSequence(p, new int[]{0,1,0,1}) + "\n");

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.isValidSequence(p, new int[]{0,0,1}) + "\n");
        
        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.isValidSequence(p, new int[]{0,1,1}) + "\n");


        p = new TreeNode(8);
        p.left = new TreeNode(3);
        p.left.left = new TreeNode(2);
        p.left.right = new TreeNode(1);
        p.left.left.left = new TreeNode(5);
        p.left.left.right = new TreeNode(4);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.isValidSequence(p, new int[]{8}) + "\n");

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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return this.helper(root, arr, 0);
    }

    private boolean helper(TreeNode root, int[] arr, int len){
        System.out.print("\n root: " + root + "\tlen:"+ len);
        if(root == null){
            return false;
        }
        if(len == arr.length - 1 && root.left == null && root.right == null && arr[len] == root.val){
            return true;
        }else if(len < arr.length && arr[len] == root.val){
            System.out.print("\tMatched");
            return helper(root.left, arr, len+1) || helper(root.right, arr, len+1);
        }else{
            return false;
        }

    }
/*
    private boolean helper(TreeNode root, int[] arr, int len){
        System.out.print("\n root: " + root + "\tlen:"+ len);
        if(root == null && len == arr.length){
            return true;
        }else  if(root == null){
            return false;
        }
        
        if(len < arr.length && arr[len] == root.val){
            System.out.print("\tMatched");
            return helper(root.left, arr, len+1) || helper(root.right, arr, len+1);
        }else{
            return false;
        }

    }

*/
}