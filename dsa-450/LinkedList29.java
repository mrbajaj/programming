/**
 * URL: 
 * Tags: LinkedList
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class LinkedList29{
    public static void main(String[] args) {
        LinkedList29 obj = new LinkedList29();
        Solution sol = new Solution();

        ListNode a = new ListNode(1);
        a.next = new ListNode(0);
        a.next.next = new ListNode(1);
        a.next.next.next = new ListNode(2);
        a.next.next.next.next = new ListNode(0);
        a.next.next.next.next.next = new ListNode(0);
        a.next.next.next.next.next.next = new ListNode(1);
        a.next.next.next.next.next.next.next = new ListNode(2);

        System.out.print("Given:\t"); obj.printList(a);
        
        ListNode ans = sol.segregate(a);
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

class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static ListNode segregate(ListNode head)
    {
        ListNode curr = head;
        ListNode prev = head;

        while(curr != null){
            if(curr.val == 0){
                curr.val = prev.val;
                prev.val = 0;
                prev = prev.next;
            }
            curr = curr.next;
        }
        curr = prev;
        while(curr != null){
            if(curr.val == 1){
                curr.val = prev.val;
                prev.val = 1;
                prev = prev.next;
            }
            curr = curr.next;
        }

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