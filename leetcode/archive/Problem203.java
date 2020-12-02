/**
 * URL: https://leetcode.com/problems/remove-linked-list-elements/
 * 
 * 
 */
class Problem203{

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
        Problem203 obj = new Problem203();
        
        ListNode a = new ListNode(3);
        a.next = new ListNode(1);
        a.next.next = new ListNode(1);
        a.next.next.next = new ListNode(10);
        a.next.next.next.next = new ListNode(15);
        a.next.next.next.next.next = new ListNode(21);
        a.next.next.next.next.next.next = new ListNode(3);
        a.next.next.next.next.next.next.next = new ListNode(10);

        obj.printList(a);
        obj.removeElements(a, 7);
        obj.removeElements(a, 10);
        obj.removeElements(a, 21);
        obj.removeElements(a, 15);
        obj.printList(a);

        // ListNode a = new ListNode(1);
        // a.next = new ListNode(2);
        // a.next.next = new ListNode(2);
        // a.next.next.next = new ListNode(2);
    
        // obj.printList(a);
        // obj.removeElements(a, 2);
        // obj.printList(a);
    }

    public ListNode removeElements(ListNode head, int val) {
        
        while(head!=null && head.val == val){
            head = head.next;
        }

        if(head == null){
            return head;
        }

        ListNode itr = head;
        System.err.println("Head: " + itr);
        while(itr != null && itr.next != null){
            
            while(itr.next != null && itr.next.val == val){
                itr.next = itr.next.next;
            }

            itr = itr.next;
        }

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