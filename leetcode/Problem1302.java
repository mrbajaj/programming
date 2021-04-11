/**
 * URL: https://leetcode.com/problems/deepest-leaves-sum/
 * Tags: Tree
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

import java.util.LinkedList;
import java.util.Queue;

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

class Problem1302 {

    public static void main(String[] args) {
        Problem1302 obj = new Problem1302();
        SolutionRecursive sol = new SolutionRecursive();

        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(3);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.deepestLeavesSum(p) + "\n");

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.deepestLeavesSum(p) + "\n");
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

class SolutionIterative {
    public int deepestLeavesSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        TreeNode dummy = new TreeNode(0);
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(dummy);
        TreeNode curr, prev = null;
        int currLevelSum = 0, prevLevelSum = 0;
        while(!queue.isEmpty()){
            curr = queue.remove();

            if(curr == dummy && prev != dummy){
                queue.add(dummy);
                prevLevelSum = currLevelSum;
                currLevelSum = 0;
            }else{
                currLevelSum += curr.val;
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }

            prev = curr;
        }

        return prevLevelSum;
    }
}

class SolutionRecursive {
    int maxLevel = 0, sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        levelOrderTraversal(root, 0);
        return sum;
    }

    private void levelOrderTraversal(TreeNode root, int level){
        if(root == null){
            return;
        }

        if(level > maxLevel){
            sum = 0;
            maxLevel = level;
        }
        if(level == maxLevel){
            sum += root.val;
        }

        levelOrderTraversal(root.left, level + 1);
        levelOrderTraversal(root.right, level + 1);
    }
}