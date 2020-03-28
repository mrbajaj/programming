import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Collections;


/**
 * URL: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 */
class Problem103{

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
            return String.valueOf(this.val);
        }
    }
    public static void main(String[] args) {
        Problem103 obj = new Problem103();

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(4);
        p.right.left = new TreeNode(3);

        System.out.println("Ans: " + obj.zigzagLevelOrder(p) + "\n\n\n");


        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);

        System.out.println("Ans: " + obj.zigzagLevelOrder(p));
        

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> allList = new ArrayList<List<Integer>>();
        TreeNode dummy = new TreeNode(0), prev = null;
        if(root == null){
            return allList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(dummy);
        boolean forward = false;
        List<Integer> currList = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();
            if(prev == curr){
                break;
            }

            if(curr == dummy){
                if(forward == true) { Collections.reverse(currList); } ;              
                allList.add(currList);
                queue.add(dummy);
                currList = new ArrayList<>();
                forward = !forward;
                prev = curr;
                continue;
            }
            
            if(curr.left != null){
                queue.add(curr.left);
            }

            if(curr.right != null){
                queue.add(curr.right);
            }

            currList.add(curr.val);
            prev = curr;
        }

        return allList;
    }

}