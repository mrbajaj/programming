/**
 * URL: 
 * 
 */
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

class Problem236 {

    public static void main(String[] args) {
        Problem236 obj = new Problem236();
        Solution sol = new Solution();

        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(20);
        TreeNode p = new TreeNode(5);
        p.left = a;
        p.right = b;
        obj.printTree(p); System.out.println();
        System.out.println("Ans : " + sol.lowestCommonAncestor(p, a, b) + "\n");

        a = new TreeNode(10);
        b = new TreeNode(20);
        p = a;
        p.left = b;
        p.right = new TreeNode(9);  
        obj.printTree(p); System.out.println();
        System.out.println("Ans : " + sol.lowestCommonAncestor(p, a, b) + "\n");

        a = new TreeNode(10);
        b = new TreeNode(20);
        p = a;
        p.left = new TreeNode(9);
        p.right = b;
        obj.printTree(p); System.out.println();
        System.out.println("Ans : " + sol.lowestCommonAncestor(p, a, b) + "\n");

        a = new TreeNode(10);
        b = new TreeNode(20);
        p = new TreeNode(4);  
        p.left = new TreeNode(7);
        p.right = new TreeNode(9);  
        p.left.left = a;
        p.left.right = new TreeNode(8);  
        p.right.right = b;
        obj.printTree(p); System.out.println();
        System.out.println("Ans : " + sol.lowestCommonAncestor(p, a, b) + "\n");
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root  == null){
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
