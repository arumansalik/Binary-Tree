package BinarySearchTree.CoreOperations;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class InsertValueInBST {
    Node insert(Node root, int val) {
        if(root == null) return new Node(val);

        if(val < root.data) {
            root.left = insert(root.left, val);
        } else if (val > root.data) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        InsertValueInBST inBST = new InsertValueInBST();
        Node root = null;

        int[] values = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for(int val : values) {
            root = inBST.insert(root, val);
        }
    }
}
