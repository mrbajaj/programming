/**
 * 
 * 
 */

class Problem2{
    static class ListNode{
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

    public static void main(String[] args) {
        Problem2 obj = new Problem2();

        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);

        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);

        ListNode sum = obj.addTwoNumbers(a, b);

        obj.printList(sum);
        
    }

    public ListNode addTwoNumbers(ListNode revL1, ListNode revL2) {
        if(revL1 == null){
            return revL2;
        } 
        if(revL2 == null){
            return revL1;
        }
        ListNode result = null, prev = null;
        
        ListNode itr1 = revL1, itr2 = revL2;

        int carry = 0;
        while(itr1 != null && itr2 != null){
            int sum = itr1.val + itr2.val + carry;

            carry = sum / 10;
            ListNode newNode = new ListNode(sum%10);

            if(result == null){
                result = newNode;
                prev = result;
            }else{
                prev.next = newNode;
                prev = newNode;
            }

            itr1 = itr1.next;
            itr2 = itr2.next;
        }

        while(itr1 != null){
            int sum = itr1.val + carry;

            carry = sum / 10;
            ListNode newNode = new ListNode(sum%10);
            prev.next = newNode;
            prev = newNode;

            itr1 = itr1.next;
        }

        while(itr2 != null){
            int sum = itr2.val + carry;

            carry = sum / 10;
            ListNode newNode = new ListNode(sum%10);
            prev.next = newNode;
            prev = newNode;

            itr2 = itr2.next;
        }

        this.printList(result);

        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            prev.next = newNode;
        }

        return result;
    }

    public ListNode reverseList(ListNode l) {
        if(l == null){
            return l;
        }

        ListNode prev = null, curr = l, next = l.next;

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