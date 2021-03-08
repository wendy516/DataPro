package tree;

import tree.bean.TreeNode;

import java.util.ArrayList;

/**
 * 层级遍历 --构建树
 */
public class TierCreateTree {
    public static void main(String[] args) {
        int[] data = new int[]{5,4,8,11,0,13,4,7,2,0,0,0,1};
        TreeNode root = createTree(data,0);
        print(root);
    }

    //层级遍历
    public static TreeNode createTree(int[] treedata, int n) {
        if (treedata.length == 0){
            return null;
        }
        if (n < treedata.length){
            int left = n*2+1;
            int right = n*2+2;
            TreeNode treeroot = new TreeNode(treedata[n],createTree(treedata,left),createTree(treedata,right));
            return treeroot;
        }
        return null;
    }
    public static void print(TreeNode node){
        if (node != null){
            if (node.left != null){
                print(node.left);
            }
            System.out.println(node.data);
            if (node.right != null){
                print(node.left);
            }
        }
    }
}

