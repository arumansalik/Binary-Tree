package HardProblems;

import com.sun.source.tree.Tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int va) {
        this.val = val;
    }
}

public class WidthOfABinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
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

    }
}
