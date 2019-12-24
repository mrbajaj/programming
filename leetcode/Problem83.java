/**
 * URL: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 
 */
class Problem83 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        // ListNode head = new ListNode(1);
        // head.next = new ListNode(1);
        // head.next.next = new ListNode(2);
        // head.next.next.next = new ListNode(2);

        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);

        // ListNode head = new ListNode(1);


        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(4);


        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(4);
        
        
        
        printList( head );
        printList( deleteDuplicates(head) );

        

    }

    static public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode prev = head;
        boolean isDuplicate;

        while(null != curr){
            
            isDuplicate = false;
            while(null != curr && prev.val == curr.val){
                curr = curr.next;
                isDuplicate = true;
            }

            if(isDuplicate){
                prev.next = curr;
                prev = curr;
            }else if(curr != null){
                curr = curr.next;
                prev = prev.next;
            }
            

        }
        
        return head;
    }

    static public void printList(ListNode head){
        ListNode curr = head;

        while(null != curr){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

        System.out.println();

    }
}