package grafskaia.java.core.hw.lesson3.task1;

import grafskaia.java.core.hw.lesson3.task2.Apple;

public class MethodChangeArray {

    public static void main(String[] args) {

        MakeArray<Apple> appleArray = new MakeArray<>(new Apple[4]);
        changeArray(appleArray,0,2);
        appleArray.getArrayPrint();
        MakeArray<Integer> newArray = new MakeArray<>(10,20,30);
        System.out.print("Исходный массив: ");
        newArray.getArrayPrint();
        changeArray(newArray,0,2);
        System.out.print("Новый массив: ");
        newArray.getArrayPrint();

        MakeArray<String> newArray2 = new MakeArray<>("Hi!", "How", "are", "you");
        newArray2.getArrayPrint();
        changeArray(newArray2,0,2);
        newArray2.getArrayPrint();

        String[] arr1 = new String[]{"Hi!", "How", "are", "you"};
        Integer[] arr2 = new Integer[]{10,20,30};
        System.out.println("Исходный массив: ");
        for (int i = 0; i < 4; i++) {
            System.out.print(arr1[i] +  " ");
        }
        changeArray2(arr1,0,2);
        System.out.println("Новый массив: ");
        for (int i = 0; i < 4; i++) {
            System.out.print(arr1[i] +  " ");
        }
        System.out.println("Исходный массив: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(arr2[i] +  " ");
        }
        changeArray2(arr2,0,2);
        System.out.println("Новый массив: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(arr2[i] +  " ");
        }
    }

    public static <T extends Object> MakeArray<T> changeArray(MakeArray<T> arr, int i, int k) {

        if (arr.getArrayLength() == 1) {
            System.out.println("Нужен массив как минимум из двух элементов");
        } else {
            T temporary = arr.getArray()[i];
            arr.setArrayElement(i, arr.getArray()[k]);
            arr.setArrayElement(k, temporary);
        }
        return arr;
    }

    public static <T extends Object> void changeArray2(T[] arr, int i, int k) {
            T temporary = arr[i];
            arr[i] = arr[k];
            arr[k] = temporary;
    }

}
