package vehiclestore.model;

import java.util.HashMap;

import vehiclestore.model.vehicle.Car;
import vehiclestore.model.vehicle.Motorcycle;
import vehiclestore.model.vehicle.Vehicle;

public class VehicleStock {
	
	private HashMap<Integer,Vehicle> vehicleItems = new HashMap<>();
	
	public void initializeVehicleProvider() {
			vehicleItems.put(100, new Car(100, "Honda Civic", 2015, 15000,"185-193 km/h"));
			vehicleItems.put(101, new Car(101, "Rolls-Royce", 2023, 200000,"250 km/h"));
			vehicleItems.put(102, new Car(102,"BMW", 2018, 50000,"210-250 km/h"));
			vehicleItems.put(103, new Car(103,"Jepp-Audi", 2016, 25000,"160-209 km/h"));
			vehicleItems.put(104, new Car(104, "AUDI-A6", 2013, 15000,"210-250 km/h"));
			vehicleItems.put(105, new Motorcycle(105,"Honda-Motorcycle", 2019, 1000,"160-177 km/h"));
			vehicleItems.put(106, new Motorcycle(106, "Harley Davidson", 2019, 1300,"177-193 km/h"));
			vehicleItems.put(107, new Motorcycle(107,"Black Kawasaki", 2019, 10000,"160-177 km/h"));
			vehicleItems.put(108, new Motorcycle(108, "EBR-motorcycle", 2020, 1200,"274-290 km/h"));
			vehicleItems.put(110, new Motorcycle(110, "Suzuki-motorcycle", 2012, 15000,"250-266 km/h"));
	}
	public HashMap<Integer,Vehicle> getVehicleItems(){
		return vehicleItems;
	}
}
