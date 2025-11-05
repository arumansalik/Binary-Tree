package Problems;

import java.util.*;

public class RightSideView {
    public static List<Integer> rightSideView(Node root) {
        List<Integer> res = new ArrayList<>();

        rightSide(root, 0, res);

        return res;
    }

    private static void rightSide(Node node, int level, List<Integer> res) {
        if(node == null) return;

        if (level == res.size()) {
            res.add(node.data);
        }

        rightSide(node.right, level + 1, res);
        rightSide(node.left, level + 1, res);
    }
}
