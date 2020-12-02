import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Problem897 {

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            
            return val + " ";
        }
    }

    public static void main(String[] args) {

        Problem897 obj = new Problem897();
        TreeNode root = null;
        TreeNode ans = null;

        ans = obj.increasingBST(root);
        obj.printRightNodes(ans);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ans = obj.increasingBST(root);
        obj.printRightNodes(ans);


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        ans = obj.increasingBST(root);
        obj.printRightNodes(ans);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        ans = obj.increasingBST(root);
        obj.printRightNodes(ans);
        
    }

    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }

        List<Integer> inorderList = new ArrayList<>();

        this.getInorder(root, inorderList);
        TreeNode newTree = new TreeNode(inorderList.get(0));
        TreeNode itr = newTree;
        for(int i = 1; i< inorderList.size(); i++){
            itr.right = new TreeNode(inorderList.get(i));
            itr = itr.right;
        }
        return newTree;
        
    }

    public void getInorder(TreeNode root, List<Integer> inorderList) {

        if(root == null){
            return;
        }
        getInorder(root.left, inorderList);
        inorderList.add(root.val);
        getInorder(root.right, inorderList);
        
        
    }

    public void printRightNodes(TreeNode node){

        while(node != null){
            System.out.print(node);
            node = node.right;
        }

        System.out.println();

    }
}