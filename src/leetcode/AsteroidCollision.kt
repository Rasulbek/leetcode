package leetcode

import java.util.Stack


fun main() {
    var test1 = arrayOf(5, 10, -5).toIntArray()
//    test1 = arrayOf(8, -8).toIntArray()
    test1 = arrayOf(10, 2, -5).toIntArray()
//    test1 = arrayOf(-2,-2,1,-2).toIntArray()

    AsteroidCollision().asteroidCollision(test1).forEach {
        print("$it, ")
    }
}

class AsteroidCollision {

    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = Stack<Int>()

        asteroids.forEach {
            if (stack.isEmpty()) {
                stack.add(it)
            } else {
                var peek = stack.peek()
                val sameDirection = (peek < 0 && it < 0) || (peek > 0 && it > 0)
                if (sameDirection || it > 0) {
                    stack.add(it)
                } else {
                    while (true) {
                        if ((peek < 0 && it < 0) || (peek > 0 && it > 0)) {
                            stack.add(it)
                            break
                        }
                        if (peek + it == 0) {
                            stack.pop()
                            break
                        }
                        if (peek > Math.abs(it)) {
                            break
                        }
                        stack.pop()
                        if (stack.isEmpty()) {
                            stack.add(it)
                            break
                        }
                        peek = stack.peek()
                    }
                }
            }
        }
        return stack.toIntArray()
    }
}