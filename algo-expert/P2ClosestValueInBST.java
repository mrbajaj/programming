import java.util.Scanner;

public class P2ClosestValueInBST{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        sc.close();
    }
}

class Node{
    Node left;
    Integer val;
    Node right;

    Node(){
        this.left = this.right = this.val = null;
    }
}

class BST {
    Node root;

    void insertIntoBST(Node node){
        root = insertRecursive(root, node);
    }

    Node insertRecursive(Node root, Node node){
        if(root.val == node.val){
            node.right = root.right;
            root.right = node;
            return root;
        }
        if(root.val < node.val){
                
        }

        return root;
    }
}