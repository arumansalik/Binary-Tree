package BasicRecursionProblems;

class Node {
    int data;
    Node left, right;
    Node(int val) {
        this.data = val;
    }
}

public class CountNodes {
    static int count(Node root) {
        if(root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        System.out.println("Total Nodes: " + count(root));
    }
}
