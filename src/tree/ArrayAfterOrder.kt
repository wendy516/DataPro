package tree

import tree.bean.BiTNode

/**
 * 如何判断一个数组是否是二元查找树后序遍历的序列
 * 输入 个整数数组，判断该数组是否是某 元查找树的后序遍历的结果。如果是，那么返回 true ，否则返回 false 。例如数组｛ 1,3,2,5,7,6 4｝就是下图中二叉树的后序遍历序列
 */


//如何判断一个数组是否是二元查找树后序遍历的序列
fun isAfterOrder(arr: IntArray?, start: Int, end: Int): Boolean {
    if (arr == null) {
        return false
    }
    val root = arr[end]
    var i: Int = start
    var j: Int
    while (i < end) {
        if (arr[i] > root)
            break
            i++
    }
    j = i
    while (j < end) {
        if (arr[j] < root)
            return false
            j++
    }
    var leftIsAfterOrder = true
    var rightIsAfterOrder = true
    if (i > start) {
        leftIsAfterOrder = isAfterOrder(arr, start, i - 1)
    }
    if (j < end) {
        rightIsAfterOrder = isAfterOrder(arr, i, end)
    }
    return leftIsAfterOrder && rightIsAfterOrder
}
fun main() {
    val arr= intArrayOf(1, 3, 2, 5, 7, 6, 4)
    val result= isAfterOrder(arr, 0, arr.size - 1)
    for (i in arr.indices)
        print("${arr[i]} ")
    if (result)
        println("是某一二元查找树的后续遍历序列")
    else
        println("不是某一二元查找树的后续遍历序列")
}