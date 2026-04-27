public class flattenlist {

    // Definition for multilevel doubly linked list
    static class Node {
        int val;
        Node prev, next, child;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node flatten(Node head) {
        flattentail(head);
        return head;
    }

    // returns tail after flattening
    private static Node flattentail(Node head) {
        if (head == null) return head;

        if (head.child == null) {
            if (head.next == null) return head;
            return flattentail(head.next);
        }

        // CASE: child exists
        Node child = head.child;
        head.child = null;

        Node next = head.next;

        Node childtail = flattentail(child);

        // connect head -> child
        head.next = child;
        child.prev = head;

        if (next != null) {
            // connect child tail -> next
            childtail.next = next;
            next.prev = childtail;

            return flattentail(next);
        }

        return childtail;
    }

    // helper: print flattened list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        /*
            Example structure:
            1 - 2 - 3
                |
                7 - 8
        */

        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        head.next = n2;
        n2.prev = head;

        n2.next = n3;
        n3.prev = n2;

        n2.child = n7;
        n7.next = n8;
        n8.prev = n7;

        System.out.println("Original (not fully shown structure)");

        head = flatten(head);

        System.out.print("Flattened: ");
        printList(head);
    }
}