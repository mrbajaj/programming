/**
 * URL: https://leetcode.com/problems/average-of-levels-in-binary-tree/
 * Tags: Tree
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;


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

class Problem637 {

    public static void main(String[] args) {
        Problem637 obj = new Problem637();
        Solution sol = new Solution();

        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(9);
        p.right = new TreeNode(20);
        p.right.left = new TreeNode(15);
        p.right.right = new TreeNode(7);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.averageOfLevels(p) + "\n");

        // p = new TreeNode(4);  
        // p.left = new TreeNode(2);  
        // p.right = new TreeNode(9);  
        // p.left.left = new TreeNode(3);  
        // p.left.right = new TreeNode(8);  
        // p.right.right = new TreeNode(7);

        // obj.printTree(p); System.out.println();
        // System.out.println("Ans: " + sol.averageOfLevels(p) + "\n");
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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Double sum = 0.0, count = 0.0;
        TreeNode placeHolder = new TreeNode(0);
        Queue<TreeNode> q  = new LinkedList<>(); 
        q.add(root);
        q.add(placeHolder);
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr == placeHolder){
                ans.add(sum / count);
                sum = 0.0; 
                count = 0.0;

                if(q.isEmpty()){
                    break;
                }else{
                    q.add(placeHolder);
                }
                continue;
            }
            
            count++;
            sum += curr.val;
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }

        return ans;
    }
}