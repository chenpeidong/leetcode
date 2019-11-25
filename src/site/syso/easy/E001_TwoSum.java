package site.syso.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * <p>
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class E001_TwoSum {

    /**
     * 双层循环
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * 两遍哈希表
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int r = target - nums[i];
            if (map.containsKey(r) && i != map.get(r)) {
                return new int[]{i, map.get(r)};
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * 一遍哈希表
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int r = target - nums[i];
            if (map.containsKey(r) && i != map.get(r)) {
                return new int[]{i, map.get(r)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);
        Arrays.stream(twoSum2(nums, target)).forEach(System.out::println);
        Arrays.stream(twoSum3(nums, target)).forEach(System.out::println);
    }

}
