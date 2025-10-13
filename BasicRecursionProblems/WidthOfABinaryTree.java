package BasicRecursionProblems;

import java.util.*;

public class WidthOfABinaryTree {
    static int width(Node root) {
        if(root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int maxWidth = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            maxWidth = Math.max(maxWidth, size);

            for(int i = 0; i < size; i++) {
                Node curr = q.poll();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return maxWidth;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("Width: " + width(root)); // Output: 2
    }
}
