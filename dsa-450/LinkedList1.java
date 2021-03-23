/**
 * URL: 
 * Tags: LinkedList
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class LinkedList1{
    public static void main(String[] args) {
        LinkedList1 obj = new LinkedList1();
        Solution sol = new Solution();

        ListNode a = new ListNode(3);
        a.next = new ListNode(7);
        a.next.next = new ListNode(8);
        a.next.next.next = new ListNode(10);

        System.out.print("Given:\t"); obj.printList(a);
        
        ListNode ans = sol.reverseRecursive(a);
        System.out.print("Answer:\t"); obj.printList( ans );
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
    public ListNode reverseRecursive(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode rest = reverseRecursive(head.next);
        
        head.next.next = head;
        head.next = null;
        
        return rest;
    }

    public ListNode reverseIterative(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null, curr = head, next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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