package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MakingFileNamesUniqueTest {
    MakingFileNamesUnique.Solution solution = new MakingFileNamesUnique.Solution();

    @Test
    void should_return_origin() {
        Assertions.assertArrayEquals(new String[]{"pes", "fifa", "gta", "pes(2019)"},
            solution.getFolderNames(new String[]{"pes", "fifa", "gta", "pes(2019)"}));
    }

    @Test
    void should_return_have_repeat() {
        Assertions.assertArrayEquals(new String[]{"gta", "gta(1)", "gta(2)", "avalon"},
            solution.getFolderNames(new String[]{"gta", "gta(1)", "gta", "avalon"}));
    }

    @Test
    void should_return_have_repeat_1() {
        Assertions.assertArrayEquals(new String[]{"kaido", "kaido(1)", "kaido(2)", "kaido(1)(1)"},
            solution.getFolderNames(new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)"}));
    }

    @Test
    void should_return_have_repeat_2() {
        Assertions.assertArrayEquals(new String[]{"wano", "wano(1)", "wano(2)", "wano(3)"},
            solution.getFolderNames(new String[]{"wano", "wano", "wano", "wano"}));
    }

    @Test
    void should_return_have_repeat_3() {
        Assertions.assertArrayEquals(new String[]{"kaido", "kaido(1)", "kaido(2)", "kaido(1)(1)", "kaido(2)(1)"},
            solution.getFolderNames(new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)", "kaido(2)"}));
    }
}