package site.syso.leetcode.easy;

import java.util.Arrays;

/**
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 * <p>
 * 示例 1：
 * 输入：[2,1,2]
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：[1,2,1]
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：[3,2,3,4]
 * 输出：10
 * <p>
 * 示例 4：
 * 输入：[3,6,2,3]
 * 输出：8
 *  
 * <p>
 * 提示：
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-perimeter-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E0976_LargestPerimeter {


    public static void main(String[] args) {
        int[] arr = {2, 1, 2};
        System.out.println(new E0976_LargestPerimeter().largestPerimeter(arr));
    }


    /**
     * 思路：
     * 1. 排序
     * 2. 能组成面积最大三角形的必为连续的子数组
     */
    public int largestPerimeter(int[] A) {
        if (A == null || A.length < 3) return 0;

        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i - 1] + A[i - 2] <= A[i]) continue;
            return A[i - 1] + A[i - 2] + A[i];
        }

        return 0;
    }

}
