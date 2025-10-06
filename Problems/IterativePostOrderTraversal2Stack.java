package Problems;

import java.util.*;

public class IterativePostOrderTraversal2Stack {
    public static List<Integer> postOrderTraversal(Node root) {
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        st1.push(root);
        while(!st1.isEmpty()) {
            root = st1.pop();
            st2.push(root);

            if(root.left != null) st1.push(root.left);
            if(root.right != null) st1.push(root.right);
        }

        while(!st2.isEmpty()) {
            ans.add(st2.pop().data);
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

        System.out.println("Postorder Traversal: " + postOrderTraversal(root));
    }
}
