/**
 * URL: 
 * 
 */

 import java.util.ArrayList;
 import java.util.List;

 import java.util.Set;
 import java.util.HashSet;

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
}


class Problem199 {
    public static void main(String[] args) {
        Problem199 obj = new Problem199();
        Solution1 sol = new Solution1();

        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(3);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.rightSideView(p) + "\n");

        p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(5);
        p.left.left = new TreeNode(3);
        p.left.right = new TreeNode(4);
        p.right.left = new TreeNode(6);
        p.right.right = new TreeNode(7);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + sol.rightSideView(p) + "\n");
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
    // Iterative
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode dummy = new TreeNode(0);
        if(root == null){
            return ans;
        }
        List<Integer> level = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        TreeNode prev = null;
        queue1.add(root);
        queue1.add(dummy);
        while(!queue1.isEmpty()){
            TreeNode curr = queue1.remove();

            if(curr == dummy){
                if(prev == dummy){
                    break;
                }
                System.out.println("level: " + level);
                ans.add(level.get(level.size() -1 ));
                queue1.add(dummy);
            }else{
                level.add(curr.val);
            }
            
            if(curr.left != null){
                queue1.add(curr.left);
            }
            if(curr.right !=  null){
                queue1.add(curr.right);
            }
            prev = curr;
        }
        return ans;
    }
}