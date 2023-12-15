package org.makerminds.jcoaching.videotraining.vehicleshop.controller.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import vehiclestore.controller.order.AbstractOrderlCalculator;
import vehiclestore.model.VehicleStock;
import vehiclestore.model.order.OrderItem;
import vehiclestore.model.order.PackageType;
import vehiclestore.model.vehicle.Vehicle;

public class AbstractOrderCalculatorTest {

	private VehicleStock vehicleStock = new VehicleStock();
	AbstractOrderlCalculator orderCalculatorMock = new AbstractOrderlCalculator() {

		@Override
		public double getCategoryAmount(PackageType packageType) {
			return 1.0;
		}

		@Override
		public double getVATRate() {
			return 0.12;
		}

		@Override
		public double calculateCategoryItemPrice(OrderItem orderItem) {
			 double categoryAmount = getCategoryAmount(orderItem.getVehicleCategory());
		        double vehiclePrice = orderItem.getVehicle().getPrice();
		        double categoryItemPrice = categoryAmount * vehiclePrice;
		        return categoryItemPrice;
		}
	};
	

	@Test
	public void testCalcuateTotalOrderItemPrice() {
		Vehicle vehicle = vehicleStock.getVehicleItems().get(100);
		OrderItem orderItem = new OrderItem(vehicle, PackageType.SPORT);

		double totalOrderItemPrice = orderCalculatorMock.calculateCategoryItemPrice(orderItem);

		Assertions.assertEquals(15000.0, totalOrderItemPrice);
	}
	@Test
	public void testCalculateTotalOrderAmountVAT() {
		double totalOrderAmountVAT = orderCalculatorMock.calculateTotalOrderAmountVAT(12.0);
		Assertions.assertEquals(1.44, totalOrderAmountVAT);
	}
}
