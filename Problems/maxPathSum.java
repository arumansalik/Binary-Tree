package Problems;

public class maxPathSum {
    private int maxSum;

    public int maxPathSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }

    private int maxGain(Node node) {
        if (node == null) return 0;

        // Ignore negative paths
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // Price of the path that passes through this node
        int currentPathSum = node.data + leftGain + rightGain;

        // Update global max if current path is better
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the max gain to continue the path upwards
        return node.data + Math.max(leftGain, rightGain);
    }
}
