/**
 * URL: https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Problem94 {
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
        Problem94 obj = new Problem94();

        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(3);

        System.out.println("Ans: " + obj.inorderTraversal(p));
        System.out.println("Ans: " + obj.inorderTraversalIterative(p));

        

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);

        System.out.println("Ans: " + obj.inorderTraversal(p));
        System.out.println("Ans: " + obj.inorderTraversalIterative(p));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        inorderTraversalRecursive(root, list);

        return list;
        
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root,  List<Integer> list){
        if(root == null){
            return list;
        }

        inorderTraversalRecursive(root.left, list);
        list.add(root.val);
        inorderTraversalRecursive(root.right, list);

        return list;
    }


    public List<Integer> inorderTraversalIterative(TreeNode root) {

        // 1) Create an empty stack S.
        // 2) Initialize current node as root
        // 3) Push the current node to S and set current = current->left until current is NULL
        // 4) If current is NULL and stack is not empty then 
        //      a) Pop the top item from stack.
        //      b) Print the popped item, set current = popped_item->right 
        //      c) Go to step 3.
        // 5) If current is NULL and stack is empty then we are done.


        List<Integer> list = new ArrayList<>();

        if(root == null){
            return list;
        }
        // 1) Create an empty stack S.
        Stack<TreeNode> stack = new Stack<>();

        // 2) Initialize current node as root
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty() ){
            
            // 3) Push the current node to S and set current = current->left until current is NULL
            while(curr != null){
                stack.add(curr);
                curr = curr.left;
            }    
            
            // 4) If current is NULL and stack is not empty then 
            if(curr == null){
                // a) Pop the top item from stack.
                // b) Print the popped item, set current = popped_item->right 
                // c) Go to step 3.
                TreeNode v = stack.pop();
                list.add(v.val);
                curr = v.right;
            }
            
            // 5) If current is NULL and stack is empty then we are done.
            if(curr== null && stack.isEmpty()){
                break;
            }
        
        }

        return list;
        
    }
}