package _041_080._069_mySqrt;

class MySqrt {

    public int mySqrt(int x) {
        return this.binarySearch(1, x, x);
    }

    private int binarySearch(int start, int end, int x) {
        if (start > end) {
            return end;
        }

        int mid = start + (end - start) / 2;

        if (x / mid  == mid) {
            return mid;
        } else if (x / mid > mid) {
            return this.binarySearch(mid+1, end, x);
        } else {
            return this.binarySearch(start, mid - 1, x);
        }
    }
}
