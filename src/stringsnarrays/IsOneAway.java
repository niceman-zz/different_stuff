package stringsnarrays;

public class IsOneAway {
    public static void main(String[] args) {
        String s1 = "pale";
        String s2 = "parle";
        System.out.println(isOneAway(s1, s2));
    }

    static boolean isOneAway(String s1, String s2) {
        if (s1 == null || s2 == null || Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }
        if (s1.length() > s2.length()) {
            return compare(s1, s2);
        } else {
            return compare(s2, s1);
        }
    }

    static boolean compare(String bigger, String lesser) {
        boolean diff = false;
        for (int i = 0, j = 0; i < bigger.length() && j < lesser.length(); i++, j++) {
            if (bigger.charAt(i) != lesser.charAt(j)) {
                if (diff) {
                    return false;
                }
                diff = true;
                j--;
            }
        }
        return true;
    }
}
