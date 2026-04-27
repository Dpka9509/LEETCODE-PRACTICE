public class removeel {

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

    // Recursive function (converted to static)
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        head.next = removeElements(head.next, val);

        return (head.val == val) ? head.next : head;
    }

    // Print function
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Create list: 1 -> 2 -> 6 -> 3 -> 6 -> 4
        ListNode head = new ListNode(1,
                new ListNode(2,
                new ListNode(6,
                new ListNode(3,
                new ListNode(6,
                new ListNode(4))))));

        int val = 6;

        System.out.print("Original: ");
        printList(head);

        head = removeElements(head, val);

        System.out.print("After Removing " + val + ": ");
        printList(head);
    }
}