package methods;


public class Test {
    public static void main(String[] args) {
        Calculation calculation = new Calculation();
        
// Print total volume of Items
        calculation.totalVolume();
// Printing total weight of items
        calculation.totalWeight();
        
        calculation.addItems();
        calculation.printItems();
        calculation.addOrder();
        
        
// Printing items which taken from user
        calculation.printOrder();
        
// PRinting best shipping method
        calculation.bestShipping();
        
        

    }
}

// Project done by Mukhammadsidik Ibrokhimov( 55094865)
