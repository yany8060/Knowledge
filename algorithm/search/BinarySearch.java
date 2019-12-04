package algorithm.search;

/**
 * 
 */

 public class BinarySearch {

    /**
     * 非递归二分
     */
    public static int binarySearch(int a[], int n, int value) {
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) >> 1;
            if(a[mid] == value) {
                return mid;
            }else if(a[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归 二分
     */
    public static int binarySearchRecursive(int a[], int low, int high, int value) {
        if (high < low) return -1;
        int mid = low + (high - low) >> 1;
        if(a[mid] == value) {
            return mid;
        }else if(a[mid] > value) {            
            return binarySearchRecursive(a, low, mid - 1, value);
        } else {
            return binarySearchRecursive(a, mid + 1, high, value);
        }
    }

    /**
     * 二分查找第一个
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int binarySearchFirst(int a[], int n, int value) {
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low - (high - low) >> 1;
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || a[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找最后一个
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int binarySearchLast(int a[], int n, int value) {
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low - (high - low) >> 1;
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == high || a[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
    
     
 }