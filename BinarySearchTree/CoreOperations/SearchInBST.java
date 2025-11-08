package BinarySearchTree.CoreOperations;

public class SearchInBST {
    boolean search(Node root, int val) {
        if(root == null) return false;

        if(root.data == val) return true;
        if(val < root.data) return search(root.left, val);
        else return search(root.right, val);
    }

    public static void main(String[] args) {
        InsertValueInBST inBST = new InsertValueInBST();
        SearchInBST searchInBST = new SearchInBST();
        Node root = null;

        int[] values = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int val : values) {
            root = inBST.insert(root, val);
        }

        int val = 13;
        System.out.println("Search " + val + ": " + searchInBST.search(root, val));
    }
}
