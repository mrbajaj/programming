/**
 * URL: https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 */

 import java.util.ArrayList;
 import java.util.List;

 import java.util.Set;
 import java.util.HashSet;

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
}


class Problem145 {
    public static void main(String[] args) {
        Problem145 obj = new Problem145();
        Solution1 sol1 = new Solution1();
        Solution2 sol2 = new Solution2();

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        obj.printTree(p); System.out.println();
        System.out.println("Ans Recursive: " + sol1.postorderTraversal(p));
        System.out.println("Ans Iterative: " + sol2.postorderTraversal(p) + "\n");

        p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(5);
        p.left.left = new TreeNode(3);
        p.left.right = new TreeNode(4);
        p.right.left = new TreeNode(6);
        p.right.right = new TreeNode(7);

        obj.printTree(p); System.out.println();
        System.out.println("Ans Recursive: " + sol1.postorderTraversal(p));
        System.out.println("Ans Iterative: " + sol2.postorderTraversal(p) + "\n");
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

class Solution1 {
    // Recursive
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        this.postorderTraversal_util(root, ans );
        return ans;
    }
    
    public void postorderTraversal_util(TreeNode root, List<Integer> ans) {
        if(root == null){
            return;
        }
        this.postorderTraversal_util(root.left, ans );
        this.postorderTraversal_util(root.right, ans );
        ans.add(root.val);
    }
}

class Solution2 {
    // Iterative
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            stack2.push(curr);
            if(curr.left != null){
                stack.push(curr.left);
            }
            if(curr.right !=  null){
                stack.push(curr.right);
            }
        }
        while(!stack2.isEmpty()){
            TreeNode curr = stack2.pop();
            ans.add(curr.val);
        }

        
        return ans;
    }
}