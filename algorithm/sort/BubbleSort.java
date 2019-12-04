package algorithm.sort;

/**
 * 冒泡排序
 * 
 */
public class BubbleSort {

    // 冒泡排序，a是数组，n表示数组大小
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;
        for(int i=0; i < n; i++) {          
            for(int j= 0; j < n - i - 1; j++) {
                if(a[j] < a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                }
            }
        }
    }

    // 冒泡排序，a是数组，n表示数组大小
    public static void bubbleSort1(int[] a, int n) {
        if (n <= 1) return;

        for(int i=0; i < n; i++) {
            // 提前退出标志位
            boolean flag = false;            
            for(int j= 0; j < n - 1 - i; j++) {
                if(a[j] < a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                    // 此次冒泡有数据交换
                    flag = true;
                }
            }
            // 没有数据交换，提前退出
            if(!flag) break;
        }
    }

    /**
     * 冒泡排序，a是数组，n表示数组大小
     * 设置边界 
     * @param a
     * @param n
     */
    public static void bubbleSort2(int[] a, int n) {
        if(n <= 1) return;
        
        int lastExchange = 0;
        int sortBorder = n - 1;

        for(int i = 0; i < n; i++) {
            boolean flag = false;
            for(int j = 0; j < sortBorder; j++) {
                if(a[j] <= a[j + 1]) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                    flag = true;
                    lastExchange = j;
                }
            }

            sortBorder = lastExchange;
            if(!flag) break;
        }
    }

    public static void bubbleSort3(int a[], int n) {
        
    }

}