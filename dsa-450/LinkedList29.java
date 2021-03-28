/**
 * URL: 
 * Tags: LinkedList
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class LinkedList29{
    public static void main(String[] args) {
        LinkedList29 obj = new LinkedList29();
        Solution sol = new Solution();

        ListNode a = new ListNode(2);
        a.next = new ListNode(0);
        a.next.next = new ListNode(1);
        a.next.next.next = new ListNode(2);
        a.next.next.next.next = new ListNode(0);
        a.next.next.next.next.next = new ListNode(2);
        a.next.next.next.next.next.next = new ListNode(1);
        a.next.next.next.next.next.next.next = new ListNode(2);
        a.next.next.next.next.next.next.next.next = new ListNode(0);

        System.out.print("Given:\t"); obj.printList(a);
        
        ListNode ans = sol.segregateByChangingLinks(a);
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
}

class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    ListNode segregate(ListNode head)
    {
        ListNode curr = head;
        ListNode prev = head;

        while(curr != null){
            if(curr.val == 0){
                curr.val = prev.val;
                prev.val = 0;
                prev = prev.next;
            }
            curr = curr.next;
        }
        curr = prev;
        while(curr != null){
            if(curr.val == 1){
                curr.val = prev.val;
                prev.val = 1;
                prev = prev.next;
            }
            curr = curr.next;
        }

        return head;
    }

    ListNode segregateByChangingLinks(ListNode head)
    {
        ListNode curr = head, next;
        ListNode zeroDummy = new ListNode(3), oneDummy =  new ListNode(3), twoDummy =  new ListNode(3);
        ListNode zero = zeroDummy, one = oneDummy, two = twoDummy;

        while(curr != null){
            if(curr.val == 0){
                zero.next = curr;
                zero = zero.next;
            } else if(curr.val == 1){
                one.next = curr;
                one = one.next;
            } else if(curr.val == 2){
                two.next = curr;
                two = two.next;
            }
            next = curr.next;
            curr.next = null;
            curr = next;
        }

        this.printList(zeroDummy);
        this.printList(oneDummy);
        this.printList(twoDummy);

        zero.next = (oneDummy.next!=null) ? (oneDummy.next) : (twoDummy.next);
        one.next = twoDummy.next; 
        
        return zeroDummy.next;
    }

    void printList(ListNode head){
        ListNode itr = head;
        while(itr!=null){
            System.out.print(itr +" ");
            itr = itr.next;
        }
        System.out.println();
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