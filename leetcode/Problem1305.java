/**
 * URL: 
 * 
 */

 import java.util.List;
 import java.util.ArrayList;
 import java.util.Collections;

class Problem1305 {

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
        Problem1305 obj = new Problem1305();

        TreeNode p = new TreeNode(10);
        p.left = new TreeNode(5);
        p.right = new TreeNode(15);
        p.left.left = new TreeNode(2);
        p.left.right = new TreeNode(8);

        obj.printTree(p); System.out.println();

        TreeNode q = new TreeNode(11);  
        q.left = new TreeNode(4);  
        q.right = new TreeNode(20);  
        q.left.left = new TreeNode(1);  
        q.left.right = new TreeNode(8);  
        q.right.right = new TreeNode(25);

        obj.printTree(q); System.out.println();

        System.out.println("Ans: " + obj.getAllElements_bruteforce(p,q) + "\n");
        System.out.println("Ans: " + obj.getAllElements_mergesort(p,q) + "\n");
    }

    public List<Integer> getAllElements_bruteforce(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();


        this.addToList(root1, ans);
        this.addToList(root2, ans);

        Collections.sort(ans);

        return ans;
    }

    public List<Integer> getAllElements_mergesort(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();


        this.addToList(root1, list1);
        this.addToList(root2, list2);

        return this.merge(list1, list2);

    }

    public List<Integer> merge(List<Integer> list1, List<Integer> list2){
        List<Integer> ans = new ArrayList<>();
        int i = 0, j =0, k = 0;
        for(; i < list1.size() && j < list2.size() && k < list1.size() + list2.size(); k++){

            if(list1.get(i) < list2.get(j)){
                ans.add( list1.get(i) );
                i++;
            }else{
                ans.add( list2.get(j) );
                j++;
            }
        }

        while(j < list2.size()){
            ans.add( list2.get(j) );
            j++;
            k++;
        }
        while(i < list1.size()){
            ans.add( list1.get(i) );
            i++;
            k++;
        }

        return ans;
    }

    public void addToList(TreeNode root, List<Integer> ans){
        if(root == null){
            return;
        }
        addToList(root.left, ans);
        ans.add(root.val);
        addToList(root.right, ans);
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