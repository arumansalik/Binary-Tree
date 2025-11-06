package Problems;

import com.sun.source.tree.Tree;

import java.util.*;

class Pair {
    Node node;
    int hd;
    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class TopViewOfBinaryTree {
    public static List<Integer> topView(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while(!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int hd = current.hd;

            if(!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            if(node.left != null) queue.offer(new Pair(node.left, hd - 1));
            if(node.right != null) queue.offer(new Pair(node.right, hd  +1));
        }
        ans.addAll(map.values());
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        List<Integer> result = topView(root);

        System.out.println("Top view of Binary Tree: ");
        for(int val : result) System.out.print(val + " ");
    }
}
