public class ParkingAllocation {

    public static int getMinimumSlots(int big, int small,  int buses,int cars) {
       
        //First case:largeSlots Insufficient
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
        // Second case：BigSlots has enough space for all buses and cars
        if (remainingBigSlots >= bigslot_car_count){  
            return  buses+ bigslot_car_count;
        }else{
           //The third case: BigSlots has enough space for buses and and smallSlots has enough space cars(Cars park in bigslots first)
           if(smallCarsInBigSlots + small >= cars){
             return big+cars-smallCarsInBigSlots;
           }else{
            //The fourth case ：BigSlots are sufficient, smallSlots are insufficient
            return -1;
           }

          
        }
        
    }

    public static void main(String[] args) {
        System.out.println(getMinimumSlots(2, 12, 1, 13)); // should print 3
    }
}