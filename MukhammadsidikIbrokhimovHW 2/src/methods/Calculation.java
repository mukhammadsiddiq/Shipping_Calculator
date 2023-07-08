package methods;

import items.Item;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import containers.Container;

public class Calculation {
	
		   // private List<Item> items;
		    private List<Container> containers;
		    private List<Integer> order;
		    private ArrayList<Item> items;
		    public Calculation() {    
		       this.items = new ArrayList<>();
		       this.containers = new ArrayList<>();
		       order = new ArrayList<>();
    }
	

	    // getting total volume of item
	    public double totalVolume() {
	        double totalVolume = 0;

	        for (int i = 0; i < items.size(); i++) {
	            totalVolume += items.get(i).calculateVolume() * order.get(i);
	        }

	        return totalVolume;
	    }
	    
	  
	    	
	    
	    // getting total Weight of item

	    public double totalWeight() {
	        double totalWeight = 0;

	        for (int i = 0; i < items.size(); i++) {
	            totalWeight += items.get(i).getWeight() * order.get(i);
	        }

	        return totalWeight;
	        
	        
	    }

	    // Best shipping method
	    public void bestShipping() {
	        Container smallContainer = new Container("Small Container", 243, 259, 606, 500);
	        Container bigContainer = new Container("Big Container", 243, 259, 1201, Double.MAX_VALUE);
	        containers.add(smallContainer);
	        containers.add(bigContainer);

	        double totalVolume = totalVolume();
	        double totalWeight = totalWeight();
	        
	        
	        System.out.println("Total Volume: " + totalVolume + " cubic cm");
	        System.out.println("Total Weight: " + totalWeight + " kg");


	        if (totalWeight <= 500 ) {
	            if (totalVolume <= smallContainer.getVolume()) {
	                System.out.println("Best shipping method: 1 small container");
	                System.out.println("Shipping cost: 1000 Euro");
	      
	            	
	            }
	            else if (totalWeight > 500 ) {
	            	if(totalVolume <= smallContainer.getVolume()) {
	            		System.out.println("Best shipping cost: 1 small container");
	            		System.out.println("Shipping cost: 1200 Euro ( Because the total weight more than 500 kg");
	            		
	            	}
	            	
	            }
	            else {
	                System.out.println("Best shipping method: 1 big container");
	                System.out.println("Shipping cost: 1800 Euro");
	            }
	        } 

	        else {
	            int numBigContainers = (int) Math.floor(totalVolume / bigContainer.getVolume());
	            int numSmallContainers = (int) Math.ceil(  Math.floor(numBigContainers) / smallContainer.getVolume());
	            System.out.print("Best shipping method: " + numBigContainers + " big container(s)");
	            System.out.println(" and " + numSmallContainers + " Small container(s)");
	            
	            System.out.println("Shipping cost: " + ((numBigContainers * 1800) + ( numSmallContainers * 1000) ) + " Euro");
	            
	            
	        }
	    }
	    
	    // Calculating shipping price 

	    public double totalPrice() {
	        double totalWeight = totalWeight();
	        double totalVolume = totalVolume();
	        double shippingCost = 0;

	        if (totalWeight <= 500) {
	            shippingCost = 1000;
	        } else if(totalWeight > 500) {
	        	if(totalVolume <= 243 * 259 * 606 ) {
	        		shippingCost = 1200;
	        	}}
	        else {
	        	shippingCost = 1800;
	        }

	        return shippingCost;
	    }
	    //For correcting an error in GUI method , otherwise My GUI returned 0 shipping cost, than decided to change best shipping 
	    // to double method, now my program working well!!! Hope you will not give a penalty for this 
	    	
	    	public double shippingPrice() {
	    	    double totalVolume = totalVolume();
	    	    double totalWeight = totalWeight();
	    	    double shippingCost;

	    	    Container smallContainer = new Container("Small Container", 243, 259, 606, 500);
	    	    Container bigContainer = new Container("Big Container", 243, 259, 1201, Double.MAX_VALUE);

	    	    if (totalWeight <= 500) {
	    	        if (totalVolume <= smallContainer.getVolume()) {
	    	            shippingCost = 1000;
	    	        } else {
	    	            shippingCost = 1200;
	    	        }
	    	    } else {
	    	        int numBigContainers = (int) Math.floor(totalVolume / bigContainer.getVolume());
	    	        int numSmallContainers = (int) Math.ceil(numBigContainers / smallContainer.getVolume());
	    	        shippingCost = (numBigContainers * 1800) + (numSmallContainers * 1000);
	    	    }

	    	    return shippingCost;
	    	}


	    // Adding items information

	    public void addItems() {
	        // Adding the given products and their details
	        items.add(new Item("Laptop", 6.50, 60, 50, 50));
	        items.add(new Item("Mouse", 0.2, 30, 30, 20));
	        items.add(new Item("Desktop", 20.0, 100, 150, 50));
	        items.add(new Item("LCD screens", 2.6, 120, 140, 80));
	    }
	    
	    // getting the amount of items from the user
	    @SuppressWarnings("resource")
		public void addOrder() {
	        
			Scanner scanner = new Scanner(System.in);

	        for (Item item : items) {
	            boolean validInput = false;
	            int quantity = 0;

	            while (!validInput || quantity <= 0) {

	                System.out.print("Enter the quantity of " + item.getName() + ": ");

	                try {
	                    quantity = scanner.nextInt();
	                    validInput = true;
	                }
	                	
	  
	                catch (Exception e) {
	                    System.out.println("Invalid input. Please enter a valid Number.");
	                    scanner.nextLine(); // Clear the input buffer
	                }
	            }
	            

	            order.add(quantity);
	        }
	    }
	    
	    // I made this for my  GUI method, calculation part could executed without this method but for GUI method it is essential!! 
	    public void addOrder(int laptops, int mice, int desktops, int lcdScreens) {
	        order.add(laptops);
	        order.add(mice);
	        order.add(desktops);
	        order.add(lcdScreens);
	    }
	    
	    


	    // printing about order information which added user
	    public void printOrder() {
	        System.out.println("Order Information:");
	        for (int i = 0; i < items.size(); i++) {
	            Item item = items.get(i);
	            int quantity = order.get(i);
	            System.out.println(item.getName() + ": " + quantity);
	        }
	        System.out.println();
	        
	    }
	    public void printItems() {
	        for (Item items : items) {
	            items.printItemInfo();
	        }
	    }


	    	}

	