package containers;

public class Container {
	
    private String name;
    private double length;
    private double width;
    private double height;
    private double maxWeight;

	
	
    //constructor
    

	public Container() {

	}

	public Container(String name, double length, double width, double height, double maxWeight) {
		super();
		this.name = name;
		this.length = length;
		this.width = width;
		this.height = height;
		this.maxWeight = maxWeight;
		
	}

	// Getter and setter
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public double getMaxWeight() {
		return maxWeight;
	}


	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}

	
	



	// volume calculating method
	public double getVolume () {
		return length * width * height;
		}




	public void printContainerInfo() {
        System.out.println("Container: " + name);
        System.out.println("Dimensions: " + length + "x" + width + "x" + height + " cm");
        System.out.println("Volume: " + getVolume() + " cm^3");
        System.out.println();
    }
	
	

}
