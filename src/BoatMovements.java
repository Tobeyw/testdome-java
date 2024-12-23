public class BoatMovements {

    private static boolean IsOutOfBounds(boolean[][] gameMatrix, int row, int col) {
        return row < 0 || row >= gameMatrix.length || col < 0 || col >= gameMatrix[0].length;
    }

    private static boolean IsLand(boolean[][] gameMatrix, int row, int col) {
        return !gameMatrix[row][col];
    }

    public static boolean canTravelTo(boolean[][] gameMatrix, int fromRow, int fromColumn, int toRow, int toColumn) {
        if (IsOutOfBounds(gameMatrix, fromRow, fromColumn) || IsOutOfBounds(gameMatrix, toRow, toColumn)) {
            return false;
        }

        if (IsLand(gameMatrix, fromRow, fromColumn) || IsLand(gameMatrix, toRow, toColumn))  {
            return false;
        }
        //只能在同一行或同一列
        if (fromRow != toRow && fromColumn != toColumn){
            return false;
        }

        //
        // 允许向左移动一格
        if (fromRow == toRow && fromColumn - toColumn == 1) {
             return true;
        }
        
        // 允许向右移动一格
        if (fromRow == toRow && toColumn - fromColumn == 1){
            return true;
        }
         // 允许向上移动一格
        if (fromColumn == toColumn && fromRow - toRow == 1){
            return true;
        }
        

        // 允许向上移动一格
        if (fromColumn == toColumn && toRow - fromRow == 1){
            return true;
        }
        
        // 允许向右移动二格
        if (fromRow == toRow && toColumn - fromColumn == 2){
            return !IsLand(gameMatrix, fromRow, fromColumn + 1);
        }
        
        return false;
    }

    public static void main(String[] args) {
        boolean[][] gameMatrix = {
            {false, true,  true,  false, false, false}, // (0, 0) -> (0, 5)
            {true,  true,  true,  false, false, false}, // (1, 0) -> (1, 5)
            {true,  true,  true,  true,  true,  true},  // (2, 0) -> (2, 5)
            {false, true,  true,  false, true,  true},  // (3, 0) -> (3, 5)
            {false, true,  true,  true,  false, true},  // (4, 0) -> (4, 5)
            {false, false, false, false, false, false}  // (5, 0) -> (5, 5)
        };


        System.out.println(canTravelTo(gameMatrix, 3, 2, 2, 2)); // true, Valid move
        System.out.println(canTravelTo(gameMatrix, 3, 2, 3, 4)); // false, Can't travel through land
        System.out.println(canTravelTo(gameMatrix, 3, 2, 6, 2)); // false, Out of bounds
    }
    
}