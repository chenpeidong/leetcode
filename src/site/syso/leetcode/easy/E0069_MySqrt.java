package site.syso.leetcode.easy;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E0069_MySqrt {

    /**
     * 二分法
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int left = 1, right = x, mid, res = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
                res = mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        E0069_MySqrt e0069_mySqrt = new E0069_MySqrt();
        System.out.println(e0069_mySqrt.mySqrt(4));
        System.out.println(e0069_mySqrt.mySqrt(8));
        System.out.println(e0069_mySqrt.mySqrt(9));
        System.out.println(e0069_mySqrt.mySqrt(15));
        System.out.println(e0069_mySqrt.mySqrt(17));
    }

}
