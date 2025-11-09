package BinarySearchTree.CoreOperations;

public class DeleteFromBinaryTree {
    int findMin(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    Node delete(Node root, int val) {
        if(root == null) return null;

        if(val < root.data) {
            root.left = delete(root.left, val);
        } else if (val > root.data) {
            root.right = delete(root.right, val);
        }
        else {
            if(root.left == null && root.right == null) {
                return null;
            }
            else if(root.left == null) {
                return root.left;
            } else if (root.right == null) {
                return root.right;
            }

            int minNode = findMin(root.right);
            root.data = minNode;
            root.right = delete(root.right, minNode);
        }
        return root;
    }
}
