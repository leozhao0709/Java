package algorithms.sort;

class SelectionSort implements SortFunction{

    public void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            SortUtils.swap(arr, i, minIndex);
        }
    }
}
