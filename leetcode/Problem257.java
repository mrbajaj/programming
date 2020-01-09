import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Problem257 {

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
        Problem257 obj = new Problem257();
        TreeNode root = null;

        System.out.println( obj.binaryTreePaths(root) );

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println( obj.binaryTreePaths(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        System.out.println( obj.binaryTreePaths(root));

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        this.binaryTreePathsRecursive(root, list, stack);

        List<String> listFormeted = new ArrayList<>();
        for(String l: list){
            String x = l.replace(", ", "->");
            x = x.replace("[", "");
            x = x.replace("]", "");
            listFormeted.add(x);
        }
        

        return listFormeted;
        // return new ArrayList<>();
        
    }

    public void binaryTreePathsRecursive(TreeNode root, List<String> list, Stack<Integer> stack){
        if(root == null){
            return;
        }
        stack.push(root.val);
        binaryTreePathsRecursive(root.left, list, stack);

        if(root.left == null && root.right == null){
            // leaf node
            list.add(stack.toString());
        }

        binaryTreePathsRecursive(root.right, list, stack);

        stack.pop();

    }

    public String getPath(Stack<Integer> stack){
        // Stack<Integer> tmp = stack;
        String s = stack.toString();
        
        System.out.println(s);
        
        return s;

    }
    
}