package mode.algorithm.sort;

/**
 * 快速排序
 * <p>
 * 采用分治法与递归
 * <p>
 * 选取首个元素，然后从两端开始遍历，将比其小的元素放到该元素左边，将比其大的元素放到右边
 * （从右往左遍历时，如果右指针所指的元素比该元素小，并且右指针的索引比该元素索引大，则交换两个元素的位置,
 *   从左往右遍历时，如果左指针所指的元素比该元素大，并且左指针的索引比该元素索引小，则交换两个元素的位置）
 * 遍历一遍之后，该元素左侧的元素都比该元素小，该元素右侧的元素都比该元素大，将左侧与右侧分别递归再次排序即可
 *
 * @author he
 * @since 2023-02.22-23:06
 */
public class QuickSort implements Sort{
    @Override
    public void sort(int[] target) {
        if (target == null || target.length == 0) {
            return;
        }
        sort(target, 0, target.length-1);
    }

    private void sort(int[] target, int left, int right) {
        if (left >= right) {
            return;
        }
        int cur = target[left];
        int index = left;
        while (left < right) {
            if (target[right] < cur && right > index) {
                target[index] = target[right];
                target[right] = cur;
                index = right;
            }
            right--;
            if (target[left] > cur && left < index) {
                target[index] = target[left];
                target[left] = cur;
                index = left;
            }
            left++;
        }
        sort(target, 0, index);
        sort(target, index, right);
    }
}
