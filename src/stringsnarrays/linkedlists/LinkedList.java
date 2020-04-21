package stringsnarrays.linkedlists;

import java.util.StringJoiner;

public class LinkedList {
    Node head;
    Node tail;
    int size = 0;

    LinkedList(int... values) {
        for (int value : values) {
            addToTail(value);
        }
    }

    LinkedList addToHead(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
        return this;
    }

    LinkedList add(int value) {
        return addToTail(value);
    }

    LinkedList addToTail(int value) {
        Node node = new Node(value);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        return this;
    }

    static LinkedList reverse(LinkedList list) {
        if (list.head == null || list.head.next == null) {
            return list;
        }
        LinkedList result = new LinkedList();
        Node node = list.head;
        while (node != null) {
            result.addToTail(node.value);
            node = node.next;
        }

        return result;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "this list is empty";
        }
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        Node node = head;
        while (node != null) {
            joiner.add(String.valueOf(node.value));
            node = node.next;
        }
        return joiner.toString();
    }

    static LinkedList copy(LinkedList list) {
        if (list.head == null) {
            return list;
        }
        LinkedList result = new LinkedList();
        Node node = list.head;
        while (node != null) {
            result.addToHead(node.value);
            node = node.next;
        }

        return result;
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
            return String.valueOf(value);
        }
    }
}
