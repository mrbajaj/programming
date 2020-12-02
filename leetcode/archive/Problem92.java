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

public class Problem92{
    public static void main(String[] args) {
        Helper helper = new Helper();
        Solution obj = new Solution();


        ListNode a = new ListNode(3);
        a.next = new ListNode(5);
        helper.printList(a);
        helper.printList(obj.reverseBetween(a, 1, 1));

        a = new ListNode(3);
        a.next = new ListNode(5);
        helper.printList(a);
        helper.printList(obj.reverseBetween(a, 1, 2));


        a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        a.next.next.next.next.next = new ListNode(6);
        a.next.next.next.next.next.next = new ListNode(7);
        a.next.next.next.next.next.next.next = new ListNode(8);
        helper.printList(a);
        helper.printList(obj.reverseBetween(a, 2, 5));


    }

    
}
class Solution{
    public ListNode reverseBetween(ListNode head, int m, int n) {
        Helper helper = new Helper();
        if(head == null || head.next == null || m == n){
            return head;
        }
        n = n - m + 1;
        ListNode mPrevNode = null, mNode = head;
        while(m != 1){
            mPrevNode = mNode;
            mNode = mNode.next;
            m--;
        }
        System.out.println("mPrevNode: " + mPrevNode);
        System.out.println("mNode: " + mNode);
        
        ListNode nPrevNode = null, nNode = mNode;
        while(n != 1){
            nPrevNode = nNode;
            nNode = nNode.next;
            n--;
        }
        System.out.println("nPrevNode: " + nPrevNode);
        System.out.println("nNode: " + nNode);

        ListNode remaining = nNode.next;
        System.out.println("remaining: " + remaining);

        nNode.next = null;
        ListNode reverseHead = this.reverseList(mNode);

        System.out.println("reverseHead: " + reverseHead);
        if(mPrevNode == null){
            head = reverseHead;
        }else{
            mPrevNode.next = reverseHead;
        }
        
        // helper.printList(reverseHead);
        mNode.next = remaining;
        return head;
    }
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
}

class Helper{
    public void printList(ListNode head){
        ListNode itr = head;

        while(itr != null){
            System.out.print(itr + " ");
            itr = itr.next;
        }
        System.out.println("\n");

    }
}