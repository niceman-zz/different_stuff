package stringsnarrays.linkedlists;

import static stringsnarrays.linkedlists.LinkedList.Node;

public class Intersection {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(1, 2, 3, 4);
        LinkedList l2 = new LinkedList(5, 6);
        LinkedList l3 = new LinkedList(17, 8, 9);
        l1.tail.next = l3.head;
        l2.tail.next = l3.head;
        System.out.println(findIntersection(l1, l2));
    }

    static Node findIntersection(LinkedList l1, LinkedList l2) {
        int delta = Math.abs(l1.size - l2.size);
        Node node1 = l1.head;
        Node node2 = l2.head;
        if (l1.size > l2.size) {
            while (delta > 0) {
                node1 = node1.next;
                delta--;
            }
        } else {
            while (delta > 0) {
                node2 = node2.next;
                delta--;
            }
        }
        while (node1 != null) {
            if (node1 == node2) {
                return node1;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return null;
    }
}
