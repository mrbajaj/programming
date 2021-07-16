/**
 * URL: 
 * Tags: Tree
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */
import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedList;

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

class Problem230 {

    public static void main(String[] args) {
        Problem230 obj = new Problem230();
        Solution sol = new Solution();
        SolutionIterative solItr = new SolutionIterative();

        
        TreeNode p = new TreeNode(10);  
        p.left = new TreeNode(5);  
        p.right = new TreeNode(15);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(20);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.kthSmallest(p, 2) + "\n");
        System.out.println("Ans: " + solItr.kthSmallest(p, 2) + "\n");
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

/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> sorted = new ArrayList<>();
        inorder(root, sorted);
         //System.out.println(sorted);
        return sorted.get(k-1);
    }
    private void inorder(TreeNode root, ArrayList<Integer> sorted){
        if(root == null){
            return;
        }
        inorder(root.left, sorted);
        sorted.add(root.val);
        inorder(root.right, sorted);
    }
}

/**
 * Time Complexity:
 * Space Complexity:
 */
class SolutionIterative {
    public int kthSmallest(TreeNode root, int k) {
        //TODO
    }
    
}