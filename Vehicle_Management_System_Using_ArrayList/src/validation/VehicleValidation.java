package validation;


import java.time.LocalDate;
import java.util.List;

import VehicleExce.VehicleCustomException;
import VehicleManagSys.Color;
import VehicleManagSys.Vehicle;

public class VehicleValidation {
	public static Vehicle validateAllInputs(String chasisNo, int vehicleId, String col, double basePrice, String companyName,
			String manfactDate,List<Vehicle>vehicles) throws VehicleCustomException{
		checkDuplicateChasisNo(chasisNo,vehicles);

		Color valid=parseAndValidateColor(col);
		
		LocalDate validDate=parseAndValidateLocalDate(manfactDate);
		return new Vehicle(chasisNo,vehicleId,valid,basePrice,companyName,validDate);
		
		
	}

	
	public static LocalDate parseAndValidateLocalDate(String manfactDate) throws VehicleCustomException {
		LocalDate d1=LocalDate.parse(manfactDate);
		LocalDate beginyear=LocalDate.of(LocalDate.now().getYear(), 1, 1);  //if Localdate in int format we use LocalDate.of
		if(d1.isAfter(beginyear)) {
			return d1;
		}else throw new VehicleCustomException("Manifacturing date must be after 1,1,curYear");
	}


	public static Color parseAndValidateColor(String clr) {
		
		return Color.valueOf(clr.toUpperCase());
	}
	public static void checkDuplicateChasisNo(String chasisNo,List<Vehicle>vehicles) throws VehicleCustomException {
		Vehicle newVehicle= new Vehicle(chasisNo);
		if(vehicles.contains(chasisNo))
			throw new VehicleCustomException("Duplicate chassis no ");
		System.out.println("no duplicate found");
	}
	
	
	

}

