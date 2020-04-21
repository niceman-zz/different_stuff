package treesngraphs;

public class Tree {
    Node root;

    static class Node {
        int value;
        Node parent;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}
