package test.nowcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 标题：学生方阵 | 时间限制：1秒 | 内存限制：262144K | 语言限制：不限
 * 学校组织活动，将学生排成一个矩形方阵。请在矩形方阵中找到最大的位置相连的男生数量。这个相连位置在一个直线上，方向可以是水平的、垂直的、呈对角线的或者反对角线的。
 * 注：学生个数不会超过10000.
 * 收起
 * 输入描述:
 * 输入的第一行为矩阵的行数和列数，接下来的n行为矩阵元素，元素间用“,”分隔。
 * 输出描述:
 * 输出一个整数，表示矩阵中最长的位置相连的男生个数。
 * 示例1
 * 输入
 * 3,4
 * F,M,M,F
 * F,M,M,F
 * F,F,F,M
 * 输出
 * 3
 *
 * @since 2022/6/2
 */
public class StudentMatrix {
    char[][] matrix = new char[3][];

    @BeforeEach
    public void before() {
        char[] one = new char[]{'F', 'M', 'M', 'F'};
        char[] two = new char[]{'F', 'M', 'M', 'F'};
        char[] three = new char[]{'F', 'F', 'F', 'M'};
        matrix[0] = one;
        matrix[1] = two;
        matrix[2] = three;
    }

    @Test
    public void should_return_2_when_compute_line_max() {
        Assertions.assertEquals(2, getLineMax(matrix));
    }

    @Test
    public void should_return_2_when_compute_column_max() {
        Assertions.assertEquals(2, getColumnMax(matrix));
    }

    @Test
    public void should_return_3_when_compute_column_max() {
        matrix = new char[][]{{'F', 'M', 'M', 'F'}, {'F', 'M', 'M', 'F'}, {'F', 'M', 'F', 'F'}};
        Assertions.assertEquals(3, getColumnMax(matrix));
    }


    @Test
    public void should_return_3_when_compute_oblique_max() {
        Assertions.assertEquals(3, getObliqueMax(matrix, 3, 4));
    }

    @Test
    public void should_return_0_when_compute_oblique_max() {
        Assertions.assertEquals(0, getObliqueMax(new char[][]{{'F'}}, 1, 1));
    }

    @Test
    public void should_return_1_when_compute_oblique_max() {
        Assertions.assertEquals(1, getObliqueMax(new char[][]{{'M'}}, 1, 1));
    }

    @Test
    public void should_return_1_when_compute_revert_oblique_max() {
        Assertions.assertEquals(1, getRevertObliqueMax(new char[][]{{'M'}}, 1, 1));
    }

    @Test
    public void should_return_0_when_compute_revert_oblique_max() {
        Assertions.assertEquals(0, getRevertObliqueMax(new char[][]{{'F'}}, 1, 1));
    }

    @Test
    public void should_return_2_when_compute_revert_oblique_max() {
        Assertions.assertEquals(2, getRevertObliqueMax(matrix, 3, 4));
    }

    @Test
    public void should_return_3_when_compute_max() {
        Assertions.assertEquals(3, getMaxManNumber(matrix));
    }

    @Test
    public void should_return_4_when_compute_max() {
        Assertions.assertEquals(4, getMaxManNumber(new char[][]{
            {'F', 'M', 'F', 'F', 'M'},
            {'F', 'M', 'F', 'M', 'F'},
            {'F', 'M', 'M', 'F', 'M'},
            {'F', 'F', 'F', 'F', 'F'},
            {'M', 'F', 'F', 'F', 'M'},
        }));
    }

    public int getMaxManNumber(char[][] matrix) {
        int lineLen = matrix.length;
        int columnLen = matrix[0].length;
        int lineMax = getLineMax(matrix);
        int columnMax = getColumnMax(matrix);
        int max = Math.max(lineMax, columnMax);
        int obliqueMax = getObliqueMax(matrix, lineLen, columnLen);
        max = Math.max(obliqueMax, max);
        int revertObliqueMax = getRevertObliqueMax(matrix, lineLen, columnLen);
        return Math.max(revertObliqueMax, max);
    }

    private int getRevertObliqueMax(char[][] matrix, int lineLen, int columnLen) {
        int revertObliqueMax = 0;
        for (int i = 0; i < columnLen - 1; i++) {
            int line = 0;
            int column = i;
            int curMax = 0;
            while (line < lineLen && column >= 0) {
                if (matrix[line][column] == 'M') {
                    curMax++;
                }
                line++;
                column--;
            }
            revertObliqueMax = Math.max(revertObliqueMax, curMax);
        }
        for (int i = 0; i < lineLen; i++) {
            int column = columnLen - 1;
            int line = i;
            int curMax = 0;
            while (line < lineLen && column >= 0) {
                if (matrix[line][column] == 'M') {
                    curMax++;
                }
                line++;
                column--;
            }
            revertObliqueMax = Math.max(revertObliqueMax, curMax);
        }
        return revertObliqueMax;
    }

    private int getObliqueMax(char[][] matrix, int lineLen, int columnLen) {
        int obliqueMax = 0;
        for (int i = columnLen - 1; i > 0; i--) {
            int line = 0;
            int column = i;
            int curMax = 0;
            while (line < lineLen && column < columnLen) {
                if (matrix[line][column] == 'M') {
                    curMax++;
                }
                line++;
                column++;
            }
            obliqueMax = Math.max(obliqueMax, curMax);
        }
        for (int i = 0; i < lineLen; i++) {
            int column = 0;
            int line = i;
            int curMax = 0;
            while (line < lineLen && column < columnLen) {
                if (matrix[line][column] == 'M') {
                    curMax++;
                }
                line++;
                column++;
            }
            obliqueMax = Math.max(obliqueMax, curMax);
        }
        return obliqueMax;
    }

    private int getColumnMax(char[][] matrix) {
        int columnMax = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            int curMax = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 'M') {
                    curMax++;
                }
            }
            columnMax = Math.max(columnMax, curMax);
        }
        return columnMax;
    }

    private int getLineMax(char[][] matrix) {
        int lineMax = 0;
        for (int i = 0; i < matrix.length; i++) {
            char[] curLine = matrix[i];
            int curMax = 0;
            for (int j = 0; j < curLine.length; j++) {
                if (curLine[j] == 'M') {
                    curMax++;
                }
            }
            lineMax = Math.max(lineMax, curMax);
        }
        return lineMax;
    }
}