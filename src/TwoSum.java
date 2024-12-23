import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    //性能不够
    public static int[] findTwoSum2(int[] list, int sum) {
       // throw new UnsupportedOperationException("Waiting to be implemented.");
       if (list.length<2){
        return null;
       }
     
       for (int i = 0; i < list.length; i++) {
           for (int j = i+1; j < list.length; j++) {
               if (list[i]+list[j]== sum){
                return new int[]{i,j};
               }
           }
       }

       return null;
    }

    public static int[] findTwoSum(int[] list, int sum) {
        // 创建一个哈希表以存储数值及其索引
        Map<Integer, Integer> numToIndex = new HashMap<>();

        // 遍历数组中的数字
        for (int i = 0; i < list.length; i++) {
            // 计算目标差值
            int complement = sum - list[i];

            // 检查差值是否在哈希表中
            if (numToIndex.containsKey(complement)) {
                return new int[] { numToIndex.get(complement), i };
            }

            // 将当前数字及其索引存储在哈希表中
            numToIndex.put(list[i], i);
        }

        // 如果没有找到匹配的数字对，返回 null
        return null;
    }


    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}