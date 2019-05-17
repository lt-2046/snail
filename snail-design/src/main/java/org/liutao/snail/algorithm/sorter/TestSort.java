package org.liutao.snail.algorithm.sorter;

public class TestSort {

    public static int find(int[] arrays, int key) {
        int low = 0;
        int high = arrays.length - 1;
        int flag;
        while (low <= high) {
            flag = (low + high) / 2;
            if (arrays[flag] > key) {
                high = flag - 1;
            } else if (arrays[flag] < key) {
                low = flag + 1;
            } else {
                return flag;
            }
        }

        return -1;
    }

    public static void pao(int[] arrays) {
        int length = arrays.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                }
            }
        }
    }

    public static void select(int[] arrays) {
        int length = arrays.length;
        for (int i = 0; i < length; i++) {
            int k = i;
            for (int j = i; j < length; j++) {
                if (arrays[k] > arrays[j]) {
                    k = j;
                }
            }
            if (k > i) {
                int temp = arrays[i];
                arrays[i] = arrays[k];
                arrays[k] = temp;
            }

        }
    }

    public static void insertSort(int[] arrays) {
        int length = arrays.length-1;
        int flagValue;
        for (int i = 0; i < length; i++) {
            int flag = i;
            flagValue = arrays[flag + 1];
            while (flag >= 0 && arrays[flag] > flagValue) {
                arrays[flag+1] = arrays[flag];
                flag--;
            }
            arrays[flag+1] = flagValue;
        }
    }

    public static void main(String[] args) {
        int[] arrys = {0, 5, 8, 9, 12, 14, 45, 69, 444, 789};
        System.out.println("二分查找");
        int flag = TestSort.find(arrys, 5);
        System.out.println(flag);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ");
        int[] arrys1 = {5, 45, 8, 12, 0, 9, 789, 14, 69, 444};
        System.out.println("冒泡排序");
        TestSort.pao(arrys1);
        for (int temp : arrys1)
            System.out.print(temp + ",");
        System.out.println("");
        System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ");
        int[] arrys2 = {5, 45, 8, 12, 0, 9, 789, 14, 69, 444};
        TestSort.select(arrys2);
        System.out.println("选择排序");
        for (int temp : arrys2)
            System.out.print(temp + ",");
        System.out.println("");
        int[] arrys4 = {5, 45, 8, 12, 0, 9, 789, 14, 69, 444};
        System.out.println("插入排序");
        TestSort.insertSort(arrys4);
        for (int temp : arrys4)
            System.out.print(temp + ",");
        System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ");
    }


}