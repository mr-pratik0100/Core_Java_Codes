package VehicleManagSys;

public enum Color {
	WHITE(1000),BLACK(2000),RED(3000),GREEN(4000),BLUE(5000);
	
	private double price;
	
	private Color(double price) {
		this.price=price;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String toString() {
		return name()+"@"+price;
	}

}
