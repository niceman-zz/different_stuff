package sorts;

import java.util.Iterator;
import java.util.LinkedList;

public class MergeForLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3); list.add(5); list.add(8); list.add(5); list.add(10); list.add(2); list.add(1); list.add(15); list.add(4);
        System.out.println(mergeSort(list));
    }

    static LinkedList<Integer> mergeSort(LinkedList<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("list can't be null");
        }
        if (list.size() <= 1) {
            return list;
        }
        int half = list.size() / 2;
        LinkedList<Integer> leftHalf = copyList(list, 0, half);
        LinkedList<Integer> rightHalf = copyList(list, half);
        leftHalf = mergeSort(leftHalf);
        rightHalf = mergeSort(rightHalf);
        return merge(leftHalf, rightHalf);
    }

    static LinkedList<Integer> copyList(LinkedList<Integer> list, int start) {
        return copyList(list, start, list.size());
    }

    static LinkedList<Integer> copyList(LinkedList<Integer> list, int start, int end) {
        if (start > list.size()) {
            throw new IndexOutOfBoundsException();
        }
        LinkedList<Integer> result = new LinkedList<>();
        Iterator<Integer> it = list.iterator();
        int index;
        for (index = 0; index < start; index++) {
            it.next();
        }
        for (; index < end; index++) {
            result.add(it.next());
        }
        return result;
    }

    static LinkedList<Integer> merge(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> result = new LinkedList<>();
        Iterator<Integer> it1 = list1.iterator();
        Iterator<Integer> it2 = list2.iterator();
        Integer o1 = null, o2 = null;
        while (it1.hasNext() || it2.hasNext()) {
            if (o1 == null && it1.hasNext()) {
                o1 = it1.next();
            }
            if (o2 == null && it2.hasNext()) {
                o2 = it2.next();
            }
            if (o1 != null && (o2 == null || o1 < o2)) {
                result.add(o1);
                o1 = null;
            } else {
                result.add(o2);
                o2 = null;
            }
        }
        if (o1 != null) {
            result.add(o1);
        }
        if (o2 != null) {
            result.add(o2);
        }
        return result;
    }
}
