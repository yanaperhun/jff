package easy.stack

import java.util.Stack

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 */

fun isValid(s: String): Boolean {
    println("s = $s")
    val setClosed = setOf(')', ']', '}')
    val stack = Stack<Char>()

    if (s.count { it == '(' } != s.count { it == ')' }) return false
    if (s.count { it == '{' } != s.count { it == '}' }) return false
    if (s.count { it == '[' } != s.count { it == ']' }) return false

    s.forEach { char ->
        if (char == '(' || char == '{' || char == '[') {
            stack.add(char)
        } else {
            if (stack.isEmpty() && setClosed.contains(char)) return false
            val element = stack.pop()
            if (char == '}' && element != '{') return false
            if (char == ')' && element != '(') return false
            if (char == ']' && element != '[') return false
        }
    }
    return stack.isEmpty()
}