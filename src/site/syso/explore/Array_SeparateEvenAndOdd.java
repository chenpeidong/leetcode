package site.syso.explore;

import java.util.Arrays;

/**
 * 给定一个数组，使得奇数在前，偶数在后
 */
public class Array_SeparateEvenAndOdd {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        separate(a);
        System.out.println(Arrays.toString(a));
        int[] b = {1, 3, 5, 7, 9};
        separate(b);
        System.out.println(Arrays.toString(b));
        int[] c = {2, 4, 6};
        separate(c);
        System.out.println(Arrays.toString(c));
        int[] d = {2, 4, 6, 1, 3, 5};
        separate(d);
        System.out.println(Arrays.toString(d));
    }


    private static void separate(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int left = 0, right = arr.length - 1;
        while (right - left > 1) {
            while ((arr[left] & 1) == 1 && left < right) {//偶数
                left++;
            }
            while ((arr[right] & 1) == 0 && left < right) {//奇数
                right--;
            }
            if (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
    }

}
