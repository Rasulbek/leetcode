package leetcode

fun main() {
//    println(CandyRating().candy(arrayOf(1, 2, 87, 87, 87, 2, 1).toIntArray()))
//    println(CandyRating().candy(arrayOf(1, 3, 2, 2, 1).toIntArray()))
//    println(CandyRating().candy(arrayOf(3, 2, 1, 0, 2).toIntArray()))
//    println(CandyRating().candy(arrayOf(1, 0, 2).toIntArray()))
//    println(CandyRating().candy(arrayOf(1, 2, 2).toIntArray()))
//    println(CandyRating().candy(arrayOf(1,3,4,5,2).toIntArray()))
//    println(CandyRating().candy(arrayOf(10,10,10,10,10,10).toIntArray()))
    println(CandyRating().candy(arrayOf(5, 1, 1, 1, 10, 2, 1, 1, 1, 3).toIntArray()))
}

class CandyRating {

    var osyapti = false
    var kamayyapti = false
    lateinit var balls: IntArray

    var left = 0
    var right = 0
    fun candy(ratings: IntArray): Int {
        if (ratings.size == 1) return 1
        balls = IntArray(ratings.size)
        balls[0] = 1
        var i = 1
        var b = true
        while (b) {
            if (i >= ratings.size) break
            if (ratings[i] > ratings[i - 1]) {
                if (kamayyapti) {
                    kamayishniHisobla(i)
                    left = i - 1
                }
                osyapti = true
                right = i
                i++
                if (i < ratings.size) continue
            }
            if (osyapti) {
                osishniHisobla(i)
                continue
            }

            if (ratings[i] < ratings[i - 1]) {
                if (osyapti) {
                    osishniHisobla(i)
                    left = i - 1
                }
                if (!kamayyapti) left = i - 1
                kamayyapti = true
                right = i
                i++
                if (i < ratings.size) continue
            }

            if (kamayyapti) {
                kamayishniHisobla(i)
                continue
            }

            if (ratings[i] == ratings[i - 1]) {
                balls[i] = 1
                left = i
            }
            i++
            if (i >= ratings.size) b = false
        }
        return balls.sum()
    }

    fun kamayishniHisobla(i: Int) {
        kamayyapti = false
        var mx = right - left + 1
        var j = left
        while (j <= right) {
            if (balls[j] < mx) balls[j] = mx
            mx--
            j++
        }
        left = i
        right = i
    }

    fun osishniHisobla(i: Int) {
        osyapti = false
        var j = right
        var mx = right - left + 1
        while (j >= left) {
            balls[j] = mx
            mx--
            j--
        }
        left = i
        right = i
    }

}