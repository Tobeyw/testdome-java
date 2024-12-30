public class Tiles {
    public static void tileEdges(boolean[][] tiles) {
       // throw new UnsupportedOperationException("Waiting to be implemented");
       System.out.print(tiles.length);
       System.out.print(tiles[0].length);
        
        for (int i = 0; i < tiles.length; i++) {
            
            tiles[i][0] = true;
        
            tiles[i][tiles[0].length-1] =true;
        }

        for(int j= 0; j< tiles[0].length; j++) {
             tiles[0][j] =true;
             tiles[tiles.length-1][j] = true;
        }
    

       
    }

    public static void main(String[] args) {
        boolean[][] tiles = new boolean[4][5];
        
        tileEdges(tiles);

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                System.out.print(tiles[i][j] ? "true  " : "false ");
            }
            System.out.println();
        }
    }
}