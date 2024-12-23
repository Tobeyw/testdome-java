
public class MegaStore {

    public enum DiscountType {
        Standard,
        Seasonal,
        Weight;
    }
    
    public static double getDiscountedPrice(double cartWeight,
                                            double totalPrice,
                                            DiscountType discountType) {
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
    
    public static void main(String[] args) {        
        System.out.println(getDiscountedPrice(12, 100, DiscountType.Weight));
    }
}



