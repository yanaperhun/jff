package easy.stack

import java.util.Stack

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