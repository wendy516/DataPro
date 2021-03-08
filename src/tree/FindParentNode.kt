package tree

import tree.bean.BiTNode
import java.util.*

/**
 * 如何找出排序二叉树上任意两个结点的
 * 最近共同父结点
 * 方法1：路径对比法
 * 方法2：后续遍历法（扩展）
 */
//摄取二叉树从根结点root到node结点的路径
fun getPathFromRoot(root: BiTNode?, node: BiTNode?, s: Stack<BiTNode>): Boolean {
    if (root == null) {
        return false
    }
    if (root == node) {
        s.push(root)
        return true
    }
    if (getPathFromRoot(root.lChild, node, s) || getPathFromRoot(root.rChild, node, s)) {
        s.push(root)
        return true
    }
    return false
}

fun findParentNode(root: BiTNode, node1: BiTNode?, node2: BiTNode?): BiTNode? {
    val stack1 = Stack<BiTNode>()
    val stack2 = Stack<BiTNode>()
    getPathFromRoot(root,node1,stack1)
    getPathFromRoot(root,node2,stack2)
    var commonParent : BiTNode? = null
    while (stack1.peek() == stack2.peek()){
        commonParent = stack1.peek()
        stack1.pop()
        stack2.pop()
    }
    return commonParent
}

fun main() {
    var arr = intArrayOf(1,2,3,4,5,6,7,8,9,10)
    val root = arrayToTree(arr,0,arr.size-1)
    val node1 = root?.lChild?.lChild?.lChild
    val node2 = root?.lChild?.rChild
    val res = root?.let {
        findParentNode(it,node1,node2)
    }
    if (res != null){
        print("${node1?.data.toString()}与${node2?.data.toString()}的最近父节点为：${res.data}")
    }else{
        print("没有父节点")
    }
}





