/**
 * URL: 
 * Tags: LinkedList
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class Problem1290{
    public static void main(String[] args) {
        Problem1290 obj = new Problem1290();
        Solution sol = new Solution();

        ListNode a = new ListNode(1);
        a.next = new ListNode(0);
        a.next.next = new ListNode(1);
        
        System.out.print("Given:\t"); obj.printList(a);
        
        System.out.println("Answer:\t" + sol.getDecimalValue(a) );
        
        

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
    public int getDecimalValue(ListNode head) {
        if(head == null){
            return 0;
        }
        
        ListNode lsb = reverseList(head);
        int i = 0, ans = 0;
        while(lsb != null){
            
            ans = ans + lsb.val * (int) Math.pow(2,i);
            
            lsb = lsb.next;
            i++;
        }
        
        return ans;
    }
    
    private ListNode reverseList(ListNode head){
        ListNode prev = null, curr = head, next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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