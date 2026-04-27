public class removeduplicateLL {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Your function (made static so no object needed)
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode fast = head, slow = dummy;

        slow.next = fast;

        while (fast != null) {

            // skip duplicates
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }

            if (slow.next != fast) {
                // duplicates found → remove them
                slow.next = fast.next;
                fast = slow.next;
            } else {
                // no duplicate → move both
                slow = slow.next;
                fast = fast.next;
            }
        }

        return dummy.next;
    }

    // Helper function to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Creating sorted linked list: 1 -> 2 -> 2 -> 3 -> 3 -> 4
        ListNode head = new ListNode(1,
                new ListNode(2,
                new ListNode(2,
                new ListNode(3,
                new ListNode(3,
                new ListNode(4))))));

        System.out.print("Original: ");
        printList(head);

        head = deleteDuplicates(head);

        System.out.print("After Removing Duplicates: ");
        printList(head);
    }
}