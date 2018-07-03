package _001_040._021_mergeTwoSortedList;

class MergeTwoSortedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {this.val = x;}
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode current = dummy;
        while (p != null || q != null) {
            if (p == null) {
                current.next = new ListNode(q.val);
                q = q.next;
            } else if (q == null) {
                current.next = new ListNode(p.val);
                p = p.next;
            } else if (p.val < q.val) {
                current.next = new ListNode(p.val);
                p = p.next;
            } else {
                current.next = new ListNode(q.val);
                q = q.next;
            }

            current = current.next;
        }

        return dummy.next;
    }
}
