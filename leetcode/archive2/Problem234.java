/**
 * URL: 
 * Tags: LinkedList
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class Problem234{
    public static void main(String[] args) {
        Problem234 obj = new Problem234();
        Solution sol = new Solution();

        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(2);
        a.next.next.next.next = new ListNode(1);
        a.next.next.next.next.next = new ListNode(6);
        
        System.out.print("Given:\t"); obj.printList(a);
        System.out.print("Answer:\t" + sol.isPalindrome(a));
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
    //note if fast == null then even else odd numbers of items
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slowPrev = null, slow = head, fast = head;
        while(slow != null && fast != null && fast.next != null){
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        slowPrev.next = null;
        ListNode tmp = this.reverseList(slow); // reversed Second Half
        ListNode front = head, back = tmp;
        boolean isPalindrome = true;
        // this.printList(front);
        // this.printList(back);
        while(front != null && back !=null){
            if(front.val != back.val){
                isPalindrome = false;
                break;
            }
            front = front.next;
            back = back.next;
        }
        if(front == null && back != null){
            isPalindrome = true;
        }

        slowPrev.next = this.reverseList(tmp); // reversed Second Half
        // this.printList(head);
        return isPalindrome;
    }
    
    public ListNode reverseList(ListNode head){
        ListNode prev = null, curr = head, next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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