package stringsnarrays.linkedlists;

public class ReverseSinglyLinkedList {
    public static void main(String[] args) {
        Node node = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        System.out.println(node);
        System.out.println("Reversed: " + reverse(node));
    }

    static Node reverse(Node head) {
        if (head.next == null) {
            return head;
        }
        Node prev = head;
        Node node = head.next;
        prev.next = null;
        while (node != null) {
            Node next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    static class Node {
        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        Node next;
        int value;

        @Override
        public String toString() {
            return value + (next == null ? "" : (", " + next.toString()));
        }
    }
}
