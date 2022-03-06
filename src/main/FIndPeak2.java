package main;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class FIndPeak2 {
    public static int n = 7;
    public static int[] numbers = new int[n];

    public static void main(String[] args) {
        genNumber(numbers);
        System.out.println(Arrays.toString(numbers));
        int [] number = new int[]{1, 2, 1, 0, 2, 3, 5};
        int res = findPeak2(numbers, 0, n - 1);
        System.out.println(res);
    }

    public static void genNumber(int @NotNull [] arr){
        int x = arr.length;

        for(int i = 0; i < x; i ++){
            arr[i] = (int)(Math.random() * 10 + 5);
        }

    }

    public static int findPeak2(int[] num, int init, int end){
        int j = (init + end) / 2;

        if(end == init && init == 0){
            if(num[j] >= num[j + 1])
                return 0;
        }

        else if( end == init && init == n - 1){
            if (num[j] >= num[j - 1]){
                return n - 1;
            }
        }

        if(num[j] >= num[j + 1] && num[j] >= num[j - 1]){
            return j;
        }

        else if(num[j] < num[j + 1]){
            return findPeak2(num, j + 1, end);
        }
        
        else if(num[j] < num[j - 1]){
            return findPeak2(num, init, j - 1);
        }
        return 0;
    }
}
