package Problems;
import java.util.*;

public class BoundaryTraversal {
    public static List<Integer> boundaryTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        if(!isLeaf(root))
            res.add(root.data);

        addLeftBoundary(root.left, res);

        addLeaves(root, res);

        addRightBoundary(root.right, res);

        return res;
    }

    private static boolean isLeaf(Node root) {
        return root != null && root.left != null && root.right != null;
    }

    private static void addLeftBoundary(Node root, List<Integer> res) {
        while(root != null) {
            if(!isLeaf(root))
                res.add(root.data);
            root = (root.left != null) ? root.left : root.right;
        }
    }

    private static void addLeaves(Node root, List<Integer> res) {
        if(root == null) return;
        if(isLeaf(root)) {
            res.add(root.data);
            return;
        }
        addLeaves(root.left, res);
        addLeaves(root.right, res);
    }

    private static void addRightBoundary(Node root, List<Integer> res) {
        Stack<Integer> st = new Stack<>();
        while(root != null) {
            if(!isLeaf(root))
                st.push(root.data);
            root = (root.right != null) ? root.right : root.left;
        }
        while (!st.isEmpty()) {
            res.add(st.pop());
        }
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
