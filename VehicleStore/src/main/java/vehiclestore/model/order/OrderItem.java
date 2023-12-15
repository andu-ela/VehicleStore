package vehiclestore.model.order;

import vehiclestore.model.vehicle.Vehicle;

public class OrderItem {

	private Vehicle vehicle;
	private PackageType vehicleItemCategory;
	private double vehicleItemPrice;
	

	public OrderItem(Vehicle vehicle, PackageType vehicleItemCategory) {
		this.vehicle = vehicle;
		this.vehicleItemCategory = vehicleItemCategory;
	
	}
	
	public OrderItem() {
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public double getVehicleItemPrice() {
		return vehicleItemPrice;
	}
	public void setVehicleItemPrice(double vehicleItemPrice) {
		this.vehicleItemPrice = vehicleItemPrice;
	}

	public PackageType getVehicleCategory() {
		return vehicleItemCategory;
	}

	public void setVehicleCategory(PackageType vehicleCategory) {
		this.vehicleItemCategory = vehicleCategory;
	}

}
