// 在游戏Pixelville中，玩家拥有一组不同大小的数字烧瓶。目标是从魔法井中装满这些烧瓶，并将水倒入高架水箱中。一次只能取一个烧瓶中的水，每个烧瓶可以部分装满或完全装满。烧瓶可以使用任意次数。
// 实现getCount方法，该方法应获取烧瓶容量、井中可用的总水量以及水箱容量的列表。它应返回完全填满高架水箱所需的最少抽水次数，如果无法完全填满水箱，则返回-1。
// 例如，以下代码应打印5:

import java.util.Arrays;
import java.util.List;

public class Bottles {
    // 继承
    public static int getCount(List<Integer> bottles, int wellCapacity, int tankCapacity) {
    int max = bottles.get(0);
    for (int i = 0; i < bottles.size()-1; i++) {
      if (max<bottles.get(i)){
        max = bottles.get(i);
      }
    }
    
    int count=0;
    while (wellCapacity>0) {
      tankCapacity -= max;
      wellCapacity -= max;
      count++;
      if (tankCapacity<=0){
        break;
      }
    
    }
   return count;
    
}

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(2,3,7,1,5,4);
    System.err.println(getCount(input,100,34));
    }
}