
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Add code here to test your solutions

        int[] intArr = {1,6,324,88,4,35,45, 6, 45,33};
        int[] sAndL = findLargestAndSmallest(intArr);
        System.out.println("Smallest and largest");
        for (int i = 0; i < 2; i ++){
            System.out.println(sAndL[i]);
        }

        List<Integer> lInts = new ArrayList<>();
        for(int i = 0; i < intArr.length; i++)
            lInts.add(intArr[i]);

        System.out.println("Sum of two largest: " + sumOfTwoLargest(lInts));

        System.out.println("Remove duplicates:");
        printList(removeDuplicatesFromList(lInts));


        int[] array1 = {1,4,7,9,0,0,0};
        int[] array2 = {1,5,11};
        
        System.out.println("Merging and sorting:");

        int[] merged = mergeSortedArrays(array1,array2);


        for (int i = 0; i < merged.length; i ++){
            System.out.println(merged[i]);
        }


    }

    /**
     * Question 1: Find the smallest and largest numbers in an array
     *
     * You are given an array of integers, with at least two values.
     * Find the smallest and largest numbers in the array, and pass them back in an array containing two values,
     * the smallest and the largest.
     *
     * @param array An array of integers with at least two values
     * @return An array of integers with two elements, the largest and smallest from the method parameter
     */
    public static int[] findLargestAndSmallest(int array[]){
        int[] sAndLInts = {array[0], array[0]};

        for (int i = 1; i < array.length; i++){

            if (array[i] < sAndLInts[0]){
                sAndLInts[0] = array[i];
                continue;
            }
            if (array[i] > sAndLInts[1])
                sAndLInts[1] = array[i];
        }

        return sAndLInts;

    }


    /**
     * Questions 2
     *
     * Given a List of Integers, return the sum of the two largest values.
     *
     * If the array is empty, return 0.
     * If the array has one value, return that value.
     *
     * @param intList A List of integers of any size.
     * @return Sum of the two largest values
     */

    public static int sumOfTwoLargest(List intList){
        int[] intArray = listToIntArray(intList);

        int largest, secondLargest;
        if (intArray.length == 0)
            return 0;
        else if (intArray.length == 1)
            return intArray[0];
        else {
            int indexOfLargest = 0;
            largest = intArray[0];
            secondLargest = intArray[0];
            for (int i = 1; i < intArray.length; i++) {
                if(intArray[i] > largest){
                    largest = intArray[i];
                    indexOfLargest = i;
                }
            }

            intArray = removeElement(intArray, indexOfLargest);
            for (int i = 1; i < intArray.length; i++) {
                if(intArray[i] > secondLargest)
                    secondLargest = intArray[i];
            }
        }

        return largest + secondLargest;

    }

    /**
     * Question3: Remove duplicates from a List
     *
     * You are given a List of Integers that might have duplicates. You must remove any duplicates from the List,
     * and return a List that doesn't contain duplicates. The order of the elements in the original List
     * does not need to be kept the same.
     *
     * You MAY use any collections types you wish, but the method must return a List.
     *
     * Example: [1,4,3,2,1] would return, in any order, [1,2,3,4]
     *
     * @param intList A List of Integers that may or may not include duplicates
     * @return A List of Integers that doesn't contain duplicates.
     */
    public static List removeDuplicatesFromList(List intList){
        Collections.sort(intList);

        int temp = (int) intList.get(0);

        for (int i = 1; i < intList.size(); i++){
            if (temp == (int) intList.get(i))
                intList.remove(i);
            else
                temp = (int) intList.get(i);
        }

        return intList;
    }


    //BONUS QUESTION IS BELOW

    /**
     * BONUS:
     *
     * Given two sorted arrays of integers, return a sorted array of the two original arrays merged together.
     * All valid numbers in these arrays are greater than 0.
     *
     * array1 has enough empty space (represented by the value 0) to hold all valid values from the original two arrays
     * combined. The returned array must be array1 with the new values merged in.
     *
     * For example:
     *      array1 = [1,4,7,9,0,0,0]
     *      array2 = [1,5,11]
     *      returned array = [1,1,4,5,7,9,11]
     *
     * No test cases are provided for this method, you will need to test it on your own.
     *
     * @param array1 Array of sorted integers
     * @param array2 Array of sorted integers
     * @return Array of sorted integers, merged from array1 and array2
     */
    public static int[] mergeSortedArrays(int[] array1, int[] array2){
        int array2Index = 0;
        //merge first
        for(int i = 0; i < array1.length; i++) {
            if(array1[i] == 0){
                array1[i] = array2[array2Index++];
            }
        }
        //then sort
        for(int i = 0; i < array1.length; i++){
            for (int j = 1; j < array1.length - i; j++){
                if(array1[j-1] > array1[j]){
                    //swap
                    int temp = array1[j-1];
                    array1[j -1] = array1[j];
                    array1[j] = temp;
                }
            }
        }

        return array1;
    }

    /*
       * Helper methods
     */

    public static int[] removeElement(int[] original, int element){
        int[] n = new int[original.length - 1];
        System.arraycopy(original, 0, n, 0, element );
        System.arraycopy(original, element+1, n, element, original.length - element-1);
        return n;
    }


    public static int[] listToIntArray(List intList){
        int[] ints = new int[intList.size()];

        for (int i = 0; i < ints.length; i++){
            ints[i] = (int) intList.get(i);
        }
        return ints;
    }


    public static void printList(List list){
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i).toString());
    }

}
