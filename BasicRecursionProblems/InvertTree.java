package BasicRecursionProblems;

public class InvertTree {
    static Node invert(Node root) {
        if(root == null) return null;
        Node left = invert(root.left);
        Node right = invert(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    static void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        System.out.println("Before invert:");
        inorder(root);
        invert(root);
        System.out.println("\nAfter invert:");
        inorder(root);
    }
}
