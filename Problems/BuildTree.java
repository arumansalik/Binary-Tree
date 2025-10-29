package Problems;

import java.util.*;

public class BuildTree {

    static int preIndex = 0;
    static Map<Integer, Integer> inorderMap = new HashMap<>();

    public static Node buildTree(int[] preorder, int[] inorder) {
        // store inorder values and their indices for O(1) lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private static Node build(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // Step 1: Pick current root from preorder
        int rootVal = preorder[preIndex++];
        Node root = new Node(rootVal);

        // Step 2: Find root index in inorder
        int inorderIndex = inorderMap.get(rootVal);

        // Step 3: Build left & right subtrees
        root.left = build(preorder, inStart, inorderIndex - 1);
        root.right = build(preorder, inorderIndex + 1, inEnd);

        return root;
    }

    // Print inorder for verification
    public static void printInorder(Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        Node root = buildTree(preorder, inorder);

        System.out.print("Constructed Tree Inorder: ");
        printInorder(root);
    }
}
