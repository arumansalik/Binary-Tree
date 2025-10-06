package Problems;

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int key) {
        this.data = key;
        left = right = null;
    }
}

public class IterativePreOrderTravesal {
    public static List<Integer> levelOrder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()) {
            root = st.pop();
            ans.add(root.data);

            if(root.right != null) st.push(root.right);
            if(root.left != null) st.push(root.left);

        }
        return ans;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        // Run preorder traversal
        List<Integer> result = levelOrder(root);

        // Print result
        System.out.println("Preorder Traversal: " + result);
    }
}
