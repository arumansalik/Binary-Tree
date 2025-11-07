package Problems;

import java.util.*;

class Pair1<U, V> {
    private U key;
    private V value;

    public Pair1(U key, V value) {
        this.key = key;
        this.value = value;
    }

    public U getKey() { return key; }
    public V getValue() { return value; }
}

public class MaxWidthofBinaryTree {
    public static int widthOfBinaryTree(Node root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair1<Node, Integer>> q = new LinkedList<>();
        q.offer(new Pair1<>(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int minIndex = q.peek().getValue();
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair1<Node, Integer> p = q.poll();
                Node node = p.getKey();
                int currIndex = p.getValue() - minIndex;

                if (i == 0) first = currIndex;
                if (i == size - 1) last = currIndex;

                if (node.left != null)
                    q.offer(new Pair1<>(node.left, 2 * currIndex + 1));
                if (node.right != null)
                    q.offer(new Pair1<>(node.right, 2 * currIndex + 2));
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(9);

        int width = widthOfBinaryTree(root);
        System.out.println("Maximum width of binary tree: " + width);
    }

}
