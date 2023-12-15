package vehiclestore.model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import vehiclestore.exceptions.InvalidPackageTypeException;
import vehiclestore.model.vehicle.Car;
import vehiclestore.model.vehicle.Motorcycle;
import vehiclestore.model.vehicle.Vehicle;

public class VehicleStockImporter {

	public VehicleStock importVehicles(String filepath) {
	    VehicleStock importVehicles = new VehicleStock();
	    try {
	        List<String> fileLines = Files.readAllLines(Paths.get(getClass().getResource(filepath).toURI()));
	        
	        for(String vehicleItemAsString : fileLines) {
	            String[] vehicleItemStringArray = vehicleItemAsString.split(",");
	            
	            int vehicleId = Integer.valueOf(vehicleItemStringArray[0]);
	            String vehicleCategory = vehicleItemStringArray[1];
	            String vehicleName = vehicleItemStringArray[2];
	            int vehicleYear = Integer.valueOf(vehicleItemStringArray[3]);
	            double vehiclePrice = Double.valueOf(vehicleItemStringArray[4]);
	            
	            Vehicle vehicle = null;
	            if("car".equals(vehicleCategory)) {
	                String vehicleSpeed = vehicleItemStringArray[5];
	                vehicle = new Car(vehicleId, vehicleName, vehicleYear,     vehiclePrice, vehicleSpeed);
	            } else if ("motorcycle".equals(vehicleCategory)) {
	                String vehicleSpeed = vehicleItemStringArray[5];
	                vehicle = new Motorcycle(vehicleId, vehicleName, vehicleYear, vehiclePrice, vehicleSpeed);
	            } else {
	                StringBuffer stringBuffer = new StringBuffer();
	                stringBuffer.append("The vehicle file couldn't be processed as the vehicle category from vehicle ")
	                             .append(vehicleName).append(" is invalid");
	                throw new InvalidPackageTypeException(stringBuffer.toString());
	            }
	            importVehicles.getVehicleItems().put(vehicleId, vehicle);
	        }

	    } catch (IOException | URISyntaxException e) {
	        throw new RuntimeException("Vehicle file couldn't be found.", e);
	    }
	    return importVehicles;
	}
}