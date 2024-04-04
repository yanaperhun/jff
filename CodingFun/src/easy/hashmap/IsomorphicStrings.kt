package easy.hashmap

import java.lang.reflect.Array
import java.util.*
import kotlin.collections.HashMap

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 *
 */

fun isIsomorphic(s: String, t: String): Boolean {
    println("s = $s; t = $t")
    if (s == t) return true
    val sHashMap = HashMap<Char,Int>()
    val tHashMap = HashMap<Char,Int>()

    s.forEach { char ->
        println(char)
        val charCount = sHashMap.getOrDefault(char, 0)
        sHashMap[char] = charCount.inc()
    }

    t.forEach { char ->
        val charCount = tHashMap.getOrDefault(char, 0)
        tHashMap[char] = charCount.inc()
    }

    val setS = sHashMap.values.toIntArray()
    val setT = tHashMap.values.toIntArray()
    if (setS.size != setT.size) return false
    setS.forEachIndexed { index, i ->
        if (setT[index] != i) return false
    }
    println("SetS = ${setS.joinToString(", ")}; SetT = ${setT.joinToString(", ")}")
    return (Arrays.equals(setT, setS))
}