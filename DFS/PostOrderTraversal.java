package DFS;

public class PostOrderTraversal {
    void postOder(Node root) {
        if(root == null) {
            return;
        }
        postOder(root.left);
        postOder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        PostOrderTraversal tree = new PostOrderTraversal();
        System.out.println("PostOrder Traversal: ");
        tree.postOder(root);
    }
}
