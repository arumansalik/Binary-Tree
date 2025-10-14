package BasicRecursionProblems;

class IdenticalTrees {
    static boolean isIdentical(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        return (a.data == b.data) &&
                isIdentical(a.left, b.left) &&
                isIdentical(a.right, b.right);
    }

    public static void main(String[] args) {
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(4);

        Node t2 = new Node(1);
        t2.left = new Node(2);
        t2.right = new Node(3);
        t2.left.left = new Node(4);
        System.out.println("Identical: " + isIdentical(t1, t2)); // true
    }
}
