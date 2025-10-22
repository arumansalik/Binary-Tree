package BasicRecursionProblems;

public class BinarySumTree {
     public static boolean isSumTree(Node root) {
         int ls, rs;

         if(root == null || (root.left == null && root.right == null))
             return true;

         ls = sum(root.left);
         rs = sum(root.right);

         return (root.data == ls + rs) && isSumTree(root.left) && isSumTree(root.right);
     }

     public static int sum(Node root) {
         if(root == null)
             return 0;

         return sum(root.left) + root.data + sum(root.right);
     }

    public static void main(String[] args) {
        // create hard coded tree
        //       26
        //      /  \
        //     10   3
        //    / \    \
        //   4  6     3
        Node root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);

        if (isSumTree(root))
            System.out.println("True");
        else
            System.out.println("False");
    }

}