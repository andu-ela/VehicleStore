package vehiclestore.controller.order;

import vehiclestore.model.order.OrderItem;
import vehiclestore.model.vehicle.Vehicle;

public abstract class  AbstractOrderlCalculator implements IOrderCalculator {


	public double calculateCategoryItemPrice(OrderItem orderItem) {
		double categoryAmount = getCategoryAmount(orderItem.getVehicleCategory());
		double totalCategoryItemPriceSingle = orderItem.getVehicleItemPrice() * categoryAmount;
		orderItem.setVehicleItemPrice(totalCategoryItemPriceSingle);
		return totalCategoryItemPriceSingle;
	}

	public double getVATRate(boolean decimal) {
		if (decimal) {
			return getVATRate();
		} else {
			return getVATRate() * 100;
		}
	}
	public double calculateVehicleItemPriceIncludingCategory(OrderItem orderItem) {
		double vehicleItemPriceIncludingCategory = calculateOrderItemPriceIncludingCategory(orderItem);
		return vehicleItemPriceIncludingCategory;
	}
	private double calculateOrderItemPriceIncludingCategory(OrderItem orderItem) {
		double categoryRateAmount = 1;

		Vehicle vehicle = orderItem.getVehicle();
		double totalOrderItemPriceSingle = vehicle.getPrice() * categoryRateAmount;
		orderItem.setVehicleItemPrice(totalOrderItemPriceSingle);
		return totalOrderItemPriceSingle;
	}

	public double calculateTotalOrderAmountVAT(double totalOrderAmount) {
		return totalOrderAmount * getVATRate();

	}
	public abstract double getVATRate();

	public OrderAmount calculateOrderAmount(Vehicle vehicle) {
		double totalOrderAmount = vehicle.getPrice();
		double totalOrderAmountVAT = calculateTotalOrderAmountVAT(totalOrderAmount);
		double totalOrderAmountWithVAT = totalOrderAmount + totalOrderAmountVAT; 

		OrderAmount orderAmount = new OrderAmount(totalOrderAmount, totalOrderAmountVAT, totalOrderAmountWithVAT);
		return orderAmount;
	}
}
