/**
 * URL: 
 * 
 */
import java.util.List;
import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    public String toString() {
        return String.valueOf(this.val);
    }
}

class Problem114 {

    public static void main(String[] args) {
        Problem114 obj = new Problem114();
        Solution1 sol = new Solution1();

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        obj.printTree(p); System.out.println();
        sol.flatten(p);
        System.out.print("\nAns: \t"); obj.printRightTree(p); System.out.println();

        p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(5);
        p.left.left = new TreeNode(3);
        p.left.right = new TreeNode(4);
        p.right.left = new TreeNode(6);
        p.right.right = new TreeNode(7);

        obj.printTree(p); System.out.println();
        sol.flatten(p);
        System.out.print("\nAns: \t");  obj.printRightTree(p); System.out.println();
    }

    public void printTree(TreeNode root) {
        
        if(root == null){
            return;
        }
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
        
    }
    public void printRightTree(TreeNode root) {
        
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.right);
        
    }

}

class Solution1 {
    // recursive without extra space
    void flatten(TreeNode root) { 
        // base condition- return if root is NULL or if it is a leaf node 
        if (root == null || root.left == null && root.right == null) { 
            return; 
        } 
    
        // if root->left exists then we have to make it root->right 
        if (root.left != null) { 
    
            // move left recursively 
            flatten(root.left); 
        
            // store the node root->right 
            TreeNode tmpRight = root.right; 
            root.right = root.left; 
            root.left = null; 
    
            // find the position to insert  the stored value    
            TreeNode t = root.right; 
            while (t.right != null) { 
                t = t.right; 
            } 
    
            // insert the stored value 
            t.right = tmpRight; 
        } 
  
        // now call the same function 
        // for root->right 
        flatten(root.right); 
    } 
    
}

class Solution2 {

    // recursive and list
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode flattenHead = null;
        TreeNode flattenright = null;
        List<Integer> list = new ArrayList<>();
        this.inorder(root, list);

        for(Integer ele : list){
            if(flattenHead == null){
                flattenHead = new TreeNode(ele);
                flattenright = flattenHead;
            }else{
                flattenright.right = new TreeNode(ele);
                flattenright = flattenright.right;
            }
        }
        root.val = flattenHead.val;
        root.left = null;
        root.right = flattenHead.right;
    
    }
    private void inorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        inorder(root.left, list);
        inorder(root.right, list);
    }
}

