/**
 * URL: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 */

class Problem105{

    static int pindex = 0;
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; left = null; right = null;}
    }

    public static void main(String[] args) {
        Problem105 obj = new Problem105();

        int[] preorder  = new int[]{3, 9, 20, 15, 7};
        int[] inorder   = new int[]{9, 3, 15, 20, 7};
        TreeNode root = obj.buildTree(preorder, inorder);
        obj.printTree(root); System.out.println();
        
        int[] preorder2  = new int[]{1, 2};
        int[] inorder2   = new int[]{1, 2};
        TreeNode root2 = obj.buildTree(preorder2, inorder2);
        obj.printTree(root2); System.out.println();

        int[] preorder3  = new int[]{3,1,2,4};
        int[] inorder3  = new int[]{1,2,3,4};
        TreeNode root3 = obj.buildTree(preorder3, inorder3);
        obj.printTree(root3); System.out.println();
        
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length == 0){
            return null;
        }
        if(preorder.length == 1){
            return new TreeNode(preorder[0]);
        }
        if(preorder.length != inorder.length){
            return null;
        }
        pindex = 0;
        return this.buildTreeUtil(preorder, inorder,  0, inorder.length - 1 );
    }

    public TreeNode buildTreeUtil(int[] preorder, int[] inorder, int ilow, int ihigh ){
        if(ilow > ihigh || pindex >= preorder.length){
            return null;
        }else{
            System.out.print("ilow:" + ilow + "\tihigh:" + ihigh + "\tpindex:" + pindex);
        }

        Integer curr = preorder[pindex++];
        TreeNode root = new TreeNode(curr);

        System.out.println("\tcurr: " + curr);
        
        int inorderIndex = this.searchIndex(inorder, ilow, ihigh, curr);

        root.left = this.buildTreeUtil(preorder, inorder, ilow, inorderIndex - 1);
        root.right = this.buildTreeUtil(preorder, inorder, inorderIndex+1, ihigh);
        
        

        return root;
    }

    public int searchIndex(int[] inorder, int ilow, int ihigh, int curr ){
        for(int i = ilow;  i <= ihigh ; i++){
            if(curr == inorder[i]){
                return i;
            }
        }
        return -1;
    }

    public void printTree(TreeNode root){

        if(root == null){
            return;
        }

        printTree(root.left);

        System.out.print(root.val + " ");

        printTree(root.right);

    }
}