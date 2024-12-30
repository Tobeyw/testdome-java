public class CircuitSimulator {
    public static boolean simulate(boolean input1, boolean input2, boolean input3) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    
        boolean a= !input1 && input2;
        boolean b = input1 && input3;
        boolean c= b && input2;

        return a||c;
    }
    
    public static void main(String[] args) {
        System.out.println(simulate(false, true, false)); // should print true
    }
}//