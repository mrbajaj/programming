/**
 * URL: 
 * Tags: LinkedList
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class Problem61{
    public static void main(String[] args) {
        Problem61 obj = new Problem61();
        Solution sol = new Solution();

        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        // a.next.next.next.next.next = new ListNode(6);

        System.out.print("Given:\t"); obj.printList(a);
        ListNode ans = sol.rotateRight(a, 6);
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
    public ListNode rotateRight(ListNode head, int x) {
        if(head == null || x == 0){
            return head;
        }
        ListNode front, rear, tmp = null, itr = null;
        int k = x, size = 0;
 
        front = head; rear = head;
 
        while(k > 0 && front != null){
            size++;
            k--;
            front = front.next;
        }
         
        if(front != null){
            while(front != null){
                tmp = rear;
                rear = rear.next;
                front = front.next;
            }
            tmp.next = null;
            itr = rear;
            while(itr != null){
                tmp = itr;
                itr = itr.next;
            }
            tmp.next = head;
        }else{
            return rotateRight(head, x%size);
        }
         
 
         return rear;
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