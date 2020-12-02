/**
 * 
 * 
 */
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

public class Problem24{
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        Problem24 obj = new Problem24();

        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);

        System.out.print("Before: "); obj.printList(a);
        sol.swapPairs(a);
        System.out.print("After: "); obj.printList(a);
        
        System.out.println();
        
        a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        a.next.next.next.next.next = new ListNode(6);

        System.out.print("Before: "); obj.printList(a);
        sol.swapPairs(a);
        System.out.print("After: "); obj.printList(a);
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

    //recursive
    public ListNode swapPairs(ListNode head) {
        
        this.helper(head);
        return head;

    }
    private void helper(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        int tmp = head.val;
        head.val = head.next.val;
        head.next.val = tmp;
        
        helper(head.next.next);

    }
}