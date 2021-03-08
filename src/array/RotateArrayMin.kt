package array

/**
 * 如何找出旋转数组中的最小元素
 * {3,4,5,1,2} ->{1,2,3,4,5}  前面为后面一个数组的旋转
 */

fun getMin(arr: IntArray, low: Int, high: Int): Int {
    //
    if (high < low) {
        return arr[0]
    }

    if (high == low) {
        return arr[low]
    }

    val mid = low + (high - low shr 1)

    return when {
        arr[mid] < arr[mid - 1] -> arr[mid]
        arr[mid + 1] < arr[mid] -> arr[mid + 1]
        arr[high] > arr[mid] -> getMin(arr, low, mid - 1)
        arr[mid] > arr[low] -> getMin(arr, mid + 1, high)
        else -> {
            Math.min(getMin(arr, low, mid - 1), getMin(arr, mid + 1, high))
        }
    }
}

fun getMin(arr: IntArray): Int {
    return getMin(arr, 0, arr.size - 1)
}

fun main(args: Array<String>) {
    val arr = intArrayOf(5, 6, 1, 2, 3, 4)
    var min = getMin(arr)
    println(min)
    val arr2 = intArrayOf(1, 1, 0, 1)
    min = getMin(arr2)
    println(min)
}