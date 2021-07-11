/**
 * URL: 
 * Tags: LinkedList
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class Problem142{
    public static void main(String[] args) {
        Problem142 obj = new Problem142();
        Solution sol = new Solution();
        ListNode head;
        ListNode a = new ListNode('a');
        ListNode b = new ListNode('b');
        ListNode c = new ListNode('c');
        ListNode d = new ListNode('d');
        ListNode e = new ListNode('e');
        ListNode f = new ListNode('f');
        ListNode g = new ListNode('g');

        head = a;
        a.next = b; b.next = c; c.next = d; d.next = e; e.next = f;
        f.next = g; g.next = d;

        
        
        ListNode ans = sol.detectCycle(a);
        System.out.print("\tAnswer:\t" + ans);
        System.out.print("\n\n"); 
        
    }

}

class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        boolean loopExist = false;
        while(fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                loopExist = true;
                break;
            }
        }
        
        System.out.print("\tSlow:\t" + slow);
        System.out.print("\tFast:\t" + fast);
        if(loopExist){
            slow = head;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }else{
            return null;
        }

    }
}

class ListNode{
    Character val;
    ListNode next;
    ListNode(char v){
        this.val = v;
        this.next = null;
    }
    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}