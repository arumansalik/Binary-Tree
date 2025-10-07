package Problems;

import java.util.*;

public class PostOrderOneStack {
    public static List<Integer> postOrderTraversal(Node root) {
        List<Integer> postOrder = new ArrayList<>();
        if(root == null) return postOrder;

        Stack<Node> st = new Stack<>();
        Node curr = root;
        Node lastVisited = null;

        while (curr != null || !st.isEmpty()) {
            if(curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                Node peekNode = st.peek();

                if(peekNode.right != null && lastVisited != peekNode.right) {
                    curr = peekNode.right;
                } else {
                    postOrder.add(peekNode.data);
                    lastVisited = st.pop();
                }
            }
        }
        return postOrder;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Postorder Traversal: " + postOrderTraversal(root));
    }
}
