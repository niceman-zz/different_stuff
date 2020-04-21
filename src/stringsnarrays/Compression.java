package stringsnarrays;

public class Compression {
    public static void main(String[] args) {
        System.out.println(compress("abbbbbbbcisduflzkkkkkkkkka"));
    }

    static String compress(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        int count = 0;
        char prev = str.charAt(0);
        StringBuilder sb = new StringBuilder(prev + "");
        for (char c : str.toCharArray()) {
            if (prev == c) {
                count++;
            } else {
                sb.append(count).append(c);
                count = 1;
                prev = c;
            }
        }
        sb.append(count);
        return sb.length() < str.length() ? sb.toString() : str;
    }
}
