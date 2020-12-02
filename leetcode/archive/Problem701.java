/**
 * URL: 
 * 
 */

class Problem701 {

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
        Problem701 obj = new Problem701();

        TreeNode p = new TreeNode(20);
        p.left = new TreeNode(10);
        p.right = new TreeNode(30);

        obj.printTree(p); System.out.println("\nAfter Insert 35:");
        p = obj.insertIntoBST(p, 35);
        obj.printTree(p); System.out.println();

        obj.printTree(p); System.out.println("\nAfter Insert 25:");
        p = obj.insertIntoBST(p, 25);
        obj.printTree(p); System.out.println();

        obj.printTree(p); System.out.println("\nAfter Insert 5:");
        p = obj.insertIntoBST(p, 5);
        obj.printTree(p); System.out.println();


        obj.printTree(p); System.out.println("\nAfter Insert 7:");
        p = obj.insertIntoBST(p, 7);
        obj.printTree(p); System.out.println();


        obj.printTree(p); System.out.println("\nAfter Insert 32:");
        p = obj.insertIntoBST(p, 32);
        obj.printTree(p); System.out.println();
        

        
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }

        if(root.val > val){
            root.left = insertIntoBST(root.left, val);
        }else if(root.val <= val){
            root.right = insertIntoBST(root.right, val);
        }


        return root;
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