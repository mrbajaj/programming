/**
 * URL: https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 */

class Problem21{

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        
        Problem21 obj = new Problem21();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(7);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(11);
        l1.next.next.next.next.next = new ListNode(14);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(12);
        l2.next.next = new ListNode(15);


        obj.printList( obj.mergeTwoLists(l1, l2) );

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode itr1 = l1, itr2 = l2, itr3 = null;
        ListNode l3 = null;
        
        if(itr1 != null && itr2 != null){
            if(itr1.val <= itr2.val){
                itr3 = new ListNode(itr1.val);
                itr1 = itr1.next;
            }else{
                itr3 = new ListNode(itr2.val);
                itr2 = itr2.next;
            }
        } else if(itr1 != null){
            itr3 = new ListNode(itr1.val);
            itr1 = itr1.next;
        } else if( itr2 != null){
            itr3 = new ListNode(itr2.val);
            itr2 = itr2.next;
        }
        
        l3 = itr3;

        while(itr1 != null && itr2 != null){

            if(itr1.val <= itr2.val){
                itr3.next = new ListNode(itr1.val);
                itr1 = itr1.next;
            }else{
                itr3.next = new ListNode(itr2.val);
                itr2 = itr2.next;
            }

            itr3 = itr3.next;
            
        }

        while(itr1 != null){
            itr3.next = new ListNode(itr1.val);
            itr1 = itr1.next;
            itr3 = itr3.next;
        }

        while(itr2 != null){
            itr3.next = new ListNode(itr2.val);
            itr2 = itr2.next;
            itr3 = itr3.next;
        }

        return l3;
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