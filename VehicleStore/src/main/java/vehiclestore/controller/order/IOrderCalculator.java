package vehiclestore.controller.order;

import vehiclestore.model.order.OrderItem;
import vehiclestore.model.order.PackageType;
import vehiclestore.model.vehicle.Vehicle;

public interface IOrderCalculator {
	
	public double calculateCategoryItemPrice(OrderItem orderItem); 
	public  double getCategoryAmount(PackageType packageType);
	public double calculateTotalOrderAmountVAT(double totalOrderAmount);
	public OrderAmount calculateOrderAmount(Vehicle vehicle);
	

	public double getVATRate(boolean decimal);
}
