package DFS;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int key) {
        this.data = key;
        left = right = null;
    }
}

public class PreOderTraversal {
    void preoder(Node root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preoder(root.left);
        preoder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        PreOderTraversal tree = new PreOderTraversal();
        System.out.println("Preorder Traversal: ");
        tree.preoder(root);
    }
}
