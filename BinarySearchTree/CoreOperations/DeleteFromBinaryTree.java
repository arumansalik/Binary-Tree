package BinarySearchTree.CoreOperations;

public class DeleteFromBinaryTree {
    int findMin(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
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

    public static void main(String[] args) {
        DeleteFromBinaryTree bst = new DeleteFromBinaryTree();
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        System.out.print("Inorder before deletion: ");
        bst.inorder(root);
        System.out.println();

        int key = 7;
        root = bst.delete(root, key);

        System.out.println("After deleting " + key + ": ");
        bst.inorder(root);
    }
}
