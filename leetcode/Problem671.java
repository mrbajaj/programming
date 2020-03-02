import java.util.PriorityQueue;
import java.util.Stack;

/**
 * URL: 
 * 
 */

class Problem671 {

    public static class TreeNode {
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
            return this.val + " ";
        }
    }

    public static void main(String[] args) {
        Problem671 obj = new Problem671();

        TreeNode p = new TreeNode(2);
        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.findSecondMinimumValue(p) + "\n");

        p = new TreeNode(2);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(2);
        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.findSecondMinimumValue(p) + "\n");

        p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(3);
        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.findSecondMinimumValue(p) + "\n");

        p = new TreeNode(4);  
        p.left = new TreeNode(2);  
        p.right = new TreeNode(9);  
        p.left.left = new TreeNode(3);  
        p.left.right = new TreeNode(8);  
        p.right.right = new TreeNode(7);
        obj.printTree(p); System.out.println();
        System.out.println("Ans: " + obj.findSecondMinimumValue(p) + "\n");
    }

    public int findSecondMinimumValue(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return -1;
        }
        int min = root.val, smin = -1;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()){
            
            TreeNode curr = stack.pop();
            System.out.println(curr + "::\t Min:" + min + ":: smin:" + smin);
            if( curr.val != min ){
                if( smin == -1) smin = curr.val;
                else smin = curr.val < smin ? curr.val : smin;
            }
            
            if(curr.left != null){
                stack.add(curr.left);    
            }
            if(curr.right != null){
                stack.add(curr.right);
            }
            
        }

        return smin;

    }


    public int findSecondMinimumValue_WithHeap(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        this.buildHeap(root, pq);
        System.out.println(pq);
        Integer top = pq.poll(), curr;
        do{
            curr = pq.poll();
            
        }while(top == curr && !pq.isEmpty());
        return (top == curr) ? -1 : curr;
    }

    private void buildHeap(TreeNode root, PriorityQueue<Integer> pq){
        if(root == null){
            return;
        }

        pq.add(root.val);
        this.buildHeap(root.left, pq);
        this.buildHeap(root.right, pq);
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