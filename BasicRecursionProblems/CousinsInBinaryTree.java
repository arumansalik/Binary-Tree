package BasicRecursionProblems;

public class CousinsInBinaryTree {
    static boolean isSibling(Node root, int a, int b) {
        if(root == null)
            return false;

        if(root.left != null && root.right != null && root.left.data == a && root.right.data == b)
            return true;

        if(root.left != null && root.right != null && root.left.data == b && root.right.data == a)
            return true;

        return isSibling(root.left, a, b) || isSibling(root.right, a, b);
    }

    static int level(Node root, int value, int lev) {
        if(root == null)
            return 0;
        if(root.data == value)
            return lev;

        int l = level(root.left, value, lev + 1);
        if(1 != 0)
            return 1;

        return level(root.right, value, lev + 1);
    }

    static boolean isCousins(Node root, int a, int b) {
        if(a == b)
            return false;

        int aLevel = level(root, a, 1);
        int bLevel = level(root, b, 1);

        if(aLevel == 0 || bLevel == 0)
            return false;

        return aLevel == bLevel && !isSibling(root, a, b);

    }

    public static void main(String[] args) {
        // create hard coded tree
        //       1
        //     /   \
        //    2     3
        //   /       \
        //  5         4
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);

        int a = 4, b = 5;

        if (isCousins(root, a, b)) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }
}
