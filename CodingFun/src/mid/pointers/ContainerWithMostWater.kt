package mid.pointers

import kotlin.math.max
import kotlin.math.min

/**
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Input: height = [2,3,4,5,18,17,6]
 * Output: 17
 *
 *
 *
 */

fun maxArea(height: IntArray): Int {
    val len = height.size
    val range = len / 2
    var startIndex = 0
    var endIndex = len - 1

    var biggestArea = 0
    while(startIndex <= endIndex) {

        val startPoint = height[startIndex]
        val endPoint = height[endIndex]

        val widthArea = endIndex - startIndex
        val heightArea = min(height[startIndex], height[endIndex])

        if (widthArea * heightArea > biggestArea) {
            biggestArea = widthArea * heightArea
        }

        var stepped = false
        if (height[startIndex] >=  height[endIndex]) {
            println("==>")
            while (height[endIndex] <= endPoint && endIndex > startIndex) {
                stepped = true
                endIndex = endIndex.dec()
                if (endIndex > startIndex) break
                println("dec end index $endIndex")
            }
        } else {
            while (height[startIndex] <= startPoint) {
                stepped = true
                startIndex = startIndex.inc()
                if (endIndex > startIndex) break
                println("inc start index $startIndex")
            }
        }
        println("biggest area : $biggestArea startIndex = $startIndex endIndex = $endIndex")
        if (!stepped) break
    }

    return biggestArea
}

fun calcArea(width: Int, height: Int) {

}
