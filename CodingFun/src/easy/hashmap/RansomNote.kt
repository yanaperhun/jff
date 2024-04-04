package easy.hashmap

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed
 * by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 */

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    if (ransomNote == magazine) return true
    val magazineHashMap = HashMap<Char,Int>()
    val ransomNoteHashMap = HashMap<Char,Int>()

    magazine.forEach { char ->
        val charCount = magazineHashMap.getOrDefault(char, 0)
        magazineHashMap[char] = charCount.inc()
    }

    ransomNote.forEach { char ->
        val charCount = ransomNoteHashMap.getOrDefault(char, 0)
        ransomNoteHashMap[char] = charCount.inc()
    }

    ransomNoteHashMap.entries.forEach {
        if (it.value > magazineHashMap.getOrDefault(it.key , -2)) {
            return false
        }
    }
    return true

}