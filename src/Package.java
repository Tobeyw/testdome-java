
public class Package {
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }

    public static boolean canPartition2(int[] nums) {
        int total = sum(nums);
        System.out.println(total);
        if (total%2 != 0){
            return false;
        }

        int sum = total /2;
        bubbleSort(nums,nums.length);  
        System.out.print(sum);
       for (int i = 0; i < nums.length; i++) {
        System.out.print(nums[i]);
       }
      
        for (int i =nums.length-1; i > 0; i--) {
            sum -= nums[i];
            if(sum==0){
            return true;
            }

        }
            return false;
    }

    public static int sum(int[] nums){
        int total =0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        return total;
    }

    public static void bubbleSort(int [] a, int n){
        int j , k;
        int flag = n ;//flag来记录最后交换的位置，也就是排序的尾边界
    
        while (flag > 0){//排序未结束标志
            k = flag; //k 来记录遍历的尾边界
            flag = 0;
    
            for(j=1; j<k; j++){
                //升序
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


    public static void main(String[] args) {
      
        int[] arr = new int[]{2,2,1,1}; 
        
        System.out.println(Package.canPartition(arr));
    }
}