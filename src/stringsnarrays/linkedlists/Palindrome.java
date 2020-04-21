package stringsnarrays.linkedlists;

import static stringsnarrays.linkedlists.LinkedList.Node;

public class Palindrome {
    public static void main(String[] args) {
        //Node node = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        LinkedList list = new LinkedList(1, 2, 3, 4, 5, 4, 3, 2, 1);
        System.out.println(isPalindrome(list));
    }

    static boolean isPalindrome(LinkedList list) {
        LinkedList copy = LinkedList.copy(list);
        LinkedList reversed = LinkedList.reverse(list);
        Node copyHead = copy.head;
        Node reversedHead = reversed.head;
        while (copyHead != null) {
            if (copyHead.value != reversedHead.value) {
                return false;
            }
            copyHead = copyHead.next;
            reversedHead = reversedHead.next;
        }
        return true;
    }

    static Node copy(Node head) {
        Node node = new Node();
        Node newHead = node;
        while (head != null) {
            node.value = head.value;
            if (head.next != null) {
                node.next = new Node();
                node = node.next;
            }
            head = head.next;
        }
        return newHead;
    }
}
