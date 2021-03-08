package recursion

import recursion.bean.ListNode

/**
 * 1-》2-》4
 * 1-》3-》4
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 1,1,2,3,4,4
 */

var root1 : ListNode? = null
var root2 : ListNode? = null

fun mergeTwoLists(l1: ListNode?, l2: ListNode?) :ListNode?{
   if (l1 == null) return l2
   if (l2 == null) return l1
    var res :ListNode?
    if (l1.value < l2.value){
        res =l1
        res.next = mergeTwoLists(l1.next,l2)
    }else{
        res = l2
        res.next = mergeTwoLists(l1,l2.next)
    }
    return res
}
fun createNode(){
    root1 = ListNode(1, ListNode(2, ListNode(4,null)))
    root2 = ListNode(1, ListNode(3,ListNode(4,null)))
}
fun main() {
    createNode()
 var res =  mergeTwoLists(root1, root2)
    while (res != null){
        println(res.value)
        res = res.next
    }
}
