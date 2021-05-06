/**
 * URL: 
 * Tags: Tree
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

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

class Problem109 {

    public static void main(String[] args) {
        Problem109 obj = new Problem109();
        Solution sol = new Solution();

        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode root = sol.sortedListToBST(head);
        obj.printTree(root);
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

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode end = head;
        return helper(head, null);

    }

    private TreeNode helper(ListNode start, ListNode end){
        ListNode slow = start, fast = start;
        if(start == end){
            return null;
        }
        while(fast != end && fast.next != end){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode node = new TreeNode(slow.val);

        node.left = helper(start, slow);
        node.right = helper(slow.next, end);
        return node;
    }
}