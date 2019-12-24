
public class Problem876{
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(7);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(10);
        // head.next.next.next.next = new ListNode(12);
       

        System.out.println("Ans: " + middleNode(head).val);

    }

    static public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}

