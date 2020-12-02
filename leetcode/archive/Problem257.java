/**
 * URL: 
 * 
 */
import java.util.List;
import java.util.ArrayList;

class Problem257 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
        public String toString(){
            return this.val + " ";
        }
    }

    public static void main(String[] args) {
        Problem257 obj = new Problem257();

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.left.right = new TreeNode(5);
        p.right = new TreeNode(3);
        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.binaryTreePaths(p) + "\n");

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);
        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.binaryTreePaths(p) + "\n");
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        List<String> currPath = new ArrayList<>();
        this.preorder(root, paths, currPath);

        return paths;
    }

    public void preorder(TreeNode root, List<String> paths, List<String> currPath){
        if(root == null){
            return;
        }

        currPath.add(String.valueOf(root.val));
        if(root.left == null && root.right == null){
            // System.out.println("root: " + root + "currPath: " + currPath);
            paths.add( String.join("->", currPath) );
            currPath.remove( currPath.size() - 1 );
            return;
        }

        preorder(root.left, paths, currPath);
        preorder(root.right, paths, currPath);

        currPath.remove( currPath.size() - 1 );
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