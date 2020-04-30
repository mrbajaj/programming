/**
 * URL: 
 * 
 */
import java.util.ArrayList;
import java.util.List;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class PrintAllPaths {

    public static void main(String[] args) {
        PrintAllPaths obj = new PrintAllPaths();
        Solution sol = new Solution();

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        obj.printTree(p); System.out.println();
        sol.printPath(p);
        System.out.println( "\n-----------------------");

        p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        sol.printPath(p);
        System.out.println( "\n-----------------------");

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);
        sol.printPath(p);
        System.out.println( "\n-----------------------");

        p = new TreeNode(5);  
        p.left = new TreeNode(4);  
        p.right = new TreeNode(8);  
        p.left.left = new TreeNode(11);  
        p.right.left = new TreeNode(13);
        p.right.right = new TreeNode(4);
        p.left.left.left = new TreeNode(7);  
        p.left.left.right = new TreeNode(2);  
        p.right.right.right = new TreeNode(1);
        sol.printPath(p);
        System.out.println( "\n-----------------------");
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
    public void printPath(TreeNode root) {
        this.printHelper(root, new ArrayList<Integer>());
    }
    private void printHelper(TreeNode root, List<Integer> path){

        if(root == null){
            return;
        }

        path.add(root.val);

        if(root.left == null && root.right == null){
            System.out.println(path);
        }
        printHelper(root.left, path);
        printHelper(root.right, path);
        path.remove(path.size() -1 );

        

    }
}