package site.syso.leetcode.easy;

import java.util.HashSet;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E0026_RemoveDuplicates {


    /**
     * 一遍哈希
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            nums[result] = nums[i];
            set.add(nums[i]);
            result++;
        }
        return result;
    }

    /**
     * 双指针
     */
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[result - 1] == nums[i]) {
                continue;
            }
            nums[result] = nums[i];
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        E0026_RemoveDuplicates e0026_removeDuplicates = new E0026_RemoveDuplicates();
        // System.out.println(e26_removeDuplicates.removeDuplicates(nums));
        System.out.println(e0026_removeDuplicates.removeDuplicates2(nums));
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        // System.out.println(e26_removeDuplicates.removeDuplicates(nums2));
        System.out.println(e0026_removeDuplicates.removeDuplicates2(nums2));
        int[] nums3 = {1};
        // System.out.println(e26_removeDuplicates.removeDuplicates(nums3));
        System.out.println(e0026_removeDuplicates.removeDuplicates2(nums3));
    }


}
