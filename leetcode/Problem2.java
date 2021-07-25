/**
 * URL: 
 * Tags: LinkedList
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class Problem2{
    public static void main(String[] args) {
        Problem2 obj = new Problem2();
        Solution sol = new Solution();

        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(7);
        // a.next.next.next = new ListNode(1);

        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);

        obj.printList(a);
        obj.printList(b);
        
        ListNode ans = sol.addTwoNumbers(a, b);
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1, b = l2, c = new ListNode(0);
        ListNode ans = c;
        int carry = 0;
        
        while(a != null && b != null){
            int sum = a.val + b.val + carry;
            carry = sum / 10;
            c.next = new ListNode(sum % 10);;
            a = a.next;
            b = b.next;
            c = c.next;
        }
        
        while(a != null){
            int sum = a.val + carry;
            carry = sum / 10;
            c.next = new ListNode(sum % 10);;
            a = a.next;
            c = c.next;
        }

        while(b != null){
            int sum = b.val + carry;
            carry = sum / 10;
            c.next = new ListNode(sum % 10);;
            b = b.next;
            c = c.next;
        }

        if(carry != 0){
            c.next = new ListNode(carry);;
        }

        return ans.next;
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