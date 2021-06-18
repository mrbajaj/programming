/**
 * URL: 
 * Tags: LinkedList
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class Problem328{
    public static void main(String[] args) {
        Problem328 obj = new Problem328();
        Solution sol = new Solution();

        ListNode a = new ListNode(8);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        a.next.next.next.next.next = new ListNode(6);

        System.out.print("Given:\t"); obj.printList(a);
        
        ListNode ans = sol.oddEvenList(a);
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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = null, evenHead = null, odd = null, even = null, curr = head, next = null;

        while(curr != null){
            next = curr.next;
            curr.next = null;
            if(curr.val % 2 == 0){
                //even
                if(evenHead == null){
                    evenHead = curr;
                    even = evenHead;
                }else{
                    even.next = curr;
                    even = even.next;
                }
            }else{
                //odd
                if(oddHead == null){
                    oddHead = curr;
                    odd = oddHead;
                }else{
                    odd.next = curr;
                    odd = odd.next;
                }
            }

            curr = next;
        }
        if(head !=null && head.val % 2 == 0){
            //starting even
            if(evenHead == null){
                return oddHead;
            }
            even.next = oddHead;
            return evenHead;

        }else{
            //starting odd
            if(oddHead == null){
                return evenHead;
            }
            odd.next = evenHead;
            return oddHead;
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