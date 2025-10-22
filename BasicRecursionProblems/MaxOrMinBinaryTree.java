package BasicRecursionProblems;

public class MaxOrMinBinaryTree {
    public static int findMax(Node node) {
        if(node == null) return Integer.MIN_VALUE;

        int res = node.data;
        int lres = findMax(node.left);
        int rres = findMax(node.right);

        if(lres > res)
            res = lres;
        if(rres > res)
            res = rres;
        return res;
    }

    public static void main(String[] args) {
        Node tree = new Node(2);
        tree.left = new Node(7);
        tree.right = new Node(5);
        tree.left.right = new Node(6);
        tree.left.right.left = new Node(1);
        tree.left.right.right = new Node(11);
        tree.right.right = new Node(9);
        tree.right.right.left = new Node(4);

        System.out.println("Maximum element is " + findMax(tree));
    }
}
