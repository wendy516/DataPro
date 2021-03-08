package tree

import tree.bean.BiTNode

/**
 *如何求－棵二叉树的最大子树和
 * 给定二叉树，它的每个结点都是正整数或负整数，如何找到一棵子树，使得它所有结点的和最大？
 */

private var maxSum = Integer.MIN_VALUE
//后续遍历
fun findMaxSubTree(root: BiTNode?, maxRoot: BiTNode): Int {
    if (root == null) {
        return 0
    }
    println("入栈："+root.data)
    val lMax = findMaxSubTree(root.lChild, maxRoot)
    val rMax = findMaxSubTree(root.rChild, maxRoot)
    var sum = lMax + rMax + root.data
    if (sum > maxSum) {
        maxSum = sum
        maxRoot.data = root.data
    }
    println("          出栈："+root.data)
    return sum
}

//构建树
fun constructTree(): BiTNode {
    val root = BiTNode()
    val node1 = BiTNode()
    val node2 = BiTNode()
    val node3 = BiTNode()
    val node4 = BiTNode()
    root.data = 6
    node1.data = 3
    node2.data = -7
    node3.data = -1
    node4.data = 9
    root.lChild = node1
    root.rChild = node2
    node1.lChild = node3
    node1.rChild = node4
    node4.rChild = null

    node4.lChild = node4.rChild
    node3.rChild = node4.lChild
    node3.lChild = node3.rChild
    node2.rChild = node3.lChild
    node2.lChild = node2.rChild
    return root
}

fun main(args: Array<String>) {
    val root = constructTree()
    val maxRoot = BiTNode()
    findMaxSubTree(root, maxRoot)
    print("最大子树和为：${maxSum}")
    print("对应子树的根节点为：${maxRoot.data}")
}
