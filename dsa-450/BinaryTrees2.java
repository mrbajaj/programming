/**
 * URL: https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1
 * Tags: Tree
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

class BinaryTrees2 {

    public static void main(String[] args) {
        BinaryTrees2 obj = new BinaryTrees2();
        Solution sol = new Solution();

        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(3);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.reverseLevelOrder(p) + "\n");

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.reverseLevelOrder(p) + "\n");
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

class Solution
{
    static ArrayList<Integer> reverseLevelOrder(TreeNode node) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(node == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(node);
        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();
            stack.push(curr.val);
            if(curr.right != null){
                queue.add(curr.right);
            }
            if(curr.left != null){
                queue.add(curr.left);
            }
        }
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }
}
