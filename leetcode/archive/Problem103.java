import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Collections;


/**
 * URL: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 */
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}

public class Problem103{
    
    public static void main(String[] args) {
        Solution1 sol1 = new Solution1();
        Solution2 sol2 = new Solution2();

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(4);
        p.right.left = new TreeNode(3);

        System.out.println("Ans: " + sol1.zigzagLevelOrder(p));
        System.out.println("Ans: " + sol2.zigzagLevelOrder(p) + "\n\n\n");


        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);

        System.out.println("Ans: " + sol1.zigzagLevelOrder(p));
        System.out.println("Ans: " + sol2.zigzagLevelOrder(p) + "\n\n\n");
        

    }

}
class Solution1{
    // using Stack
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> allList = new ArrayList<List<Integer>>();
        if(root == null){
            return allList;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);
        boolean isForward = true;
        while(!s1.isEmpty()){
            List<Integer> currList = new ArrayList<>();
            if(isForward == true){
                this.copyStack(s1,s2);
                this.printAndCopyStack(s2,s1, currList);
            }else{
                this.printAndCopyStack(s1, s2, currList);
                this.copyStack(s2,s1);
            }
            while(!s1.isEmpty()){
                TreeNode node = s1.pop();
                if(node.right != null){
                    s2.push(node.right);
                }
                if(node.left != null){
                    s2.push(node.left);
                }
            }
            allList.add(currList);
            this.copyStack(s2, s1);
            isForward = !isForward;
        }

        return allList;
    }

    private void copyStack(Stack<TreeNode> source, Stack<TreeNode> dest){
        while(!source.isEmpty()){
            dest.push(source.pop());
        }
    }

    private void printAndCopyStack(Stack<TreeNode> source, Stack<TreeNode> dest, List<Integer> currList){
        while(!source.isEmpty()){
            TreeNode node = source.pop();
            currList.add(node.val);
            dest.push(node);
        }
    }
    
}
class Solution2{
    // using Queue
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> allList = new ArrayList<List<Integer>>();
        TreeNode dummy = new TreeNode(0), prev = null;
        if(root == null){
            return allList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(dummy);
        boolean forward = false;
        List<Integer> currList = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();
            if(prev == curr){
                break;
            }

            if(curr == dummy){
                if(forward == true) { Collections.reverse(currList); } ;              
                allList.add(currList);
                queue.add(dummy);
                currList = new ArrayList<>();
                forward = !forward;
                prev = curr;
                continue;
            }
            
            if(curr.left != null){
                queue.add(curr.left);
            }

            if(curr.right != null){
                queue.add(curr.right);
            }

            currList.add(curr.val);
            prev = curr;
        }

        return allList;
    }
}