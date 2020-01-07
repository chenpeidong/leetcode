package site.syso.explore;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 排序
 */
public class Sorter {

    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        int[] original = {3, 6, 2, 4, 7, 8, 1, 5};
        // 冒泡排序
        print(sorter.bubbleSort(copyArray(original)));
        // 插入排序
        print(sorter.insertionSort(copyArray(original)));
        // 选择排序
        print(sorter.selectionSort(copyArray(original)));
        // 归并排序
        print(sorter.mergeSort(copyArray(original)));
        // 快速排序
        print(sorter.quickSort(copyArray(original)));
    }


    /**
     * 快速排序
     * <p>
     * 思想：分治。实现：递归
     * <p>
     * 原地排序：√
     * 稳定排序：×
     * 时间复杂度：O(nlogn) - O(n²)
     * 空间复杂度：O(1)
     */
    private int[] quickSort(int[] arr) {
        quickSortRec(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSortRec(int[] arr, int start, int end) {
        // 终止条件
        if (start >= end) return;
        // 获取分区点
        int pivotIndex = partition(arr, start, end);
        // 分治&递归
        quickSortRec(arr, start, pivotIndex - 1);
        quickSortRec(arr, pivotIndex + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        // 选取最后一个元素为基准数
        int pivot = arr[end];
        int i = start;
        // 比pivot小的值移动到前面
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                if (i != j) swap(arr, i, j);
                i++;
            }
        }
        // 交换：循环结束后i为大于和小于基准数的分界，且i下标对应的元素>pivot
        swap(arr, i, end);
        return i;
    }


    /**
     * 归并排序
     * <p>
     * 思想：分治。实现：递归
     * <p>
     * 原地排序：×
     * 稳定排序：√
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     */
    private int[] mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return arr;
        mergeSortRec(arr, 0, arr.length - 1);
        return arr;
    }

    private void mergeSortRec(int[] arr, int start, int end) {
        // 终止条件
        if (start >= end) return;
        // 分治&递归
        int mid = (start + end) / 2;
        mergeSortRec(arr, start, mid);
        mergeSortRec(arr, mid + 1, end);
        // 合并
        merge(arr, start, mid, end);
    }

    private void merge(int[] source, int start, int mid, int end) {
        int[] tmp = new int[source.length];
        int index = start, leftPos = start, rightPos = mid + 1;
        // 比较&合并
        while (leftPos <= mid && rightPos <= end) {
            if (source[leftPos] <= source[rightPos]) {
                tmp[index++] = source[leftPos++];
            } else {
                tmp[index++] = source[rightPos++];
            }
        }
        // 如果数组中仍有数据，直接将后面所有元素追加到result数组中
        while (leftPos <= mid) tmp[index++] = source[leftPos++];
        while (rightPos <= end) tmp[index++] = source[rightPos++];
        // 复制
        for (int i = start; i <= end; i++) {
            source[i] = tmp[i];
        }
    }


    /**
     * 选择排序
     * <p>
     * 原地排序：√
     * 稳定排序：×
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     * <p>
     * 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。
     * 但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
     */
    private int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) minIndex = j;
            }
            if (minIndex == i) continue;
            // 交换
            swap(arr, i, minIndex);
        }
        return arr;
    }


    /**
     * 插入排序
     * <p>
     * 原地排序：√
     * 稳定排序：√
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
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
     * 空间复杂度：O(1)
     * <p>
     * 冒泡排序只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求。如果不满足就让它俩互换。
     */
    private int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean change = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {  // 交换
                    swap(arr, j, j + 1);
                    change = true;
                }
            }
            if (!change) break;
        }
        return arr;
    }

    private void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    private static int[] copyArray(int[] original) {
        return Arrays.copyOf(original, original.length);
    }

    private static void print(int[] arr) {
        System.out.println(Arrays.stream(arr).boxed().map(Object::toString).collect(Collectors.joining(",")));
    }

}
