public class InspectBits {
    public static int inspectBits(int number) {
        // 检查数字是否包含两个或更多连续的1
        while (number > 0) {
            // 如果发现两个连续的1，则返回1
            if ((number & 3) == 3) { // 检查最低两位是否为11
                return 1;
            }
            number >>= 1; // 右移一位
        }
        // 如果未找到两个连续的1，则返回0
        return 0;
    }

    public static void main(String[] args) {
        // 测试示例
        int number1 = 13; // 二进制表示为1101
        int number2 = 8;  // 二进制表示为1000
        int number3 = 7;  // 二进制表示为0111
        int number4 = 6;  // 二进制表示为0100

        System.out.println("Inspect 13: " + inspectBits(number1)); // 输出1
        System.out.println("Inspect 8: " + inspectBits(number2));  // 输出0
        System.out.println("Inspect 7: " + inspectBits(number3));  // 输出1
        System.out.println("Inspect 4: " + inspectBits(number4));  // 输出1
    }
}
