/**
 * URL: https://leetcode.com/problems/linked-list-cycle/
 * 
 */

class Problem141{
    static class ListNode{
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

    public static void main(String[] args) {
        Problem141 obj = new Problem141();

        ListNode a = new ListNode(3);
        a.next = new ListNode(7);
        a.next.next = new ListNode(8);
        a.next.next.next = new ListNode(10);

        System.out.println("Ans:" + obj.hasCycle(a)  + "\n");


        ListNode b = new ListNode(3);
        b.next = new ListNode(2);
        b.next.next = new ListNode(0);
        b.next.next.next = new ListNode(-4);
        b.next.next.next.next = b.next;
        System.out.println("Ans:" + obj.hasCycle(b)  + "\n");

        ListNode c = new ListNode(3);
        c.next = c;
        System.out.println("Ans:" + obj.hasCycle(c)  + "\n");
        
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (slow != null && slow.next != null && fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }

        return false;
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