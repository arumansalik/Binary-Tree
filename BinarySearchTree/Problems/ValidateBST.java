package BinarySearchTree.Problems;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class ValidateBST {
    public boolean isValidateBST(Node root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(Node node, long min, long max) {
        if(node == null) return true;
        if(node.data <= min || node.data >= max) return false;
        return helper(node.left, min, node.data) && helper(node.right, node.data, max);
    }

    public static void main(String[] args) {
//        Node root = new Node(5);
//        root.left = new Node(3);
//        root.right = new Node(7);
//        root.left.left = new Node(2);
//        root.left.right = new Node(4);
//        root.right.right = new Node(8);

        Node root1  = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(3);

        ValidateBST valiBST = new ValidateBST();
//        System.out.println(valiBST.isValidateBST(root));
        System.out.println(valiBST.isValidateBST(root1));
    }
}
