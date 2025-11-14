package BinarySearchTree.Problems;

public class RecoverBST {
    static Node first, middle, last, prev;

    static void recoverTree(Node root) {
        first = middle = last = prev = null;
        inOrder(root);

        if(first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && middle != null) {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    static void inOrder(Node root) {
        if(root == null) return;
        inOrder(root.left);

        if(prev != null && prev.data > root.data) {
            if(first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        prev = root;
        inOrder(root.right);
    }

    static void printInorder(Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(4);
        root.right.left = new Node(2);

        System.out.print("Before Fix: ");
        printInorder(root);
        System.out.println();

        recoverTree(root);

        System.out.print("After Fix: ");
        printInorder(root);
    }
}
