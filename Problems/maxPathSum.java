package Problems;

public class maxPathSum {
    static int maxSum;

    public static int maxpathSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private static int dfs(Node root) {
        if(root == null) return 0;

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        maxSum = Math.max(maxSum, left + right + root.data);

        return root.data + Math.max(left, right);
    }

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println("Maximum Path Sum: " + maxpathSum(root));
    }
}
