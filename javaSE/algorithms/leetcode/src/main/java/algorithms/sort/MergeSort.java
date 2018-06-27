package algorithms.sort;

class MergeSort implements SortFunction {

    @Override
    public void sort(int[] arr) {
        this.mergeSort(arr, 0, arr.length-1);
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l)/2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);

        this.merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int l, int middle, int r) {
        int[] arrTemp = new int[r - l + 1];

        for (int i = 0; i < arrTemp.length ; i++) {
            arrTemp[i] = arr[l + i];
        }

        int i = l;
        int j = middle + 1;

        for (int k = l; k <= r; k++) {
            if (i > middle) {
                arr[k] = arrTemp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = arrTemp[i - l];
                i++;
            } else if (arr[i] < arr[j]) {
                arr[k] = arrTemp[i - l];
                i++;
            } else {
                arr[k] = arrTemp[j - l];
            }
        }

    }
}
