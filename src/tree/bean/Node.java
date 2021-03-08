package tree.bean;

/**
 * 路径总和 是否等于某个值
 */

public class Node {
    public int distance = -1;
    public Node left;
    public Node right;
    public Node parent;
    public int pre;


    public Node(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Node{" +
                "distance=" + distance +
                ", left.distance=" + (left == null ? -1 : left.distance) +
                ", right.distance=" + (right == null ? -1 : right.distance) +
                '}';
    }
}
