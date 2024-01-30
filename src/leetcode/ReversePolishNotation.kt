package leetcode

import java.util.*

fun main() {
    println(ReversePolishNotation().evalRPN(arrayOf("2")))
    println(ReversePolishNotation().evalRPN(arrayOf("2", "3")))
    println(ReversePolishNotation().evalRPN(arrayOf("2", "1", "+", "3", "*")))
    println(ReversePolishNotation().evalRPN(arrayOf("4", "13", "5", "/", "+")))
    println(
        ReversePolishNotation().evalRPN(
            arrayOf(
                "10",
                "6",
                "9",
                "3",
                "+",
                "-11",
                "*",
                "/",
                "*",
                "17",
                "+",
                "5",
                "+"
            )
        )
    )
}

class ReversePolishNotation {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        var a: Int
        tokens.forEach {
            if (it != "+" && it != "-" && it != "*" && it != "/") {
                stack.push(it.toInt())
            } else {
                a = stack.pop()
                stack.push(
                    when (it) {
                        "-" -> {
                            stack.pop() - a
                        }

                        "*" -> {
                            a * stack.pop()
                        }

                        "/" -> {
                            stack.pop() /a
                        }

                        else -> {
                            a + stack.pop()
                        }
                    }
                )
            }
        }
        return stack.pop()
    }
}