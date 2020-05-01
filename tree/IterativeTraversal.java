/**
 * URL: 
 * 
 */
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

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

class IterativeTraversal {

    public static void main(String[] args) {
        IterativeTraversal obj = new IterativeTraversal();
        Solution sol = new Solution();

        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(3);

        sol.inorder(p); System.out.println();
        sol.preorder(p); System.out.println();
        sol.postorder(p); System.out.println("\n");

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);

        sol.inorder(p); System.out.println();
        sol.preorder(p); System.out.println();
        sol.postorder(p); System.out.println("\n");
    }

}

class Solution {
    public void inorder(TreeNode root) {
        System.out.print("Inorder :\t");
        if(root == null){
            return;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null){
            
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            if(stack.isEmpty()){
                break;
            }
            curr = stack.pop();
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }

    public void preorder(TreeNode root) {
        System.out.print("Preorder :\t");
        if(root == null){
            return;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null){
            
            while(curr != null){
                System.out.print(curr.val + " ");
                stack.push(curr);
                curr = curr.left;
            }

            if(stack.isEmpty()){
                break;
            }
            curr = stack.pop();
            curr = curr.right;
        }
    }

    public void postorder(TreeNode root) {
        System.out.print("Postorder :\t");
        if(root == null){
            return;
        }
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode curr = stack1.pop();
            stack2.push(curr);

            if(curr.left != null){
                stack1.push(curr.left);
            }
            if(curr.right != null){
                stack1.push(curr.right);
            }
        }

        while(!stack2.isEmpty()){
            TreeNode curr = stack2.pop();
            System.out.print(curr.val + " ");
        }
    }
}