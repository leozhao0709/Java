package algorithms.sort;

class QuickSortThreeWay implements SortFunction {

    @Override
    public void sort(int[] arr) {
        this.quickSortThreeWay(arr, 0, arr.length-1);
    }

    private void quickSortThreeWay(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int randomIndex = (int)(Math.random() * (r - l + 1) + l);
        SortUtils.swap(arr, l, randomIndex);
        int pivot = arr[l];

        int lt = l;
        int gt = r;
        int i = l+1;

        while (i <= gt) {
            if (arr[i] < pivot) {
                SortUtils.swap(arr, i, lt+1);
                i++;
                lt++;
            } else if (arr[i] > pivot) {
                SortUtils.swap(arr, i, gt);
                gt--;
            } else {
                i++;
            }
        }

        SortUtils.swap(arr, l, lt);

        this.quickSortThreeWay(arr, l, lt-1);
        this.quickSortThreeWay(arr, gt+1, r);
    }
}
