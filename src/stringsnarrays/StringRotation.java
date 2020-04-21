package stringsnarrays;

public class StringRotation {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(isRotation(s1, s2));
        System.out.println(isRotationPieceOfCake(s1, s2));
    }

    static boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        int lapsCount = 0;
        int lapsLimit = s1.length();
        int i = 0;
        int j;
        while (lapsCount < lapsLimit) {
            j = i + lapsCount;
            if (j >= s2.length()) {
                j -= s2.length();
            }
            if (s1.charAt(i) != s2.charAt(j)) {
                i = 0;
                lapsCount++;
                continue;
            }
            i++;
            if (i == s1.length()) {
                return true;
            }
        }
        return false;
    }

    static boolean isRotationPieceOfCake(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        s2 += s2;
        return isSubstring(s1, s2);
    }

    static boolean isSubstring(String searchString, String containerString) {
        return containerString.contains(searchString);
    }
}
