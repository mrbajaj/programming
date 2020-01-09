import java.util.LinkedList;
import java.util.Queue;

class Problem958 {

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

        Problem958 obj = new Problem958();
        TreeNode root = null;

        System.out.println("Expected: true ::: Ans: " + obj.isCompleteTree(root) +"\n");

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Expected: true ::: Ans: " + obj.isCompleteTree(root));


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        System.out.println("Expected: true ::: Ans: " + obj.isCompleteTree(root));



        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println("Expected: false ::: Ans: " + obj.isCompleteTree(root));
        
    }

    public boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return true;
        }

        TreeNode prev = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            System.out.println(queue.toString());
            TreeNode tmp = queue.remove();

            if(tmp == null){
                prev = tmp;
                continue;
            }

            if(prev == null && tmp != null){
                return false;
            }

            
            queue.add(tmp.left);
            queue.add(tmp.right);
            prev = tmp;
        }

        return true;
        
    }
}