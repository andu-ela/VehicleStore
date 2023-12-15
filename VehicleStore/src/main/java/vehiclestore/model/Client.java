package vehiclestore.model;

public class Client {

	private String name;
	private String phoneNr;
	private String address;
	
	public Client(String name, String phoneNr, String address) {
		this.name = name;
		this.phoneNr = phoneNr;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNr() {
		return phoneNr;
	}
	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
