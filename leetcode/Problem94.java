import java.util.ArrayList;
import java.util.List;

class Problem94 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Problem94 obj = new Problem94();

        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(3);

        System.out.println("Ans: " + obj.inorderTraversal(p));

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);

        System.out.println("Ans: " + obj.inorderTraversal(p));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        inorderTraversalRecursive(root, list);

        return list;
        
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root,  List<Integer> list){
        if(root == null){
            return list;
        }

        inorderTraversalRecursive(root.left, list);
        list.add(root.val);
        inorderTraversalRecursive(root.right, list);

        return list;
    }

}