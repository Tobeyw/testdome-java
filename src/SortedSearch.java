// 实现函数countNumbers，该函数接受一个已排序的唯一整数数组，并且 就所用时间而言，有效地 计算小于参数lessThan的数组元素的数量。
// 例如，Sortedsearch.countNumbers(new int[]{135,7},4)应该返回 2，因为有两个数组元素小于 4。

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
       // throw new UnsupportedOperationException("Waiting to be implemented.");
       int low = 0;
        int high = sortedArray.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (sortedArray[mid] < lessThan) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
    
    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
    }
}