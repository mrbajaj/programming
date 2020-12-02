/**
 * URL: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 */

 class Problem19{

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Problem19 obj = new Problem19();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        obj.printList( obj.removeNthFromEnd(head, 5) );

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = null, fast = head;
        int  tmp = n, count = 0;

        while(fast != null){
            count++;
            if(slow != null){
                slow = slow.next;
            }

            if(tmp == 0){
                slow = head;
            }
            tmp--;
            
            fast = fast.next;
        }

        if(count == n){
            head = head.next;
        } else if(tmp <= 0 && slow != null && slow.next != null){
            slow.next = slow.next.next;
        }
        

        return  head;
        
    }


    public void printList(ListNode head){
        ListNode curr = head;

        while(null != curr){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

        System.out.println();

    }

 }