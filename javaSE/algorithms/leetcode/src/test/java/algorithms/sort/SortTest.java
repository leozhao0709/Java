package algorithms.sort;

import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SortTest {

    private SelectionSort selectionSort;
    private InsertionSort insertionSort;
    private MergeSort mergeSort;

    @Before
    public void setUp() throws Exception {
        this.selectionSort = new SelectionSort();
        this.insertionSort = new InsertionSort();
        this.mergeSort = new MergeSort();
    }


    @Test
    public void sort() throws Exception {
        int n = 1000000;
        int[] arr = this.generateRandomArray(n, 0, n);
        int[] arr1 = arr.clone();
        int[] arr2 = arr.clone();
        int[] arr3 = arr.clone();

//        this.testSort("selectionSort", arr1, this.selectionSort);
//        this.testSort("InsertionSort", arr2, this.insertionSort);
        this.testSort("mergeSort", arr3, this.mergeSort);
    }

    private boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    private int[] generateRandomArray(int n, int rangeL, int rangeR) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1)) + rangeL;
        }

        return arr;
    }

    private void testSort(String sortName, int[] arr, SortFunction sortFunction) throws Exception {

        int[] arrCopy = arr.clone();
        long startTime = System.nanoTime();
        sortFunction.sort(arr);
        long endTime = System.nanoTime();
        System.out.println(sortName + ": " + (double)(endTime - startTime)/Math.pow(10, 9) + "s");

        if (!this.isSorted(arr)) {
            System.out.println("before " + sortName + ": " + Arrays.toString(arrCopy));
            System.out.println("after " + sortName + ": " + Arrays.toString(arr));
            throw new Exception(sortName + " Error");
        }
    }
}