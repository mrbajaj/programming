import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

/**
 * URL: 
 * 
 */

class Problem107 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
        @Override
        public String toString() {
            return " " + this.val + " ";
        }
    }

    public static void main(String[] args) {
        Problem107 obj = new Problem107();

        TreeNode p = null;
        System.out.println("Ans: " + obj.levelOrderBottom(p) + "\n");

        p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p.left.left = new TreeNode(4);
        System.out.println("Ans: " + obj.levelOrderBottom(p) + "\n");

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);
        System.out.println("Ans: " + obj.levelOrderBottom(p) + "\n");
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        TreeNode dummy = new TreeNode(0); 
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode current, prev = root;
        queue.add(root);
        queue.add(dummy);
        while(!queue.isEmpty()){
            current = queue.remove();
            stack.add(current);
            if(current == dummy){
                queue.add(dummy);
            }
            if(prev == dummy && current == dummy){
                break;
            }
            if(current.left != null){
                queue.add(current.left);
            }

            if(current.right != null){
                queue.add(current.right);
            }
            prev = current;
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> level = new ArrayList<Integer>();
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node == dummy && !level.isEmpty()){
                Collections.reverse(level);
                result.add(level);
                level = new ArrayList<Integer>();
                continue;
            }
            if(node != dummy){
                level.add(node.val);
            }   
        }
        result.add(level);
        System.out.println();
        
        return result;
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