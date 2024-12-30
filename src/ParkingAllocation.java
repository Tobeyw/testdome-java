public class ParkingAllocation {
    /*
     * There are four situations where cars are given priority to park in large parking spaces if there are remaining large parking spaces
     * 1. Large parking spaces are not enough to park buses
     * 2. Large parking spaces can accommodate all buses and cars
     * 3. Large parking spaces can accommodate all buses, and the remaining space can accommodate some cars, and small parking spaces can accommodate the remaining cars
     * 4. Large parking spaces can accommodate all buses, and there are not enough parking spaces for cars
     */

    public static int getMinimumSlots(int big, int small,  int buses,int cars) {
       
        //case 1:largeSlots Insufficient
        if (big<buses){
            return -1;
        }
      
        int remainingBigSlots = big - buses;  // Remaining big slots after parking buses
        int smallCarsInBigSlots = remainingBigSlots * 3;  // Each remaining big slot can park 2 small cars
        
        //Cars park in bigslots first
        int bigslot_car_count;
        if (cars%3==0) {
            bigslot_car_count = cars/3;   
        }else {
            bigslot_car_count = cars/3 +1;    
        }
        //case 2：BigSlots has enough space for all buses and cars
        if (remainingBigSlots >= bigslot_car_count){  
            return  buses+ bigslot_car_count;
        }else{
           //case 3: BigSlots has enough space for buses and and smallSlots has enough space cars(Cars park in bigslots first)
           if(smallCarsInBigSlots + small >= cars){
             return big+cars-smallCarsInBigSlots;
           }else{
            //case 4：BigSlots are sufficient, smallSlots are insufficient
            return -1;
           }

          
        }
        
    }

    public static void main(String[] args) {
        System.out.println(getMinimumSlots(2, 12, 1, 13)); // should print 3
    }
}