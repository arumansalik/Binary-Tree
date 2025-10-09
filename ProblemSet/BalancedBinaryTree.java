package ProblemSet;

public class BalancedBinaryTree {
    public static boolean isBalanced(Node root) {
        if(root == null) return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

         if(Math.abs(leftHeight - rightHeight) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int height(Node node) {
        if(node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }



    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(isBalanced(root));
    }
}
