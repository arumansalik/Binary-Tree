package Problems;

public class CountNodesInBinaryTree {
    public static int countNodes(Node root) {
        if(root == null) return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if(leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static int getLeftHeight(Node node) {
        int height = 0;
        while(node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    public static int getRightHeight(Node node) {
        int height = 0;
        while(node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

    public static void main(String[] args) {
        // Create a sample complete binary tree:
        //
        //         1
        //        / \
        //       2   3
        //      / \  /
        //     4  5 6

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        int result = countNodes(root);

        System.out.println("Number of nodes in the complete binary tree: " + result);
    }
}
