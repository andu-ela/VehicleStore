package vehiclestore.model.vehicle;

public class Motorcycle extends Vehicle {

	String motorcycleMaxSpeed;

	public Motorcycle(int vehicleID, String model, int year, double price) {
		setVehicleID(vehicleID);
		setModel(model);
		setYear(year);
		setPrice(price);
	}

	public Motorcycle(int vehicleID, String model, int year, double price, String maxSpeed) {
		this(vehicleID, model, year, price);
		this.motorcycleMaxSpeed = maxSpeed;
	}

	public String getMaxSpeed() {
		return motorcycleMaxSpeed;
	}

	public void setMaxSpeed(String maxSpeed) {
		this.motorcycleMaxSpeed = maxSpeed;
	}
}
