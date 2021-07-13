/**
 * URL: 
 * Tags: Tree
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
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

class Problem103 {

    public static void main(String[] args) {
        Problem103 obj = new Problem103();
        Solution sol = new Solution();

        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(3);

        obj.printTree(p); System.out.println();
        List<List<Integer>> ans = sol.zigzagLevelOrder(p);
        System.out.println("Ans: " + ans + "\n");

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);

        obj.printTree(p); System.out.println();
        ans = sol.zigzagLevelOrder(p);
        System.out.println("Ans: " + ans + "\n");
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result  = new ArrayList<List<Integer>>();
        List<Integer> level = new ArrayList<>();
        TreeNode dummy = new TreeNode(-1), curr = null, prev = null;
        boolean isForward = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(dummy);
        while(!queue.isEmpty()){
            curr = queue.remove();
            if(curr == dummy && prev == dummy){
                break;
            }
            if(curr == dummy){
                if(isForward == true){
                    result.add(level);
                }else{
                    level = this.reverseArrayList(level);
                    result.add(level);
                }
                queue.add(dummy);
                isForward = !isForward;
                level = new ArrayList<>();
            }else{
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
                level.add(curr.val);
            }
            
            prev = curr;
        }
        return result;
    }
    private ArrayList<Integer> reverseArrayList(List<Integer> alist)
    {
        // Arraylist for storing reversed elements
        ArrayList<Integer> revArrayList = new ArrayList<Integer>();
        for (int i = alist.size() - 1; i >= 0; i--) {
 
            // Append the elements in reverse order
            revArrayList.add(alist.get(i));
        }
 
        // Return the reversed arraylist
        return revArrayList;
    }
}