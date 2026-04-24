class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class deleteLL {
    public static void main(String[] args) {
        // Create list: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        // Suppose we want to "delete" node with value 5
        ListNode node = head.next; // node = 5

        ListNode prev = null;

        while (node != null && node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }

        if (node != null) { // list not empty
            if (prev != null) prev.next = null;
            else node = null; // single node case
        }

        // Print updated list
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
