package BinarySearchTree.Problems;

import java.util.Stack;

public class BSTIterator {
    static class BSTIt {
        private Stack<Node> stack = new Stack<>();

        public BSTIt(Node root) {
            pushAll(root);
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int next() {
            Node tempNode = stack.pop();
            pushAll(tempNode.right);
            return tempNode.data;
        }

        private void pushAll(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
    public static void main(String[] args) {
        // Build the BST
        Node root = new Node(7);
        root.left = new Node(3);
        root.right = new Node(15);
        root.right.left = new Node(9);
        root.right.right = new Node(20);


        BSTIt iterator = new BSTIt(root);

        // Simulate the LeetCode calls
        System.out.println(iterator.next());    // 3
        System.out.println(iterator.next());    // 7
        System.out.println(iterator.hasNext()); // true
        System.out.println(iterator.next());    // 9
        System.out.println(iterator.hasNext()); // true
        System.out.println(iterator.next());    // 15
        System.out.println(iterator.hasNext()); // true
        System.out.println(iterator.next());    // 20
        System.out.println(iterator.hasNext()); // false
    }
}
