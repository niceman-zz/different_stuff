package stringsnarrays.linkedlists;

public class Sum {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(7, 1, 6);
        LinkedList l2 = new LinkedList(5, 9, 2);
        System.out.println(sum(l1, l2));
    }

    static LinkedList sum(LinkedList l1, LinkedList l2) {
        int n1 = listToNum(l1);
        int n2 = listToNum(l2);
        return numToList(n1 + n2);
    }

    static int listToNum(LinkedList l1) {
        LinkedList.Node node = l1.head;
        int order = 1;
        int value = 0;
        while (node != null) {
            value += node.value * order;
            order *= 10;
            node = node.next;
        }
        return value;
    }

    static LinkedList numToList(int num) {
        LinkedList list = new LinkedList();
        final int order = 10;
        while (num > 0) {
            list.addToTail(num % order);
            num /= order;
        }
        return list;
    }
}
