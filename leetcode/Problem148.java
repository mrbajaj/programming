/**
 * URL: 
 * Tags: LinkedList
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class Problem148{
    public static void main(String[] args) {
        Problem148 obj = new Problem148();
        Solution sol = new Solution();

        ListNode a = new ListNode(6);
        a.next = new ListNode(2);
        a.next.next = new ListNode(5);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(3);
        // a.next.next.next.next.next = new ListNode(1);

        System.out.print("Given:\t"); obj.printList(a);
        ListNode ans = sol.sortList(a);
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
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;
    
        ListNode mid = middle(head);
        ListNode a = head;
        ListNode b = mid.next;
        mid.next = null;
    
        a = sortList(a);
        b = sortList(b);
    
        ListNode temp = mergeList(a, b);
        return temp;
      }
    
      private ListNode mergeList(ListNode a, ListNode b) {
        if (a == null) return b ;
        else if (b == null) return a;
    
        ListNode temp;
        if (a.val <= b.val){
             temp = a;
             temp.next = mergeList(a.next, b);
        } else {
            temp = b;
            temp.next = mergeList(a,b.next);
        }
        return temp;
      }
    
      private ListNode middle(ListNode node) {
        if (node == null) return node;
        ListNode slwPtr = node, fastPtr = node.next;
        while (fastPtr != null && fastPtr.next != null) {
          slwPtr = slwPtr.next;
          fastPtr = fastPtr.next.next;
        }
        return slwPtr;
      }
}