import java.util.ArrayList;

public class Booking {
	
	// Flight Data
	
	private ArrayList <String> flightID;
	private ArrayList <String> departCity;
	private ArrayList <String> arrivalCity;
	private ArrayList <String> departAirport;
	private ArrayList <String> arrivalAirport;
	private ArrayList <String> departDate;
	private ArrayList <String> departTime;
	private ArrayList <String> arrivalTime;
	private ArrayList <String> duration;
	private ArrayList <String> distance;
	private ArrayList <String> delay;
	private ArrayList <String> airline;
	
	private ArrayList <String> userSelectedFlight;
	private String [] userSelectedFlightThere;
	private String [] userSelectedFlightBack;
	
	
	// Additional Data
	
	private ArrayList <String> passengers;
	private ArrayList <String> finances;
	private ArrayList <String> food;
	private ArrayList <String> products;
	private ArrayList <String> seats;
	
	
	// Constructor
	
	public Booking(ArrayList <String> userSelectedFlight) {
		
		userSelectedFlightThere = userSelectedFlight.get(0).split(",");
		
		if (userSelectedFlight.size() == 2) {
			
			userSelectedFlightBack = userSelectedFlight.get(1).split(",");
			
		}
		
		this.userSelectedFlight = userSelectedFlight;
		
	}
	
	
	// Getters

	public ArrayList <String> getFlightID() {
		
		flightID.add(userSelectedFlightThere[10]);
		
		if (userSelectedFlight.size() == 2) {
			
			flightID.add(userSelectedFlightBack[10]);
			
		}
		
		return flightID;
		
	}
	
	public ArrayList <String> getDepartCity() {
		
		departCity.add(userSelectedFlightThere[7]);
		
		if (userSelectedFlight.size() == 2) {
			
			departCity.add(userSelectedFlightBack[7]);
			
		}
		
		return departCity;
		
	}
	
	public ArrayList <String> getArrivalCity() {
		
		arrivalCity.add(userSelectedFlightThere[9]);
		
		if (userSelectedFlight.size() == 2) {
			
			arrivalCity.add(userSelectedFlightBack[9]);
			
		}
		
		return arrivalCity;
		
	}
	
	public ArrayList <String> getDepartAirport() {
		
		departAirport.add(userSelectedFlightThere[6]);
		
		if (userSelectedFlight.size() == 2) {
			
			departAirport.add(userSelectedFlightBack[6]);
			
		}
		
		return departAirport;
		
	}
	
	public ArrayList <String> getArrivalAirport() {
		
		arrivalAirport.add(userSelectedFlightThere[8]);
		
		if (userSelectedFlight.size() == 2) {
			
			arrivalAirport.add(userSelectedFlightBack[8]);
			
		}
		
		return arrivalAirport;
		
	}
	
	public ArrayList <String> getDepartDate() {
		
		departDate.add(userSelectedFlightThere[0]);
		
		if (userSelectedFlight.size() == 2) {
			
			departDate.add(userSelectedFlightBack[0]);
			
		}
		
		return departDate;
		
	}
	
	public ArrayList <String> getDepartTime() {
		
		departTime.add(userSelectedFlightThere[1]);
		
		if (userSelectedFlight.size() == 2) {
			
			departTime.add(userSelectedFlightBack[1]);
			
		}
		
		return departTime;
		
	}
	
	public ArrayList <String> getArrivalTime() {
		
		arrivalTime.add(userSelectedFlightThere[2]);
		
		if (userSelectedFlight.size() == 2) {
			
			arrivalTime.add(userSelectedFlightBack[2]);
			
		}
		
		return arrivalTime;
		
	}
	
	public ArrayList <String> getDuration() {
		
		duration.add(userSelectedFlightThere[3]);
		
		if (userSelectedFlight.size() == 2) {
			
			duration.add(userSelectedFlightBack[3]);
			
		}
		
		return duration;
		
	}
	
	public ArrayList <String> getDistance() {
		
		distance.add(userSelectedFlightThere[4]);
		
		if (userSelectedFlight.size() == 2) {
			
			distance.add(userSelectedFlightBack[4]);
			
		}
		
		return distance;
		
	}
	
	public ArrayList <String> getDelay() {
		
		delay.add(userSelectedFlightThere[5]);
		
		if (userSelectedFlight.size() == 2) {
			
			delay.add(userSelectedFlightBack[5]);
			
		}
		
		return delay;
		
	}
	
	public ArrayList <String> getAirline() {
		
		airline.add(userSelectedFlightThere[11]);
		
		if (userSelectedFlight.size() == 2) {
			
			airline.add(userSelectedFlightBack[11]);
			
		}
		
		return airline;
		
	}
	
	public ArrayList <String> getPassengers() {
		
		return passengers;
		
	}
	
	public ArrayList <String> getFinances() {
		
		return finances;
		
	}
	
	public ArrayList <String> getFood() {
		
		return food;
		
	}
	
	public ArrayList <String> getProducts() {
		
		return products;
		
	}
	
	public ArrayList <String> getSeats() {
		
		return seats;
		
	}
	
	
	// Setters
	
	public void setFlightID(ArrayList <String> flightID) {
		
		this.flightID = flightID;
		
	}
	
	public void setDepartCity(ArrayList <String>  departCity) {
		
		this.departCity = departCity;
		
	}
	
	public void setArrivalCity(ArrayList <String>  arrivalCity) {
		
		this.arrivalCity = arrivalCity;
		
	}
	
	public void setDepartAirport(ArrayList <String>  departAirport) {
		
		this.departAirport = departAirport;
		
	}
	
	public void setArrivalAirport(ArrayList <String>  arrivalAirport) {
		
		this.arrivalAirport = arrivalAirport;
		
	}
	
	public void setDepartDate(ArrayList <String> departDate) {
		
		this.departDate = departDate;
		
	}
	
	public void setDepartTime(ArrayList <String> departTime) {
		
		this.departTime = departTime;
		
	}
	
	public void setArrivalTime(ArrayList <String> arrivalTime) {
		
		this.arrivalTime = arrivalTime;
		
	}
	
	public void setDuration(ArrayList <String> duration) {
		
		this.duration = duration;
		
	}
	
	public void setDistance(ArrayList <String> distance) {
		
		this.distance = distance;
		
	}
	
	public void setDelay(ArrayList <String> delay) {
		
		this.delay = delay;
		
	}
	
	public void setAirline(ArrayList <String> airline) {
		
		this.airline = airline;
		
	}
	
	public void setPassengers(ArrayList<String> passengers) {
		
		this.passengers = passengers;
		
	}
	
	public void setFinances(ArrayList<String> finances) {
		
		this.finances = finances;
		
	}
	
	public void setFood(ArrayList<String> food) {
		
		this.food = food;
		
	}
	
	public void setProducts(ArrayList<String> products) {
		
		this.products = products;
		
	}
	
	public void setSeats(ArrayList<String> seats) {
		
		this.seats = seats;
		
	}

}







