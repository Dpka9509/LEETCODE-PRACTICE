public class oddevenll {

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

    public static ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode evenHead = null, evenTail = null;
        ListNode oddHead = null, oddTail = null;

        ListNode curr = head;
        int i = 1;

        while (curr != null) {

            if (i % 2 == 0) {
                // EVEN NODE
                if (evenHead == null) {
                    evenHead = evenTail = curr;
                } else {
                    evenTail.next = curr;
                    evenTail = evenTail.next;
                }
            } else {
                // ODD NODE
                if (oddHead == null) {
                    oddHead = oddTail = curr;
                } else {
                    oddTail.next = curr;
                    oddTail = oddTail.next;
                }
            }

            curr = curr.next;
            i++;
        }

        // connect odd list to even list
        oddTail.next = evenHead;

        // important safety fix
        if (evenTail != null) {
            evenTail.next = null;
        }

        return oddHead;
    }

    // print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Example: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5)))));

        System.out.print("Original: ");
        printList(head);

        head = oddEvenList(head);

        System.out.print("Odd-Even: ");
        printList(head);
    }
}