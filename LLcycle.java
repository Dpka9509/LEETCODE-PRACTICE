class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LLcycle {
    public static void main(String[] args) {
        // Create nodes
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        // Link nodes: 3 -> 2 -> 0 -> -4
        head.next = second;
        second.next = third;
        third.next = fourth;

        // Create cycle: last node points to second node
        fourth.next = second;

        // Floyd’s Cycle Detection
        if (head == null || head.next == null) {
            System.out.println(false);
            return;
        }

        ListNode slow = head, fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        System.out.println(hasCycle);
    }
}