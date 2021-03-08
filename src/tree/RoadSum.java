package tree;
import tree.bean.Node;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 路径总和 是否等于某个值
 */
class RoadSum {
    private static Node root;


    public static void main(String[] args) {
        int[] ints={5,4,8,11,13,6,7,2,1};

//        System.out.println("构造树: ");
        createTree(ints);
        printTree(root);

//        System.out.println("计算路劲: ");
        int sumTarget=19;
        hasRoadBy(sumTarget,root,0);

        ArrayList<Integer> list = new ArrayList();
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.left == null && root.right == null){
                list.add(root.pre);
            }
            root = root.right;
        }
        for (int a: list) {
            System.out.print(a+" ");
        }
    }

    static void createTree(int[] source) {
        final int[] values = source;
        for (int i = 0; i < values.length; i++) {
            insert(new Node(values[i]));
        }
    }

    private static void insert(Node node) {
        if (root == null) {
            root = node;
            return;
        }

        Node base = root;
        while (base != null) {

            if (node.distance < base.distance) {
                if (base.left == null) {
                    base.left=node;
                    return;
                }
                base = base.left;
            } else {
                if (base.right == null) {
                    base.right=node;
                    return;
                }
                base = base.right;
            }

        }
    }

    private static void hasRoadBy(int sumTarget, Node root,int preResult) {

        if (root == null){
            return;
        }
        preResult = preResult + root.distance;
        root.pre = preResult;
        if (root.left != null){
            hasRoadBy(sumTarget,root.left,preResult);
        }
        if (root.right != null){
            hasRoadBy(sumTarget,root.right,preResult);
        }
    }
    private static void printTree(Node tree) {
        System.out.println(tree.toString());
        if (tree.left != null) {
            System.out.println("left: ");
            printTree(tree.left);

        }

        if (tree.right != null) {
            System.out.println("right: ");
            printTree(tree.right);
        }
    }
}
