package test.leetcode.editor.cn;

import java.util.Arrays;

/**
 * //假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * //
 * // 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True
 * //，不能则返回False。
 * //
 * // 示例 1:
 * //
 * //
 * //输入: flowerbed = [1,0,0,0,1], n = 1
 * //输出: True
 * //
 * //
 * // 示例 2:
 * //
 * //
 * //输入: flowerbed = [1,0,0,0,1], n = 2
 * //输出: False
 * //
 * //
 * // 注意:
 * //
 * //
 * // 数组内已种好的花不会违反种植规则。
 * // 输入的数组长度范围为 [1, 20000]。
 * // n 是非负整数，且不会超过输入数组的大小。
 * //
 * // Related Topics 贪心算法 数组
 * // 👍 235 👎 0
 */
class CanPlaceFlowers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] flowerbed = new int[]{1, 0, 0, 0};
        boolean result = solution.canPlaceFlowers(flowerbed, 1);
        System.out.println(result);
    }

    static class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int num = 0;
            int count = 1;
            for (int i = 0; i < flowerbed.length; i++) {
                if (flowerbed[i] == 0) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == 3) {
                    num++;
                    count = 1;
                }
                if (i == flowerbed.length - 1 && count == 2) {
                    num++;
                }
            }
            return num >= n;
        }

        private int filterLength(int[] flowerbed) {
            for (int i = 0; i < flowerbed.length; i++) {
                if (flowerbed[i] == 1) {
                    if ((i - 1) >= 0) {
                        flowerbed[i - 1] = 2;
                    }
                    if ((i + 1) < flowerbed.length) {
                        flowerbed[i + 1] = 2;
                    }
                }
            }
            return (int) Arrays.stream(flowerbed).filter(v -> v == 0).count();
        }
    }
}