/**
 * URL: 
 * Tags: Tree, Backtracking
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */
import java.util.List;
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

class Problem113 {

    public static void main(String[] args) {
        Problem113 obj = new Problem113();
        Solution sol = new Solution();

        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(3);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.pathSum(p, 3) + "\n");

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.pathSum(p, 9) + "\n");
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
  
    List<List<Integer>> output;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        output = new ArrayList<>();
        backtrack(root, targetSum, 0, new ArrayList<Integer>());
        
        return output;
    }
    
    private void backtrack(TreeNode root, int targetSum, int currSum, List<Integer> currPath){
       if(root == null){
            return;
        }
        currSum += root.val;
        currPath.add(root.val);
        if(root.left == null && root.right == null && currSum == targetSum){
            output.add(currPath);
            return;
        }
        backtrack(root.left, targetSum, currSum, new ArrayList<>(currPath));
        backtrack(root.right, targetSum, currSum, new ArrayList<>(currPath));
        currSum -= root.val;
        currPath.remove(currPath.size() -1);
    } 
}