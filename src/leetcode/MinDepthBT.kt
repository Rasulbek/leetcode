package leetcode


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class MinDepthBT {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        if (root?.left == null && root?.right == null) {
            return 1
        }
        val leftD = if (root.left == null) {
            1001
        } else {
            minDepth(root.left)
        }
        val rightD = if (root.right == null) {
            1001
        } else {
            minDepth(root.right)
        }
        val min = if (leftD < rightD) leftD else rightD
        return min + 1
    }
}