import java.util.HashMap;
import java.util.Map;

public class CubeSum {
    static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            Pair pair = (Pair) obj;
            return a == pair.a && b == pair.b || a == pair.b && b == pair.a;
        }
    }

    public static void main(String[] args) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int a = 1; a <= 32; a++) {
            int a3 = a * a * a;
            for (int b = a; b <= 32; b++) {
                if (a == b) continue;
                int b3 = b * b * b;
                int sum = a3 + b3;
                Pair curPair = new Pair(a, b);
                Pair prevPair = map.get(sum);
                if (prevPair != null) {
                    if (!curPair.equals(prevPair)) {
                        System.out.println(String.format("%d^3 + %d^3 = %d^3 + %d^3 = %d", curPair.a, curPair.b, prevPair.a, prevPair.b, sum));
                    }
                } else {
                    map.put(sum, curPair);
                }
            }
        }
    }
}
