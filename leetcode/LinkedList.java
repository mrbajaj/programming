/**
 * URL: 
 * Tags: LinkedList
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class LinkedList{
    public static void main(String[] args) {
        LinkedList obj = new LinkedList();
        Solution sol = new Solution();

        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        a.next.next.next.next.next = new ListNode(6);

        System.out.print("Given:\t"); obj.printList(a);
        
        ListNode ans = sol.func(a);
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
    public ListNode func(ListNode head) {
        return head;
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