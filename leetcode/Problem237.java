class Problem237{

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
        Problem237 obj = new Problem237();
        
        ListNode a = new ListNode(3);
        a.next = new ListNode(7);
        a.next.next = new ListNode(8);
        a.next.next.next = new ListNode(10);

        obj.printList(a);
        obj.deleteNode(a.next);
        obj.printList(a);
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public void printList(ListNode head){
        ListNode itr = head;

        while(itr != null){
            System.out.print(itr + " ");
            itr = itr.next;
        }
        System.out.println();

    }

}