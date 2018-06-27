package algorithms.sort;

class InsertionSort implements SortFunction {

    @Override
    public void sort(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if (arr[j] < arr[j-1]) {
                    SortUtils.swap(arr, j, j-1);
                } else {
                    break;
                }
            }

        }
    }
}
