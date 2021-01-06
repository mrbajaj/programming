/**
 * URL: https://leetcode.com/problems/reverse-linked-list/
 * Tags: LinkedList
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class Problem206 {
    public static void main(String[] args) {
        Problem206 obj = new Problem206();
        Solution sol = new Solution();

        ListNode a = new ListNode(3);
        a.next = new ListNode(7);
        a.next.next = new ListNode(8);
        a.next.next.next = new ListNode(10);

        System.out.print("Original:\t"); obj.printList(a);
        System.out.print("\nReversed:\t"); obj.printList( sol.reverseList(a));
        System.out.print("\n\n"); 
        
        ListNode b = new ListNode(99);
        b.next = new ListNode(1);
        b.next.next = new ListNode(4);

        System.out.print("Original:\t"); obj.printList(b);
        System.out.print("\nReversed:\t"); obj.printList( sol.reverseList(b));
        System.out.print("\n\n"); 
        
    }

    public void printList(ListNode head){
        ListNode itr = head;
        while(itr!=null){
            System.out.print(itr +" ");
            itr = itr.next;
        }
        System.out.println();
    }

    public int lengthOfList(ListNode head){
        int length = 0;
        ListNode itr = head;
        while(itr!=null){
            length++;
            itr = itr.next;
        }
        return length;
        
    }

}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode p = null, q = head, r;

        while(q != null){
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }

        return p;
    }
}

class ListNode{
    Integer val;
    ListNode next;
    ListNode(int v){
        this.val = v;
        this.next = null;
    }
    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}