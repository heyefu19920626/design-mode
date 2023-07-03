package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumHoursOfTrainingToWinACompetitionTest {
    MinimumHoursOfTrainingToWinACompetition.Solution solution = new MinimumHoursOfTrainingToWinACompetition.Solution();

    @Test
    void should_return_8() {
        Assertions.assertEquals(8, solution.minNumberOfHours(5, 3, new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1}));
    }

    @Test
    void should_return_0() {
        Assertions.assertEquals(0, solution.minNumberOfHours(2, 4, new int[]{1}, new int[]{3}));
    }

    @Test
    void should_return_51() {
        Assertions.assertEquals(51, solution.minNumberOfHours(1, 1, new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 50}));
    }
}