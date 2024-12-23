
public class GamePlatform {
    public static double calculateFinalSpeed(double initialSpeed, int[] inclinations) {
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

    public static void main(String[] args){
        System.out.println(calculateFinalSpeed(60.0, new int[] { 0, 30, 0, -45, 0 }));
    }
}

