/**
 * URL: https://leetcode.com/problems/reverse-linked-list/
 * 
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}

public class Problem206{
    public static void main(String[] args) {
        Solution obj = new Solution();


        ListNode a = new ListNode(3);
        a.next = new ListNode(1);
        a.next.next = new ListNode(1);
        a.next.next.next = new ListNode(10);
        a.next.next.next.next = new ListNode(15);
        a.next.next.next.next.next = new ListNode(21);
        a.next.next.next.next.next.next = new ListNode(3);
        a.next.next.next.next.next.next.next = new ListNode(10);

        obj.printList(a);
        obj.printList(obj.reverseList(a));


    }

    
}

class Solution{
    public ListNode reverseList(ListNode head) {

        if(head == null){
            return head;
        }
        ListNode p = null, q = null, r = head;

        while(r != null){
            p = q;
            q = r;
            r = r.next;
            q.next = p;
        }

        head = q;

        return head;
        
    }

    public void printList(ListNode head){
        ListNode itr = head;

        while(itr != null){
            System.out.print(itr + " ");
            itr = itr.next;
        }
        System.out.println("\n");

    }

}