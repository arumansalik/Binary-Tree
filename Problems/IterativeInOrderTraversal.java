package Problems;

import java.util.*;

public class IterativeInOrderTraversal {
    public static List<Integer> inorderTraversal(Node root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node current = root;

        while(current != null || !st.isEmpty()) {
            while(current != null) {
                st.push(current);
                current = current.left;
            }

            current = st.pop();
            inorder.add(current.data);

            current = current.right;
        }
        return inorder;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        // Run inorder traversal
        List<Integer> result = inorderTraversal(root);

        // Print result
        System.out.println("Inorder Traversal: " + result);
    }
}
