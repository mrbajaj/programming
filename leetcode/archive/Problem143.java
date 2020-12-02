/**
 * URL: https://leetcode.com/problems/reorder-list/
 * 
 */

class Problem143{
    static class ListNode{
        Integer val;
        ListNode next;
        ListNode(int v){
            this.val = v;
            this.next = null;
        }
        public String toString() {
            return String.valueOf(this.val);
        }
    }

    public static void main(String[] args) {
        Problem143 obj = new Problem143();

        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        obj.printList(a);
        ListNode r = obj.reorderList(a);
        obj.printList(r);

        System.out.println("-------------");

        a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        obj.printList(a);
        r = obj.reorderList(a);
        obj.printList(r);


        
    }

    public ListNode reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast !=null && fast.next != null){
            System.out.println("slow:" + slow.val + "\tfast:" + fast.val);
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        ListNode p = head;
        ListNode q = this.reverse(slow);;

        this.printList(p);
        this.printList(q);
        ListNode rItr = p;
        ListNode pItr = p.next;
        ListNode qItr = q;
        while(pItr != null || qItr != null){
            if(qItr != null){
                rItr.next = qItr;
                rItr = rItr.next;
                qItr = qItr.next;
            }
            if(pItr != null){
                rItr.next = pItr;
                rItr = rItr.next;
                pItr = pItr.next;
            }
            
        }
        return p;

    }

    public ListNode reverse(ListNode head){
        ListNode p = null, c = head, n;

        while(c!=null){
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }

        return p;

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