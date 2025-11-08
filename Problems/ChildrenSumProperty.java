package Problems;

public class ChildrenSumProperty {
    public static void changeTree(Node root) {
        if(root == null) return;

        int child = 0;
        if(root.left != null) {
            child += root.left.data;
        }

        if(root.right != null) {
            child += root.right.data;
        }

        if (child >= root.data) {
           root.data = child;
        } else {
            if(root.left != null) {
                root.left.data = root.data;
            } else if (root.right != null) {
                root.right.data = root.data;
            }
        }

        changeTree(root.left);
        changeTree(root.right);

        int tot = 0;
        if(root.left != null) {
            tot += root.left.data;
        }
        if(root.right != null) {
            tot += root.right.data;
        }

        if(root.left != null || root.right != null) {
            root.data = tot;
        }
    }

    public static void inOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);


        changeTree(root);

        inOrderTraversal(root);
    }
}
