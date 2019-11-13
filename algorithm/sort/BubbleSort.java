public class BubbleSort {

    // 冒泡排序，a是数组，n表示数组大小
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for(int i=0; i < n; i++) {
            // 提前退出标志位
            boolean flag = false;            
            for(int j= 0; j < n - i - 1; j ++) {
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

}