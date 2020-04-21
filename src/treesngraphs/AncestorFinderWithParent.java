package treesngraphs;

public class AncestorFinderWithParent {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new Tree.Node(40);
        tree.root.left = new Tree.Node(20);
        tree.root.left.parent = tree.root;
        tree.root.left.left = new Tree.Node(15);
        tree.root.left.left.parent = tree.root.left;
        Tree.Node node1 = tree.root.left.left.left = new Tree.Node(13);
        tree.root.left.left.left.parent = tree.root.left.left;
        tree.root.left.left.right = new Tree.Node(17);
        tree.root.left.left.right.parent = tree.root.left.left;
        tree.root.left.right = new Tree.Node(25);
        tree.root.left.right.parent = tree.root.left;
        tree.root.left.right.left = new Tree.Node(22);
        tree.root.left.right.left.parent = tree.root.left.right;
        tree.root.right = new Tree.Node(60);
        tree.root.right.parent = tree.root;
        tree.root.right.right = new Tree.Node(70);
        tree.root.right.right.parent = tree.root.right;
        tree.root.right.right.right = new Tree.Node(75);
        tree.root.right.right.right.parent = tree.root.right.right;
        tree.root.right.right.left = new Tree.Node(65);
        tree.root.right.right.left.parent = tree.root.right.right;
        tree.root.right.left = new Tree.Node(50);
        tree.root.right.left.parent = tree.root.right;
        Tree.Node node2 = tree.root.right.left.right = new Tree.Node(55);
        tree.root.right.left.right.parent = tree.root.right.left;

        System.out.println(findAncestor(node1, node2));
    }

    static Tree.Node findAncestor(Tree.Node node1, Tree.Node node2) {
        while (node1 != null) {
            Tree.Node curNode = node2;
            while (curNode != null) {
                if (node1 == curNode) return curNode;
                curNode = curNode.parent;
            }
            node1 = node1.parent;
        }
        return null;
    }
}
