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
         * 从右到左再次遍历sums，假设当前位为j，设满足题解的左位数索引为i，则sum[j] - sum[i] = 0
         * 遍历满足的i，记录j-i的最大值
         *
         * @param array
         * @return
         */
        public String[] findLongestSubarray(String[] array) {
            int len = array.length;
            if (len < 1) {
                return new String[]{};
            }
            int[] sums = new int[len];
            char first = array[0].charAt(0);
            sums[0] = first >= '0' && first <= '9' ? 1 : -1;
            // Map<Integer, Integer> map = new HashMap<>();
            // map.put(sums[0], 1);
            Map<Integer, List<Integer>> mapIndex = new HashMap<>();
            List<Integer> start = new ArrayList<>();
            start.add(0);
            mapIndex.put(sums[0], start);
            for (int i = 1; i < array.length; i++) {
                char cu = array[i].charAt(0);
                if (cu >= '0' && cu <= '9') {
                    sums[i] = sums[i - 1] + 1;
                } else {
                    sums[i] = sums[i - 1] - 1;
                }
                // map.put(sums[i], map.getOrDefault(sums[i], 0) + 1);
                mapIndex.getOrDefault(sums[i], new ArrayList<>()).add(i);
            }

            int st = -1, end = -1, res = 0;
            for (int i = len - 1; i >= 0; i--) {
                List<Integer> list = mapIndex.get(sums[i]);
                if (list == null || list.size() < 2) {
                    continue;
                }
                for (Integer cur : list) {
                    if (i - cur > res) {
                        res = i - cur;
                        st = cur;
                        end = i;
                    }
                }
            }
            if (res == 0) {
                return new String[]{};
            }
            String[] result = new String[res];
            int j = 0;
            for (int i = st + 1; i < end + 1; i++) {
                result[j] = array[i];
                j++;
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}