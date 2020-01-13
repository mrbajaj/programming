import java.util.ArrayList;
import java.util.List;

/**
 * URL: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 * 
 */
class Problem230{

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    }
    public static void main(String[] args) {
        Problem230 obj = new Problem230();

        TreeNode root = null;
        System.out.println("Ans: " + obj.kthSmallest(root, 1));
        System.out.println("Opt   Ans: " + obj.kthSmallest_Optimized(root, 1));

        root = new TreeNode(1);
        System.out.println("Ans: " + obj.kthSmallest(root, 1));
        System.out.println("Opt   Ans: " + obj.kthSmallest_Optimized(root, 1));
        
        root = new TreeNode(10);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.right.right = new TreeNode(20);
        System.out.println("Basic Ans: " + obj.kthSmallest(root, 4));
        System.out.println("Opt   Ans: " + obj.kthSmallest_Optimized(root, 4));

    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        kthSmallestUtil(root, list);
        
        if(k <= list.size()){
            return list.get(k-1);
        }else{
            return 0;
        }

    }

    public void kthSmallestUtil(TreeNode root, List<Integer> list){

        if(root == null){
            return;
        }

        kthSmallestUtil(root.left, list);
        list.add(root.val);
        kthSmallestUtil(root.right, list);
    }

    public int kthSmallest_Optimized(TreeNode root, int k) {
        int c = 0;
        if (root == null) 
            return 0 ; 
  
  
        java.util.Stack<TreeNode> s = new java.util.Stack<TreeNode>(); 
        TreeNode curr = root; 
  
        while (curr != null || s.size() > 0) 
        { 
            

            // go to extreme left from curr node
            while (curr !=  null) 
            { 
                s.push(curr); 
                curr = curr.left; 
            }

            // pop out the top node from stack
            curr = s.pop(); 
  
            //process the node
            c++;
            if(c == k){
                return curr.val;
            }
  
            // jump one step right
            curr = curr.right; 

        }

        return 0;
    }   

    
    

}