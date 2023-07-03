//给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。 
//
// 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。 
//
// 示例 1: 
//
// 
//输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K",
//"L","M"]
//
//输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
// 
//
// 示例 2: 
//
// 
//输入: ["A","A"]
//
//输出: []
// 
//
// 提示： 
//
// 
// array.length <= 100000 
// 
// Related Topics 数组 哈希表 前缀和 👍 170 👎 0

package test.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLongestSubarrayLcci {
    public static
        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 数组转换、前缀和、哈希表
         * <p>
         * 从左到右遍历，如果该位位数字，则记为1，否则记为-1
         * <p>
         * 求和为0的最长子数组：
         * 数组转换后求前缀后sums
         * 遍历sums,记录每个sum出现的次数
         * 从右到左再次遍历sums，假设当前位为j，设满足题解的左位数索引为i，则sum[j] - sum[i-1] = 0
         * 遍历满足的i，记录j-i的最大值
         * 时间复杂度: O(n*n)
         * <p>
         * 优化版:
         * 求和为0的最长子数组,并且左侧的索引要尽可能的小：
         * 从右到左遍历,计算前缀和sums，假设当前位为j，设满足题解的左位数索引为i，则sum[j] - sum[i-1] = 0
         * 因为左侧索引要尽可能的小,所以i记录最小值即可
         *
         * @param array
         * @return
         */
        public String[] findLongestSubarray(String[] array) {
            int sum = 0;
            Map<Integer, Integer> sumFirstIndex = new HashMap<>();
            // 如果有前缀和为0,则可以左侧可以从-1开始计算
            sumFirstIndex.put(0, -1);
            int res = 0;
            int start = 0;
            for (int i = 0; i < array.length; i++) {
                if (Character.isLetter(array[i].charAt(0))) {
                    sum--;
                } else {
                    sum++;
                }
                if (sumFirstIndex.containsKey(sum)) {
                    int firstIndex = sumFirstIndex.get(sum);
                    if (i - firstIndex > res) {
                        res = i - firstIndex;
                        start = firstIndex + 1;
                    }
                } else {
                    sumFirstIndex.put(sum, i);
                }
            }
            if (res == 0) {
                return new String[]{};
            }
            String[] result = new String[res];
            System.arraycopy(array, start, result, 0, res);
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}