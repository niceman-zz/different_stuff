package treesngraphs;

public class IsBST {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new Tree.Node(40);
        tree.root.left = new Tree.Node(20);
        tree.root.left.left = new Tree.Node(15);
        tree.root.left.left.left = new Tree.Node(13);
        tree.root.left.left.right = new Tree.Node(17);
        tree.root.left.right = new Tree.Node(25);
        tree.root.left.right.left = new Tree.Node(22);
      //  tree.root.left.right.right = new Tree.Node(50); // breaks BST!
        tree.root.right = new Tree.Node(60);
        tree.root.right.right = new Tree.Node(70);
        tree.root.right.right.right = new Tree.Node(75);
        tree.root.right.right.left = new Tree.Node(65);
        tree.root.right.left = new Tree.Node(50);
        tree.root.right.left.right = new Tree.Node(55);
       // tree.root.right.left.left = new Tree.Node(35); // breaks BST!

        System.out.println(isBst(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    static boolean isBst(Tree.Node node, int min, int max) {
        boolean isBst = true;
        if (node.left != null) {
            if (node.left.value <= node.value && node.left.value > min) {
                isBst = isBst(node.left, min, node.value);
            } else {
                isBst = false;
            }
        }
        if (node.right != null) {
            if (node.right.value > node.value && node.right.value < max) {
                isBst = isBst && isBst(node.right, node.value, max);
            } else {
                isBst = false;
            }
        }
        return isBst;
    }
}
