package tree;

import tree.bean.TreeNode;

import java.util.ArrayList;

public class BinaryTreeRecyleByFloor {
    static TreeNode root;
    static TreeNode realRoot;

    public static void initData(){
        ArrayList<Integer> list = new ArrayList<>();
//        for (int i=0; i< 10; i++){
//
//        insert((int) (Math.random()*10));
//        }
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 10);
        root = insert(root, 25);
        root = insert(root, 15);
    }

    public static void main(String[] args) {
        initData();
//        printTree(realRoot);
        ArrayList<TreeNode> temp = new ArrayList<>();
        temp.add(root);
        floorTree(temp);
    }

    //层序遍历
    public static void floorTree(ArrayList<TreeNode> floorList){
        ArrayList<TreeNode> list = new ArrayList<>();
        for (TreeNode treeNode : floorList){
            System.out.print(treeNode.data+" ");
            if (treeNode.left != null){
                list.add(treeNode.left);
            }
            if (treeNode.right != null){
                list.add(treeNode.right);
            }
        }
        System.out.println();
        if (!list.isEmpty()){
            floorTree(list);
        }
    }
    // 中序遍历
    public static void print(TreeNode node){
        if (node != null){
            if (node.left != null){
                print(node.left);
                System.out.println(node.data);
            }
            System.out.println(node.data);
            if (node.right != null){
                print(node.left);
                System.out.println(node.data);
            }
        }
    }
    //前序遍历
    private static void printTree(TreeNode tree) {
        System.out.println(tree.data);
        if (tree.left != null) {
            System.out.println("left: ");
            printTree(tree.left);

        }

        if (tree.right != null) {
            System.out.println("right: ");
            printTree(tree.right);
        }
    }

    private static TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value <= root.data) {// left
            root.left=insert(root.left, value);

        } else {//right
            root.right=insert(root.right, value);

        }
        return root;
    }}
