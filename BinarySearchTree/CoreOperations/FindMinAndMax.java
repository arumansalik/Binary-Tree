package BinarySearchTree.CoreOperations;

public class FindMinAndMax {
    int findMin(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    int findMax(Node root) {
        while(root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    public static void main(String[] args) {
        InsertValueInBST inBST = new InsertValueInBST();
        FindMinAndMax minAndMax = new FindMinAndMax();
        Node root = null;

        int[] values = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int val : values) {
            root = inBST.insert(root, val);
        }

        System.out.println("The Minimum Value in the Tree: " + minAndMax.findMin(root));
        System.out.println("The Maximum Value in the Tree: " + minAndMax.findMax(root));
    }
}
