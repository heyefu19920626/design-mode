package test.leetcode.editor.cn;

/**
//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 双指针 👍 4108 👎 0

*/
class ContainerWithMostWater {
    public static
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


        /**
         *
         * 使用双指针
         *
         * 左指针从0往右移动，右指针从右往左移动
         * 左指针为i = 0，右指针为j = length-1
         * 当前最大面积为area = min(height[i],height[j]) * (j-i)
         * j-i的值变化不过1
         * 如果左指针的数比右指针小，则左指针往右移动一位，
         *      如果此时左指针指数比之前大,此时面积计为height[i] * (j-1) > area, 更新area
         *      如果此时左指针指数比之前小，则此时面积为height[i] * (j-i) < area, area 不变
         *  如果右指针的数比左指针小，则右指针往左移动一位，同理area > area1
         *
         *
         * @param height
         * @return
         */
        public int maxArea(int[] height) {
            int i = 0, j = height.length - 1;
            int maxArea = Math.min(height[i], height[j]) * (j-i);
            while (i < j) {
                if (height[i] <= height[j]) {
                    i++;
                } else {
                    j--;
                }
                int area = Math.min(height[i], height[j]) * (j-i);
                maxArea = Math.max(area, maxArea);
            }
            return maxArea;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}