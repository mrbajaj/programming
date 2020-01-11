/**
 * Good morning! Here's your coding interview problem for today.
 * This problem was asked by Google.
 * Given two singly linked lists that intersect at some point, find the intersecting ListNode. The lists are non-cyclical.
 * 
 * For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the ListNode with value 8.
 * In this example, assume ListNodes with the same value are the exact same ListNode objects.
 * 
 * Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 * 
 */

class Problem20{
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
        Problem20 obj = new Problem20();

        ListNode a = new ListNode(3);
        a.next = new ListNode(7);
        a.next.next = new ListNode(8);
        a.next.next.next = new ListNode(10);

        ListNode b = new ListNode(99);
        b.next = new ListNode(1);
        b.next.next = new ListNode(4);
        b.next.next.next = a.next.next;
        // b.next.next = a.next.next;

        obj.printList(a);
        obj.printList(b);

        System.out.println("Ans:" + obj.getIntersectionNode(a, b) );
        
    }



    public ListNode getIntersectionNode(ListNode a, ListNode b){
        ListNode joint = null;
        int la = this.lengthOfList(a);
        int lb = this.lengthOfList(b);
        int diff;

        System.out.println("aLength:" + la);
        System.out.println("bLength:" + lb);
        ListNode itrA = a;
        ListNode itrB = b;
        if(la < lb){
            // same or b is larger
            diff = lb - la;
            System.out.println("Diff:" + diff);
            while(diff != 0){
                itrB = itrB.next;
                diff--;
            }
        }else{
            // a is larger
            diff = la - lb;
            System.out.println("Diff:" + diff);
            while(diff != 0){
                itrA = itrA.next;
                diff--;
            }
        }


        while(itrA != null && itrB != null && itrA != itrB){
            itrA = itrA.next;
            itrB = itrB.next;
        }

        if(itrA != null && itrB !=null && itrA == itrB){
            joint = itrA;
        }

        return joint;

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