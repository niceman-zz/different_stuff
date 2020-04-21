package stringsnarrays;

import java.util.Arrays;
import java.util.HashSet;

public class IsUnique {
    public static void main(String[] args) {
        String s = "abcdefghijklmopqrstuvwxyz";
//        String s = "tesla coil";
        System.out.println(isUniqueHash(s));
        System.out.println(isUniqueNoStruct(s));
    }

    /**
     * O(n) but uses additional hash which is additional O(n) memory
     */
    static boolean isUniqueHash(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c: s.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * O(n*log(n)) but doesn't use any additional structures (presumably), so O(1) additional memory
     */
    static boolean isUniqueNoStruct(String s) {
        s = nLogNSort(s);
        char prev = '\0';
        for (char c: s.toCharArray()) {
            if (c == prev) {
                return false;
            }
            prev = c;
        }
        return true;
    }

    /**
     * n*log(n) sort method for string which presumably shouldn't use any
     * additional data structures (though this one does)
     */
    static String nLogNSort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
