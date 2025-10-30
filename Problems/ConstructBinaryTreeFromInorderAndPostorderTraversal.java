package Problems;

import java.util.*;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    private int postIndex;
    private Map<Integer, Integer> inorderMap;

    public Node buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        inorderMap = new HashMap<>();

        // Store inorder values with their index for quick lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private Node build(int[] inorder, int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // Pick the current root value from postorder
        int rootVal = postorder[postIndex--];
        Node root = new Node(rootVal);

        // Find the position of the root in inorder
        int inIndex = inorderMap.get(rootVal);

        // Build right subtree first, then left
        root.right = build(inorder, postorder, inIndex + 1, inEnd);
        root.left = build(inorder, postorder, inStart, inIndex - 1);

        return root;
    }

    // Helper function to print inorder traversal of the constructed tree
    public void printInorder(Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    // Main method for local testing
    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal obj = new ConstructBinaryTreeFromInorderAndPostorderTraversal();

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        Node root = obj.buildTree(inorder, postorder);

        System.out.print("Inorder of constructed tree: ");
        obj.printInorder(root); // Should print: 9 3 15 20 7
    }
}