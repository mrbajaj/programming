/**
 * URL: 
 * Tags: Tree
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

import java.util.List;
import java.util.ArrayList;

class Node {
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

class Problem589 {

    public static void main(String[] args) {
        Problem589 obj = new Problem589();
        Solution sol = new Solution();

        Node root = new Node(1);
        List<Node> children = new ArrayList<>();
        Node level1_1  = new Node(2); children.add(level1_1);
        Node level1_2 = new Node(3); children.add(level1_2);
        Node level1_3 = new Node(4); children.add(level1_3);
        root.children = children;

        
        System.out.println("Ans: " + sol.preorder(root) + "\n");
    }

}

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        preorderRec(root, ans);
        return ans;
    }
    private void preorderRec(Node root, List<Integer> ans){
        if(root == null){
            return;
        }
        ans.add(root.val);
        if(root.children == null){
            return;
        }
        for(Node c: root.children){
            preorderRec(c, ans);
        }
    }
}