public class partitionlist {

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

    // Partition function (made static)
    public static ListNode partition(ListNode head, int x) {

        ListNode slist = new ListNode(0); // dummy for smaller
        ListNode blist = new ListNode(0); // dummy for bigger

        ListNode small = slist;
        ListNode big = blist;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }

        // connect both lists
        small.next = blist.next;
        big.next = null;

        return slist.next;
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

        // Create list: 1 -> 4 -> 3 -> 2 -> 5 -> 2
        ListNode head = new ListNode(1,
                new ListNode(4,
                new ListNode(3,
                new ListNode(2,
                new ListNode(5,
                new ListNode(2))))));

        int x = 3;

        System.out.print("Original: ");
        printList(head);

        head = partition(head, x);

        System.out.print("Partitioned around " + x + ": ");
        printList(head);
    }
}