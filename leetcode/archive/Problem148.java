/**
 * URL: https://leetcode.com/problems/sort-list/
 * 
 */

class Problem148{
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
        Problem148 obj = new Problem148();

        ListNode a = new ListNode(3);
        a.next = new ListNode(7);
        a.next.next = new ListNode(8);
        a.next.next.next = new ListNode(16);
        a.next.next.next.next = new ListNode(10);
        a.next.next.next.next.next = new ListNode(2);
        a.next.next.next.next.next.next = new ListNode(20);
        a.next.next.next.next.next.next.next = new ListNode(19);
        a.next.next.next.next.next.next.next.next = new ListNode(1);

        ListNode sorted = obj.sortList(a);

        obj.printList(a);
        System.out.print("Ans: "); obj.printList(sorted);

        a = new ListNode(2);
        a.next = new ListNode(1);
        a.next.next = new ListNode(4);
        a.next.next.next = new ListNode(3);
        
        sorted = obj.sortList(a);

        obj.printList(a);
        System.out.print("Ans: "); obj.printList(sorted);


    }

    public ListNode sortList(ListNode head) {
        if(head == null ){
            return null;
        }

        ListNode sorted = head;
        ListNode itr = head.next;
        sorted.next = null;
        while(itr != null){

            sorted = this.insertIntoSortedList(itr.val, sorted);

            itr = itr.next;
        }

        return sorted;
    }

    private ListNode insertIntoSortedList(int val, ListNode sorted){
        ListNode node = new ListNode(val);
        // System.out.print(val + " :: "); this.printList(sorted);

        if(sorted == null){
            return node;
        }

        if(sorted.val >= val){
            node.next = sorted;
            sorted = node;
            return sorted;
        }

        ListNode itr = sorted;
        while(itr.next != null && itr.next.val <= val){
            itr = itr.next;
        }

        if(itr.next == null){
            itr.next = node;
        }else{
            node.next = itr.next;
            itr.next = node;
        }

        return sorted;
    }

    public void printList(ListNode head){
        ListNode itr = head;
        while(itr!=null){
            System.out.print(itr + " ");
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