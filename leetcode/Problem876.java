/**
 * 
 * 
 */

public class Problem876{
    public static void main(String[] args) {
        Problem876 obj = new Problem876();

        ListNode a = new ListNode(3);
        a.next = new ListNode(7);
        a.next.next = new ListNode(8);
        a.next.next.next = new ListNode(10);

        ListNode b = new ListNode(99);
        b.next = new ListNode(1);
        b.next.next = new ListNode(4);
        b.next.next.next = a.next.next;

        obj.printList(a);
        obj.printList(b);

        Solution sol = new Solution();

        System.out.println("Ans:" + sol.middleNode(a)  + "\n");
        System.out.println("Ans:" + sol.middleNode(b)  + "\n");


        
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
    public ListNode middleNode(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

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