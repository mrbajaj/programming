/**
 * URL: 
 * 
 */
import java.util.List;
import java.util.ArrayList;

class Problem1038 {

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
        Problem1038 obj = new Problem1038();

        TreeNode p = new TreeNode(4);  
        p.left = new TreeNode(1);
        p.right = new TreeNode(6);
        p.left.left = new TreeNode(0);
        p.left.right = new TreeNode(2);  
        p.left.right.right = new TreeNode(3);
        p.right.left = new TreeNode(5);
        p.right.right = new TreeNode(7);
        p.right.right.right = new TreeNode(8);
        

        obj.printTree(p); System.out.println();
        TreeNode gst = obj.bstToGst(p);
        obj.printTree(gst); System.out.println();
    }

    public TreeNode bstToGst(TreeNode root) {
        List<Integer> gstValues = new ArrayList<Integer>();
        this.reverseInorder(root, gstValues);
        System.out.println(gstValues);
        TreeNode clone = clone(root);
        copy(clone,gstValues);
        return clone;
    }
    public void reverseInorder(TreeNode root, List<Integer> gstValues){
        if(root == null){
            return;
        }
        reverseInorder(root.right, gstValues);
        Integer prev = (gstValues.size() == 0) ? 0: gstValues.get(gstValues.size() - 1);
        gstValues.add(root.val + prev);
        reverseInorder(root.left, gstValues);
    }
    public TreeNode clone(TreeNode root){
        if(root== null){
            return null;
        }
        TreeNode newNode = new TreeNode(0);
        newNode.left = clone(root.left);
        newNode.right = clone(root.right);

        return newNode;
    }

    public void copy(TreeNode clone,List<Integer> gstValues){
        if(clone == null){
            return;
        }
        copy(clone.right, gstValues);
        clone.val = gstValues.get(0);
        gstValues.remove(0);
        copy(clone.left, gstValues);
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