package site.syso.explore;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 排序
 */
public class Sorter {

    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        int[] arr1 = {3, 6, 2, 4, 1, 5};
        // 冒泡排序
        print(sorter.bubbleSort(arr1));
        // 插入排序
        int[] arr2 = {3, 6, 2, 4, 1, 5};
        print(sorter.insertionSort(arr2));
        // 选择排序
        int[] arr3 = {3, 6, 2, 4, 1, 5};
        print(sorter.selectionSort(arr3));
    }


    /**
     * 选择排序
     * <p>
     * 原地排序：√
     * 稳定排序：×
     * 时间复杂度：O(n²)
     * <p>
     * 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。
     * 但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
     */
    private int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) minIndex = j;
            }
            if (minIndex == i) continue;
            // 交换
            arr[i] ^= arr[minIndex];
            arr[minIndex] ^= arr[i];
            arr[i] ^= arr[minIndex];
        }
        return arr;
    }


    /**
     * 插入排序
     * <p>
     * 原地排序：√
     * 稳定排序：√
     * 时间复杂度：O(n²)
     * <p>
     * 将数组中的数据分为两个区间，已排序区间和未排序区间。
     * 初始已排序区间只有一个元素，就是数组的第一个元素。
     * 插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。
     * 重复这个过程，直到未排序区间中元素为空，算法结束。
     */
    private int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] <= tmp) {
                    break;
                }
                arr[j + 1] = arr[j];    // 已排序区域元素向后移动
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }


    /**
     * 冒泡排序
     * <p>
     * 原地排序：√
     * 稳定排序：√
     * 时间复杂度：O(n²)
     * <p>
     * 冒泡排序只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求。如果不满足就让它俩互换。
     */
    private int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean change = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {  // 交换
                    arr[j] ^= arr[j + 1];
                    arr[j + 1] ^= arr[j];
                    arr[j] ^= arr[j + 1];
                    change = true;
                }
            }
            if (!change) break;
        }
        return arr;
    }


    private static void print(int[] arr) {
        System.out.println(Arrays.stream(arr).boxed().map(Object::toString).collect(Collectors.joining(",")));
    }

}
