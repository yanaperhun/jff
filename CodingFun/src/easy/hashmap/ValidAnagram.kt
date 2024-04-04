package easy.hashmap

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 */

fun isAnagram(s: String, t: String): Boolean {

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
//    val sKeys = sHashMap.keys.toCharArray()
//    val tKeys = tHashMap.keys.toCharArray()
//    sKeys.sort()
//    tKeys.sort()
//    if (!sKeys.contentEquals(tKeys)) return false

    sHashMap.keys.forEach {
        if (!tHashMap.containsKey(it)) return false
        if (sHashMap[it] != tHashMap[it]) return false
    }
    return true
}