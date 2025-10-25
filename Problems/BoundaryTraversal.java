package Problems;
import java.util.*;

public class BoundaryTraversal {
    public static List<Integer> boundaryTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        // Root node (only if it's not a leaf)
        if (!isLeaf(root))
            res.add(root.data);

        // 1️⃣ Add left boundary
        addLeftBoundary(root.left, res);

        // 2️⃣ Add leaf nodes
        addLeaves(root, res);

        // 3️⃣ Add right boundary
        addRightBoundary(root.right, res);

        return res;
    }

    // Helper to check if a node is leaf
    private static boolean isLeaf(Node node) {
        return node != null && node.left == null && node.right == null;
    }

    // Add left boundary (top-down, excluding leaves)
    private static void addLeftBoundary(Node node, List<Integer> res) {
        while (node != null) {
            if (!isLeaf(node))
                res.add(node.data);
            node = (node.left != null) ? node.left : node.right;
        }
    }

    // Add all leaf nodes (left-to-right)
    private static void addLeaves(Node node, List<Integer> res) {
        if (node == null) return;
        if (isLeaf(node)) {
            res.add(node.data);
            return;
        }
        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }

    // Add right boundary (bottom-up, excluding leaves)
    private static void addRightBoundary(Node node, List<Integer> res) {
        Stack<Integer> st = new Stack<>();
        while (node != null) {
            if (!isLeaf(node))
                st.push(node.data);
            node = (node.right != null) ? node.right : node.left;
        }
        // Add in reverse order
        while (!st.isEmpty())
            res.add(st.pop());
    }

    // Driver code
    public static void main(String[] args) {
        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
               / \
              8   9
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);

        List<Integer> boundary = boundaryTraversal(root);
        System.out.println("Boundary Traversal: " + boundary);
    }
}
