import java.util.LinkedList;
import java.util.List;

public class IceCreamMachine {
    public String[] ingredients;
    public String[] toppings;
    
    public static class IceCream {
        public String ingredient;
        public String topping;

        public IceCream(String ingredient, String topping) {
            this.ingredient = ingredient;
            this.topping = topping;
        }
    }

    public IceCreamMachine(String[] ingredeints, String[] toppings) {
        this.ingredients = ingredeints;
        this.toppings = toppings;
    }

    public List<IceCream> scoops() {
        //throw new UnsupportedOperationException("Waiting to be implemented");
        if (this.ingredients==null || this.ingredients==null){
            return null;
        }
        List<IceCream> list = new LinkedList<IceCream>();
        for (int i = 0; i < this.ingredients.length; i++) {
            for (int j = 0; j < this.toppings.length; j++) {
                 list.add(new IceCream(ingredients[i], toppings[j]));
            }
        }
        return  list;
    }

    public static void main(String[] args) {
        IceCreamMachine machine = new IceCreamMachine(new String[]{
                "vanilla", "chocolate"
        }, new String[]{
                "chocolate sauce"
        });
        List<IceCream> scoops = machine.scoops();

        /*
         * Should print:
         * vanilla, chocolate sauce
         * chocolate, chocolate sauce
         */
        for (IceCream iceCream : scoops) {
            System.out.println(iceCream.ingredient + ", " + iceCream.topping);
        }
    }
}