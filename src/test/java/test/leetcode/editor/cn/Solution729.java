package test.leetcode.editor.cn;
//<p>实现一个 <code>MyCalendar</code> 类来存放你的日程安排。如果要添加的日程安排不会造成 <strong>重复预订</strong> ，则可以存储这个新的日程安排。</p>
//
//<p>当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 <strong>重复预订</strong> 。</p>
//
//<p>日程可以用一对整数 <code>startTime</code> 和 <code>endTime</code> 表示，这里的时间是半开区间，即 <code>[startTime, endTime)</code>, 实数&nbsp;<code>x</code> 的范围为， &nbsp;<code>startTime &lt;= x &lt; endTime</code> 。</p>
//
//<p>实现 <code>MyCalendar</code> 类：</p>
//
//<ul> 
// <li><code>MyCalendar()</code> 初始化日历对象。</li> 
// <li><code>boolean book(int startTime, int endTime)</code> 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 <code>true</code> 。否则，返回 <code>false</code>&nbsp;并且不要将该日程安排添加到日历中。</li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong class="example">示例：</strong></p>
//
//<pre>
//<strong>输入：</strong>
//["MyCalendar", "book", "book", "book"]
//[[], [10, 20], [15, 25], [20, 30]]
//<strong>输出：</strong>
//[null, true, false, true]
//
//<strong>解释：</strong>
// MyCalendar myCalendar = new MyCalendar();
// myCalendar.book(10, 20); // return True
// myCalendar.book(15, 25); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了。
// myCalendar.book(20, 30); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20 ，且不包含时间 20 。</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>0 &lt;= start &lt; end &lt;= 10<sup>9</sup></code></li> 
// <li>每个测试用例，调用 <code>book</code> 方法的次数最多不超过 <code>1000</code> 次。</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>设计</li><li>线段树</li><li>数组</li><li>二分查找</li><li>有序集合</li></div></div><br><div><li>👍 307</li><li>👎 0</li></div>

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class Solution729 {
    MyCalendar solution = new MyCalendar();

    @Test
    public void test() {
        MyCalendar myCalendar = new MyCalendar();

        Assertions.assertTrue(myCalendar.canBook(new int[]{47, 50}));
        Assertions.assertTrue(myCalendar.canBook(new int[]{33, 41}));
        Assertions.assertFalse(myCalendar.canBook(new int[]{39,45}));
        // [47,50],[33,41],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]
        // Assertions.assertTrue(myCalendar.canBook(new int[]{20, 30}));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class MyCalendar {
        private List<int[]> hasBooked;

        public MyCalendar() {
            hasBooked = new ArrayList<>();
            // hasBooked = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        }

        public boolean book(int startTime, int endTime) {
            int[] time = {startTime, endTime};
            return canBook(time);
        }

        private boolean canBook(int[] time) {
            if (hasBooked.isEmpty()) {
                hasBooked.add(time);
                return true;
            }
            int place = findPlace(time);
            if (place > -1) {
                hasBooked.add(place, time);
                return true;
            }
            return false;
        }

        /**
         * 找到time的插入位置，如果找不到，返回-1
         *
         * @param time
         * @return
         */
        private int findPlace(int[] time) {
            int right = hasBooked.size() - 1;
            int left = 0;
            // 需要插入的位置，插入在该位置之后
            int place = -1;
            // hasBooked.add(0, null);
            while (left <= right) {
                int mid = (left + right) / 2;
                int[] cur = hasBooked.get(mid);
                if (time[0] == cur[0]) {
                    return -1;
                }
                // 新增的开始时间比当前的大
                if (time[0] > cur[0]) {
                    // 还没到最右边
                    if (mid < right) {
                        // 要判断是否小于下一位
                        int[] next = hasBooked.get(mid + 1);
                        if (time[0] < next[0]) {
                            // 能够放下
                            if (time[0] >= cur[1] && time[1] <= next[0]) {
                                return mid + 1;
                            }
                            // 放不下
                            return -1;
                        }
                        left = mid + 1;
                    } else {
                        // 到最右边了
                        if (time[0] >= cur[1]) {
                            return mid + 1;
                        }
                        return -1;
                    }
                } else {
                    // 新增的开始时间比当前的小
                    // 还没到最左边
                    if (mid > left) {
                        // 上一个的开始时间是否比当前时间小
                        int[] pre = hasBooked.get(mid - 1);
                        if (pre[0] < time[0]) {
                            // 能够放下
                            if (time[0] >= pre[1] && time[1] <= cur[0]) {
                                return mid;
                            }
                            return -1;
                        }
                        right = mid - 1;
                    } else {
                        // 到最左边了
                        // 能放下
                        if (time[1] <= cur[0]) {
                            return 0;
                        }
                        return -1;
                    }
                }
            }
            return place;
        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */
// leetcode submit region end(Prohibit modification and deletion)

}

