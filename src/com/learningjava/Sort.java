package com.learningjava;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {
    public static void main(StringPractice[] args) {
        int[] list1 = {1, 3, 6, 2, 4, 5};
        Integer[] list = {1, 3, 6, 2, 4, 5};
//        insertSort(list);
//        quickSort(list, 0, list.length - 1);
//        popSort(list);
//        pickSort(list);
        Arrays.sort(list, Comparator.reverseOrder());
        System.out.println(Arrays.toString(list));
    }

    //插入排序法
    public static void insertSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int head = list[i];
            for (int j = i - 1; j >= 0; j--) {
                if (head < list[j]) {
                    list[j + 1] = list[j];
                } else {
                    list[j + 1] = head;
                    break;
                }
            }
            System.out.println(Arrays.toString(list));
        }
    }

    //分治排序,快速排序
    public static void quickSort(int[] arr, int begin, int end) {
        //先定义两个参数接收排序起始值和结束值
        int a = begin;
        int b = end;
        //先判断a是否大于b

        if (a >= b) {
            //没必要排序
            return;
        }
        //基准数,默认设置为第一个值
        int x = arr[a];

        //循环
        while (a < b) {
            //从后往前找,找到一个比基准数x小的值,赋给arr[a]
            //如果a和b的逻辑正确--a<b ,并且最后一个值arr[b]>x,就一直往下找,直到找到后面的值大于x
            while (a < b && arr[b] >= x) {
                b--;
            }
            //跳出循环,两种情况,一是a和b的逻辑不对了,a>=b,这时候排序结束.二是在后面找到了比x小的值
            if (a < b) {
                //将这时候找到的arr[b]放到最前面arr[a]
                arr[a] = arr[b];
                //排序的起始位置后移一位
                a++;
            }

            //从前往后找,找到一个比基准数x大的值,放在最后面arr[b]
            while (a < b && arr[a] <= x) {
                a++;
            }
            if (a < b) {
                arr[b] = arr[a];
                //排序的终止位置前移一位
                b--;
            }
            System.out.println(Arrays.toString(arr));
        }
        //跳出循环 a < b的逻辑不成立了,a==b重合了,此时将x赋值回去arr[a]
        arr[a] = x;
        //调用递归函数,再细分再排序
        quickSort(arr, begin, a - 1);
        quickSort(arr, a + 1, end);
    }

    public static void queickSort3(int[] a, int left, int right) {
        if (left > right) {
            return;
        }
        int temp = a[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && temp >= a[i]) {
                i++;
            }
            while (i < j && temp <= a[j]) {
                j++;
            }
            if (i < j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }

        }
        a[left] = a[i];
        a[i] = temp;
        queickSort3(a, left, i - 1);
        queickSort3(a, i + 1, right);
    }

    public static void quickSort2(int[] arr, int begin, int end) {
        int a = begin;
        int b = end;
        if (a >= b) {
            return;
        }
        int x = arr[a];
        while (a < b) {
            while (a < b && arr[b] >= x) {
                b--;
            }
            if (a < b) {
                arr[a] = arr[b];
                b--;
            }
            while (a < b && arr[a] <= x) {
                a++;
            }
            if (a < b) {
                arr[b] = arr[a];
                b--;
            }
            System.out.println(Arrays.toString(arr));
        }
        arr[a] = x;
        quickSort2(arr, begin, a - 1);
        quickSort2(arr, a + 1, end);
    }

    public static void popSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }

    public static void pickSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int head = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[head]) {
                    head = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[head];
            arr[head] = tmp;
        }
    }

    public static void divideSort(int[] arr, int s, int e) {
        int m = (e - s) / 2;
        if (s < m) {
            divideSort(arr, s, m);
        }
        if (m < e) {
            divideSort(arr, m, e);
        }
        merge(arr, s, m, e);
    }

    public static void merge(int[] arr, int s, int m, int e) {

    }
}
