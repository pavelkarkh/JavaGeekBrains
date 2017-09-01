package ru.s0ber.lesson2;

import java.util.Arrays;

public class HomeWork2 {

    public static void main(String[] args) {

        // 1.
        int[] arr1 = {1,0,0,1,1,1,0,0,0,1};
        for (int i = 0; i < arr1.length; i++) {
                switch (arr1[i]){
                    case 0: {
                        arr1[i] = 1;
                        break;
                    }
                    case 1: {
                        arr1[i] = 0;
                        break;
                    }
                }

        }
        System.out.println(Arrays.toString(arr1));

        // 2.
        int[] arr2 = new int[8];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr2));

        // 3.
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr3));

        // 4.
        int[][] arr4 = new int[5][5];
        // массив квадратный кол-во строк = кол-ву столбцов
        int length = arr4.length;
        for (int i = 0; i < length; i++) {
            arr4[i][i] = 1;
            arr4[i][(length - 1) - i] = 1;
            System.out.println(Arrays.toString(arr4[i]));
        }

        // 5.
        int[] arr5 = {21,54,2,8,32,6,5,24,96,44};
        int maxArr5 = arr5[0], minArr5 = arr5[0];
        for (int i = 0; i < arr5.length; i++) {
            if (minArr5 > arr5[i]) {
                minArr5 = arr5[i];
            }
            if (maxArr5 < arr5[i]) {
                maxArr5 = arr5[i];
            }
        }
        System.out.println("Min: " + minArr5 + ", Max: " + maxArr5);

        int[] arr6 = {2, 1, 1, 2, 1};
        System.out.println(checkBalance(arr6));

        int[] arr7 = {1,2,3,4,5};
        arr7 = offsetArray(arr7, 2);
        System.out.println(Arrays.toString(arr7));
    }

    // 6.
    public static boolean checkBalance(int[] arr) {
        if (arr.length != 0) {
            int length = arr.length;
            int right = length / 2;
            int left = length - right;
            int summRigth = 0, summLeft = 0;
            for (int i = 0; i < left; i++) {
                summLeft += arr[i];
            }
            for (int i = left; i < length; i++) {
                summRigth += arr[i];
            }
            return summLeft == summRigth;
        } else {
            System.out.println("Массив пустой!");
            return false;
        }
    }

    // 7.
    public static int[] offsetArray(int[] arr, int n) {
        // arr = {1,2,3,4,5}
        // для упрощения задачи я реализовал только смещение вправо
        // аналогично можно сделать смещение влево, если n будет < 0
        // такие дела.
        int arrLength = arr.length;
        if (arrLength != 0) {
            for (int i = 0; i < Math.abs(n); i++) {
                int tmp = 0, tmp2 = 0;
                for (int j = 0; j < arrLength; j++) {
                    if (j == 0) {
                        tmp = arr[j];
                        arr[j] = arr[arrLength - 1];
                    } else {
                        tmp2 = arr[j];
                        arr[j] = tmp;
                        tmp = tmp2;
                    }

                }
            }
        }
        return arr;
    }

}
