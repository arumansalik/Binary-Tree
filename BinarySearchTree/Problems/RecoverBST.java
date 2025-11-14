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
    }
}
