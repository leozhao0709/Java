package _001_040._023_mergeKLists;

class MergeKSortedLists {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return this.mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (l >= r) {
            return lists[l];
        }

        int mid = l + (r - l) / 2;

        ListNode l1 = this.mergeKLists(lists, l, mid);
        ListNode l2 = this.mergeKLists(lists, mid + 1, r);

        return this.merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode current = dummy;
        while (p != null || q != null) {
            if (p == null) {
                current.next = q;
                q = q.next;
            } else if (q == null) {
                current.next = p;
                p = p.next;
            } else if (p.val < q.val) {
                current.next = p;
                p = p.next;
            } else {
                current.next = q;
                q = q.next;
            }

            current = current.next;
        }

        return dummy.next;
    }
}
