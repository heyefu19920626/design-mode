package test.leetcode.editor.cn;
//<p>有一个&nbsp;<code>m x n</code>&nbsp;大小的矩形蛋糕，需要切成&nbsp;<code>1 x 1</code>&nbsp;的小块。</p>
//
//<p>给你整数&nbsp;<code>m</code>&nbsp;，<code>n</code>&nbsp;和两个数组：</p>
//
//<ul> 
// <li><code>horizontalCut</code> 的大小为&nbsp;<code>m - 1</code>&nbsp;，其中&nbsp;<code>horizontalCut[i]</code>&nbsp;表示沿着水平线 <code>i</code>&nbsp;切蛋糕的开销。</li> 
// <li><code>verticalCut</code> 的大小为&nbsp;<code>n - 1</code>&nbsp;，其中&nbsp;<code>verticalCut[j]</code>&nbsp;表示沿着垂直线&nbsp;<code>j</code>&nbsp;切蛋糕的开销。</li> 
//</ul>
//
//<p>一次操作中，你可以选择任意不是&nbsp;<code>1 x 1</code>&nbsp;大小的矩形蛋糕并执行以下操作之一：</p>
//
//<ol> 
// <li>沿着水平线&nbsp;<code>i</code>&nbsp;切开蛋糕，开销为&nbsp;<code>horizontalCut[i]</code>&nbsp;。</li> 
// <li>沿着垂直线&nbsp;<code>j</code>&nbsp;切开蛋糕，开销为&nbsp;<code>verticalCut[j]</code>&nbsp;。</li> 
//</ol>
//
//<p>每次操作后，这块蛋糕都被切成两个独立的小蛋糕。</p>
//
//<p>每次操作的开销都为最开始对应切割线的开销，并且不会改变。</p>
//
//<p>请你返回将蛋糕全部切成&nbsp;<code>1 x 1</code>&nbsp;的蛋糕块的&nbsp;<strong>最小</strong>&nbsp;总开销。</p>
//
//<p>&nbsp;</p>
//
//<p><strong class="example">示例 1：</strong></p>
//
//<div class="example-block"> 
// <p><span class="example-io"><b>输入：</b>m = 3, n = 2, horizontalCut = [1,3], verticalCut = [5]</span></p> 
//</div>
//
//<p><span class="example-io"><b>输出：</b>13</span></p>
//
//<p><strong>解释：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode.com/uploads/2024/06/04/ezgifcom-animated-gif-maker-1.gif" style="width: 280px; height: 320px;" /></p>
//
//<ul> 
// <li>沿着垂直线 0 切开蛋糕，开销为 5 。</li> 
// <li>沿着水平线 0 切开&nbsp;<code>3 x 1</code>&nbsp;的蛋糕块，开销为 1 。</li> 
// <li>沿着水平线 0 切开 <code>3 x 1</code>&nbsp;的蛋糕块，开销为 1 。</li> 
// <li>沿着水平线 1 切开 <code>2 x 1</code>&nbsp;的蛋糕块，开销为 3 。</li> 
// <li>沿着水平线 1 切开 <code>2 x 1</code>&nbsp;的蛋糕块，开销为 3 。</li> 
//</ul>
//
//<p>总开销为&nbsp;<code>5 + 1 + 1 + 3 + 3 = 13</code>&nbsp;。</p>
//
//<p><strong class="example">示例 2：</strong></p>
//
//<div class="example-block"> 
// <p><span class="example-io"><b>输入：</b>m = 2, n = 2, horizontalCut = [7], verticalCut = [4]</span></p> 
//</div>
//
//<p><span class="example-io"><b>输出：</b>15</span></p>
//
//<p><strong>解释：</strong></p>
//
//<ul> 
// <li>沿着水平线 0 切开蛋糕，开销为 7 。</li> 
// <li>沿着垂直线 0 切开&nbsp;<code>1 x 2</code>&nbsp;的蛋糕块，开销为 4 。</li> 
// <li>沿着垂直线 0 切开&nbsp;<code>1 x 2</code>&nbsp;的蛋糕块，开销为 4 。</li> 
//</ul>
//
//<p>总开销为&nbsp;<code>7 + 4 + 4 = 15</code>&nbsp;。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li> 
// <li><code>horizontalCut.length == m - 1</code></li> 
// <li><code>verticalCut.length == n - 1</code></li> 
// <li><code>1 &lt;= horizontalCut[i], verticalCut[i] &lt;= 10<sup>3</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>排序</li></div></div><br><div><li>👍 25</li><li>👎 0</li></div>

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution3219 {
    Solution solution = new Solution();

    @Test
    public void test() {
        int i = 0, j = 0;
        System.out.println(++i);
        System.out.println(i);
        System.out.println(j++);
        System.out.println(j);
        Assertions.assertEquals(13, solution.minimumCost(3, 2, new int[]{1, 3}, new int[]{5}));
        Assertions.assertEquals(15, solution.minimumCost(2, 2, new int[]{7}, new int[]{4}));
        Assertions.assertEquals(28, solution.minimumCost(6, 3, new int[]{2, 3, 2, 3, 1}, new int[]{1, 2}));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 贪心算法
         * <p>
         * 因为最终要切成1*1，所以可以假设每刀都切到底，
         * 最开始连续切两刀到底的情况，有四种方式：1、两刀横切，2、两刀竖切，3、先横切再竖切，4、先竖切再横切
         * 其中交换1和2没有任何影响
         * 先横切需要花费: horizontalCut[i] + verticalCut[j]*2,
         * 先竖切需要花费: 2*horizontalCut[i] + verticalCut[j],
         * 两者相差：diff = verticalCut[j] - horizontalCut[i],
         * 如果需要diff < 0,即先横切花费小，则需要horizontalCut[i] > verticalCut[j]
         * 因此，对于相邻的两刀的来说，先切的那刀更大的话，则总花费越小
         *
         * @param m             垂直方向
         * @param n             水平方向
         * @param horizontalCut 水平
         * @param verticalCut   垂直
         * @return
         */
        public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
            Arrays.sort(horizontalCut);
            Arrays.sort(verticalCut);
            // 需要水平切割到底的次数
            int horizon = 1;
            // 需要垂直切割到底的次数
            int vertical = 1;
            long cost = 0;
            // 横切的位置
            int horPlace = horizontalCut.length - 1;
            int verPlace = verticalCut.length - 1;
            while (horPlace >= 0 || verPlace >= 0) {
                // 横切完毕
                if (horPlace < 0) {
                    cost += (long) verticalCut[verPlace--] * vertical;
                    continue;
                }
                // 竖切完毕
                if (verPlace < 0) {
                    cost += (long) horizontalCut[horPlace--] * horizon;
                    continue;
                }
                if (horizontalCut[horPlace] >= verticalCut[verPlace]) {
                    // 横切之后, 竖切的需要的刀数会增加
                    cost += (long) horizontalCut[horPlace--] * horizon;
                    vertical++;
                } else {
                    cost += (long) verticalCut[verPlace--] * vertical;
                    horizon++;
                }
            }
            return cost;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}

