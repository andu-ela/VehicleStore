package org.makerminds.jcoaching.videotraining.vehicleshop.controller.test;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import vehiclestore.model.VehicleStock;
import vehiclestore.model.VehicleStockImporter;
import vehiclestore.model.vehicle.Vehicle;

//created new class VehicleStockImporterTest
public class VehicleStockImporterTest {
	
	private VehicleStockImporter vehicleStockImporter;
	private final String VEHICLE_FILE_PATH = "/vehicle-test.txt";
	
	@Test
	//Testing
	public void testImportVehicle() {
		vehicleStockImporter = new VehicleStockImporter();
		
		// Method to test
		VehicleStock importVehicles = vehicleStockImporter.importVehicles(VEHICLE_FILE_PATH);
		HashMap<Integer,Vehicle> vehicleItems = importVehicles.getVehicleItems();
		
		// Validate output
		Assertions.assertEquals(6, vehicleItems.size());
		
	}

}
