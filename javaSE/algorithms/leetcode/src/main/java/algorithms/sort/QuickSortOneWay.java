package algorithms.sort;

class QuickSortOneWay implements SortFunction {

    @Override
    public void sort(int[] arr) {
        this.quickSortOneWay(arr, 0, arr.length-1);
    }

    private void quickSortOneWay(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = this.partition(arr, l, r);

        this.quickSortOneWay(arr, l, p - 1);
        this.quickSortOneWay(arr, p + 1, r);

    }


    private int partition(int[] arr, int l, int r) {
        int randomIndex = (int) (Math.random() * (r - l + 1) + l);
        SortUtils.swap(arr, randomIndex, l);

        int pivot = arr[l];

        int j = l;

        for (int i = l+1; i <= r; i++) {
            if (arr[i] < pivot) {
                SortUtils.swap(arr, j+1, i);
                j++;
            }
        }

        SortUtils.swap(arr, j, l);
        return j;
    }
}
