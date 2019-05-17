package org.liutao.snail.algorithm.sorter;

public class MySort {

    public static int find(int[] arrys, int key) {
        int low = 0;
        int high = arrys.length - 1;
        int flag = -1;

        if (arrys[low] > key || arrys[high] < key || high < low) {
            return flag;
        }

        while (low <= high) {
            flag = (low + high) / 2;
            if (arrys[flag] > key) {
                high = flag - 1;
            } else if (arrys[flag] < key) {
                low = flag + 1;
            } else {
                return flag;
            }
        }
        return flag;
    }

    /**
     * 冒泡排序
     *
     * @param arrys
     */
    public static void pao(int[] arrys) {
        int length = arrys.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arrys[j] > arrys[j + 1]) {
                    int temp = arrys[j];
                    arrys[j] = arrys[j + 1];
                    arrys[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * @param arrys
     */
    public static void select(int[] arrys) {
        int length = arrys.length;
        for (int i = 0; i < length; i++) {
            int k = i;
            for (int j = i + 1; j < length; j++) {
                if (arrys[j] < arrys[k]) {
                    k = j;
                }
            }
            if (k > i) {
                int temp = arrys[i];
                arrys[i] = arrys[k];
                arrys[k] = temp;
            }
        }
    }


    /**
     * 插入排序
     *
     * @param arrys
     */
    public static void insertSort(int[] arrys) {
        int length = arrys.length;
        int falgValue;
        for (int i = 0; i < length - 1; i++) {
            falgValue = arrys[i + 1];
            int flag = i;
            //int[] arrys3 = {5, 45, 8, 12, 0, 9, 789, 14, 69, 444};
            System.out.println("插入排序，正在提取第 " + (i + 1) + "   " + falgValue + "   flag  " + flag);
            while (flag >= 0 && falgValue < arrys[flag]) {
                System.out.print("更换位置 " + arrys[flag + 1] + "  为 " + arrys[flag]);
                arrys[flag + 1] = arrys[flag];
                flag--;
                System.out.println("flag " + flag);
                System.out.println("内层循环结果 ");
                for (int temp : arrys)
                    System.out.print(temp + ",");
                System.out.println(" ");
            }
            arrys[flag + 1] = falgValue;
            System.out.println("arrys[flag+1] " + (flag + 1) + "  " + arrys[flag + 1]);
            System.out.println("结果 ");
            for (int temp : arrys)
                System.out.print(temp + ",");
            System.out.println(" ");
            System.out.println("============================================== ");
        }
    }

    /**
     * 插入排序
     *
     * @param arrays
     */
    public static void insertSort2(int[] arrays) {
        int length = arrays.length;

        int flagValue;//记录比较值
        for (int i = 0; i < length - 1; i++) {
            flagValue = arrays[i + 1];
            int flag = i;
            while (flag >= 0 && arrays[flag] > flagValue) {
                arrays[flag + 1] = arrays[flag];
                flag--;//递减,从当前位置，一直向前比较
            }
            arrays[flag + 1] = flagValue;
        }
    }


    public static void main(String[] args) {
        int[] arrys = {0, 5, 8, 9, 12, 14, 45, 69, 444, 789};
        System.out.println("二分查找");
        int flag = MySort.find(arrys, 789);
        System.out.println(flag);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ");
        int[] arrys1 = {5, 45, 8, 12, 0, 9, 789, 14, 69, 444};
        System.out.println("冒泡排序");
        MySort.pao(arrys1);
        for (int temp : arrys1)
            System.out.print(temp + ",");
        System.out.println("");
        System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ");
        int[] arrys2 = {5, 45, 8, 12, 0, 9, 789, 14, 69, 444};
        MySort.select(arrys2);
        System.out.println("选择排序");
        for (int temp : arrys2)
            System.out.print(temp + ",");
        System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ");
//        System.out.println("");
//        int[] arrys3 = {5, 45, 8, 12, 0, 9, 789, 14, 69, 444};
//        System.out.println("插入排序");
//        MySort.insertSort(arrys3);
//        for (int temp : arrys3)
//            System.out.print(temp + ",");
//        System.out.println("\n %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ");
        int[] arrys4 = {5, 45, 8, 12, 0, 9, 789, 14, 69, 444};
        System.out.println("插入排序2");
        MySort.insertSort2(arrys4);
        for (int temp : arrys4)
            System.out.print(temp + ",");
        System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ");

        int[] arrys5 = {5, 45, 8, 12, 0, 9, 789, 14, 69, 444};
        System.out.println("快速排序");
        MySort.quickSort(arrys5, 0, arrys5.length - 1);
        for (int temp : arrys5)
            System.out.print(temp + ",");
        System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ");
    }

    /**
     * 快速排序
     *
     * @param data
     * @param start
     * @param end
     */
    public static void quickSort(int[] data, int start, int end) {
        if (data == null || start >= end) return;
        int i = start, j = end;
        int pivotKey = data[start];//定义基准值为数组第一个数
        while (i < j) {
            while (i < j && data[j] >= pivotKey)
                j--;
            if (i < j)
                data[i++] = data[j];
            while (i < j && data[i] <= pivotKey)
                i++;
            if (i < j)
                data[j--] = data[i];
        }
        data[i] = pivotKey;//把基准值放到合适的位置
        quickSort(data, start, i - 1);//对左边的子数组进行快速排序
        quickSort(data, i + 1, end);//对右边的子数组进行快速排序
    }
}