package vehiclestore.controller.order;

import java.util.HashMap;

import vehiclestore.model.Client;
import vehiclestore.model.Employee;
import vehiclestore.model.VehicleStock;
import vehiclestore.model.order.OrderItem;
import vehiclestore.model.vehicle.Vehicle;
import vehicletore.enums.Location;

public class OrderPrinter {

	public void printVehicleInfo(Vehicle vehicle,Employee employee, Client client,
			VehicleStock vehicleStock,OrderItem orderItem,Location currentLocation,int vatRate) {

		printVehicleInfoHeader(employee);

		HashMap<Integer, Vehicle> vehicleItems = vehicleStock.getVehicleItems();
		for (Vehicle vehicles : vehicleItems.values()) {
			System.out.println(vehicles.getVehicleID() + ". " + vehicles.getModel() + " | " + vehicles.getYear() + " | "
					+ vehicles.getPrice() + "�.");
			printOrderItemInfo(orderItem, currentLocation);

		}
		printVehicleInfoFooter(vehicle,client,currentLocation,vatRate);

	}

	private void printOrderItemInfo(OrderItem orderItem, Location location) {
		Vehicle vehicle = orderItem.getVehicle();
		IOrderCalculator orderCalculator = getOrderCalculator(location);
		orderCalculator.calculateCategoryItemPrice(orderItem);
		System.out.println(vehicle.getVehicleID() + ". " + vehicle.getModel() + ", Year: " + vehicle.getPrice() 
		+ " e.");
	}

	public void printVehicleInfoHeader(Employee employee) {
		System.out.println("-----------VEHCILE SHOP------------");
		System.out.println(" ");
		System.out.println("Employee Name: " + employee.getName());
		System.out.println("Employee ID: " + employee.getEmployeeID());
		System.out.println("------------------------------------");
		System.out.println("Sell a Vehicle: ");
		System.out.println("");

	}

	public void printVehicleInfoFooter(Vehicle vehicle,Client client, Location currentLocation,int vatRate) {
		IOrderCalculator orderCalculator = getOrderCalculator(currentLocation);
		OrderAmount orderAmount = orderCalculator.calculateOrderAmount(vehicle);
		vatRate = (int) orderCalculator.getVATRate(false);

		System.out.println("------------------------------------");
		System.out.println("The total price of the sell is: ");
		System.out.println("SUB TOTAL: " + orderAmount.getTotalOrderAmount() + " �.");
		System.out.println("VAT 18%: " + orderAmount.getTotalOrderAmountVAT() + " �.");
		System.out.println("TOTAL: " + orderAmount.getTotalOrderAmountWithVAT() + " �.");
		System.out.println("------------------------------------");
		System.out.println("Client: " + client.getName());
		System.out.println("Phone Number: " + client.getPhoneNr());
	}

	private IOrderCalculator getOrderCalculator(Location currentLocation) {
		if (currentLocation == null) {
			throw new IllegalArgumentException("Current location must not be null.");
		} else {
			switch (currentLocation) {
			case KOSOVO:
				return new OrderCalculatorKS();
			case GERMANY:
				return new OrderCalculatorGR();
			default:
				throw new IllegalArgumentException("Current location is invalid.");
			}
		}
	}

}
