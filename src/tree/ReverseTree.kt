package tree

import tree.bean.BiTNode
import java.util.*

/**
 * 如何对二叉树进行镜像反转
 */

fun reverseTree(root: BiTNode?){
    if (root == null) return
    reverseTree(root.lChild)
    reverseTree(root.rChild)
    var temp = root.lChild
    root.lChild = root.rChild
    root.rChild = temp
}
//层序打印二叉树
fun printTreeLayer(root:BiTNode?){
    if (root == null) return
    var p: BiTNode
    val queue = LinkedList<BiTNode>()
    queue.offer(root)
    while (queue.size>0){
        p = queue.poll()
        print("${p.data} ")
        if (p.lChild != null){
            queue.offer(p.lChild)
        }
        if (p.rChild != null){
            queue.offer(p.rChild)
        }

    }
}

fun main() {
    val arr = intArrayOf(1,2,3,4,5,6,7)
    val root: BiTNode?
    root = arrayToTree(arr,0,arr.size-1)
    println("二叉树的层序遍历为：")
    printTreeLayer(root)
    println()
    reverseTree(root)
    println("反转后的二叉树的层序遍历为：")
    printTreeLayer(root)
}

