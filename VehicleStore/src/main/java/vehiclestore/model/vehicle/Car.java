package vehiclestore.model.vehicle;

public class Car extends Vehicle {

	String carMaxSpeed;

	public Car(int vehicleID, String model, int year, double price) {
		setVehicleID(vehicleID);
		setModel(model);
		setYear(year);
		setPrice(price);
	}

	public Car(int vehicleID, String model, int year, double price, String carMaxSpeed) {
		this(vehicleID, model, year, price);
		this.carMaxSpeed = carMaxSpeed;
	}

	public String getCarMaxSpeed() {
		return carMaxSpeed;
	}

	public void setCarMaxSpeed(String carMaxSpeed) {
		this.carMaxSpeed = carMaxSpeed;
	}

}
