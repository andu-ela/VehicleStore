package vehiclestore;

import java.util.ArrayList;
import java.util.Scanner;

import vehiclestore.controller.LocationManager;
import vehiclestore.controller.VehiclePrinter;
import vehiclestore.controller.order.IOrderCalculator;
import vehiclestore.controller.order.OrderCalculatorGR;
import vehiclestore.controller.order.OrderCalculatorKS;
import vehiclestore.controller.order.OrderPrinter;
import vehiclestore.controller.vehicle.VehicleShopManager;
import vehiclestore.model.Client;
import vehiclestore.model.Employee;
import vehiclestore.model.VehicleStock;
import vehiclestore.model.order.OrderItem;
import vehiclestore.model.vehicle.Car;
import vehiclestore.model.vehicle.Vehicle;
import vehicletore.enums.ApplicationMode;
import vehicletore.enums.Location;

public class VehicleShop {

	private static Location currentLocation;
	private static Scanner scanner = new Scanner(System.in);
	private static int vatRate;

	public static void main(String[] args) {
		ApplicationMode selectedApplicationMode;
		try {
			do {
				selectedApplicationMode = getApplicationMode();
				if(selectedApplicationMode == ApplicationMode.SELLVEHICLE) {
					getCurrentLocation();
				}
				validateApplicationMode(selectedApplicationMode);
			}while (selectedApplicationMode != ApplicationMode.EXIT);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		
	}
	
	private static void getCurrentLocation() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Please select your location (type number):").append(System.lineSeparator())
				.append("1. " + Location.KOSOVO.name()).append(System.lineSeparator()).append("2. " + Location.GERMANY.name());
		System.out.println(stringBuilder.toString());
		int selectedLocationId = scanner.nextInt();
		currentLocation = LocationManager.getLocationFromId(selectedLocationId);
	}

	private static ApplicationMode getApplicationMode() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Please select an application mode (tybe number): ").append(System.lineSeparator())
				.append("1. " + ApplicationMode.SELLVEHICLE.name()).append(System.lineSeparator())
				.append("2. " + ApplicationMode.ADD_NEW_VEHICLE.name()).append(System.lineSeparator())
				.append("3. " + ApplicationMode.EXIT.name()).append(System.lineSeparator());
		
		System.out.println(stringBuilder.toString());
		int selectedApplicationModeID = scanner.nextInt();
		ApplicationMode selectedApplicationMode = getApplicationModeFromId(selectedApplicationModeID);
		return selectedApplicationMode;
	}

	private static ApplicationMode getApplicationModeFromId(int selectedApplicationModeID) {
		switch (selectedApplicationModeID) {
		case 1:
			return ApplicationMode.SELLVEHICLE;
		case 2:
			return ApplicationMode.ADD_NEW_VEHICLE;
		case 3:
			return ApplicationMode.EXIT;
		}

		return null;
	}

	private static void validateApplicationMode(ApplicationMode applicationMode) {
		switch (applicationMode) {
		case SELLVEHICLE:
			runSellProcess();
			break;
		case ADD_NEW_VEHICLE:
			runNewVehiclesProcess();
			break;
		case EXIT:
		   System.out.println("The application has stopped running. \nThank you for using our app.");
		   break;
		default:
			throw new IllegalArgumentException("No valid application mode selected!");
		}
	}

	private static void runSellProcess() {
		Vehicle vehicle = new Car(100, "Honda Civic", 2022, 15000);

		Employee employee = new Employee("John Mean", 20);

		Client client = new Client("Anduela Nurshaba", "+38312345678", "Bregu i Diellit, Prishtine");

		VehicleStock vehicleStock = new VehicleStock();

		VehiclePrinter vehicleStockPrinter = new VehiclePrinter();
		vehicleStockPrinter.printCarStock(vehicleStock);

		calculateAndPrintOrderDetails(employee, vehicle, client, vehicleStock,vatRate);

	}

	private static IOrderCalculator getSellCalculator() {
		switch (currentLocation) {
		case KOSOVO:
			return new OrderCalculatorKS();
		case GERMANY:
			return new OrderCalculatorGR();
		default:
			System.err.println("Current location is invalid.");
			return null;
		}
	}

	private static void calculateAndPrintOrderDetails(Employee employee, Vehicle vehicle, Client client,
			VehicleStock vehicleStock , int vatRate) {
		IOrderCalculator orderCalculator = getSellCalculator();

		ArrayList<OrderItem> order = new ArrayList<>();
		vehicleStock.getVehicleItems();

		OrderPrinter orderPrinter = new OrderPrinter();
		orderPrinter.printVehicleInfoHeader(employee);

		for (OrderItem orderItem : order) {
			orderPrinter.printVehicleInfo(vehicle, employee, client, vehicleStock, orderItem,currentLocation,vatRate);
		}
		 vatRate = (int) orderCalculator.getVATRate(false);
		orderPrinter.printVehicleInfoFooter(vehicle, client, currentLocation,vatRate);
	}

	private static void runNewVehiclesProcess() {
		
		VehicleStock vehicleStock = new VehicleStock();
		    System.out.println("Adding a New Vehicle to Stock:");
		    VehicleShopManager vehicleShopManager = new VehicleShopManager();
		   vehicleShopManager.addVehicleToStockFromUserInput(vehicleStock);
	
	}
	}
