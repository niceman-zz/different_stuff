package stringsnarrays.linkedlists;

public class LoopFinder {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(1, 2, 3, 4, 5, 10, 11, 12);
        LinkedList loop = new LinkedList(16, 6, 7, 8, 9);
        loop.tail.next = loop.head;
        list.tail.next = loop.head;
        System.out.println(findLoop(list));
    }

    static LinkedList.Node findLoop(LinkedList list) {
        LinkedList.Node slow = list.head;
        LinkedList.Node fast = list.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = list.head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
