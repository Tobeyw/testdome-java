// 一，问题描述

// 给定一个正数数组arr（即数组元素全是正数），找出该数组中，两个元素相减的最大值，其中被减数的下标不小于减数的下标。

// 即求出： maxValue = max{arr[j]-arr[i] and j >= i}

public class MaxSub {

    //O(N). find out the max sum of two numbers in a positive array
   //算法复杂度O(N). 找出数组arr中两个数相减的最大值
   public static int maxValueOfSubtraction(int[] arr){
    int max = 0;// when j == i
    int i = 0;
    int sub;
    for(int j = 1; j < arr.length; j++){
        sub = arr[j] - arr[i];
        if(sub > max)
            max = sub;
        else if(sub < 0)//means there is a number smaller than a[i](i initial value is 0)
            i = j;
    }
    return max;
}

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5,6,7,8};

        long start = System.currentTimeMillis();
        int r = maxValueOfSubtraction(arr);
        long end = System.currentTimeMillis();
        System.out.println("maxValue=" + r + "  O(N)'s time:" + (end -start));

        long start2 = System.currentTimeMillis();
        int r2 = maxValueOfSubtraction(arr);
        long end2 = System.currentTimeMillis();
        System.out.println("maxValue=" + r2 + "  O(N^2)'s time:" + (end2 - start2));
    }
}