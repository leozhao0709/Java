package _041_080._061_rotateList;

class RotateList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p = head;

        int n = 1;
        while (p.next != null) {
            n++;
            p = p.next;
        }

        k = k % n;

        if (k == 0) {
            return head;
        }

        p = head;
        while ( k > 0) {
            p = p.next;
            k--;
        }

        ListNode q = head;
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }

        dummy.next = q.next;
        q.next = null;
        p.next = head;

        return dummy.next;
    }
}
