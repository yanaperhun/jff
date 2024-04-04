package mid.hashmap

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 */

fun groupAnagrams(strs: Array<String>): List<List<String>> {

    val result = mutableListOf<List<String>>()

    val mutableList = strs.toMutableList()

    var i = 0
    var size = mutableList.size

    while (size > 0) {

        val s = mutableList.first()
        println("start process [ $s ]")
        val anagrams = mutableListOf(s)
        val subList = mutableList.subList(1, mutableList.size).toList()

        println("sublist  ${subList.joinToString()}")
        subList.forEach { t ->
            println("s = $s, t = $t")
            if (isAnagram1(s, t)) {
                println("try add")
                anagrams.add(t)
                mutableList.subList(1, mutableList.size).remove(t)
            }
        }
        mutableList.removeFirst()
        size = mutableList.size
        i++
        println("add ${anagrams.joinToString()}")
        result.add(anagrams)
    }
    println("result -> ${result.joinToString { it.joinToString(" ") }}")
    return result
}

fun isAnagram1(s: String, t: String): Boolean {

    if (s.length != t.length) return false
    val sHashMap = hashMapOf<Char, Int>()
    val tHashMap = hashMapOf<Char, Int>()

    val l = s.length - 1
    for (i in 0..l) {
        val sCount = sHashMap.getOrDefault(s[i], 0)
        val tCount = tHashMap.getOrDefault(t[i], 0)

        sHashMap[s[i]] = sCount.inc()
        tHashMap[t[i]] = tCount.inc()
    }

    sHashMap.keys.forEach {
        if (!tHashMap.containsKey(it)) return false
        if (sHashMap[it] != tHashMap[it]) return false
    }
    return true
}