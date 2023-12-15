package vehiclestore.controller.order;

import vehiclestore.exceptions.InvalidPackageTypeException;
import vehiclestore.model.order.PackageType;

public class OrderCalculatorGR extends AbstractOrderlCalculator {

	private final double VAT_RATE = 0.19;
	
	public double getCategoryAmount(PackageType vehicleCategory) {
		switch(vehicleCategory) {
		case NORMAL:
			return 1;
		case BUSSINES:
			return 1.25;
		case SPORT: 
			return 1.3;
			default:
				throw new InvalidPackageTypeException("No valid package: " + vehicleCategory);
				
		}
	}
	public double getVATRate() {
		return VAT_RATE;
	}
	
}
