package Problems;

import java.util.*;

public class MorrisTraversal {
    public static List<Integer> getPreorder(Node root) {
        List<Integer> preorder = new ArrayList<>();
        Node cur = root;

        while (cur != null) {
            if(cur.left == null) {
                preorder.add(cur.data);
                cur = cur.right;
            } else {
                Node prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    preorder.add(cur.data);
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return preorder;
    }
    public static void main(String[] args) {
        // Build tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);


        List<Integer> preorder = getPreorder(root);

        System.out.print("Morris Preorder Traversal: ");
        for (int val : preorder) System.out.print(val + " ");
    }
}
