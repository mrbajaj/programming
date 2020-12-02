import java.util.Queue;
import java.util.LinkedList;

/**
 * URL: https://leetcode.com/problems/deepest-leaves-sum/
 * 
 */

class Problem1302 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Problem1302 obj = new Problem1302();

        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(3);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.deepestLeavesSum(p) + "\n");

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.deepestLeavesSum(p) + "\n");

        p = new TreeNode(1);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(3);  
        p.left.left = new TreeNode(4);  
        p.left.right = new TreeNode(5);  
        p.right.right = new TreeNode(6);
        p.left.left.left = new TreeNode(7);  
        p.right.right.right = new TreeNode(8);

        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.deepestLeavesSum(p) + "\n");
    }


    public int deepestLeavesSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        int tmp = 0 , sum = 0;
        TreeNode dummy = new TreeNode(-1), prev = null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);
        queue.add(dummy);
    
        while(!queue.isEmpty()){

            TreeNode curr = queue.remove();

            if(prev != null && prev == curr && prev == dummy){
                // System.out.println("Breaking");
                break;
            }
            sum = tmp;
            if(curr == dummy){
                tmp = 0;
                queue.add(dummy);
                // System.out.println("\t*** " + curr.val);
            }else{
                tmp += curr.val;
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
                // System.out.println("### " + curr.val);
            }
            
            prev = curr;
        }

        return sum;
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