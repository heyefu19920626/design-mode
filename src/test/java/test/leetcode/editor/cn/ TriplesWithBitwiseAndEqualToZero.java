package test.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * //给你一个整数数组 nums ，返回其中 按位与三元组 的数目。
 * //
 * // 按位与三元组 是由下标 (i, j, k) 组成的三元组，并满足下述全部条件：
 * //
 * //
 * // 0 <= i < nums.length
 * // 0 <= j < nums.length
 * // 0 <= k < nums.length
 * // nums[i] & nums[j] & nums[k] == 0 ，其中 & 表示按位与运算符。
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [2,1,3]
 * //输出：12
 * //解释：可以选出如下 i, j, k 三元组：
 * //(i=0, j=0, k=1) : 2 & 2 & 1
 * //(i=0, j=1, k=0) : 2 & 1 & 2
 * //(i=0, j=1, k=1) : 2 & 1 & 1
 * //(i=0, j=1, k=2) : 2 & 1 & 3
 * //(i=0, j=2, k=1) : 2 & 3 & 1
 * //(i=1, j=0, k=0) : 1 & 2 & 2
 * //(i=1, j=0, k=1) : 1 & 2 & 1
 * //(i=1, j=0, k=2) : 1 & 2 & 3
 * //(i=1, j=1, k=0) : 1 & 1 & 2
 * //(i=1, j=2, k=0) : 1 & 3 & 2
 * //(i=2, j=0, k=1) : 3 & 2 & 1
 * //(i=2, j=1, k=0) : 3 & 1 & 2
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [0,0,0]
 * //输出：27
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= nums.length <= 1000
 * // 0 <= nums[i] < 2¹⁶
 * //
 * //
 * // Related Topics 位运算 数组 哈希表 👍 69 👎 0
 */
class TriplesWithBitwiseAndEqualToZero {
    public static
        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 要取出三个数按位与，并且结果为0
         * <p>
         * 1. 假设前两位按位与结果为0， 则交换前两个数结果也为0， 并且第三个数可以为任意数
         *
         * @param nums
         * @return
         */
        public int countTriplets(int[] nums) {
            int result = 0;
            Map<Integer, Integer> tempResult = new HashMap<>();
            for (int j : nums) {
                for (int num : nums) {
                    int temp = j & num;
                    if (!tempResult.containsKey(temp)) {
                        tempResult.put(temp, 1);
                    } else {
                        tempResult.put(temp, tempResult.get(temp) + 1);
                    }
                }
            }
            for (Map.Entry<Integer, Integer> entry : tempResult.entrySet()) {
                if (entry.getKey() == 0) {
                    result += nums.length * entry.getValue();
                } else {
                    for (int num : nums) {
                        if ((entry.getKey() & num) == 0) {
                            result += entry.getValue();
                        }
                    }
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}