
public class Array {
    public static void main(String[] args) {
       boolean[][] arr = new boolean[4][4];
        
        for (int i = 0; i < 4; i++) {
            arr[i][0] = true;
            arr[0][i] =true;
            arr[3][i] = true;
            arr[i][3] =true;
        }

        for (int i = 0; i < arr.length; i++) {
           
            for (int j= 0; j < arr[0].length; j++) {
                System.err.print(arr[i][j]+" "); 
                
            }
            System.out.println();
            
        }
            
        }
       
 }
