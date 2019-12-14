package site.syso.leetcode.easy;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * <p>
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E0035_SearchInsert {

    /**
     * 二分查找
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        if (nums[left] >= target) {
            return left;
        }
        return left + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        E0035_SearchInsert e35 = new E0035_SearchInsert();
        System.out.println(e35.searchInsert(nums, 5));
        System.out.println(e35.searchInsert(nums, 2));
        System.out.println(e35.searchInsert(nums, 7));
        System.out.println(e35.searchInsert(nums, 0));
    }


}
