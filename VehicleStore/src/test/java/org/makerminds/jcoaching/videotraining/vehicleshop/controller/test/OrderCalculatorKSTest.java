package org.makerminds.jcoaching.videotraining.vehicleshop.controller.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import vehiclestore.controller.order.OrderCalculatorKS;
import vehiclestore.model.order.PackageType;

public class OrderCalculatorKSTest {
	
	OrderCalculatorKS orderCalculatorKS = new OrderCalculatorKS();
	
	@Test
	public void testGetVATRate() {
		double vatRate = orderCalculatorKS.getVATRate();
		Assertions.assertEquals(0.18, vatRate);
	}
	
	@Test
	public void testGetCategoryPackage() {
		double packageNormal = orderCalculatorKS.getCategoryAmount(PackageType.NORMAL);
		Assertions.assertEquals(1, packageNormal);

		double packageBussines = orderCalculatorKS.getCategoryAmount(PackageType.BUSSINES);
		Assertions.assertEquals(1.25, packageBussines);

		double packageSport = orderCalculatorKS.getCategoryAmount(PackageType.SPORT);
		Assertions.assertEquals(1.3, packageSport);

	}
}
