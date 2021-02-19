package recursion;

/**
 *用链表实现  1，2，3，4  -》 2，1 ，4，3
 */
public class LinkReverseTest {

    public static void main(String[] args) {
        Node root = initData();
        Node root1 = initData();
        while (root1 != null) {
            System.out.print(root1.data);
            root1 = root1.next;
        }
        System.out.println("---------------------------------");
        reverseNode(root);
        root = root.next;
        while (root != null) {
            System.out.print(root.data);
            root = root.next;
        }
    }


    public static void reverseNode(Node node) {
        //跳出循环条件
        // 判断下个节点 及 下下个节点是否为空
        if (node.next == null || node.next.next == null || node.next.next.next ==null) {
            return;
        }
        Node nextNode = node.next;
        Node next2Node = nextNode.next;
        nextNode.next = next2Node.next;
        next2Node.next = nextNode;
        node.next = next2Node;

        if (node.next!=null && node.next.next!=null){
            reverseNode(node.next.next);
        }
    }

    public static Node initData() {
        Node head = new Node();
        head.data = "1";
        Node root = head;
        for (int i = 1; i < 10; i++) {
            Node node = new Node();
            node.data = i + "";
            head.next = node;
            head = node;
        }
        return root;
    }
}

class Node {
    String data;
    Node next;
    public Node() {
    }
}


