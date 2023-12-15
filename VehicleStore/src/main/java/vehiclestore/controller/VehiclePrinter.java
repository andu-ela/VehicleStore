package vehiclestore.controller;

import java.util.Map.Entry;

import vehiclestore.model.VehicleStock;
import vehiclestore.model.vehicle.Vehicle;

public class VehiclePrinter {

	public void printCarStock(VehicleStock vehicleStock) {
		System.out.println("-----------------Vehicle-------------------");
		for(Entry<Integer,Vehicle> vehicleEntry : vehicleStock.getVehicleItems().entrySet()) {
			Vehicle vehicleItem = vehicleEntry.getValue();
			System.out.println(vehicleItem.getVehicleID() + ". " + vehicleItem.getModel() 
			+ " | " + vehicleItem.getYear() + " | " + vehicleItem.getPrice() + "  �.");
		}
		System.out.println("-------------------------------------------");
		System.out.println("");
	}
}
