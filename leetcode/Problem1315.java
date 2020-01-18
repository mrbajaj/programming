/**
 * URL: https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 * 
 */

class Problem1315 {

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
        Problem1315 obj = new Problem1315();

        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(3);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.sumEvenGrandparent(p) + "\n");

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.sumEvenGrandparent(p) + "\n");


        // 6,  7,8,    2,7,1,3,    9,null,1,4,null,null,null,5

        p = new TreeNode(6);  
        p.left = new TreeNode(7);  
        p.right = new TreeNode(8);
        p.left.left = new TreeNode(2);  
        p.left.right = new TreeNode(7);
        p.right.left = new TreeNode(1);
        p.right.right = new TreeNode(3);
        p.left.left.left = new TreeNode(9);
        p.left.left.right = new TreeNode(2); 
        p.left.right.left = new TreeNode(1);
        p.left.right.right = new TreeNode(4);
        // p.right.left.left = new TreeNode(1);
        // p.right.left.right = new TreeNode(1);
        // p.right.right.left = new TreeNode(3);
        p.right.right.right = new TreeNode(5);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.sumEvenGrandparent(p) + "\n");
    }


    public int sumEvenGrandparent(TreeNode root){
        if(root == null){
            return 0;
        }
        
        return this.sumEvenGrandparent_Util(root, null, null);
    }

    public int sumEvenGrandparent_Util(TreeNode root, TreeNode parent, TreeNode grandParent){
        if(root == null){
            return 0;
        }

        int currsum = (grandParent != null && (grandParent.val % 2 ) == 0) ? root.val : 0;
        

        return currsum + sumEvenGrandparent_Util(root.left, root, parent) + sumEvenGrandparent_Util(root.right, root, parent); 
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