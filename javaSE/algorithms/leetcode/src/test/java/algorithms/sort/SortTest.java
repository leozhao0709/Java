package algorithms.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SortTest {

    private SelectionSort selectionSort;
    private InsertionSort insertionSort;
    private MergeSort mergeSort;
    private QuickSortOneWay quickSortOneWay;
    private QuickSortThreeWay quickSortThreeWay;

    @Before
    public void setUp() throws Exception {
        this.selectionSort = new SelectionSort();
        this.insertionSort = new InsertionSort();
        this.mergeSort = new MergeSort();
        this.quickSortOneWay = new QuickSortOneWay();
        this.quickSortThreeWay = new QuickSortThreeWay();
    }


    @Test
    public void sort() throws Exception {
        int n = 1000000;
        int[] arr = this.generateRandomArray(n, 0, 10);
        int[] arr1 = arr.clone();
        int[] arr2 = arr.clone();
        int[] arr3 = arr.clone();
        int[] arr4 = arr.clone();
        int[] arr5 = arr.clone();

//        this.testSort("selectionSort", arr1, this.selectionSort);
//        this.testSort("InsertionSort", arr2, this.insertionSort);
//        this.testSort("quickSortOneWay", arr4, this.quickSortOneWay);
        this.testSort("mergeSort", arr3, this.mergeSort);
        this.testSort("quickSortThreeWay", arr5, this.quickSortThreeWay);
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

        if (arr.length <= 100) {
            System.out.println("before " + sortName + ": " + Arrays.toString(arrCopy));
            System.out.println("after " + sortName + ": " + Arrays.toString(arr));
        }

        if (!this.isSorted(arr)) {
            System.out.println("before " + sortName + ": " + Arrays.toString(arrCopy));
            System.out.println("after " + sortName + ": " + Arrays.toString(arr));
            throw new Exception(sortName + " Error");
        }
    }
}