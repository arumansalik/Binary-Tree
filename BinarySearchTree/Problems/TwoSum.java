package BinarySearchTree.Problems;

import java.util.Stack;

class BSTIterator1 {
    private Stack<Node> stack = new Stack<>();
    private boolean reverse = false;

    public BSTIterator1(Node root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        Node temp = stack.pop();
        if (!reverse) {
            pushAll(temp.right);
        } else {
            pushAll(temp.left);
        }
        return temp.data;
    }

    private void pushAll(Node node) {
        while(node != null) {
            stack.push(node);
            if(reverse) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }
}

public class TwoSum {
    public static boolean findTarget(Node root, int k) {
        if(root == null) return false;

        BSTIterator1 l = new BSTIterator1(root, false);
        BSTIterator1 r = new BSTIterator1(root, true);

        int i = l.next();
        int j = r.next();

        while (i < j) {
            if(i + j == k) return true;
            else if (i + j < k) {
                i = l.next();
            } else {
                j = r.next();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);

        int k = 9;
        System.out.println("Find Target (Two Sum in BST): " + findTarget(root, k));
    }
}
