public class Perm {
    public static void main(String[] args) {
        String s = "abc";
        permutate("", s, 0);
    }

    static void permutate(String cur, String init, int index) {
        if (index == init.length()) {
            System.out.println(cur);
            return;
        }
        for (int i = 0; i <= index; i++) {
            String s = cur.substring(0, i) + init.charAt(index) + cur.substring(i);
            permutate(s, init, index + 1);
        }
    }
}
