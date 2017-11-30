package com.zangyy.demo;

/**
 * 1）设置两个变量i、j，排序开始的时候：i=0，j=N-1；
 * 2）以第一个数组元素作为关键数据，赋值给key，即key=A[0]；
 * 3）从j开始向前搜索，即由后开始向前搜索(j--)，找到第一个小于key的值A[j]，将A[j]和A[i]互换；
 * 4）从i开始向后搜索，即由前开始向后搜索(i++)，找到第一个大于key的A[i]，将A[i]和A[j]互换；
 * 5）重复第3、4步，直到i=j； (3,4步中，没找到符合条件的值，即3中A[j]不小于key,4中A[i]不大于key的时候改变j、i的值，
 *      使得j=j-1，i=i+1，直至找到为止。找到符合条件的值，进行交换的时候i， j指针位置不变。另外，i==j这一过程一定正好是i+或j-完成的时候，此时令循环结束）。
 * Created by zangyaoyi on 2017/11/30.
 */
public class FastSorting {

    static void fastSort(int n[], int left, int right) {
        //对特殊值和边界值的检查，提高程序的鲁棒性
        if (n == null || left < 0) {
            return;
        }
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            fastSort(n, left, dp - 1);
            fastSort(n, dp + 1, right);
        }
    }

    static int partition(int n[], int left, int right) {
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot) {
                right--;
            }
            if (left < right) {
                n[left++] = n[right];
            }
            while (left < right && n[left] <= pivot) {
                left++;
            }
            if (left < right) {
                n[right--] = n[left];
            }
        }
        n[left] = pivot;
        return left;
    }
}