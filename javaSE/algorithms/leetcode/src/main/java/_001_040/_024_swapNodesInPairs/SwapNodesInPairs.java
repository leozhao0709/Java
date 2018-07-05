package _001_040._024_swapNodesInPairs;

class SwapNodesInPairs {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { this.val = x;}
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = head;
        ListNode third = head.next;

        while (first != null && second != null && third != null) {
            second.next = third.next;
            third.next = second;
            first.next = third;

            first = second;
            second = first.next;

            if (second == null) {
                break;
            }
            third = second.next;
        }

        return dummy.next;
    }
}
