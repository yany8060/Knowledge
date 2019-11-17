/**
 * 
 */
public class KthSmallest {


    public static int kthSmallest(int[] a, int k) {
        if (a == null || k < 0) return -1;



    }

    public static int partition(int[] a, int l, int r) {
        int pivot = a[r];
        while (l < r) {
            while (pivot >= a[l] && l < r) {
                l++;
            }
            a[l] = a[r];
            while (pivot <= a[r] && l < r) {
                r--;
            }
            a[r] = a[l];
        }
        a[l] = pivot;
        return l;
    }

}