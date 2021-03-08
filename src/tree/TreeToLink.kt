package tree

import tree.bean.BiTNode

/**
 * 如何把二叉树转换为双向链表
 * 输入一颗二元查找树，将该二元查找树转换成一个排序的双向链表。要求不能创建任何
新的结点，只能调整结点的指向
 */

private var pHead: BiTNode? = null
private var pEnd: BiTNode? = null

/**
 * 把二叉树转换双向链表
 */
fun inOrderBsToTree(root: BiTNode?) {
    if (null == root) {
        return
    }
    //转换root的左子树
    inOrderBsToTree(root.lChild)

    root.lChild = pEnd //使当前结点的左孩子指向双向链表中最后一个结点
    if (null == pEnd) {//双向列表为空,当前遍历的结点为双向链表的头结点
        pHead = root
    } else {//使双 向链表中最后一个结点的右孩子指向当前结点
        pEnd?.rChild = root
    }
    pEnd = root  //将当前结点设为双向链表中最后一个结点

    //转换root的右子树
    inOrderBsToTree(root.rChild)
}

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    val root = arrayToTree(arr, 0, arr.size - 1)
    inOrderBsToTree(root)
    var cur: BiTNode?
    println("转换后双向链表正向遍历：")
    cur = pHead
    while (cur != null) {
        print("${cur.data} ")
        cur = cur.rChild
    }
    println()
    println("转换后双向链表逆向遍历：")
    cur = pEnd
    while (cur != null) {
        print("${cur.data} ")
        cur = cur.lChild
    }
}
