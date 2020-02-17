/**
 * 
 * 
 */

class Problem445{
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
        Problem445 obj = new Problem445();

        ListNode a = new ListNode(7);
        a.next = new ListNode(2);
        a.next.next = new ListNode(4);
        a.next.next.next = new ListNode(3);

        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);

        obj.printList(a);
        obj.printList(b);

        ListNode c = obj.addTwoNumbers(a,b);
        obj.printList(c);
        
    }

    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        a = this.reverse(a);
        b = this.reverse(b);

        int aLen = this.lengthOfList(a);
        int bLen = this.lengthOfList(b);

        if(aLen < bLen){
            ListNode tmp = a;
            a = b;
            b = tmp;
        }

        int carry = 0;
        ListNode c = null;
        ListNode itr1 = a, itr2 = b, itr3 = new ListNode(-1);
        while(itr1!= null && itr2 != null){
            int x = itr1.val + itr2.val + carry;

            if(x >= 10){
                carry = 1;
                x -= 10;
            }else{
                carry = 0;
            }

            ListNode node = new ListNode(x);

            if(c == null){
                c = node;
                itr3 = node;
            }else{
                itr3.next = node;
                itr3 = itr3.next;
            }

            itr1 = itr1.next;
            itr2 = itr2.next;
        }

        while(itr1 != null){
            int x = itr1.val + carry;

            if(x >= 10){
                carry = 1;
                x -= 10;
            }else{
                carry = 0;
            }

            ListNode node = new ListNode(x);

            if(c == null){
                c = node;
                itr3 = node;
            }else{
                itr3.next = node;
                itr3 = itr3.next;
            }

            itr1 = itr1.next;
        }

        if(carry == 1){
            ListNode node = new ListNode(carry);
            itr3.next = node;
        }
        
        return this.reverse(c);
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

    public ListNode reverse(ListNode head){
        ListNode prev = null, curr = head, next;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;

        return head;
    }

}