package HardProblems;

import com.sun.source.tree.Tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

// Custom Pair class (since LeetCode provides it, but local IDE doesn't)
class Pair<U, V> {
    private U key;
    private V value;

    public Pair(U key, V value) {
        this.key = key;
        this.value = value;
    }

    public U getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class WidthOfABinaryTree {
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair<TreeNode, Long>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0L));
        int maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            long minIndex = q.peek().getValue();
            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Long> current = q.poll();
                TreeNode node = current.getKey();
                long index = current.getValue() - minIndex;

                if (i == 0) first = index;
                if (i == size - 1) last = index;

                if (node.left != null) {
                    q.add(new Pair<>(node.left, 2 * index + 1));
                }
                if (node.right != null) {
                    q.add(new Pair<>(node.right, 2 * index + 2));
                }
            }
            maxWidth = Math.max(maxWidth, (int) (last - first + 1));
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        int result = widthOfBinaryTree(root);
        System.out.println("Maximum Width of Binary Tree: " + result);
    }
}
