package com.mayo.interview_questions.collections;

import java.util.Random;

/**
 * @author yoav @since 10/19/16.
 */
public class UniqueSortedArray {

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] kArr = new int[rnd.nextInt(100)];
        int bound = kArr.length / 2;
        int n = rnd.nextInt(bound);
        System.out.println("n is: " + n);
        int[] nArr = new int[n];

        for (int i = 0; i < nArr.length; i++) {
            kArr[i] = -1;
            nArr[i] = -1;
        }

        for (int i = 0; i < kArr.length; i++) {
            kArr[i] = rnd.nextInt(n);
            if(kArr[i] == 2)kArr[i] = 0;
        }

        printArr(kArr);


        for (int i = 0; i < kArr.length; i++) {
            int num = kArr[i];
            if (nArr[num] != -1) {
                kArr[i] = -1;
            } else {
                nArr[num]=i;
            }
            kArr[i] = 0;
        }

        for (int i = 0; i < nArr.length; i++) {
            if(nArr[i] != -1){
                kArr[kArr[nArr.length]++] = i;
            }
        }

        printArr(nArr);
        printArr(kArr);
    }

    private static void printArr(int[] arr) {
        System.out.println();
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i < arr.length -1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
