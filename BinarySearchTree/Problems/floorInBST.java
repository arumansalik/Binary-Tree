package BinarySearchTree.Problems;

public class floorInBST {
    public static int floorInBst(Node root, int key) {
        int floor = -1;
        while(root != null) {
            if(root.data == key) {
                floor = root.data;
                return floor;
            }
            if(key > root.data) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(14);

        int key = 11;
        int floor = floorInBst(root, key);
        System.out.println("Floor of " + key + " in BST is: " + floor);
    }
}
