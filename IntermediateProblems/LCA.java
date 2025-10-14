package IntermediateProblems;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int key) {
        this.data = key;
        left = right = null;
    }
}

class LCA {
    static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) return root;

        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root; // both found
        return (left != null) ? left : right;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        Node p = root.left;       // 5
        Node q = root.right;      // 1
        System.out.println("LCA: " + lowestCommonAncestor(root, p, q).data); // 3
    }
}
