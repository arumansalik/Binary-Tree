package BinarySearchTree.Problems;

public class KthSmallestInBST {
    public int[] findKth(Node root, int k) {
        int[] kSmallest = new int[]{Integer.MIN_VALUE};
        int[] counter = new int[]{0};

        inorder(root, counter, k, kSmallest);

        return new int[]{kSmallest[0]};
    }

    private void inorder(Node node, int[] counter, int k, int[] kSmallest) {
        if(node == null || counter[0] >= k) return;

        inorder(node.left, counter, k, kSmallest);

        counter[0]++;


        if(counter[0] == k) {
            kSmallest[0] = node.data;
            return;
        }

        inorder(node.right, counter, k, kSmallest);
    }
    public static void main(String[] args) {
        // Build BST
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(10);

        int k = 3;
        KthSmallestInBST bst = new KthSmallestInBST();
        int[] result = bst.findKth(root, k);

        System.out.println("Kth Smallest: " + result[0]);
    }

}
