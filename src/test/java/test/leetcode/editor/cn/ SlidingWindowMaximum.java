package test.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * //给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
 * //。
 * //
 * // 返回滑动窗口中的最大值。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * //输出：[3,3,5,5,6,7]
 * //解释：
 * //滑动窗口的位置                最大值
 * //---------------               -----
 * //[1  3  -1] -3  5  3  6  7       3
 * // 1 [3  -1  -3] 5  3  6  7       3
 * // 1  3 [-1  -3  5] 3  6  7       5
 * // 1  3  -1 [-3  5  3] 6  7       5
 * // 1  3  -1  -3 [5  3  6] 7       6
 * // 1  3  -1  -3  5 [3  6  7]      7
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [1], k = 1
 * //输出：[1]
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：nums = [1,-1], k = 1
 * //输出：[1,-1]
 * //
 * //
 * // 示例 4：
 * //
 * //
 * //输入：nums = [9,11], k = 2
 * //输出：[11]
 * //
 * //
 * // 示例 5：
 * //
 * //
 * //输入：nums = [4,-2], k = 2
 * //输出：[4]
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= nums.length <= 105
 * // -104 <= nums[i] <= 104
 * // 1 <= k <= nums.length
 * //
 * // Related Topics 堆 Sliding Window
 * // 👍 721 👎 0
 */
class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 7, 8, -6, 6, 4, 0, 5};
        // final int[] result = solution.maxSlidingWindow(nums, 2);
        // final int[] result = solution.maxSlidingWindowUseQue(nums, 4);
        final int[] result = solution.drabQueue(nums, 4);
        for (int i : result) {
            System.out.printf(i + " ");
        }
    }

    static class Ele {
        private int value;
        private int place;

        public Ele(int value, int place) {
            this.value = value;
            this.place = place;
        }
    }

    static class Solution {
        /**
         * 使用单调队列
         * <p>
         * 队列从大到小，且元素在数组中的序号从小到大
         * <p>
         * 新元素a插入时，如果队尾元素大于a,a直接插入队尾，否则队尾先出队，直到队尾元素大于a
         * <p>
         * 滑动队列，队首永远为最大值，如果队首元素的位置在滑块内，则为该元素，否则队首出队直到队首在滑块内
         *
         * @param nums 数组
         * @param k    滑块长度
         * @return 结果
         */
        public int[] drabQueue(int[] nums, int k) {
            LinkedList<Ele> queue = new LinkedList<>();
            // 由于单调队列是即能判断值的大小，又能判断序号的大小，实际上这里可以只存序号
            queue.addLast(new Ele(nums[0], 0));
            for (int i = 1; i < k; i++) {
                addQueue(nums, queue, i);
            }
            int[] result = new int[nums.length - k + 1];
            result[0] = queue.peekFirst().value;
            for (int i = k; i < nums.length; i++) {
                // 如果队列超出长度了，弹出队首
                if (queue.size() > k) {
                    queue.pollFirst();
                }
                addQueue(nums, queue, i);
                while (queue.peekFirst().place < (i - k + 1)) {
                    queue.pollFirst();
                }
                result[i - k + 1] = queue.peekFirst().value;
            }
            return result;
        }

        private void addQueue(int[] nums, LinkedList<Ele> queue, int i) {
            if (queue.peekLast().value < nums[i]) {
                while (!queue.isEmpty() && nums[i] > queue.peekLast().value) {
                    queue.pollLast();
                }
            }
            queue.addLast(new Ele(nums[i], i));
        }

        /**
         * 使用优先级队列
         *
         * @param nums 数组
         * @param k    滑块长度
         * @return 结果
         */
        public int[] maxSlidingWindowUseQue(int[] nums, int k) {
            PriorityQueue<Ele> queue = new PriorityQueue<>((a, b) -> b.value - a.value);
            int len = nums.length - k + 1;
            for (int i = 0; i < k - 1; i++) {
                queue.add(new Ele(nums[i], i));
            }
            int[] result = new int[len];
            for (int i = 0; i < len; i++) {
                int right = i + k - 1;
                queue.add(new Ele(nums[right], right));
                final Ele max = getMax(queue, i);
                result[i] = max.value;
                if (max.place > i) {
                    queue.add(max);
                }
            }
            return result;
        }

        private Ele getMax(PriorityQueue<Ele> queue, int i) {
            if (queue.peek().place < i) {
                queue.poll();
                return getMax(queue, i);
            }
            return queue.poll();
        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            int len = nums.length - k + 1;
            int[] result = new int[len];

            // 找出初始时候的最大值
            int place = getMaxPlace(nums, 0, k);
            result[0] = nums[place];
            if (k == nums.length) {
                return result;
            }

            // 开始滑动
            for (int i = 1; i < len; i++) {
                // 新增值的位置
                int next = i + k - 1;
                // 如果新增值大于之前最大值，则此此最大值为新增值
                if (nums[next] >= nums[place]) {
                    place = next;
                    result[i] = nums[place];
                } else {
                    if (place < i) {
                        // 如果新增值小于最大值，且最大值已经不再滑块范围内，重新寻找最大值位置
                        place = getMaxPlace(nums, i, k);
                    }
                    // 如果新增值小于最大值，且最大值还在滑块范围内，该值还为最大值
                    result[i] = nums[place];
                }
            }
            return result;
        }

        private int getMaxPlace(int[] nums, int start, int k) {
            int max = start + k;
            int place = start;
            for (int i = start; i < max; i++) {
                if (nums[i] >= nums[place]) {
                    place = i;
                }
            }
            return place;
        }
    }
}
