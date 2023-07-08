package items;

public class Item {

		
	    private String name;
	    private double weight;
	    private double length;
	    private double width;
	    private double height;
		
		//constructor with and without fields
	    public Item() {
			super();
		}

			public Item(String name, double weight, double length, double width, double height) {
			super();
			this.name = name;
			this.weight = weight;
			this.length = length;
			this.width = width;
			this.height = height;
		}
			
		//getter and setter
			
			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public double getWeight() {
				return weight;
			}

			public void setWeight(double weight) {
				this.weight = weight;
			}

			public double getLength() {
				return length;
			}

			public void setLength(double length) {
				this.length = length;
			}

			public double getWidth() {
				return width;
			}

			public void setWidth(double width) {
				this.width = width;
			}

			public double getHeight() {
				return height;
			}

			public void setHeight(double height) {
				this.height = height;
			}

		// volume calculating method
			public double calculateVolume () {
				return length * width * height;
				}

		



		public void printItemInfo() {
	        System.out.println("Item: " + name);
	        System.out.println("Dimensions: " + length + "x" + width + "x" + height + " cm");
	        System.out.println("Weight: " + weight + " kg");
	        System.out.println("Volume: " + calculateVolume() + " cm^3");
	        System.out.println();
	    }


		
	}
