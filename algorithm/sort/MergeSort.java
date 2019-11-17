/**
 * 归并算法
 * 
 */
public class MergeSort {

    public static void sort(int[] a , int n) {
      sort(a, 0, n - 1);
    }

    public static void sort(int[] a, int l, int r) {
        if( l >= r) {
            return;
        }

        int mid = (l + r)/2;
        sort(a, l, mid);
        sort(a, mid + 1, r);

        mergeSort(a, l, mid, r);
    }

    public static void mergeSort(int[] a, int l,int mid, int r) {
        int[] tmp = new int[r - l + 1];

        int i = l;
        int j = mid + 1;
        int k = 0;
        
        // 把较小的数先移到新数组中
        while(i <= mid && j <= r) {
            if(a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        // 把右边剩余的数移入数组
        while (j <= r) {
            tmp[k++] = a[j++];
        }

        for(i=0; i <= (r - l);i++) {
            a[l + i] = tmp[i];
        }
    }

    public static void mergeSortBySentry(int[] a, int l,int mid, int r) {
        int[] leftArr = new int[mid - l + 2];
        int[] rightArr = new int[r - mid + 1];

        for(int i = 0; i < (l - mid + 1); i++) {
            leftArr[i] = a[l + i];
        }
        // 第一个数组添加哨兵（最大值）
        leftArr[l - mid + 1] = Integer.MAX_VALUE;

        for(int i = 0; i < (r - mid); i++) {
            rightArr[i] = a[mid + 1 + i];
        }
        // 第二个数组添加哨兵（最大值）
        rightArr[r - mid] = Integer.MAX_VALUE;

        int i = l;
        int j = mid + 1;
        while(l <= r) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if(leftArr[i] <= rightArr[j]) {
                a[l++] = leftArr[i++];
            } else {
                a[l++] = rightArr[j++];
            }
        }

    }

}