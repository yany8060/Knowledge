package algorithm.sort;

/**
 * 插入排序
 */
public class InsertionSort {

    // 插入排序，a表示数组，n表示数组大小
    public static void insertSort(int[] a, int n) {
        if (n <= 1) return;

        for(int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;

            // 查找要插入的位置并移动数据
            for(;j >= 0; j--) {
                if(a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }

            /** 
             * 另一种查找插入位置
                while(j >=0 && a[j] > value) {
                    a[j + 1] = a[j];
                    j--;
                }
            */

            // 由于执行了j-- 所以要+1
            a[j + 1] = value;
        }
    }

    
    
}