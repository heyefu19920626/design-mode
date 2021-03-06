package test.leetcode.editor.cn;

import java.util.PriorityQueue;

//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 注意：不允许旋转信封。 
// 
//
// 示例 1： 
//
// 
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
//
// 示例 2： 
//
// 
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= envelopes.length <= 5000 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 104 
// 
// Related Topics 二分查找 动态规划
public class RussianDollEnvelopes {
    public static void main(String[] args) {
        Solution solution = new RussianDollEnvelopes().new Solution();
        int[][] envelopes = new int[9][];
        envelopes[0] = new int[]{2, 100};
        envelopes[1] = new int[]{3, 200};
        envelopes[2] = new int[]{4, 300};
        envelopes[3] = new int[]{5, 500};
        envelopes[4] = new int[]{5, 400};
        envelopes[5] = new int[]{5, 250};
        envelopes[6] = new int[]{6, 370};
        envelopes[7] = new int[]{6, 360};
        envelopes[8] = new int[]{7, 380};
        final int result = solution.maxEnvelopes(envelopes);
        System.out.println(result);
    }

    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            PriorityQueue<Place> queue = new PriorityQueue<>();
            for (int i = 0; i < envelopes.length; i++) {
                queue.add(new Place(envelopes[i][0], envelopes[i][1]));
            }
            final Place first = queue.poll();
            Place start = new Place(first.i, first.j);
            System.out.printf("%d %d\n", start.i, start.j);
            int max = 1;
            while (queue.peek() != null) {
                Place next = queue.poll();
                if (next.i > start.i) {
                    if (next.j > start.j) {
                        Place peek = queue.peek();
                        while (peek != null && peek.i == next.i) {
                            if (peek.j < next.j && peek.j > start.j) {
                                next = queue.poll();
                            } else {
                                queue.poll();
                            }
                            peek = queue.peek();
                        }
                        max++;
                        start = next;
                        System.out.printf("%d %d\n", start.i, start.j);
                    }
                }
            }
            return max;
        }
    }

    class Place implements Comparable<Place> {
        int i;

        int j;

        public Place(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Place o) {
            return i > o.i ? 1 : (i == o.i ? 0 : -1);
        }
    }
}