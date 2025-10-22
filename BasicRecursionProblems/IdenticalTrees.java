package BasicRecursionProblems;

import java.util.LinkedList;
import java.util.Queue;

class IdenticalTrees {
    //Using DFS
    static boolean isIdentical(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        return (a.data == b.data) &&
                isIdentical(a.left, b.left) &&
                isIdentical(a.right, b.right);
    }

    //Using BFS
    static boolean isIdentical1(Node r1, Node r2) {
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.add(r1);
        q2.add(r2);

        while(!q1.isEmpty() && !q2.isEmpty()) {
            Node node1 = q1.poll();
            Node node2 = q2.poll();

            if(node1.data != node2.data) {
                return false;
            }

            if(node1.left != null && node2.left != null) {
                q1.add(node1.left);
                q2.add(node2.left);
            } else if (node1.left != null || node2.left != null) {
                return false;
            }

            if(node1.right != null && node2.right != null) {
                q1.add(node1.right);
                q2.add(node2.right);
            } else if (node1.right != null || node2.right != null) {
                return false;
            }
        }
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(4);

        Node t2 = new Node(1);
        t2.left = new Node(2);
        t2.right = new Node(3);
        t2.left.left = new Node(4);
        System.out.println("Identical: " + isIdentical(t1, t2));

        Node t3 = new Node(1);
        t3.left = new Node(4);
        t3.right = new Node(3);
        t3.left.left = new Node(2);

        Node t4 = new Node(1);
        t4.left = new Node(4);
        t4.right = new Node(3);
        t4.left.left = new Node(2);
        System.out.println("Identical: " + isIdentical1(t3, t4));// true

        Node t5 = new Node(1);
        t5.left = new Node(4);
        t5.right = new Node(3);
        t5.left.left = new Node(2);

        Node t6 = new Node(1);
        t6.left = new Node(6);
        t6.right = new Node(3);
        t6.left.left = new Node(2);
        System.out.println("Identical: " + isIdentical(t5, t6));
    }
}
