package BasicRecursionProblems;

public class DiameterOfABinaryTree {
    static int diameter = 0;

    static int height(Node root) {
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);

        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
    }

    static int getDiameter(Node root) {
        height(root);
        return diameter;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("Diameter: " + getDiameter(root)); // Output: 3
    }

}
