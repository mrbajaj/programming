import java.util.List;
import java.util.ArrayList;

/**
 * URL: https://leetcode.com/problems/n-ary-tree-preorder-traversal/submissions/
 * 
 */

class Problem590{
    static class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
            children = null;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public static void main(String[] args) {
        Problem590 obj = new Problem590();
        
        List<Node> firstChildChildren = new ArrayList<Node>();
        firstChildChildren.add(new Node(5));
        firstChildChildren.add(new Node(6));
        
        List<Node> rootChildren = new ArrayList<Node>();
        rootChildren.add(new Node(3, firstChildChildren));
        rootChildren.add(new Node(2));
        rootChildren.add(new Node(4));

        Node root = new Node(1, rootChildren);

        List<Integer> result = obj.postorder(root);
        System.out.println(result);
    }
    
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        postorderRecursive(root, result);
        return result;
    }
    
    public void postorderRecursive(Node root, List<Integer> result){
        if(root == null){
            return;
        }
        
        if(root.children != null){
            for(Node child: root.children){
                postorderRecursive(child, result);    
            }
        }
        result.add(root.val);
    }
}