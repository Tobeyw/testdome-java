// 给定一个正数数组arr（即数组元素全是正数），找出该数组中，两个元素相加的最大值，其中被加数的下标大于加数的下标。由加法运算的可逆性，j >i 这个条件可以去掉。
// 即求出： maxValue = max{arr[j]+arr[i] and j > i} 
public class MaxSum {

    //O(N). find out the max sum of two numbers in a positive array
    public static int maxSum(int[] arr){
        int i = 0;
        int max = 0;//数组中所有的元素都是正数
        int addValue;
        for(int j = 1; j < arr.length; j++){
            addValue = arr[i] + arr[j];
            if(addValue > max)
                max = addValue;
            if(arr[j] - arr[i] > 0)
                i = j;//记录更大的arr[i]
        }
        return max;
    }


    public static int maxSum2(int[] arr){
        int max = 0;
        int addValue;
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                addValue = arr[j] + arr[i];
                if(addValue > max)
                    max = addValue;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5,6,7,8};

        long start = System.currentTimeMillis();
        int r = maxSum(arr);
        long end = System.currentTimeMillis();
        System.out.println("maxValue=" + r + "  O(N)'s time:" + (end -start));

        long start2 = System.currentTimeMillis();
        int r2 = maxSum2(arr);
        long end2 = System.currentTimeMillis();
        System.out.println("maxValue=" + r2 + "  O(N^2)'s time:" + (end2 - start2));
    }
}