package algorithm.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author he
 * @since 2023-02.22-23:12
 */
class QuickSortTest {
    Sort quickSort = new QuickSort();

    @BeforeAll
    public static void before() {

    }

    @Test
    void should_return_equal_when_have_same_ele() {
        int[] target = new int[]{41, 13, 25, 11, 36, 29, 41};
        quickSort.sort(target);
        Assertions.assertArrayEquals(new int[]{11,13,25,29,36,41,41}, target);
    }

    @Test
    void should_return_equal_when_ele_is_even() {
        int[] target = new int[]{41, 13, 25, 11, 36, 29};
        quickSort.sort(target);
        Assertions.assertArrayEquals(new int[]{11,13,25,29,36,41}, target);
    }

    @Test
    void should_return_equal_when_have_only_one_ele() {
        int[] target = new int[]{41};
        quickSort.sort(target);
        Assertions.assertArrayEquals(new int[]{41}, target);
    }
}