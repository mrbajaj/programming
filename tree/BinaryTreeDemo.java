import javax.print.attribute.standard.PrinterInfo;

/**
 * 
 * @author Mayur Bajaj
 */
public class BinaryTreeDemo{
    public static void main(String[] args) {
        MyCompleteBinaryTree cbt = new MyCompleteBinaryTree();
        int[] arr = new int[]{4,2,5,1,3,6};

        cbt.createTree(arr);

        cbt.printInorder();
        cbt.printPreorder();
        cbt.printPostorder();
    }
}


/**
 * 
 * @author Mayur Bajaj
 */
class MyCompleteBinaryTree{
    Node root;

    static class Node{
        Node left;
        Integer val;
        Node right;
    
        Node(Integer val){
            this.val = val;
            left = right = null;
        }
    
    }
    
    /**
     * 
     * @param arr
     */
    public void createTree(int[] arr){
        root = insertLevelOrder(arr, root, 0);
    }

    /**
     * Create tree for given array in level order insertion into the tree for given array
     * @param arr
     */
    public Node insertLevelOrder(int[] arr, Node root, int i){
        if(i < arr.length){
            root = new Node(arr[i]);
  
            root.left = insertLevelOrder(arr, root.left, 2 * i + 1); 
  
            // insert right child 
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2); 

        }
        return root;
    }

    /**
     * 
     */
    public void printInorder(){
        System.out.print("Inorder: "); 
        inorderTraversal(root); 
        System.out.println();
    }

    /**
     * 
     * @param root
     */
    public void inorderTraversal(Node root){
        if(root != null){
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }


    public void printPreorder(){
        System.out.print("Preorder: "); 
        preorderTraversal(root); 
        System.out.println();
    }
    /**
     * 
     */
    public void preorderTraversal(Node root){
        if(root != null){
            System.out.print(root.val + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }


    public void printPostorder(){
        System.out.print("Postorder: "); 
        postorderTraversal(root); 
        System.out.println();
    }
    /**
     * 
     */
    public void postorderTraversal(Node root){
        if(root != null){
            System.out.print(root.val + " ");
            postorderTraversal(root.left);
            postorderTraversal(root.right);
        }
    }
}