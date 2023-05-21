package VehicleManagSys;
import java.time.LocalDate;

public class Vehicle {
	private String chasisNo;
	private int vehicleId;
	private Color col;
	private double basePrice;
	private String companyName;
	private LocalDate ManfactDate;
	private boolean isAvailable;
	
	
	public Vehicle(String chasisNo, int vehicleId, Color col, double basePrice, String companyName,
			LocalDate manfactDate) {
		super();
		this.chasisNo = chasisNo;
		this.vehicleId = vehicleId;
		this.col = col;
		this.basePrice = basePrice;
		this.companyName = companyName;
		ManfactDate = manfactDate;
		this.isAvailable = true;
	}
	
	public Vehicle(String chasisNo) {
		this.chasisNo=chasisNo;
	}


//	public Vehicle(String chasisNo2, int vehicleId2, Color white, int basePrice2, String companyName2, int i) {
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ", vehicleId=" + vehicleId + ", col=" + col + ", basePrice="
				+ basePrice + ", companyName=" + companyName + ", ManfactDate=" + ManfactDate + "]";
	}


	public String getChasisNo() {
		return chasisNo;
	}


	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double price) {
		basePrice=basePrice+price;
	}


	public LocalDate getManfactDate() {
		return ManfactDate;
	}
	
	public Color getColor() {
		return col;
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Vehicle) {
			return this.chasisNo.equals(((Vehicle)o).chasisNo);
		}
		return false;
	}
	
	

}
