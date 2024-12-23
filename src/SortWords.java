import java.util.Arrays;

public class SortWords {

    public static void sortWords(String[] words) {
        int n = words.length;

        // 使用冒泡排序
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // 按字典顺序比较两个字符串
                if (words[j].compareTo(words[j + 1]) < 0) {
                    // 交换位置
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }
    }

    //优化过的冒泡排序
    public static void bubbleSort3(int [] a, int n){
        int j , k;
        int flag = n ;//flag来记录最后交换的位置，也就是排序的尾边界
    
        while (flag > 0){//排序未结束标志
            k = flag; //k 来记录遍历的尾边界
            flag = 0;
    
            for(j=1; j<k; j++){
                if(a[j-1] > a[j]){//前面的数字大于后面的数字就交换
                    //交换a[j-1]和a[j]
                    int temp;
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j]=temp;
    
                    //表示交换过数据;
                    flag = j;//记录最新的尾边界.
                }
            }
        }
    }

    // 实现对单词数组的降序排序
    public static void sortWords2(String[] words) {
        // 使用 Arrays.sort 方法，并指定降序比较规则
        Arrays.sort(words, (a, b) -> b.compareTo(a));
    }

    public static void main(String[] args) {
        // 定义单词数组
        String[] words = {"cherry", "orange", "apple"};

        // 调用排序方法
        sortWords(words);

        // 输出排序后的数组
        System.out.println("Sorted words in descending order:");
        for (String word : words) {
            System.out.println(word);
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            
            int pivot = partition(arr, left, right);
        
            // 基准元素一定比左边的数大，所以左边分区最大值是：pivot - 1，分区范围是[left, pivot - 1]
            quickSort(arr, left, pivot - 1);
            // 基准元素一定比右边的数小，所以右边分区最小值是：pivot + 1，分区范围是[pivot + 1, right]
            quickSort(arr, pivot + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        // 定义基准元素
        int pivotValue = arr[left];
        // 遍历（条件就是分区左边索引小于右边索引）
        while (left < right) {
            // 从右边right开始遍历，找到一个数比基准数小
            while (left < right && arr[right] >= pivotValue) {
                // 未找到，继续往前找
                right--;
            }
            // 找到了，则把找到小值放到此时左边索引的位置
            // 第一次进入时,基准元素已存放到临时值pivotValue了，第一次就相当于放到基准位置了，同时，arr[right]也腾出了一个位置
            arr[left] = arr[right];
            // 从左边left开始遍历，找到一个数比基准数大
            while (left < right && arr[left] <= pivotValue) {
                // 未找到，继续往后找
                left++;
            }
            // 找到了，则把找到大值放到此时右边索引的位置（也就是腾出的位置）
            // 同时，arr[left]也腾出了一个位置
            arr[right] = arr[left];
        }
        // left等于right说明遍历结束了，把基准元素插入到腾出的位置，也就是arr[left]或者arr[right]
        arr[left] = pivotValue;
        // 返回基准元素插入的位置
        return left;
    }

    // public static void main(String[] args) {
    //     int[] arr = new int[]{19, 28, 8, 23, 10, 21, 9};
    //     log.info("要排序的初始化数据：{}", arr);
    //     //从小到大排序
    //     quickSort(arr, 0, arr.length - 1);
    //     log.info("最后排序后的结果：{}", arr);
    // }


}
