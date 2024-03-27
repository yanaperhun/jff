package mid.pointers

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 */

fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()

    for (i in 0..nums.size - 1) {
        var startIndex = i + 1
        var endIndex = nums.size - 1
        if (i > 0 && nums[i] == nums[i - 1]) continue

        while (startIndex < endIndex) {
            val sum = nums[i] + nums[startIndex] + nums[endIndex]
            if (sum == 0) {
                result.add(listOf(nums[i], nums[startIndex], nums[endIndex]))
                val prev = nums[startIndex]
                while (nums[startIndex] == prev && startIndex < endIndex) {
                    startIndex++
                }
            } else if (sum > 0) {
                endIndex--
            } else {
                startIndex++
            }
        }
    }
    return result
}
