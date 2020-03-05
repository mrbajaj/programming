/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

class Problem429{

    static class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    
    public static void main(String[] args) {
        Problem429 obj = new Problem429();
        
        List<Node> level1Children = new ArrayList<>();
        level1Children.add(new Node(100));
        level1Children.add(new Node(101));
        level1Children.add(new Node(102));

        Node root = new Node(10, level1Children);

        List<List<Integer>> result = obj.levelOrder(root);
        obj.printLevelOrder(result);
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Node dummy = new Node(0), prev = null;
        if(root == null){
            return ans;
        }

        List<Integer> levelList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(dummy);

        while(queue != null){

            Node curr = queue.remove();

            if(prev == curr){
                break;
            }
            
            if(curr == dummy){
                ans.add(levelList);
                levelList = new ArrayList<>();
                queue.add(dummy);
            }else{
                levelList.add(curr.val);
            }

            if(curr.children != null){
                List<Node> childrens = curr.children;
                for(Node child: childrens){
                    queue.add(child);
                }
            }
            

            prev = curr;
        }
        
        return ans;
    }

    public void printLevelOrder(List<List<Integer>> result){

        for(List<Integer> list : result) {
            System.out.println(list);
        }

    }
}