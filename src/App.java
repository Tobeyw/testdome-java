

public class App {

    public static boolean canTravelTo(boolean[][] gameMatrix, int fromRow, int fromColumn, int toRow, int toColumn) {
        // 确保矩阵非空且矩阵每行的列数一致
        if (gameMatrix == null || gameMatrix.length == 0 || gameMatrix[0].length == 0) {
            System.out.println("Matrix is invalid or empty.");
            return false;
        }

        int rows = gameMatrix.length;
        int cols = gameMatrix[0].length;

        // 确保起点和终点在矩阵范围内
        if (!isWithinBounds(fromRow, fromColumn, rows, cols)) {
            System.out.println("From coordinates out of bounds: (" + fromRow + "," + fromColumn + ")");
            return false;
        }
        if (!isWithinBounds(toRow, toColumn, rows, cols)) {
            System.out.println("To coordinates out of bounds: (" + toRow + "," + toColumn + ")");
            return false;
        }

        // 确保起点和终点在陆地上
        if (!gameMatrix[fromRow][fromColumn] || !gameMatrix[toRow][toColumn]) {
            System.out.println("Either start or end point is not land.");
            return false;
        }

        // 如果起点等于终点
        if (fromRow == toRow && fromColumn == toColumn) {
            return true;
        }

        // 从起点开始沿着不同方向前进
        return canSwitchDirection(gameMatrix, fromRow, fromColumn, toRow, toColumn);
    }

    // 这个方法允许每次沿着一个方向走一步，然后切换方向
    private static boolean canSwitchDirection(boolean[][] gameMatrix, int fromRow, int fromColumn, int toRow, int toColumn) {
        int currentRow = fromRow;
        int currentColumn = fromColumn;

        // 遍历所有可能的路径（先横向，再纵向，或先纵向，再横向）
        return tryPath(gameMatrix, currentRow, currentColumn, toRow, toColumn, true) || // 先横向，再纵向
               tryPath(gameMatrix, currentRow, currentColumn, toRow, toColumn, false);  // 先纵向，再横向
    }

    // 尝试路径，沿着一个方向走，然后切换方向
    private static boolean tryPath(boolean[][] gameMatrix, int fromRow, int fromColumn, int toRow, int toColumn, boolean startWithHorizontal) {
        int currentRow = fromRow;
        int currentColumn = fromColumn;

        // 判断是先沿横向还是纵向开始
        boolean horizontal = startWithHorizontal; // 是否当前是横向行进

        while (currentRow != toRow || currentColumn != toColumn) {
            if (horizontal) {
                // 沿横向走
                if (currentColumn < toColumn) {
                    // 向右走
                    if (!isStraightPathClear(gameMatrix, currentRow, currentColumn, currentRow, currentColumn + 1)) {
                        return false;
                    }
                    currentColumn++;
                } else if (currentColumn > toColumn) {
                    // 向左走
                    if (!isStraightPathClear(gameMatrix, currentRow, currentColumn, currentRow, currentColumn - 1)) {
                        return false;
                    }
                    currentColumn--;
                }
            } else {
                // 沿纵向走
                if (currentRow < toRow) {
                    // 向下走
                    if (!isStraightPathClear(gameMatrix, currentRow, currentColumn, currentRow + 1, currentColumn)) {
                        return false;
                    }
                    currentRow++;
                } else if (currentRow > toRow) {
                    // 向上走
                    if (!isStraightPathClear(gameMatrix, currentRow, currentColumn, currentRow - 1, currentColumn)) {
                        return false;
                    }
                    currentRow--;
                }
            }

            // 切换方向
            horizontal = !horizontal;
        }

        return true;
    }

    // 检查是否可以沿直线路径到达
    private static boolean isStraightPathClear(boolean[][] gameMatrix, int fromRow, int fromColumn, int toRow, int toColumn) {
        if (fromRow == toRow) { // 横向路径
            int minCol = Math.min(fromColumn, toColumn);
            int maxCol = Math.max(fromColumn, toColumn);
            for (int col = minCol; col <= maxCol; col++) {
                if (!gameMatrix[fromRow][col]) {
                    return false; // 遇到障碍
                }
            }
        } else if (fromColumn == toColumn) { // 纵向路径
            int minRow = Math.min(fromRow, toRow);
            int maxRow = Math.max(fromRow, toRow);
            for (int row = minRow; row <= maxRow; row++) {
                if (!gameMatrix[row][fromColumn]) {
                    return false; // 遇到障碍
                }
            }
        } else {
            return false; // 非直线路径
        }
        return true;
    }

    // 检查坐标是否在矩阵范围内
    private static boolean isWithinBounds(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public static void main(String[] args) {
        boolean[][] gameMatrix = {
            {false, true,  true,  false, false, false},
            {true,  true,  true,  false, false, false},
            {true,  true,  true,  true,  true,  true},
            {false, true,  true,  false, true,  true},
            {false, true,  true,  true,  false, true},
            {false, false, false, false, false, false},
        };

        // 测试用例
        System.out.println(canTravelTo(gameMatrix, 3, 2, 2, 2)); // true, Valid move (Path is clear)
        System.out.println(canTravelTo(gameMatrix, 3, 2, 3, 4)); // false, Can't travel through land (Obstacle)
        System.out.println(canTravelTo(gameMatrix, 3, 2, 6, 2)); // false, Out of bounds
        System.out.println(canTravelTo(gameMatrix, 0, 1, 0, 1)); // true, Same point
        System.out.println(canTravelTo(gameMatrix, -1, 0, 0, 0)); // false, Out of bounds
        System.out.println(canTravelTo(gameMatrix, 2, 2, 2, 5)); // true, Straight path clear
        System.out.println(canTravelTo(gameMatrix, 4, 1, 4, 3)); // true, Valid L-shaped path

        //
        System.out.println(calculateFinalSpeed(60.0, new int[] { 0, 30, 0, -45, 0 }));
        //
        System.out.println(getDiscountedPrice(12, 100, DiscountType.Weight));

        
    }
   
    //
    public static double calculateFinalSpeed(double initialSpeed, int[] inclinations) {
       // throw new UnsupportedOperationException("Waiting to be implemented.");
       if (initialSpeed <= 0) {
        return 0.0;
         
     }

     for (int i = 0; i < inclinations.length; i++) {
         initialSpeed -= inclinations[i];
         if (initialSpeed <= 0) {
            initialSpeed =0;
            break;
         }
         
     }
     return initialSpeed;
    }

    //
    public enum DiscountType {
        Standard,
        Seasonal,
        Weight;
    }
    
    public static double getDiscountedPrice(double cartWeight,
                                            double totalPrice,
                                            DiscountType discountType) {
       // throw new UnsupportedOperationException("Waiting to be implemented.");

       double price =0.0;
       switch (discountType) {
           case DiscountType.Standard:
               price = totalPrice * (1-0.06);
               break;
           case DiscountType.Seasonal:
                price = totalPrice * (1-0.12);
                break;
            case DiscountType.Weight:
                if (cartWeight>10){
                    price = totalPrice * (1-0.18);
                }else if(cartWeight<=10 && cartWeight >=0){
                    price = totalPrice * (1-0.06);
                }
                break;
           default:
               throw new AssertionError();
       }
        return price;
    }

 

}
