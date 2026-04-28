public class palindromell {
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

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode fast = head, slow = head;

        // Step 1: find middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: reverse second half
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;

        ListNode temp = secondHalf;

        // Step 3: compare
        while (temp != null) {
            if (firstHalf.val != temp.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        // Step 4: restore list
        reverse(secondHalf);

        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Example: 1 -> 2 -> 3 -> 2 -> 1
        ListNode head = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(2,
                new ListNode(1)))));

        System.out.print("List: ");
        printList(head);

        boolean result = isPalindrome(head);

        System.out.println("Is Palindrome: " + result);

        System.out.print("After Check (restored): ");
        printList(head);
    }   
}
