import java.util.List;
import java.util.ArrayList;

/**
 * URL: https://leetcode.com/problems/n-ary-tree-preorder-traversal/submissions/
 * 
 */

class Problem589{
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
        Problem589 obj = new Problem589();
        
        List<Node> firstChildChildren = new ArrayList<Node>();
        firstChildChildren.add(new Node(5));
        firstChildChildren.add(new Node(6));
        
        List<Node> rootChildren = new ArrayList<Node>();
        rootChildren.add(new Node(3, firstChildChildren));
        rootChildren.add(new Node(2));
        rootChildren.add(new Node(4));

        Node root = new Node(1, rootChildren);

        List<Integer> result = obj.preorder(root);
        System.out.println(result);
    }
    
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        preorderRecursive(root, result);
        return result;
    }
    
    public void preorderRecursive(Node root, List<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        if(root.children != null){
            for(Node child: root.children){
                preorderRecursive(child, result);    
            }
        }
        
    }
}