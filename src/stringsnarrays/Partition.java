package stringsnarrays;

import java.util.Iterator;
import java.util.LinkedList;

public class Partition {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3); list.add(5); list.add(8); list.add(5); list.add(10); list.add(2); list.add(1); list.add(15); list.add(4);
        System.out.println(partition(list, 5));
    }

    static LinkedList<Integer> partition(LinkedList<Integer> list, int partition) {
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();
        for (int value : list) {
            if (value < partition) {
                left.add(value);
            } else {
                right.add(value);
            }
        }
        left.addAll(right);
        return left;
    }
}
