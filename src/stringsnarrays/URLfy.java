package stringsnarrays;

import java.util.Arrays;

public class URLfy {
    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        char[] chars = s.toCharArray();
        urlfy(chars, 13);
        System.out.println(new String(chars));
    }

    static void urlfy(char[] chars, int length) {
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                urlfySpace(chars, i);
                length += 2;
                i += 2;
            }
        }
    }

    static void urlfySpace(char[] chars, int index) {
        for (int i = chars.length - 3; i > index; i--) {
            chars[i + 2] = chars[i];
        }
        chars[index] = '%';
        chars[index + 1] = '2';
        chars[index + 2] = '0';
    }
}
