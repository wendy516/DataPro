package tree

/**
 * 如何把－个有序整数数组放到二叉树中
 * 分析解答：
 * 如果要把 个有序的 数数组放到 叉树中，那么所构造出来的 叉树必定也是一
 * 序的 叉树。鉴于此，实现思路是：取数组的中间元素作为根结点，将数组分成 右两部分，
 * 对数组的两部分用递归的方法分别构建左右子树。
 */
class ArrrayToTree {
    //方法功能：把有序数组转换为二叉树
    fun arrayToTree(arr: IntArray, start: Int, end: Int): BiTNode? {
        var root: BiTNode?
        if (end >= start) {
            root = BiTNode()
            val mid = (start + end + 1) / 2
            root.data = arr[mid]
            root.lChild = arrayToTree(arr, start, mid - 1)
            root.rChild = arrayToTree(arr, mid + 1, end)
        }else{
            root = null
        }
        return root
    }
    //中序遍历
    fun printTreeMidOrder(root: BiTNode?) {
        if (root == null){
            return
        }
        if (root.lChild != null){
            printTreeMidOrder(root.lChild)
        }
        print("${root.data} ")
        if (root.rChild != null){
            printTreeMidOrder(root.rChild)
        }
    }
}

class BiTNode {
    var data: Int = 0
    var lChild: BiTNode? = null
    var rChild: BiTNode? = null
}

fun main(args: Array<String>) {
    var toTree = ArrrayToTree()
    val arr=  intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var root = toTree.arrayToTree(arr,0,arr.size-1)
    toTree.printTreeMidOrder(root)
}