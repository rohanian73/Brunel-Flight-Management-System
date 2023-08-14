import java.awt.FontFormatException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Flights {
	
	ArrayList <String> flights = new ArrayList <String> ();
	
	public Flights() throws IOException {
		
		FileReader readerHandle = new FileReader("Flights.csv");
		BufferedReader BR = new BufferedReader(readerHandle);
		
		String line = "";
		
		while ((line = BR.readLine()) != null) {
			
			flights.add(line);
			
		}
		
	}
	
	
	// Returning List of Flights from CSV File
	
	public ArrayList <String> getFlights() {
		
		return flights;
		
	}
	
	// Getting List of Departure Cities
	
	public ArrayList <String> getDepartCities(ArrayList <String> flights) {
		
		ArrayList <String> departCities = new ArrayList <String> ();
		
		for (int i = 0; i < flights.size(); i++) {
			
			String [] lineArr = flights.get(i).split(",");
			
			if (departCities.size() == 0) {
				
				departCities.add(lineArr[7]);
				
			} else {
				
				int j = 0;
				
				while (!departCities.get(j).equals(lineArr[7])) {
					
					if (j == departCities.size() - 1) {
						
						departCities.add(lineArr[7]);
						break;
						
					}
					
					j++;
					
				}
				
			}
			
		}
		
		return departCities;
		
	}
	
	// Getting List of Arrival Cities
	
	public ArrayList <String> getArrivalCities(ArrayList <String> flights) {
		
		ArrayList <String> arrivalCities = new ArrayList <String> ();
		
		for (int i = 0; i < flights.size(); i++) {
			
			String [] lineArr = flights.get(i).split(",");
			
			if (arrivalCities.size() == 0) {
				
				arrivalCities.add(lineArr[9]);
				
			} else {
				
				int j = 0;
				
				while (!arrivalCities.get(j).equals(lineArr[9])) {
					
					if (j == arrivalCities.size() - 1) {
						
						arrivalCities.add(lineArr[9]);
						break;
						
					}
					
					j++;
					
				}
				
			}
			
		}
		
		return arrivalCities;
		
	}
	
	
	
	// Filtering Flights based on User Data
	
	public ArrayList <String> filterFlights (ArrayList <String> userFlight) {
		
		ArrayList <String> foundFlights = new ArrayList <String> ();
		
		for (int i = 0; i < flights.size(); i++) {
			
			String flight = flights.get(i);
			String lineArr [] = flight.split(",");
			String dbDepartCity = lineArr[7];
			String dbArrivalCity = lineArr[9];
			String dbDepartDate = lineArr[0];
			
			if (userFlight.get(0).equals(dbDepartCity)) {
				
				if (userFlight.get(1).equals(dbArrivalCity)) {
					
					if (userFlight.get(2).equals(dbDepartDate)) {
						
						foundFlights.add(flight);
						
					} else {
						
						continue;
						
					}
					
				} else {
					
					continue;
					
				}
				
			} else {
				
				continue;
				
			}
			
		}
		
		ArrayList <String> foundFlightsBack = new ArrayList <String> ();
		
		if (userFlight.size() == 4) {
			
			for (int i = 0; i < flights.size(); i++) {
				
				String flight = flights.get(i);
				String lineArr [] = flight.split(",");
				
				String dbDepartCity = lineArr[7];
				String dbArrivalCity = lineArr[9];
				String dbReturnDate = lineArr[0];
				
				if (userFlight.get(0).equals(dbArrivalCity)) {
					
					if (userFlight.get(1).equals(dbDepartCity)) {
						
						if (userFlight.get(3).equals(dbReturnDate)) {
							
							foundFlightsBack.add(flight);
							
						} else {
							
							continue;
							
						}
						
					} else {
						
						continue;
						
					}
					
				} else {
					
					continue;
					
				}
				
			}
			
		}
		
		int backFlightsCounter = 0;
		
		if (foundFlights.size() == foundFlightsBack.size()) {
			
			for (int i = 1; i <= foundFlights.size(); i += 2) {
				
				foundFlights.add(i, foundFlightsBack.get(backFlightsCounter));
				backFlightsCounter++;
				
			}
			
		}
		
		
		return foundFlights;
		
	}
	

}
