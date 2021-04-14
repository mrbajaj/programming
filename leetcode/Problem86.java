/**
 * URL: 
 * Tags: LinkedList
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class Problem86{
    public static void main(String[] args) {
        Problem86 obj = new Problem86();
        Solution sol = new Solution();

        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(2);
        a.next.next.next.next = new ListNode(5);
        a.next.next.next.next.next = new ListNode(2);

        System.out.print("Given:\t"); obj.printList(a);
        
        ListNode ans = sol.partition(a, 3);
        System.out.print("Answer:\t"); obj.printList( ans );
        System.out.print("\n\n"); 
        

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
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = null, afterHead = null;
        ListNode before = null, after=null, curr=head, next = null;

        while(curr != null){
            next = curr.next; curr.next = null;
            if(curr.val < x){
                if(beforeHead == null){
                    beforeHead = curr;
                    before = curr;
                }else{
                    before.next = curr;
                    before = before.next;
                }
            }else{
                if(afterHead == null){
                    afterHead = curr;
                    after = curr;
                }else{
                    after.next = curr;
                    after = curr;
                }
            }
            curr = next;
        }
        if(beforeHead == null){
            return afterHead;
        }else{
            before.next = afterHead;
            return beforeHead;
        }
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