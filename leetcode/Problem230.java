import java.util.ArrayList;
import java.util.List;

/**
 * URL: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 * 
 */
class Problem230{

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        Problem230 obj = new Problem230();

        TreeNode root = null;
        System.out.println("Ans: " + obj.kthSmallest(root, 1));

        root = new TreeNode(1);
        System.out.println("Ans: " + obj.kthSmallest(root, 1));
        
        root = new TreeNode(10);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.right.right = new TreeNode(20);
        System.out.println("Ans: " + obj.kthSmallest(root, 2));

    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        kthSmallestUtil(root, list);
        
        if(k <= list.size()){
            return list.get(k-1);
        }else{
            return 0;
        }

    }

    public void kthSmallestUtil(TreeNode root, List<Integer> list){

        if(root == null){
            return;
        }

        kthSmallestUtil(root.left, list);
        list.add(root.val);
        kthSmallestUtil(root.right, list);
    }
}