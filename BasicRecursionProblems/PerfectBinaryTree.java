package BasicRecursionProblems;

public class PerfectBinaryTree {
    static int depth(Node root) {
        if(root == null) {
            return 0;
        }

        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    static boolean isPerfectRecur(Node root, int d) {
        if(root == null) return true;

        if(root.left == null && root.right == null) {
            return d == 1;
        }

        if(root.left == null || root.right == null) {
            return false;
        }

        return isPerfectRecur(root.left, d - 1) && isPerfectRecur(root.right, d - 1);
    }

    static boolean isPerfect(Node root) {
        int d = depth(root);

        return isPerfectRecur(root, d);
    }

    public static void main(String[] args) {
        // Binary tree
        //           10
        //        /     \
        //      20       30
        //     /  \     /  \
        //   40    50  60   70
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        if (isPerfect(root)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
