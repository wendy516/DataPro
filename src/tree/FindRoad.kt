package tree

import tree.bean.BiTNode
import java.util.*

/**
 * 如何在二叉树中找出与输入整数相等的所有路径
 * 为 6->3-> -1 ->- (6+3-1=8)
 */


/**
打印出满足所有结点数据的和等于 num 的所有路径
@param root 二叉树根结点
@param num 给定的整数
@pram s 当前路径上所有结点的和
@param v 用来存储从根结点到当前遍历到结点的路径
 **/
fun findRoad(root: BiTNode, num: Int, s: Int, v: Vector<Int>) {
    var sum = s
    sum += root.data
    v.add(root.data)

    if (root.lChild == null && root.rChild == null && sum == num) {
        v.forEach {
            print("${it}  ")
        }
        println()
    }
    root.lChild?.apply { findRoad(this,num,sum,v) }
    root.rChild?.apply { findRoad(this,num,sum,v) }
    sum -= v[v.size-1]
    v.removeAt(v.size-1)
}

fun main() {
    val root = constructTree()
    val s = Vector<Int>()
    print("满足路径结点和等于8路径为:")
    findRoad(root, 8, 0, s)
}









