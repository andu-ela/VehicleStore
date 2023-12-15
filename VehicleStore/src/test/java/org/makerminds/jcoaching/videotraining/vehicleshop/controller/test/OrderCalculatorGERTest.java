package org.makerminds.jcoaching.videotraining.vehicleshop.controller.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import vehiclestore.controller.order.OrderCalculatorGR;
import vehiclestore.model.order.PackageType;

public class OrderCalculatorGERTest {

	OrderCalculatorGR orderCalculatorGER = new OrderCalculatorGR();

	@Test
	public void testGetVATRate() {
		double vatRate = orderCalculatorGER.getVATRate();
		Assertions.assertEquals(0.19, vatRate);
	}

	@Test
	public void testGetCategoryPackage() {
		double packageNormal = orderCalculatorGER.getCategoryAmount(PackageType.NORMAL);
		Assertions.assertEquals(1, packageNormal);

		double packageBussines = orderCalculatorGER.getCategoryAmount(PackageType.BUSSINES);
		Assertions.assertEquals(1.25, packageBussines);

		double packageSport = orderCalculatorGER.getCategoryAmount(PackageType.SPORT);
		Assertions.assertEquals(1.3, packageSport);

	}
}
