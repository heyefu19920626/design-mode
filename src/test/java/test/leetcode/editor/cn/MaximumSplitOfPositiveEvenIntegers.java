package test.leetcode.editor.cn;

// 给你一个整数 finalSum 。请你将它拆分成若干个 互不相同 的正偶数之和，且拆分出来的正偶数数目 最多 。
//
// 
// 比方说，给你 finalSum = 12 ，那么这些拆分是 符合要求 的（互不相同的正偶数且和为 finalSum）：(2 + 10) ，(2 + 4 +
// 6) 和 (4 + 8) 。它们中，(2 + 4 + 6) 包含最多数目的整数。注意 finalSum 不能拆分成 (2 + 2 + 4 + 4) ，因为拆分
// 出来的整数必须互不相同。
// 
//
// 请你返回一个整数数组，表示将整数拆分成 最多 数目的正偶数数组。如果没有办法将 finalSum 进行拆分，请你返回一个 空 数组。你可以按 任意 顺序返
// 回这些整数。
//
// 
//
// 示例 1： 
//
// 
// 输入：finalSum = 12
// 输出：[2,4,6]
// 解释：以下是一些符合要求的拆分：(2 + 10)，(2 + 4 + 6) 和 (4 + 8) 。
//(2 + 4 + 6) 为最多数目的整数，数目为 3 ，所以我们返回 [2,4,6] 。
//[2,6,4] ，[6,2,4] 等等也都是可行的解。
// 
//
// 示例 2： 
//
// 
// 输入：finalSum = 7
// 输出：[]
// 解释：没有办法将 finalSum 进行拆分。
// 所以返回空数组。
// 
//
// 示例 3： 
//
// 
// 输入：finalSum = 28
// 输出：[6,8,2,12]
// 解释：以下是一些符合要求的拆分：(2 + 26)，(6 + 8 + 2 + 12) 和 (4 + 24) 。
//(6 + 8 + 2 + 12) 有最多数目的整数，数目为 4 ，所以我们返回 [6,8,2,12] 。
//[10,2,4,12] ，[6,2,4,16] 等等也都是可行的解。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= finalSum <= 10¹⁰ 
// 
// Related Topics 贪心 数学 回溯 👍 51 👎 0


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSplitOfPositiveEvenIntegers {
    private Solution solution = new Solution();

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Long> maximumEvenSplit(long finalSum) {
            List<Long> result = new ArrayList<>();
            if (finalSum % 2 != 0) {
                return result;
            }
            return split(finalSum);
        }

        /**
         * 要分尽可能的多,而且不能重复, 从小到大开始尝试
         * <p>
         * 先从2开始，target可以分割为target-2,2;target-4,4,2;
         * 如果target-2小于等于2了，则说明此分割不可行，回退，将target加入，并停止
         * 如果target为0了，也停止
         *
         * @param target
         * @return
         */
        private List<Long> split(long target) {
            List<Long> result = new ArrayList<>();
            long temp = 2;
            while (target > 0) {
                target -= temp;
                result.add(temp);
                if (target <= temp) {
                    result.add(result.remove(result.size() - 1) + target);
                    break;
                }
                temp += 2;
            }
            return result;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)
    @Test
    @DisplayName("当输入为奇数时，无法拆分，返回空列表")
    void should_return_empty_when_input_is_odd() {
        Assertions.assertEquals(new ArrayList<>(), solution.maximumEvenSplit(7));
    }

    @Test
    @DisplayName("当输入12时，返回2,4,6")
    void should_return_246_when_input_12() {
        Assertions.assertEquals(Arrays.asList(2L, 4L, 6L), solution.maximumEvenSplit(12));
    }

    @Test
    @DisplayName("当输入4时，返回4")
    void should_return_4_when_input_4() {
        Assertions.assertEquals(Arrays.asList(4L), solution.maximumEvenSplit(4));
    }

    @Test
    @DisplayName("当输入28时，返回24616")
    void should_return_26812_when_input_28() {
        // 这里实际有多个解
        Assertions.assertEquals(Arrays.asList(2L, 4L, 6L, 16L), solution.maximumEvenSplit(28));
    }

    @Test
    @DisplayName("测试性能，不能重复，通过大小判断比contain判断效率高的多")
    void test_performance() {
        int i = 10;
        while (i > 0) {
            long start = System.currentTimeMillis();
            List<Long> result = solution.maximumEvenSplit(6914017674L);
            System.out.println(System.currentTimeMillis() - start);
            i--;
        }
    }
}