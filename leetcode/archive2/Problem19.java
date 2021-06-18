/**
 * URL: 
 * Tags: LinkedList
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class Problem19{
    public static void main(String[] args) {
        Problem19 obj = new Problem19();
        Solution sol = new Solution();

        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        System.out.print("Given:\t"); obj.printList(a);        
        ListNode ans = sol.removeNthFromEnd(a, 2);
        System.out.print("Answer:\t"); obj.printList( ans );
        System.out.print("\n\n"); 

        a = new ListNode(1);
        System.out.print("Given:\t"); obj.printList(a);        
        ans = sol.removeNthFromEnd(a, 1);
        System.out.print("Answer:\t"); obj.printList( ans );
        System.out.print("\n\n"); 
        
        a = new ListNode(1);
        a.next = new ListNode(2);
        System.out.print("Given:\t"); obj.printList(a);        
        ans = sol.removeNthFromEnd(a, 1);
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0); dummy.next = head;
        ListNode curr = dummy, prevToNthNode = dummy; 
        int i = n;

        while(curr != null && i >= 0){
            curr = curr.next;
            i--;
        }

        while(curr != null){
            curr = curr.next;
            prevToNthNode = prevToNthNode.next;
        }

        prevToNthNode.next = prevToNthNode.next.next;

        return dummy.next;
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

/*
ListNode curr = head, n = N;
        

        while(curr != null && n >= 0){
            System.out.println("loop: " + curr + "\t n:" + n);
            curr = curr.next;
            n--;
        }
        System.out.println(curr + " n:" + n);

        ListNode nth  = head;
        while(curr != null){
            curr = curr.next;
            nth = nth.next;
        }

        System.out.println("n-1th: " + nth);

        if(nth != null && nth.next != null){
            nth.next = nth.next.next;
        }

        
        return head;
*/
/**
 * ListNode curr = head, prevToNthNode = null; 
        int i = n;

        while(curr != null && i >= 0 ){
            System.out.println("loop:  " + curr + "\t i:" + i);
            curr = curr.next;
            i--;
        }
        
        while(curr != null){
            if(prevToNthNode == null)
                prevToNthNode = head.next;
            curr = curr.next;
            prevToNthNode = prevToNthNode.next;
        }
        System.out.println("prevToNthNode: " + prevToNthNode);

        if(prevToNthNode != null && prevToNthNode.next != null){
            prevToNthNode.next = prevToNthNode.next.next;
        }

        if(prevToNthNode == null && i){
            return head.next;
        }else{
            return head;
        }
 */