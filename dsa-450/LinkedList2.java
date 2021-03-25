/**
 * URL: 
 * Tags: LinkedList
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class LinkedList2{
    public static void main(String[] args) {
        LinkedList2 obj = new LinkedList2();
        Solution sol = new Solution();

        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        // a.next.next.next.next.next = new ListNode(6);
        // a.next.next.next.next.next.next = new ListNode(7);
        // a.next.next.next.next.next.next.next = new ListNode(8);

        System.out.print("Given:\t"); obj.printList(a);
        
        ListNode ans = sol.reverseKGroup(a, 3);
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode groupRHead = null, prevStart = null;
        ListNode rest = head;
        while(rest != null){
            int i=0;
            ListNode start = rest, end = rest;
            while(i < k && rest != null){
                System.out.print(rest.val + " ");
                end = rest;
                rest = rest.next;
                i++;
            }
            System.out.print("\tstart: " + start + "\tend: " + end + "\trest: " + rest);
            if(i == k){
                // reverse the current group between start to end
                end.next = null;
                ListNode reverseHead =  reverse(start);
                if(groupRHead == null){
                    groupRHead = reverseHead;
                }else{
                    prevStart.next = reverseHead;
                }
                System.out.print("\treverseHead: " + reverseHead);
                prevStart = start;
            }else{
                //do not reverse if the remaining group is not full
                // To cover usecase => Input: arr=[1,2,3,4,5], k=3 Output: [3,2,1,4,5]

                prevStart.next = start;
            }
            System.out.println();
        }

        return groupRHead;
    }

    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
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