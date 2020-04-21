package stringsnarrays;

import java.util.HashSet;
import java.util.Set;

public class IsPermutedPalindrome {
    public static void main(String[] args) {
        String s = "Tact Coa";
        Set<String> palindromes = findPalindromes(s);
        System.out.println(palindromes);
    }

    static Set<String> findPalindromes(String s) {
//        s = cleanString(s);
        Set<String> palindromes = new HashSet<>();
        findPalindromes("", s, 0, palindromes);
        return palindromes;
    }

//    static String cleanString(String s) {
//        char[] chars = new char[s.length()];
//        int index = 0;
//        for (char c : s.toCharArray()) {
//            if (c != ' ') {
//                chars[index++] = Character.toLowerCase(c);
//            }
//        }
//        return new String(chars, 0, index);
//    }

    static void findPalindromes(String cur, String init, int index, Set<String> palindromes) {
        if (index == init.length()) {
            if (isPalindrome(cur)) {
                palindromes.add(cur);
            }
            return;
        }
        for (int i = 0; i < index + 1; i++) {
            findPalindromes(cur.substring(0, i) + init.charAt(index) + cur.substring(i), init, index + 1, palindromes);
        }
    }

    static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }


}
