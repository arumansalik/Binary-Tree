package BinarySearchTree.Problems;

public class findCeil {
    public static int findCeilInBST(Node root, int key) {
        int ceil = -1;

        while(root != null) {
            if(root.data == key) {
                ceil = root.data;
                return ceil;
            }
            if(key > root.data) {
                root = root.right;
            } else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(14);

        int key = 5;

        int ceil = findCeilInBST(root, key);
        System.out.println("Ceil of " + key + " in BST is: " + ceil);
    }
}
