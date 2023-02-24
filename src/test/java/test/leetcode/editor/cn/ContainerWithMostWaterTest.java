package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author he
 * @since 2023-02.24-23:04
 */
class ContainerWithMostWaterTest {
    ContainerWithMostWater.Solution solution = new ContainerWithMostWater.Solution();


    @Test
    void should_return_49() {
        Assertions.assertEquals(49, solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    @Test
    void should_return_1() {
        Assertions.assertEquals(1, solution.maxArea(new int[]{1,1}));
    }
}