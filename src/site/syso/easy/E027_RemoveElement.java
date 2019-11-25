package site.syso.easy;

import java.util.Arrays;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E027_RemoveElement {

    /**
     * 双指针
     * 第一个指针指向第一个和给定val相同同元素的位置，第二个指针向后遍历
     * 当遇到和给定val不同的元素时，把该元素复制到第一个指针处，
     * 第一个指针+1，第二个指针继续向后遍历直到遍历完成
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[result] = nums[i];
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        // nums = [3,2,2,3], val = 3
        E027_RemoveElement e027_removeElement = new E027_RemoveElement();
        int[] nums = {3, 2, 2, 3};
        System.out.println(e027_removeElement.removeElement(nums, 3));
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(e027_removeElement.removeElement(nums2, 2));
        Arrays.stream(nums2).forEach(System.out::print);

    }

}
