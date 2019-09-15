import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeDemo{

    public static void main(String[] args) {
        MyBinarySearchTree bst = new MyBinarySearchTree();

        bst.insert(10); 
        bst.insert(5); 
        bst.insert(15); 
        bst.insert(8); 
        bst.insert(7); 
        bst.insert(3);
        
        bst.inorder(); System.out.println();
        bst.levelOrder(); System.out.println();
    }
}



class MyBinarySearchTree{
    private Node root;

    static class Node{
        Node left;
        Integer val;
        Node right;
    
        Node(Integer val){
            this.val = val;
            left = right = null;
        }
    
    }

    public MyBinarySearchTree(){
        this.root = null;
    }

    /**
     * insert given item into the bst
     * @param item
     * @return
     */
    public void insert(Integer item){
        this.root = insertRec(this.root, item);
    }

    /**
     * Recursive insert
     * @param root
     * @param item
     * @return
     */
    public Node insertRec(Node node, Integer item){
        if(node == null){
            return new Node(item);
        }

        if(node.val < item){
            node.right = insertRec(node.right, item);
        }else{
            node.left = insertRec(node.left, item);
        }

        return node;
    }

    /**
     * Inorder traversal of the tree with given root
     */
    public void inorder(){
        inorderRec(this.root);
    }
    
    /**
     * Recursive Inorder traversal of the tree
     * @param root
     */
    public void inorderRec(Node node){
        if(node != null){
            inorderRec(node.left);
            System.out.print(node.val + " ");
            inorderRec(node.right);
        }
    }

    /**
     * 
     */
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();

        if(this.root == null){
            return;
        }
        q.add(root);
        Node curr = null;
        while(q.isEmpty() == false){
            curr = q.remove();
            System.out.print(curr.val + " ");
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }

    }
}   