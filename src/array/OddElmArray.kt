package array

/**
 * 如何找出数组中出现奇数次的数
 * 数组中有 N+2 其中N数出现了偶数次 两个数出现了奇数次（这两个数不相
等〉 请用 0(1 ）的空间复杂度，找出这两个数。注意：不需要知道具体位置，只需要找出这两个数。
 * 方法1：Hash法
 * 方法2：亦或法
 * 原理：异或性质：当两个数相同，为假，不同为真
 */

fun get2Num(arr: IntArray) {

    if (arr.isEmpty()) {
        return
    }
    val map = hashMapOf<Int,Int>()

    for (i in 0 until arr.size){
        //首次出现
        if (!map.containsKey(arr[i])){
            map.put(arr[i],1)
        }else{
            //第二次出现
            map.put(arr[i],0)
        }
    }

    map.entries.iterator().forEach {
        if (it.value ==1){
            println(it.key)
        }
    }
}


fun main() {
    val arr = intArrayOf(3,5,6,6,5,7,2,2)
    println(get2Num(arr))
}