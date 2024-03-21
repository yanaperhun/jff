package easy.pointers

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Input: s = "race a car"
 * Output: false
 */
fun isPalindrome(s: String): Boolean {
    val trimmed = s.trim().filter { it.isLetter() }.lowercase()
    if (trimmed.isEmpty()) return true

    val range = trimmed.length / 2

    for (i in 0..range) {
        if (trimmed[i] != trimmed[trimmed.length - 1 - i]) {
            return false
        }
    }
    return true
}