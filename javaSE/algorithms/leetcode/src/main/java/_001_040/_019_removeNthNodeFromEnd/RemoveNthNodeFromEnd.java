package _001_040._019_removeNthNodeFromEnd;

class RemoveNthNodeFromEnd {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {val = x;}
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;


        while (n > 0) {
            q = q.next;
            n--;
        }

        if (q == null) {
            return head.next;
        }

        while (q.next != null) {
            q = q.next;
            p = p.next;
        }

        p.next = p.next.next;

        return head;
    }

}
