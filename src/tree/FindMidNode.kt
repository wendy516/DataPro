package tree

import tree.bean.BiTNode
import java.util.*
import kotlin.math.min

/**
 * 如何在二叉排序树中找出第－个大于中间值的结点
 */

//查询值最小的节点
fun getMinNode(root: BiTNode): BiTNode{
    var rootNode = root
    while (true){
        rootNode = rootNode.lChild?:break
    }
    return rootNode
}
//查询值最大的节点
fun getMaxNode(root: BiTNode): BiTNode{
    var rootNode = root
    while (true){
        rootNode = rootNode.rChild?:break
    }
    return rootNode
}

private fun getNode(root: BiTNode):BiTNode?{
    val maxNode = getMaxNode(root)
    val minNode = getMinNode(root)
    val mid = (minNode.data + maxNode.data)/2
    var result : BiTNode? = null
    var node : BiTNode? = root
    while (node != null){
        if (node.data <= mid){
            node = node.rChild
        }else{
            result = node
            node = node.lChild
        }
    }
    return result
}


fun main() {
    val arr = intArrayOf(1,2,3,4,5,6,7)
    val root: BiTNode?
    root = arrayToTree(arr,0,arr.size-1)
    root?.apply {
        println(getNode(this)?.data)
    }
}

