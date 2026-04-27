class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class removel {
    public static void main(String[] args) {
        // Create list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2; // remove 2nd node from end

        int sz = 0;
        ListNode temp = head;

        // Calculate size
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        // If removing head
        if (sz == n) {
            head = head.next;
        } else {
            int i = 1;
            int idx = sz - n;

            ListNode prev = head;

            while (i < idx) {
                prev = prev.next;
                i++;
            }

            prev.next = prev.next.next;
        }

        // Print updated list
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}