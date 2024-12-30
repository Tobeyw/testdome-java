/* 连续三个大于0数的最小平均数*/

public class MinAveage {


public static double findMinAverage(int[] nums) {
    int n = nums.length;
    double minAvg = Double.MAX_VALUE; // 初始化最小平均值为最大值

    // 使用滑动窗口的方法，遍历所有连续的三个数
    for (int i = 0; i < n - 2; i++) {
        // 判断当前位置的三个数是否都大于0
        if (nums[i] > 0 && nums[i + 1] > 0 && nums[i + 2] > 0) {
            double avg = (nums[i] + nums[i + 1] + nums[i + 2]) / 3.0;
            minAvg = Math.min(minAvg, avg); // 更新最小平均值
        }
    }

    // 如果最小平均值仍然是初始的最大值，说明没有符合条件的连续三数
    if (minAvg == Double.MAX_VALUE) {
        throw new IllegalArgumentException("没有找到连续三个大于0的数");
    }

    return minAvg;
}

    public static void main(String[] args) {
        int[] array1 = {2, 1, 1, 1, 1, 5, 0, 0,6, 7};

    double minAverage2 = findMinAverage(array1);
    System.out.println("连续三个大于0数的最小平均数: " + minAverage2);
}
}