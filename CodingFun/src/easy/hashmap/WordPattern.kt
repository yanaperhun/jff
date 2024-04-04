package easy.hashmap

/**
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 *
 *
 * Example 1:
 *
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 */
fun wordPattern(pattern: String, s: String): Boolean {
    val words = s.split(" ")
    if (pattern.length != words.size) return false

    val pHashMap = HashMap<Char, MutableList<Int>>()
    val sHashMap = HashMap<String, MutableList<Int>>()
    pattern.toCharArray().forEachIndexed { index, c ->
        if (pHashMap.containsKey(c)) {
            val array = pHashMap.getOrDefault(c, mutableListOf())
            array.add(index)
            pHashMap[c] = array
        } else {
            pHashMap[c] = mutableListOf(index)
        }
    }

    words.forEachIndexed { index, str ->
        if (sHashMap.containsKey(str)) {
            val array = sHashMap.getOrDefault(s, mutableListOf())
            array.add(index)
            sHashMap[str] = array
        } else {
            sHashMap[str] = mutableListOf(index)
        }
    }
    pattern.toCharArray().forEachIndexed { index, char ->
        val string = words[index]
        val charArray = pHashMap[char]
        val stringArray = sHashMap[string]

        if (charArray != stringArray) return false
    }
    return true
}
