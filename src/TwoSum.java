import java.util.HashMap;
import java.util.Map;


// 编写一个函数，当传递一个列表和一个目标和时，以节省时间的方式返回任意 两个数字的两个不同的从零开始的索引，这些数字的总和等于目标和。如果没有两个数字，则该函数应返回null。
// 例如，findTwoSum(new int/]f3,15.7,5.9}10)应返回一个具有两个元素的一维数组，并包含以下任意一对索引:
// ·0和3(或3和0)，即3+7=10
// 。1和5(或5和1)，即1+9=10
// ·2和4(或4和2)等于5+5=10

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