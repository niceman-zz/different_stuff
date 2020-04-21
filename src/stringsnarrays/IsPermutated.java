package stringsnarrays;

import java.util.HashMap;
import java.util.Map;

import static stringsnarrays.IsUnique.nLogNSort;

public class IsPermutated {
    public static void main(String[] args) {
        String s1 = "arozaupalanalapuazora";
        String s2 = "upalarozaazoralapunaa";
        System.out.println(isPermutedHash(s1, s2));
        System.out.println(isPermutedSort(s1, s2));
    }

    /**
     * O(n) (hash + loop = O(n) + O(n) => O(n)) but with map which uses additional memory
     */
    static boolean isPermutedHash(String s1, String s2) {
        if (isEmptyOrDifferentLengthString(s1, s2)) {
            return false;
        }
        Map<Character, Integer> map = hash(s1);
        for (Character c: s2.toCharArray()) {
            Integer counter = map.get(c);
            if (counter == null) {
                return false;
            } else if (counter == 1) {
                map.remove(c);
            } else {
                map.put(c, counter - 1);
            }
        }
        return map.isEmpty();
    }

    /**
     * O(n*log(n)) (sort(s1) + sort(s2) + loop = O(nLogN) + O(nLogN) + O(n) => O(nLogN))
     * doesn't use additional memory (if pretend that the String is mutable)
     */
    static boolean isPermutedSort(String s1, String s2) {
        if (isEmptyOrDifferentLengthString(s1, s2)) {
            return false;
        }
        s1 = nLogNSort(s1);
        s2 = nLogNSort(s2);

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    static boolean isEmptyOrDifferentLengthString(String s1, String s2) {
        return s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty() || s1.length() != s2.length();
    }

    static Map<Character, Integer> hash(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c: s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        return map;
    }
}
