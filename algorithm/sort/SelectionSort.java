/**
 * 选择排序
 */
public class SelectionSort {

    public static void selectionSort(int[] a, int n) {
        if (n <= 1) return;

        // 总共要经过 N-1 轮比较
        for(int i = 0; i < n; i++) {
            int minIndex = i;
            for(int j = i + i; j < n;j++) {
                if(a[j] < a[minIndex]) {
                    // 记录目前能找到的最小值元素的下标
                    minIndex = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if(minIndex != i) {
                int tmp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = tmp;
            }
        }
    }

}