package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author he
 * @since 2023-03.04-09:37
 */
class TriplesWithBitwiseAndEqualToZeroTest {
    TriplesWithBitwiseAndEqualToZero.Solution solution = new TriplesWithBitwiseAndEqualToZero.Solution();

    @Test
    void should_return_12() {
        Assertions.assertEquals(12, solution.countTriplets(new int[]{2, 1, 3}));
    }

    @Test
    void should_return_27() {
        Assertions.assertEquals(27, solution.countTriplets(new int[]{0, 0, 0}));
    }

    @Test
    void should_return_1() {
        Assertions.assertEquals(1, solution.countTriplets(new int[]{0}));
    }

    @Test
    void should_test() {
        System.out.println(3 >> 1);
        System.out.println(3 & 1 & 2);
    }
}