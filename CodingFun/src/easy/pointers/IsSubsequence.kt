package easy.pointers

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting
 * some (can be none) of the characters without disturbing the relative positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 * Input: s = "ab", t = "baab"
 * Output: true
 */

fun isSubsequence(s: String, t: String): Boolean {
    if (s.isEmpty()) return true
    var index = 0
    t.toCharArray().forEach { currentChar ->
        if (index == s.length) return true
        if (currentChar == s[index]) index = index.inc()
    }
    return s.length == index
}