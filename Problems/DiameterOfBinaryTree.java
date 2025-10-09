package Problems;

public class DiameterOfBinaryTree {
    int diameter = 0;

    public int diameterOfBinaryTree(Node root) {
        height(root);
        return diameter;
    }

    private int height(Node node) {
        if (node == null) return 0;

        int lhh = height(node.left);
        int rhh = height(node.right);

        diameter = Math.max(diameter, lhh + rhh);

        return 1 + Math.max(lhh, rhh);
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree sol = new DiameterOfBinaryTree();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int ans = sol.diameterOfBinaryTree(root);
        System.out.println(ans);
    }
}
