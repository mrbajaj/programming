/**
 * URL: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 
 * 
 */
class Problem236{
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    }
    public static void main(String[] args) {
        Problem236 obj = new Problem236();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        
        System.out.println("Ans: " + obj.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)));
        System.out.println("Ans: " + obj.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4)));
        System.out.println("Ans: " + obj.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(10)));
        
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root.val == p.val){
            return p;
        }

        if(root.val == q.val){
            return q;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            // found the lca
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