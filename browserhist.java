public class browserhist{

    // Doubly Linked List Node
    static class Node {
        String url;
        Node next, prev;

        public Node(String url) {
            this.url = url;
            next = null;
            prev = null;
        }
    }

    static class BrowserHistory {

        Node curr;

        public BrowserHistory(String homepage) {
            curr = new Node(homepage);
        }

        public void visit(String url) {
            Node node = new Node(url);
            curr.next = node;
            node.prev = curr;
            curr = node;
        }

        public String back(int steps) {
            while (curr.prev != null && steps-- > 0) {
                curr = curr.prev;
            }
            return curr.url;
        }

        public String forward(int steps) {
            while (curr.next != null && steps-- > 0) {
                curr = curr.next;
            }
            return curr.url;
        }

        public String getCurrent() {
            return curr.url;
        }
    }

    public static void main(String[] args) {

        BrowserHistory bh = new BrowserHistory("google.com");

        bh.visit("youtube.com");
        bh.visit("facebook.com");
        bh.visit("github.com");

        System.out.println("Current: " + bh.getCurrent());

        System.out.println("Back 1: " + bh.back(1));
        System.out.println("Back 1: " + bh.back(1));

        System.out.println("Forward 1: " + bh.forward(1));

        bh.visit("leetcode.com");
        System.out.println("After visiting leetcode: " + bh.getCurrent());
    }
}