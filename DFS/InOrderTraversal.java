package DFS;

public class InOrderTraversal {
    void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        InOrderTraversal tree = new InOrderTraversal();
        System.out.println("InOrder Traversal: ");
        tree.inorder(root);
    }
}