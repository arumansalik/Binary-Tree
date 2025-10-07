package ProblemSet;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int key) {
        this.data = key;
        left = right = null;
    }
}

public class HeightOfABinaryTree {
    public static int maxDepth(Node root) {
        if(root == null) return 0;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.left.left = new Node(5);
        root.right.right = new Node(6);

        int ans = maxDepth(root);
        System.out.println(ans);
    }
}
