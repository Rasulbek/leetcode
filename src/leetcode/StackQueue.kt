package leetcode

import java.util.Stack

fun main() {
    println(MyStack().push(1))
}
class MyStack() {
    var f1 = 0
    val stack = mutableListOf<Short>()
    fun push(x: Int) {
        f1++
        if (f1 > stack.size) {

        }
        stack.add(f1, x.toShort())
    }

    fun pop(): Int {
        return stack[--f1].toInt()
    }

    fun top(): Int {
        return stack[f1-1].toInt()
    }

    fun empty(): Boolean {
        return f1==0
    }


}