package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> listOfNumbers = new ArrayList<>();

        listOfNumbers.add(4);
        listOfNumbers.add(3);
        listOfNumbers.add(2);
        listOfNumbers.add(1);
        listOfNumbers.add(67);
        listOfNumbers.add(7);
        listOfNumbers.add(5);
        listOfNumbers.add(0);
        listOfNumbers.add(6);
        listOfNumbers.add(-1);

        listOfNumbers = selectionSort(listOfNumbers);

        System.out.println("List of numbers sorted with selection sort is " + listOfNumbers.toString());

        ArrayList<Integer> unsortedArrayList = new ArrayList<>();

        unsortedArrayList.add(4);
        unsortedArrayList.add(1);
        unsortedArrayList.add(2);
        unsortedArrayList.add(5);
        unsortedArrayList.add(3);
        unsortedArrayList.add(-55);
        unsortedArrayList.add(10000);
        unsortedArrayList.add(0);

        unsortedArrayList = insertionSort(unsortedArrayList);

        System.out.println("List of numbers sorted with selection sort is " + unsortedArrayList.toString());

    }

    public static ArrayList<Integer> selectionSort(ArrayList<Integer> listOfNumbers) {

        int smallestNumber;
        int indexOfSmallestNumber = 0;
        int indexOfNumberToSwap = 0;
        int numberToSwap = 0;

        for (int i = 0; i < listOfNumbers.size(); i++) {
            smallestNumber = Integer.MAX_VALUE;
            for (int x = i; x < listOfNumbers.size(); x++) {
                if (listOfNumbers.get(x) < smallestNumber) {
                    smallestNumber = listOfNumbers.get(x);
                    numberToSwap = listOfNumbers.get(i);
                    indexOfSmallestNumber = x;
                    indexOfNumberToSwap = i;
                }
            }

            if (smallestNumber != numberToSwap) {
                listOfNumbers.set(indexOfSmallestNumber, numberToSwap);
                listOfNumbers.set(indexOfNumberToSwap, smallestNumber);
            }

        }

        return listOfNumbers;

    }

    public static ArrayList<Integer> insertionSort(ArrayList<Integer> unsortedArrayList) {

        ArrayList<Integer> sortedArrayList = new ArrayList<>();

        int initialArraySize = unsortedArrayList.size();

        for(int x = 0; x < initialArraySize; x++) {

            sortedArrayList.add(unsortedArrayList.get(0));
            unsortedArrayList.remove(0);

            int numberToMoveDown = sortedArrayList.get(sortedArrayList.size()-1);
            int counter = sortedArrayList.size()-1;

            if(sortedArrayList.size() > 1) {
                while(counter > 0 && numberToMoveDown < sortedArrayList.get(counter-1)) {
                    int indexOfNumberToMoveDown = sortedArrayList.indexOf(numberToMoveDown);
                    int indexOfNumberToMoveUp = counter-1;
                    int numberToMoveUp = sortedArrayList.get(counter-1);

                    swapItemsInArray(numberToMoveDown, indexOfNumberToMoveDown, numberToMoveUp, indexOfNumberToMoveUp, sortedArrayList);

                    counter--;
                }
            }

        }

        return sortedArrayList;

    }

    private static void swapItemsInArray(int firstNumber, int firstNumberIndex, int secondNumber, int secondNumberIndex, ArrayList<Integer> arrayList) {
        arrayList.set(secondNumberIndex, firstNumber);
        arrayList.set(firstNumberIndex, secondNumber);
    }

}
