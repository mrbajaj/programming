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
        boolean isForward = true;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        ArrayList<Integer> currLevel = new ArrayList<>();

        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();

            if(curr == null){
                if(isForward){
                    ans.add(currLevel);
                }else{
                    Collections.reverse(currLevel);
                    ans.add(currLevel);
                }
                isForward = !isForward;
                currLevel = new ArrayList<>();
                queue.add(null);
                curr = queue.remove();

                if(curr == null){
                    break;
                }
            }

            if(curr != null){
                currLevel.add(curr.val);
            }
            
            if(curr.left != null){
                queue.add(curr.left);
            }

            if(curr.right != null){
                queue.add(curr.right);
            }

        }


        return ans;
    }




}