/**
 * URL: 
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


class Problem144 {
    public static void main(String[] args) {
        Problem144 obj = new Problem144();
        Solution2 sol = new Solution2();

        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(3);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.preorderTraversal(p) + "\n");

        p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(5);
        p.left.left = new TreeNode(3);
        p.left.right = new TreeNode(4);
        p.right.left = new TreeNode(6);
        p.right.right = new TreeNode(7);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.preorderTraversal(p) + "\n");
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        this.preorderTraversal_util(root, ans );
        return ans;
    }
    
    public void preorderTraversal_util(TreeNode root, List<Integer> ans) {
        if(root == null){
            return;
        }
        ans.add(root.val);
        this.preorderTraversal_util(root.left, ans );
        this.preorderTraversal_util(root.right, ans );
    }
}

class Solution2 {
    // Iterative
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            System.out.print(curr.val + " ");
            ans.add(curr.val);
            if(curr.right !=  null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }

        }
        
        System.out.println();

        return ans;
    }
}