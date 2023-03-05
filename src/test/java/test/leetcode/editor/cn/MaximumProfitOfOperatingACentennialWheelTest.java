package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author he
 * @since 2023-03.05-14:15
 */
class MaximumProfitOfOperatingACentennialWheelTest {
    MaximumProfitOfOperatingACentennialWheel.Solution solution = new MaximumProfitOfOperatingACentennialWheel.Solution();

    @Test
    void should_return_3() {
        Assertions.assertEquals(3, solution.minOperationsMaxProfit(new int[]{8, 3}, 5, 6));
    }

    @Test
    void should_return_7() {
        Assertions.assertEquals(7, solution.minOperationsMaxProfit(new int[]{10, 9, 6}, 6, 4));
    }

    @Test
    void should_return__1() {
        Assertions.assertEquals(-1, solution.minOperationsMaxProfit(new int[]{3, 4, 0, 5, 1}, 1, 92));
    }

    @Test
    void should_return_9() {
        Assertions.assertEquals(9, solution.minOperationsMaxProfit(new int[]{10, 10, 6, 4, 7}, 3, 8));
    }
}