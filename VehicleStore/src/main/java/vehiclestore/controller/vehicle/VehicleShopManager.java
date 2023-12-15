package vehiclestore.controller.vehicle;

import java.util.Scanner;

import vehiclestore.model.VehicleStock;
import vehiclestore.model.vehicle.Car;
import vehiclestore.model.vehicle.Motorcycle;
import vehiclestore.model.vehicle.Vehicle;

public class VehicleShopManager {
	private static Scanner scanner = new Scanner(System.in);

	VehicleStock vehicleStock = new VehicleStock();

	public Vehicle addVehicleToStockFromUserInput(VehicleStock vehicleStock) {

		String type = readValidTextInput("Enter vehicle type (Car/Motorcycle): ", "Invalid input. Please choose again",
				new String[] { "Car", "Motorcycle" });

		// Read and validate the vehicle ID input
		int id = readValidNumberInput("Enter vehicle ID: ", "Invalid input. Please enter a valid number for the ID.");

		// Read and validate the vehicle name input
		String name = readValidNameInput("Enter vehicle name: ",
				"Invalid input for name. Please use only letters, numbers, and spaces.");

		// Read and validate the vehicle year input
		int year = readValidNumberInput("Enter vehicle Year: ",
				"Invalid input. Please enter a valid number for the ID.");

		// Read and validate the vehicle price input
		double price = readValidDoubleInput("Enter vehicle price: ",
				"Invalid input for price. Please enter a valid number.");

		// Read and validate the vehicle speed input
		String speed = readValidNameInput("Enter vehicle speed: ", "Invalid input for speed.");
		
		Vehicle vehicle = createVehicle(type, id, name, year, price, speed);
		
		// Add the new vehicle to the vehicle stock
		vehicleStock.getVehicleItems().put(id, vehicle); 

		// Display a message indicating that the new vehicle has been added successfully
		System.out.println("New vehicle added successfully:");
		System.out.println(type + ": " + id + ". " + name + ", " + year + ", " + price + ", " + speed + ".");

		return vehicle;
	}
	
	/**
	 * Creates a new Vehicle object based on the provided type and attributes.
	 * 
	 * type   The type of the vehicle (Car or Motorcycle).
	 * id     The unique ID of the vehicle.
	 * name   The name or model of the vehicle.
	 * year   The manufacturing year of the vehicle.
	 * price  The price of the vehicle.
	 * speed  The speed range of the vehicle.
	 * @return A new Vehicle object of the specified type with the provided attributes.
	 * @throws IllegalArgumentException if an invalid vehicle type is provided.
	 */

	public Vehicle createVehicle(String type, int id, String name, int year, double price, String speed) {
		if (type.equalsIgnoreCase("Car")) {
			return new Car(id, name, year, price, speed);
		} else if (type.equalsIgnoreCase("Motorcycle")) {
			return new Motorcycle(id, name, year, price, speed);
		} else {
			throw new IllegalArgumentException("Invalid vehicle type");
		}
	}
	
	/**
	 * Reads and validates user input for an integer number.
	 * 
	 * @param message     The message to display as a prompt to the user.
	 *  errorMessage The error message to display if the input is invalid.
	 * @return            The validated integer number provided by the user.
	 */

	private static int readValidNumberInput(String message, String errorMessage) {
		int number;
		while (true) {
			System.out.print(message);
			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				scanner.nextLine();
				return number;
			} else {
				System.err.println(errorMessage);
				scanner.nextLine();
			}
		}
	}
	
	/**
	 * Reads and validates user input for a Text.
	 * 
	 * The message to display as a prompt to the user.
	 *  errorMessage The error message to display if the input is invalid.
	 * @return The validated text provided by the user.
	 */
	private static String readValidTextInput(String message, String errorMessage, String[] validOptions) {
		String input;
		while (true) {
			System.out.print(message);
			input = scanner.nextLine();
			boolean isValid = false;
			for (String option : validOptions) {
				if (input.equalsIgnoreCase(option)) {
					isValid = true;
					break;
				}
			}
			if (isValid) {
				return input;
			} else {
				System.err.println(errorMessage);
			}
		}
	}

	private static String readValidNameInput(String message, String errorMessage) {
		String input;
		while (true) {
			System.out.print(message);
			input = scanner.nextLine();
			if (input.matches("^[a-zA-Z0-9 ]+$")) {
				return input;
			} else {
				System.err.println(errorMessage);
			}
		}
	}

	private static double readValidDoubleInput(String message, String errorMessage) {
		double input;
		while (true) {
			System.out.print(message);
			if (scanner.hasNextDouble()) {
				input = scanner.nextDouble();
				scanner.nextLine(); // Consume the newline
				return input;
			} else {
				System.err.println(errorMessage);
				scanner.nextLine(); // Consume the invalid input
			}
		}
	}

}
