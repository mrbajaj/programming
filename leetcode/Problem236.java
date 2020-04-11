/**
 * URL: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 
 * 
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
class Problem236{

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode p1 = new TreeNode(5);
        TreeNode p2 = new TreeNode(1);
        TreeNode p3 = new TreeNode(4);
        TreeNode p4 = new TreeNode(10);

        TreeNode root = new TreeNode(3);
        root.left = p1;
        root.right = p2;
        
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = p3;
        
        System.out.println("Ans: " + sol.lowestCommonAncestor(root, p1, p2) );
        System.out.println("Ans: " + sol.lowestCommonAncestor(root, p1, p3) );
        System.out.println("Ans: " + sol.lowestCommonAncestor(root, p1, p4) );
        
    }
}

class Solution{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }

        if(left != null){
            return left;
        }

        if(right != null){
            return right;
        }

        return null;
    }
}