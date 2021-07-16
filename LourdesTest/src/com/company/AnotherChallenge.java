package com.company;

public class AnotherChallenge {
    public static void main(String[] args) {
        int[] firstArray = {17, 92, 58, 14, 99, 8, 77, 93, 55, 57, 75, 5};
        int[] secondArray = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 120, 110};
        int[] finalArray = new int[24];
        int index = 0;
        for (int i = 0; i < 25; i++) {
            if (i % 2 == 0) {
                finalArray[i] = firstArray[index];
                continue;
            }
            finalArray[i] = secondArray[index];
            if (i % 2 != 0){
                index++;
            }
        }

    }
}
