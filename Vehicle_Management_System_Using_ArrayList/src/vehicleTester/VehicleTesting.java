package vehicleTester;

import static validation.VehicleValidation.validateAllInputs;
import static vehicleTester.PopulatedVehicles.populated;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import VehicleExce.VehicleCustomException;
import VehicleManagSys.Color;
import VehicleManagSys.Vehicle;

public class VehicleTesting {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			List<Vehicle> vehicles=populated();                 //new ArrayList<>();
			boolean exit =false;
//			System.out.println("enter chasisno,vehicleid,color,baseprice,companyName,mfcturing date");
			while(!exit) {
				System.out.println(" Enter 1:add vehicle 2:display all vehicle 0:Exit 3:checkDuplicate 4:Date and Discount 5:Delete vehicle 6:delete color");
				System.out.println("choose option");
				try {
					switch(sc.nextInt()) {
					case 1:
					System.out.println("Enter vehicles details : enter chasisno,vehicleid,color,baseprice,companyname,manifacdate");
					Vehicle validVehicles = validateAllInputs(sc.next(),sc.nextInt(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),vehicles);
					vehicles.add(validVehicles);
					System.out.println("vehicle added successfully");
					break;
					case 2:
						System.out.println("Vehicles Details Are");
//						for(Vehicle v:vehicles) {
//							System.out.println(v);
//						}
						vehicles.stream().forEach(e->System.out.println(e));
						
					break;
					case 3:
						System.out.println("enter chesis no ");
						Vehicle v1 = new Vehicle(sc.next());
						int index = vehicles.indexOf(v1);
						if(index==-1) {
							throw new VehicleCustomException("chesis no not present");
						}else {
							System.out.println(vehicles.get(index));
						}
						break;
						
					
					case 4:
						System.out.println("Enter Date and discount+ yy-MM-dd");
						LocalDate custShopDate=LocalDate.parse(sc.next());
						double quickDisc=sc.nextDouble();
						LocalDate d1 = LocalDate.parse("2050-12-12");
						if(custShopDate.isBefore(d1)) {
							for(Vehicle v: vehicles) {
								double finalAmount=v.getBasePrice()-quickDisc;
								v.setBasePrice(finalAmount);
							}
						}
						System.out.println("Set discount price proerly");
						break;
						
					case 5://Remove specific vehicle details
						//i/p : chasis no
						//o/p : valid ch no : del details o.w throw custom exc
						System.out.println("enter chessis no");
						Vehicle v2 = new Vehicle(sc.next());
						int index1 = vehicles.indexOf(v2);
						if(index1==-1) {
							throw new VehicleCustomException("chessis no not found");
						}else {
							vehicles.remove(index1);
							System.out.println("vehicle removed");
						}
						
						
						break;
						
						
						
						
						
						
						
						
						
						
					case 6:
						System.out.println("Enter colour ");
						Color col =Color.valueOf(sc.next().toUpperCase());
						for(Vehicle v:vehicles) {
							if(v.getColor()==col) {
								System.out.println("vehicle removed"+vehicles.remove(col)); 
							}else {
								throw new VehicleCustomException("Vehicle not found  plz enter valid color");
							}
						}
					case 0:
						exit=true;
						break;
						
						
				}//switch
					
				}catch(Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}//while
			}
		}//sc close JVM..
		

	}

}

//System.out.println("Enter chessis no");
//Vehicle v1= new Vehicle(sc.next());
//int index=vehicles.indexOf(v1);
//if(index==-1) {
//	throw new VehicleCustomException("Duplicate chessi no");
//}
//System.out.println(vehicles.get(index));   
//break;



//System.out.println("enter chessis no to delete vehicle details");
//Vehicle delVehi=new Vehicle(sc.next());
//int inodex=vehicles.indexOf(delVehi);
//if(inodex==-1) {
//	throw new VehicleCustomException("vehicles chessis not found");
//}else {
//	vehicles.remove(vehicles.get(inodex));
//	System.out.println("deleted vehicle successfully");
//}