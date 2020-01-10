package site.syso.leetcode.easy;

import java.util.Arrays;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * 示例：
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * 提示：
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E0922_SortArrayByParityII {

    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 7};
        int[] ints = new E0922_SortArrayByParityII().sortArrayByParityII(arr);
        System.out.println(Arrays.toString(ints));
    }


    private int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0) return A;

        int[] ret = new int[A.length];
        int even = 0, odd = 1;
        for (int i = 0; i < A.length; i++) {
            // 奇数&1=1，偶数&1=0
            if ((A[i] & 1) == 0) {
                ret[even] = A[i];
                even += 2;
            } else {
                ret[odd] = A[i];
                odd += 2;
            }
        }
        return ret;
    }

}
