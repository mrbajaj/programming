/**
 * URL: 
 * 
 */

class Problem617{

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static void main(String[] args) {
        Problem617 obj = new Problem617();

        
        TreeNode p = new TreeNode(1);  
        p.left = new TreeNode(3);  
        p.right = new TreeNode(2);  
        p.left.left = new TreeNode(5);  
        
        TreeNode q = new TreeNode(2);
        q.left = new TreeNode(1);
        q.right = new TreeNode(3);
        q.left.right = new TreeNode(4);  
        q.right.right = new TreeNode(7);

        TreeNode merged = obj.mergeTrees(p, q);

        // obj.printTree(p); System.out.println();
        // obj.printTree(q); System.out.println();
        obj.printTree(merged); System.out.println();
        
    }

    public TreeNode mergeTrees(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return null;
        }

        TreeNode r;
        if(p != null && q != null){
            r = new TreeNode(p.val + q.val);
            System.out.println("pq" + p + " " + q + "\t" + r);
            r.left = mergeTrees(p.left, q.left);
            r.right = mergeTrees(p.right, q.right);

        }else if(p != null){
            r = new TreeNode(p.val);
            System.out.println("p" + p + "\t" + r);
            r.left = mergeTrees(p.left, q);
            r.right = mergeTrees(p.right, q);
            
        }else{
            r = new TreeNode(q.val);
            System.out.println("q" + q + "\t" + r);
            r.left = mergeTrees(p, q.left);
            r.right = mergeTrees(p, q.right);
        }
        
        return r;
        
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