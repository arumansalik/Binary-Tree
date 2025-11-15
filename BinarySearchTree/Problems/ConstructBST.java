package BinarySearchTree.Problems;

public class ConstructBST {
    static int idx = 0;

    public static Node bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static Node build(int[] preorder, int lower, int upper) {
        if (idx == preorder.length) return null;

        int val = preorder[idx];
        if (val < lower || val > upper) return null;

        idx++;

        Node root = new Node(val);
        root.left = build(preorder, lower, val);
        root.right = build(preorder, val, upper);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};

        Node root = bstFromPreorder(preorder);

        System.out.println("BST constructed successfully!");
    }
}