/**
 * 快速排序
 */
public class QuickSort {


    public static void quickSort(int[] a, int n) {
        sort(a, 0 , a.length);
    }

    public static void sort(int[] a, int l, int r) {
        if(l >= r) return;
        int mid = partition(a, l, r);
        sort(a, l, mid);
        sort(a, mid + 1, r);        
    }

    public static int partition(int[] a, int l, int r) {
        int value = a[l];
        while(l < r) {
            while(value >= a[r] && l < r) {
                r--;
            }
            a[r]= a[l];
            while(value <= a[l] && l < r) {
                l++;
            }
            a[l] = a[r];
        }

        // r或者l 都可以
        a[l] = value;
        return l;
    }

    public static int partition2(int[] a, int l, int r) {
        int pivot = a[r];

        int i = l;
        for(int j = l; j < r; j++) {
            if(l == i) {
                i++;
                continue;
            }
            if(a[l] < pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, r);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}