class Node {
    int data;
    Node left;
    Node right;

    public Node(int key) {
        this.data = key;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;

    BinaryTree(int value) {
        root = new Node(value);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(40);
        tree.root.left.right = new Node(50);

        System.out.println("Root: " + tree.root.data);
        System.out.println("Left Child of Root: " + tree.root.left.data);
        System.out.println("Right Child of Root: " + tree.root.right.data);
        System.out.println("Left Child of 20: " + tree.root.left.left.data);
        System.out.println("Right Child of 20: " + tree.root.left.right.data);
    }
}
