public class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int arrayLength = mountainArr.length();

        int peakIndex = findPeakIndex(mountainArr, 0, arrayLength - 1);
        int left = search(mountainArr, 0, peakIndex, target, true);
        if (left != -1)
            return left;

        return search(mountainArr, peakIndex+1, arrayLength-1, target, false);
    }

    public int findPeakIndex(MountainArray ma, int start, int end) {
        if (start >= end) return start;

        int mid = start + (end - start) / 2;
        if (ma.get(mid) < ma.get(mid + 1)) {
            return findPeakIndex(ma, mid + 1, end);
        } else {
            return findPeakIndex(ma, start, mid - 1);
        }
    }

    public int search(MountainArray ma, int start, int end, int target, boolean increasing) {
        if (start > end) return -1;

        int mid = start + (end - start) / 2;
        int midValue = ma.get(mid);
        if (midValue == target) {
            return mid;
        } else if (increasing) {
            if (midValue > target) {
                return search(ma, start, mid - 1, target, increasing);
            } else {
                return search(ma, mid + 1, end, target, increasing);
            }
        } else {
            if (midValue > target) {
                return search(ma, mid + 1, end, target, increasing);
            } else {
                return search(ma, start, mid - 1, target, increasing);
            }
        }
    }

    interface MountainArray {
        public int get(int index);
        public int length();
    }
}