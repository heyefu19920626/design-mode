package test.oj;

import java.util.Arrays;
import java.util.Comparator;

public class ExperimentBox {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // int[][] icons = new int[4][];
        // icons[0] = new int[]{0, 1};
        // icons[1] = new int[]{2, 0};
        // icons[2] = new int[]{1, 1};
        // icons[3] = new int[]{1, 0};
        // final int[][] result = solution.experimentBox(3, 4, new int[]{2, 1, 2, 1}, icons, "UDDRL");

        int[][] icons = new int[2][];
        icons[0] = new int[]{2, 2};
        icons[1] = new int[]{1, 3};
        final int[][] result = solution.experimentBox(3, 5, new int[]{0, 0, 1, 2}, icons, "RUL");
        print(result);
    }

    private static void print(int[][] array) {
        for (int[] arr : array) {
            for (int i : arr) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
    }


    static class Solution {
        private int[][] ICONS;

        /**
         * @param rowCount   盒子行数
         * @param colCount   盒子列数
         * @param obstacle   障碍物，长度为4的数组，分别为左上角坐标，右上角坐标，左下角坐标，右下角坐标
         * @param irons      铁块，每行长度为2的数组，表示铁块所在的位置
         * @param directions 移动方向 U D L R
         * @return 移动完毕后所有铁块的坐标，顺序为从左到右，从上到下
         */
        public int[][] experimentBox(int rowCount, int colCount, int[] obstacle, int[][] irons, String directions) {
            this.ICONS = irons;
            final int[][] matrix = initMatrix(rowCount, colCount);
            initObstaclePlace(obstacle, matrix);
            initIronPlace(irons, matrix);
            move(matrix, directions);
            Arrays.sort(ICONS, (o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            });
            return irons;
        }

        private void move(int[][] que, String directions) {
            for (int i = 0; i < directions.length(); i++) {
                if (i >= 1 && directions.charAt(i) == directions.charAt(i - 1)) {
                    continue;
                }
                if ('L' == directions.charAt(i)) {
                    moveLeft(que);
                } else if ('U' == directions.charAt(i)) {
                    moveUp(que);
                } else if ('R' == directions.charAt(i)) {
                    moveRight(que);
                } else {
                    moveDown(que);
                }
            }
        }

        private void moveDown(int[][] que) {
            Arrays.sort(ICONS, (o1, o2) -> o2[0] - o1[0]);
            int temp = 0;
            for (int[] icon : ICONS) {
                int row = icon[0];
                int col = icon[1];
                int down = row + 1;
                while (down < que.length && que[down][col] == 0) {
                    down++;
                }
                que[row][col] = 0;
                que[down - 1][col] = 1;
                ICONS[temp] = new int[]{down - 1, col};
                temp++;
            }
        }

        private void moveUp(int[][] que) {
            Arrays.sort(ICONS, Comparator.comparingInt(array -> array[0]));
            int temp = 0;
            for (int[] icon : ICONS) {
                int row = icon[0];
                int col = icon[1];
                int up = row - 1;
                while (up >= 0 && que[up][col] == 0) {
                    up--;
                }
                que[row][col] = 0;
                que[up + 1][col] = 1;
                ICONS[temp] = new int[]{up + 1, col};
                temp++;
            }
        }

        private void moveRight(int[][] que) {
            Arrays.sort(ICONS, (o1, o2) -> o2[1] - o1[1]);
            int temp = 0;
            for (int[] icon : ICONS) {
                int len = que[0].length;
                int row = icon[0];
                int col = icon[1];
                int right = col + 1;
                while (right < len && que[row][right] == 0) {
                    right++;
                }
                que[row][col] = 0;
                que[row][right - 1] = 1;
                ICONS[temp] = new int[]{row, right - 1};
                temp++;
            }
        }

        private void moveLeft(int[][] que) {
            Arrays.sort(ICONS, Comparator.comparingInt(array -> array[1]));
            int temp = 0;
            for (int[] icon : ICONS) {
                int row = icon[0];
                int col = icon[1];
                int left = col - 1;
                while (left >= 0 && que[row][left] == 0) {
                    left--;
                }
                que[row][col] = 0;
                que[row][left + 1] = 1;
                ICONS[temp] = new int[]{row, left + 1};
                temp++;
            }
        }

        /**
         * 初始化铁的位置
         *
         * @param irons  所有铁的位置坐标
         * @param matrix 矩阵
         */
        private void initIronPlace(int[][] irons, int[][] matrix) {
            for (int[] iron : irons) {
                matrix[iron[0]][iron[1]] = 1;
            }
        }

        /**
         * 初始化障碍物
         * <p>
         * 把所有障碍物位置的值初始化为-1
         *
         * @param obstacle 障碍物数组
         * @param matrix   矩阵
         */
        private void initObstaclePlace(int[] obstacle, int[][] matrix) {
            for (int i = obstacle[0]; i <= obstacle[2]; i++) {
                for (int j = obstacle[1]; j <= obstacle[3]; j++) {
                    matrix[i][j] = -1;
                }
            }
        }

        /**
         * 初始化矩阵
         *
         * @param rowCount 行数
         * @param colCount 列数
         * @return 所有值为0的矩阵
         */
        private int[][] initMatrix(int rowCount, int colCount) {
            int[][] matrix = new int[rowCount][];
            for (int i = 0; i < rowCount; i++) {
                int[] col = new int[colCount];
                matrix[i] = col;
            }
            return matrix;
        }
    }
}