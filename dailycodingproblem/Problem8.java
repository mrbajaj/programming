/**
 * Good morning! Here's your coding interview problem for today.
 * This problem was asked by Google.
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 * Given the root to a binary tree, count the number of unival subtrees.
 * For example, the following tree has 5 unival subtrees:
 *   0
 *  / \
 * 1   0
 *    / \
 *   1   0
 *  / \
 * 1   1
 * 
 * Explaination: Four leaf nodes + 1(1,1) = Total 5 Unival
 */
class Problem8{

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            this.left= this.right = null;
        }
    }
    public static void main(String[] args) {
        Problem8 obj = new Problem8();

        TreeNode p = new TreeNode(0);  
        p.left = new TreeNode(1);  
        p.right = new TreeNode(0);  
        p.right.left = new TreeNode(1);  
        p.right.right = new TreeNode(0);
        p.right.left.left = new TreeNode(1);
        p.right.left.right = new TreeNode(1);

        System.out.println("Ans: " + obj.univalSubtreesCount(p));

    }


    public int univalSubtreesCount(TreeNode p){
        if(p == null ){
            return 0;
        }
        int count = 0;
        if(p.left != null && p.right != null && p.left.val == p.right.val){
            // left and right with same value
            count += 1;
        }else if(p.left == p.right){
            // leaf nodes
            count += 1;
        }

        return count + univalSubtreesCount(p.left) + univalSubtreesCount(p.right);
    }
}
