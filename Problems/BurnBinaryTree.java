package Problems;

import java.util.*;

public class BurnBinaryTree {
    public static int minTime(Node root, int target) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(root, null, graph);

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(target);
        visited.add(target);

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                for(int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                    if(!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                        burned = true;
                    }
                }
            }
            if (burned) time++;
        }
        return time;
    }

    private static void buildGraph(Node node, Node parent, Map<Integer, List<Integer>> graph) {
        if(node == null) return;

        if(parent != null) {
            graph.computeIfAbsent(node.data, k -> new ArrayList<>()).add(parent.data);
            graph.computeIfAbsent(parent.data, k -> new ArrayList<>()).add(node.data);
        }
        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }
    public static void main(String[] args) {
        // Build Binary Tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.left.right = new Node(7);

        int target = 1; // fire starts from node 1

        int time = minTime(root, target);
        System.out.println("🔥 Minimum time to burn the tree: " + time);
    }
}
