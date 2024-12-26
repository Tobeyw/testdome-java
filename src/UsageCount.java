
public class UsageCount {
     
  public static int usageCount(int[] bridge) {
    int peopleCount = 0;

        while (true) {
            // 检查是否所有方块的值都>=2
            boolean canCross = true;
            for (int block : bridge) {
                if (block < 2) {
                    canCross = false;
                    break;
                }
            }

            // 如果有方块值<2，停止循环
            if (!canCross) {
                break;
            }

            // 每人通过一次，所有方块的值减2
            for (int i = 0; i < bridge.length; i++) {
              bridge[i] -= 2;
            }

            // 记录通过的人数
            peopleCount++;
        }

        return peopleCount;
}
    public static void main(String[] args) {
        int[] bridge = { 7, 6, 5, 8 };
        System.out.println(usageCount(bridge)); // Should print 2
    }
}