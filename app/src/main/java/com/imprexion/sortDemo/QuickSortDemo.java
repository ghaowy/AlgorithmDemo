package com.imprexion.sortDemo;

import java.util.Arrays;

/**
 * @author : gongh
 * @date : 2020/6/18 10:50
 * @desc : TODO 快速排序
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 8, 9, 1,20, 2, 5, 6};
//        quickSortOne(arr, 0, arr.length - 1);
//        quickSortTwo(arr, 0, arr.length - 1);
//        quickSortThree(arr, 0, arr.length - 1);
        quickSortFour(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSortFour(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || start >= end) {
            return;
        }

//        System.out.println("arr-->" + Arrays.toString(arr) );
        System.out.println("start= " + start);
        System.out.println("end= " + end);

        int standard = arr[start];
        int low = start;
        int high = end;
        while (low < high) {
            while (low < high && arr[high] > standard) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= standard) {
                low++;
            }
            arr[high] = arr[low];
        }

        arr[low] = standard;

        if (low != start && low != end) {
            quickSortFour(arr, start, low);
            quickSortFour(arr, low + 1, end);
        }
    }

    private static void quickSortThree(int[] arr, int start, int end) {
        if (arr == null || start >= end) {
            return;
        }

        System.out.println("start= " + start + " end= " + end);
        System.out.println(Arrays.toString(arr));

        // 定义一个标准数
        int field = arr[start];

        int low = start;
        int high = end;

        while (low < high) {
            // 当 后面的数 比标准数小，则移到前面
            while (low < high && arr[high] >= field) {
                high--;
            }

            arr[low] = arr[high];

            while (low < high && arr[low] <= field) {
                low++;
            }

            arr[high] = arr[low];
        }

        arr[low] = field;

        quickSortThree(arr, start, low);
        quickSortThree(arr, low + 1, end);
    }

    private static void quickSortTwo(int[] arr, int start, int end) {
        if (arr == null || start >= end) {
            return;
        }
        int standard = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (right > left && arr[right] > standard) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= standard) {
                left++;
            }

            arr[right] = arr[left];
        }

        arr[left] = standard;

        quickSortTwo(arr, start, left - 1);

        quickSortTwo(arr, left + 1, end);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (arr == null || start >= end) {
            return;
        }
        // 定义基准数
        int base = arr[start];
        int low, high;
        low = start;
        high = end;

        while (low < high) {
            while (low < high && arr[high] >= base) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[low] < base) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = base;
        quickSort(arr, start + 1, low);
        quickSort(arr, low + 1, end);
    }


    /**
     * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
     * <p>
     * 从数列中挑出一个元素，称为 “基准”（pivot）；
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * <p>
     * 时间复杂度 o(nlogn)
     * 空间复杂度 o(nlogn)
     *
     * @param arr
     * @return
     */
    private static void quickSortOne(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || start >= end) {
            return;
        }

        int standard = arr[start];
        int low, high;
        low = start;
        high = end;

        while (low < high) {
            if (arr[high] >= standard) {
                high--;
            }

            arr[low] = arr[high];

            if (low < high && arr[low] <= standard) {
                low++;
            }
            arr[high] = arr[low];
        }

        arr[low] = standard;


        quickSortOne(arr, start, low);

        quickSortOne(arr, low + 1, end);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = 0;
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
