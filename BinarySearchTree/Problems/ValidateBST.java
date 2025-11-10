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
}
