/**
 * URL:
 * 
 */
class Problem2{
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {

        Problem2 obj = new Problem2();

        // ListNode L1 = new ListNode(2);
        // L1.next = new ListNode(4);
        // L1.next.next = new ListNode(3);
        // L1.next.next.next = new ListNode(9);
        // L1.next.next.next.next = new ListNode(1);

        // ListNode L2 = new ListNode(5);
        // L2.next = new ListNode(6);
        // L2.next.next = new ListNode(7);

        // ListNode L2 = null;
        
        ListNode L1 = new ListNode(5);
        ListNode L2 = new ListNode(5);

        printList( L1 );
        printList( L2 );
        printList( obj.addTwoNumbers(L1, L2) );



    }

    public ListNode addTwoNumbers(ListNode L1, ListNode L2) {
        ListNode n1= L1, n2 = L2;
        ListNode result = null, n3 = null;

        int sum, digit, carry = 0 ;

        while(n1 != null && n2 != null){
            sum = n1.val + n2.val + carry;
            carry = sum / 10;
            digit = (carry != 0) ? sum % 10 : sum;

            System.out.println("*sum: "+sum+"\t" + "*carry: "+carry+"\t" + "*digit: "+digit+"\t");

            if(n3 == null){
                n3 = new ListNode(digit);
                result = n3;
            }else{
                n3.next = new ListNode(digit);
                n3 = n3.next;
            }

            n1 = n1.next;
            n2 = n2.next;
        }

        while(n1 != null){
            sum = n1.val + carry;
            carry = sum / 10;
            digit = (carry != 0) ? sum % 10 : sum;

            System.out.println("*sum: "+sum+"\t" + "*carry: "+carry+"\t" + "*digit: "+digit+"\t");

            if(n3 == null){
                n3 = new ListNode(digit);
                result = n3;
            }else{
                n3.next = new ListNode(digit);
                n3 = n3.next;
            }

            n1 = n1.next;
        }

        while(n2 != null){
            sum = n2.val + carry;
            carry = sum / 10;
            digit = (carry != 0) ? sum % 10 : sum;

            System.out.println("*sum: "+sum+"\t" + "*carry: "+carry+"\t" + "*digit: "+digit+"\t");            

            if(n3 == null){
                n3 = new ListNode(digit);
                result = n3;
            }else{
                n3.next = new ListNode(digit);
                n3 = n3.next;
            }

            n2 = n2.next;
        }

        if(carry != 0){
            n3.next = new ListNode(carry);
            n3 = n3.next;
        }
        return result;


    }

    static public void printList(ListNode head){
        ListNode curr = head;

        while(null != curr){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

        System.out.println();

    }
}