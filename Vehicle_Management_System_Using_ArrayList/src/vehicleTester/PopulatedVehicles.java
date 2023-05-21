package vehicleTester;

import static VehicleManagSys.Color.BLACK;
import static VehicleManagSys.Color.WHITE;
import static java.time.LocalDate.parse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import VehicleManagSys.Vehicle;

public class PopulatedVehicles {

	public static List<Vehicle> populated(){
		
		List<Vehicle>l1 =new ArrayList<>();
		l1.add(new Vehicle("abdcd", 101, BLACK, 10000, "iacsd", parse("2025-12-12")));
		l1.add(new Vehicle("abcd", 101, WHITE, 10000, "iacsd", parse("2025-12-12")));
		l1.add(new Vehicle("abce", 101, WHITE, 10000, "iacsd", parse("2025-12-12")));
		return l1;
	}

}
