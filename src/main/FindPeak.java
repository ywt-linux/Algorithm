package main;

import java.util.Arrays;

public class FindPeak {
    public static int n = 5;
    public static int[] numbers  = new int[n];
    public static int[] status = new int[n]; //0为未知，1为peak， 2为一定不是peak

    public static void main(String[] args) {
        for(int i = 0; i < n; i ++){
            numbers[i] = (int)(Math.random() * 10 + 5);
        }
        System.out.println(Arrays.toString(numbers));

        Arrays.fill(status, 0);

        findPeak(numbers, 0, n - 1);

        System.out.println(Arrays.toString(status));
    }

    public static void findPeak(int[] number, int init, int end){
        if(init > end) {
            return;
        }
        int j = (init + end) / 2;
        if( j == 0){
            if(number[j] > number[j + 1]){
                status[j] = 1;
                status[j + 1] = 2;
            }
            else{
                status[j] = 2;
                findPeak(numbers, j + 1, end);
            }
            return;
        }
        else if(j == n - 1){
            if(number[j] > number[j - 1]){
                status[j] = 1;
                status[j - 1] = 2;
            }
            else{
                status[j] = 2;
                findPeak(numbers, init, j - 1);
            }
            return;
        }
        else{
            if(number[j] > number[j + 1] && number[j] > number[j - 1]){
                status[j] = 1;
                status[j - 1] = 2;
                status[j + 1] = 2;
            }
            if( j - 1 >= 0 && end <= n -1 ) {
                findPeak(numbers, 0, j -1 );
                findPeak(numbers, j + 1, end);
            }
        }
        return;
    }

}
