import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;

public class FoundFlights implements KeyListener, MouseListener, ActionListener {
	
	// Frames
	
	JFrame frame;
	Frame mainFrame;
	
	
	// Panel
	
	JPanel ticketBg;
	JPanel departFlightLine;
	JPanel flightsDivisionLine;
	JPanel returnFlightLine;
	
	
	// Labels
	
	JLabel title;
	JLabel leftArrow;
	JLabel rightArrow;
	JLabel numOfTickets;
	JLabel departSeats;
	JLabel returnSeats;
	
	
	// Departure Flight Data (Labels)
	
	JLabel departTime;
	JLabel departCity;
	JLabel departDate;
	JLabel departAirport;
	
	JLabel arrivalTime;
	JLabel arrivalCity;
	JLabel arrivalDate;
	JLabel arrivalAirport;
	
	JLabel duration;
	JLabel distance;
	JLabel delay;
	JLabel flightID;
	JLabel airline;
	
	
	// Return Flight Data (Labels)
	
	JLabel returnDepartTime;
	JLabel returnDepartCity;
	JLabel returnDepartDate;
	JLabel returnDepartAirport;
	
	JLabel returnArrivalTime;
	JLabel returnArrivalCity;
	JLabel returnArrivalDate;
	JLabel returnArrivalAirport;
	
	JLabel returnDuration;
	JLabel returnDistance;
	JLabel returnDelay;
	JLabel returnFlightID;
	JLabel returnAirline;
	
	
	// ComboBox
	
	JComboBox numOfTicketsBox;
	
	
	// Buttons
	
	JButton seatingPlan;
	JButton purchase;
	
	
	// Colors

	Color btnColor;
	Color hoverColor;
	
	
	// ArrayList
	
	ArrayList <Integer> ticketNums;
	ArrayList <String> userFlight;
	ArrayList <String> foundFlights;
	
	
	// int
	
	int countFlights = 0;
	int countOneWayFlights = 0;
	

	
	public FoundFlights(ArrayList <String> userFlight, ArrayList <String> foundFlights) {
		
		Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
		
		this.userFlight = userFlight;
		this.foundFlights = foundFlights;
		
		// Found Flights (Frame)
		
		frame = new JFrame();
		
		frame.setTitle("Brunel Flight Management System");
		frame.setVisible(true);
		frame.setLocation(180, 50);
		frame.setSize(1200, 700);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setBackground(Color.WHITE);
		
		ImageIcon image = new ImageIcon("brunel-logo.png");
		frame.setIconImage(image.getImage());
		
		
		// Title (Label)
		
		title = new JLabel("Found Flights");
		title.setFont(new Font("Open Sans", Font.BOLD, 36));
		title.setForeground(Color.BLACK);
		title.setBounds(475, 20, 250, 50);
		
		frame.add(title);
		
		
		// Constructing a Ticket
		
		if (userFlight.size() == 4) {

			// One Way is unchecked
			
			// First Departure Flight
			
			String firstDepartFlight [] = foundFlights.get(0).split(",");


			// Airline
			airline = new JLabel();
			airline.setText(firstDepartFlight[11]);
			airline.setFont(new Font("Open Sans", Font.BOLD, 16));
			airline.setForeground(Color.WHITE);
			airline.setBounds(255, 125, 250, 30);

			frame.add(airline);


			// Flight ID
			flightID = new JLabel();
			flightID.setText(firstDepartFlight[10]);
			flightID.setFont(new Font("Open Sans", Font.BOLD, 16));
			flightID.setForeground(Color.WHITE);
			flightID.setBounds(815, 125, 120, 30);

			frame.add(flightID);


			// Departure Time
			departTime = new JLabel();
			departTime.setText(firstDepartFlight[1]);
			departTime.setFont(new Font("Open Sans", Font.BOLD, 35));
			departTime.setForeground(Color.WHITE);
			departTime.setBounds(280, 185, 100, 30);

			frame.add(departTime);


			// Arrival Time
			arrivalTime = new JLabel();
			arrivalTime.setText(firstDepartFlight[2]);
			arrivalTime.setFont(new Font("Open Sans", Font.BOLD, 35));
			arrivalTime.setForeground(Color.WHITE);
			arrivalTime.setBounds(820, 185, 100, 30);

			frame.add(arrivalTime);


			// Departure City
			departCity = new JLabel();
			departCity.setText(firstDepartFlight[7]);
			departCity.setFont(new Font("Open Sans", Font.BOLD, 18));
			departCity.setForeground(Color.WHITE);

			if (firstDepartFlight[7].length() <= 5) {

				departCity.setBounds(298, 215, 70, 30);

			} else if (firstDepartFlight[7].length() == 6) {

				departCity.setBounds(290, 215, 90, 30);

			} else if (firstDepartFlight[7].length() == 7) {
				
				departCity.setBounds(285, 215, 105, 30);
				
			} else if (firstDepartFlight[7].length() == 8) {
				
				departCity.setBounds(280, 215, 105, 30);
				
			} else if (firstDepartFlight[7].length() == 9) {

				departCity.setBounds(275, 215, 105, 30);

			} else if (firstDepartFlight[7].length() == 10) {

				departCity.setBounds(270, 215, 120, 30);

			} else {

				departCity.setBounds(260, 215, 130, 30);

			}

			frame.add(departCity);


			// Arrival City
			arrivalCity = new JLabel();
			arrivalCity.setText(firstDepartFlight[9]);
			arrivalCity.setFont(new Font("Open Sans", Font.BOLD, 18));
			arrivalCity.setForeground(Color.WHITE);

			if (firstDepartFlight[9].length() <= 5) {

				arrivalCity.setBounds(838, 215, 70, 30);

			} else if (firstDepartFlight[9].length() == 6) {

				arrivalCity.setBounds(830, 215, 90, 30);

			} else if (firstDepartFlight[9].length() == 7) {
				
				arrivalCity.setBounds(825, 215, 90, 30);
				
			} else if (firstDepartFlight[9].length() == 8) {
				
				arrivalCity.setBounds(820, 215, 90, 30);
				
			} else if (firstDepartFlight[9].length() == 9) {

				arrivalCity.setBounds(815, 215, 105, 30);

			} else if (firstDepartFlight[9].length() == 10) {

				arrivalCity.setBounds(810, 215, 120, 30);

			} else {

				arrivalCity.setBounds(800, 215, 130, 30);

			}

			frame.add(arrivalCity);


			// Departure Date
			departDate = new JLabel();
			departDate.setText(firstDepartFlight[0]);
			departDate.setFont(new Font("Open Sans", Font.BOLD, 14));
			departDate.setForeground(Color.WHITE);
			departDate.setBounds(287, 235, 100, 30);

			frame.add(departDate);


			// Arrival Date
			arrivalDate = new JLabel();

			int departHour = Integer.parseInt(departTime.getText().substring(0, 2));
			int departMin = Integer.parseInt(departTime.getText().substring(3, 5));

			int arrivalHour = Integer.parseInt(arrivalTime.getText().substring(0, 2));
			int arrivalMin = Integer.parseInt(arrivalTime.getText().substring(3, 5));

			// Validation of Arrival Date

			if (departHour < arrivalHour || (departHour == arrivalHour && departMin < arrivalMin)) {

				arrivalDate.setText(departDate.getText());

			} else if (departHour > arrivalHour || (departHour == arrivalHour && departMin >= arrivalMin)) {

				String departDay = departDate.getText().substring(0 ,2);
				String departMonth = departDate.getText().substring(3, 5);
				String departYear = departDate.getText().substring(6, 10);

				String arrivalDay;
				String arrivalMonth;

				if (departDay.equals("31")) {

					arrivalDay = "01";

					if (departMonth != "12") {

						if (departMonth != "10" && departMonth != "11") {

							arrivalMonth = "0" + (Integer.parseInt(departMonth) + 1);

						} else {

							arrivalMonth = (Integer.parseInt(departMonth) + 1) + "";

						}

					} else {

						arrivalMonth = "01";

					}

					arrivalDate.setText(arrivalDay + "/" + arrivalMonth + "/" + departYear);

				} else if (departDay.equals("30") && (departMonth.equals("01") 
						|| departMonth.equals("03") 
						|| departMonth.equals("05") 
						|| departMonth.equals("07")
						|| departMonth.equals("08")
						|| departMonth.equals("10")
						|| departMonth.equals("12"))) {

					arrivalDay = "31";

					arrivalDate.setText(arrivalDay + "/" + departMonth + "/" + departYear);

				} else if (departDay.equals("30") && !(departMonth.equals("01") 
						|| departMonth.equals("03") 
						|| departMonth.equals("05") 
						|| departMonth.equals("07")
						|| departMonth.equals("08")
						|| departMonth.equals("10")
						|| departMonth.equals("12"))) {

					arrivalDay = "01";

					if (departMonth != "11") {

						arrivalMonth = "0" + (Integer.parseInt(departMonth) + 1);

					} else {

						arrivalMonth = (Integer.parseInt(departMonth) + 1) + "";

					}

					arrivalDate.setText(arrivalDay + "/" + arrivalMonth + "/" + departYear);

				} else if (departDay == "28" && departMonth == "02") {

					arrivalDay = "01";
					arrivalMonth = "03";

					arrivalDate.setText(arrivalDay + "/" + arrivalMonth + "/" + departYear);

				} else {

					if (departDay.charAt(0) == '0') {

						arrivalDay = "0" + (Integer.parseInt(departDay) + 1);

					} else {

						arrivalDay = (Integer.parseInt(departDay) + 1) + "";

					}

					arrivalDate.setText(arrivalDay + "/" + departMonth + "/" + departYear);

				}

			}

			arrivalDate.setFont(new Font("Open Sans", Font.BOLD, 14));
			arrivalDate.setForeground(Color.WHITE);
			arrivalDate.setBounds(830, 235, 100, 30);

			frame.add(arrivalDate);


			// Departure Flight Line (Panel)
			departFlightLine = new JPanel();
			departFlightLine.setBackground(Color.WHITE);
			departFlightLine.setBounds(390, 230, 410, 3);

			frame.add(departFlightLine);


			// Departure Airport
			departAirport = new JLabel();
			departAirport.setText(firstDepartFlight[6]);
			departAirport.setFont(new Font("Open Sans", Font.BOLD, 14));
			departAirport.setForeground(Color.WHITE);
			departAirport.setBounds(390, 200, 45, 30);

			frame.add(departAirport);


			// Arrival Airport
			arrivalAirport = new JLabel();
			arrivalAirport.setText(firstDepartFlight[8]);
			arrivalAirport.setFont(new Font("Open Sans", Font.BOLD, 14));
			arrivalAirport.setForeground(Color.WHITE);
			arrivalAirport.setBounds(770, 200, 45, 30);

			frame.add(arrivalAirport);


			// Duration
			duration = new JLabel();
			duration.setText(firstDepartFlight[3] + " hours");
			duration.setFont(new Font("Open Sans", Font.BOLD, 14));
			duration.setForeground(Color.WHITE);
			duration.setBounds(390, 230, 100, 30);

			frame.add(duration);


			// Distance
			distance = new JLabel();
			distance.setText(firstDepartFlight[4] + " miles");
			distance.setFont(new Font("Open Sans", Font.BOLD, 14));
			distance.setForeground(Color.WHITE);
			distance.setBounds(550, 230, 120, 30);

			frame.add(distance);


			// Delay
			delay = new JLabel();
			delay.setText(firstDepartFlight[5] + " minutes");
			delay.setFont(new Font("Open Sans", Font.BOLD, 14));
			delay.setForeground(Color.WHITE);
			delay.setBounds(715, 230, 100, 30);

			if (firstDepartFlight[5].length() == 3) {

				delay.setBounds(715, 230, 100, 30);

			} else if (firstDepartFlight[5].length() == 2) {

				delay.setBounds(725, 230, 100, 30);

			} else if (firstDepartFlight[5].length() == 1) {

				delay.setBounds(735, 230, 100, 30);

			}

			frame.add(delay);


			// Flights Division Line
			flightsDivisionLine = new JPanel();
			flightsDivisionLine.setBackground(Color.WHITE);
			flightsDivisionLine.setBounds(270, 285, 650, 1);

			frame.add(flightsDivisionLine);


			// First Return Flight

			String firstReturnFlight [] = foundFlights.get(1).split(",");


			// Return Airline
			returnAirline = new JLabel();
			returnAirline.setText(firstReturnFlight[11]);
			returnAirline.setFont(new Font("Open Sans", Font.BOLD, 16));
			returnAirline.setForeground(Color.WHITE);
			returnAirline.setBounds(255, 430, 250, 30);

			frame.add(returnAirline);


			// Return Flight ID
			returnFlightID = new JLabel();
			returnFlightID.setText(firstReturnFlight[10]);
			returnFlightID.setFont(new Font("Open Sans", Font.BOLD, 16));
			returnFlightID.setForeground(Color.WHITE);
			returnFlightID.setBounds(815, 430, 120, 30);

			frame.add(returnFlightID);


			// Return Departure Time
			returnDepartTime = new JLabel();
			returnDepartTime.setText(firstReturnFlight[1]);
			returnDepartTime.setFont(new Font("Open Sans", Font.BOLD, 35));
			returnDepartTime.setForeground(Color.WHITE);
			returnDepartTime.setBounds(280, 310, 100, 30);

			frame.add(returnDepartTime);


			// Return Arrival Time
			returnArrivalTime = new JLabel();
			returnArrivalTime.setText(firstReturnFlight[2]);
			returnArrivalTime.setFont(new Font("Open Sans", Font.BOLD, 35));
			returnArrivalTime.setForeground(Color.WHITE);
			returnArrivalTime.setBounds(820, 310, 100, 30);

			frame.add(returnArrivalTime);


			// Return Departure City
			returnDepartCity = new JLabel();
			returnDepartCity.setText(firstReturnFlight[7]);
			returnDepartCity.setFont(new Font("Open Sans", Font.BOLD, 18));
			returnDepartCity.setForeground(Color.WHITE);
			
			if (firstReturnFlight[7].length() <= 5) {

				returnDepartCity.setBounds(298, 340, 70, 30);

			} else if (firstReturnFlight[7].length() == 6) {

				returnDepartCity.setBounds(290, 340, 90, 30);

			} else if (firstReturnFlight[7].length() == 7) {
				
				returnDepartCity.setBounds(285, 340, 105, 30);
				
			} else if (firstReturnFlight[7].length() == 8) {
				
				returnDepartCity.setBounds(280, 340, 105, 30);
				
			} else if (firstReturnFlight[7].length() == 9) {

				returnDepartCity.setBounds(275, 340, 105, 30);

			} else if (firstReturnFlight[7].length() == 10) {

				returnDepartCity.setBounds(270, 340, 120, 30);

			} else {

				returnDepartCity.setBounds(260, 340, 130, 30);

			}

			frame.add(returnDepartCity);


			// Return Arrival City
			returnArrivalCity = new JLabel();
			returnArrivalCity.setText(firstReturnFlight[9]);
			returnArrivalCity.setFont(new Font("Open Sans", Font.BOLD, 18));
			returnArrivalCity.setForeground(Color.WHITE);

			if (firstReturnFlight[9].length() <= 5) {

				returnArrivalCity.setBounds(838, 340, 70, 30);

			} else if (firstReturnFlight[9].length() == 6) {

				returnArrivalCity.setBounds(830, 340, 90, 30);

			} else if (firstReturnFlight[9].length() == 7) {
				
				returnArrivalCity.setBounds(825, 340, 90, 30);
				
			} else if (firstReturnFlight[9].length() == 8) {
				
				returnArrivalCity.setBounds(820, 340, 90, 30);
				
			} else if (firstReturnFlight[9].length() == 9) {

				returnArrivalCity.setBounds(815, 340, 105, 30);

			} else if (firstReturnFlight[9].length() == 10) {

				returnArrivalCity.setBounds(810, 340, 120, 30);

			} else {

				returnArrivalCity.setBounds(800, 340, 130, 30);

			}

			frame.add(returnArrivalCity);


			// Return Departure Date
			returnDepartDate = new JLabel();
			returnDepartDate.setText(firstReturnFlight[0]);
			returnDepartDate.setFont(new Font("Open Sans", Font.BOLD, 14));
			returnDepartDate.setForeground(Color.WHITE);
			returnDepartDate.setBounds(287, 360, 100, 30);

			frame.add(returnDepartDate);


			// Return Arrival Date
			returnArrivalDate = new JLabel();

			departHour = Integer.parseInt(returnDepartTime.getText().substring(0, 2));
			departMin = Integer.parseInt(returnDepartTime.getText().substring(3, 5));

			arrivalHour = Integer.parseInt(returnArrivalTime.getText().substring(0, 2));
			arrivalMin = Integer.parseInt(returnArrivalTime.getText().substring(3, 5));


			// Validation of Arrival Date

			if (departHour < arrivalHour || (departHour == arrivalHour && departMin < arrivalMin)) {

				returnArrivalDate.setText(returnDepartDate.getText());

			} else if (departHour > arrivalHour || (departHour == arrivalHour && departMin >= arrivalMin)) {

				String departDay = returnDepartDate.getText().substring(0 ,2);
				String departMonth = returnDepartDate.getText().substring(3, 5);
				String departYear = returnDepartDate.getText().substring(6, 10);

				String arrivalDay;
				String arrivalMonth;

				if (departDay.equals("31")) {

					arrivalDay = "01";

					if (departMonth != "12") {

						if (departMonth != "10" && departMonth != "11") {

							arrivalMonth = "0" + (Integer.parseInt(departMonth) + 1);

						} else {

							arrivalMonth = (Integer.parseInt(departMonth) + 1) + "";

						}

					} else {

						arrivalMonth = "01";

					}

					returnArrivalDate.setText(arrivalDay + "/" + arrivalMonth + "/" + departYear);

				} else if (departDay.equals("30") && (departMonth.equals("01") 
						|| departMonth.equals("03") 
						|| departMonth.equals("05") 
						|| departMonth.equals("07")
						|| departMonth.equals("08")
						|| departMonth.equals("10")
						|| departMonth.equals("12"))) {

					arrivalDay = "31";

					returnArrivalDate.setText(arrivalDay + "/" + departMonth + "/" + departYear);

				} else if (departDay.equals("30") && !(departMonth.equals("01") 
						|| departMonth.equals("03") 
						|| departMonth.equals("05") 
						|| departMonth.equals("07")
						|| departMonth.equals("08")
						|| departMonth.equals("10")
						|| departMonth.equals("12"))) {

					arrivalDay = "01";

					if (departMonth != "11") {

						arrivalMonth = "0" + (Integer.parseInt(departMonth) + 1);

					} else {

						arrivalMonth = (Integer.parseInt(departMonth) + 1) + "";

					}

					returnArrivalDate.setText(arrivalDay + "/" + arrivalMonth + "/" + departYear);

				} else if (departDay == "28" && departMonth == "02") {

					arrivalDay = "01";
					arrivalMonth = "03";

					returnArrivalDate.setText(arrivalDay + "/" + arrivalMonth + "/" + departYear);

				} else {

					if (departDay.charAt(0) == '0') {

						arrivalDay = "0" + (Integer.parseInt(departDay) + 1);

					} else {

						arrivalDay = (Integer.parseInt(departDay) + 1) + "";

					}

					returnArrivalDate.setText(arrivalDay + "/" + departMonth + "/" + departYear);

				}

			}

			returnArrivalDate.setFont(new Font("Open Sans", Font.BOLD, 14));
			returnArrivalDate.setForeground(Color.WHITE);
			returnArrivalDate.setBounds(830, 360, 100, 30);

			frame.add(returnArrivalDate);


			// Return Flight Line (Panel)
			returnFlightLine = new JPanel();
			returnFlightLine.setBackground(Color.WHITE);
			returnFlightLine.setBounds(390, 355, 410, 3);

			frame.add(returnFlightLine);


			// Return Departure Airport
			returnDepartAirport = new JLabel();
			returnDepartAirport.setText(firstReturnFlight[6]);
			returnDepartAirport.setFont(new Font("Open Sans", Font.BOLD, 14));
			returnDepartAirport.setForeground(Color.WHITE);
			returnDepartAirport.setBounds(390, 325, 45, 30);

			frame.add(returnDepartAirport);


			// Return Arrival Airport
			returnArrivalAirport = new JLabel();
			returnArrivalAirport.setText(firstReturnFlight[8]);
			returnArrivalAirport.setFont(new Font("Open Sans", Font.BOLD, 14));
			returnArrivalAirport.setForeground(Color.WHITE);
			returnArrivalAirport.setBounds(770, 325, 45, 30);

			frame.add(returnArrivalAirport);


			// Return Duration
			returnDuration = new JLabel();
			returnDuration.setText(firstReturnFlight[3] + " hours");
			returnDuration.setFont(new Font("Open Sans", Font.BOLD, 14));
			returnDuration.setForeground(Color.WHITE);
			returnDuration.setBounds(390, 355, 100, 30);

			frame.add(returnDuration);


			// Return Distance
			returnDistance = new JLabel();
			returnDistance.setText(firstReturnFlight[4] + " miles");
			returnDistance.setFont(new Font("Open Sans", Font.BOLD, 14));
			returnDistance.setForeground(Color.WHITE);
			returnDistance.setBounds(550, 355, 120, 30);

			frame.add(returnDistance);


			// Delay
			returnDelay = new JLabel();
			returnDelay.setText(firstReturnFlight[5] + " minutes");
			returnDelay.setFont(new Font("Open Sans", Font.BOLD, 14));
			returnDelay.setForeground(Color.WHITE);
			returnDelay.setBounds(715, 355, 100, 30);

			if (firstReturnFlight[5].length() == 3) {

				returnDelay.setBounds(715, 355, 100, 30);

			} else if (firstReturnFlight[5].length() == 2) {

				returnDelay.setBounds(725, 355, 100, 30);

			} else if (firstReturnFlight[5].length() == 1) {

				returnDelay.setBounds(735, 355, 100, 30);

			}

			frame.add(returnDelay);

		} else if (userFlight.size() == 3) {
			
			// One Way is checked
			
			// First Departure Flight

			String firstDepartFlight [] = foundFlights.get(0).split(",");


			// Airline
			airline = new JLabel();
			airline.setText(firstDepartFlight[11]);
			airline.setFont(new Font("Open Sans", Font.BOLD, 16));
			airline.setForeground(Color.WHITE);
			airline.setBounds(255, 125, 250, 30);

			frame.add(airline);


			// Flight ID
			flightID = new JLabel();
			flightID.setText(firstDepartFlight[10]);
			flightID.setFont(new Font("Open Sans", Font.BOLD, 16));
			flightID.setForeground(Color.WHITE);
			flightID.setBounds(815, 125, 120, 30);

			frame.add(flightID);


			// Departure Time
			departTime = new JLabel();
			departTime.setText(firstDepartFlight[1]);
			departTime.setFont(new Font("Open Sans", Font.BOLD, 35));
			departTime.setForeground(Color.WHITE);
			departTime.setBounds(280, 245, 100, 30);

			frame.add(departTime);


			// Arrival Time
			arrivalTime = new JLabel();
			arrivalTime.setText(firstDepartFlight[2]);
			arrivalTime.setFont(new Font("Open Sans", Font.BOLD, 35));
			arrivalTime.setForeground(Color.WHITE);
			arrivalTime.setBounds(820, 245, 100, 30);

			frame.add(arrivalTime);


			// Departure City
			departCity = new JLabel();
			departCity.setText(firstDepartFlight[7]);
			departCity.setFont(new Font("Open Sans", Font.BOLD, 18));
			departCity.setForeground(Color.WHITE);

			if (firstDepartFlight[7].length() <= 5) {

				departCity.setBounds(298, 275, 70, 30);

			} else if (firstDepartFlight[7].length() == 6) {

				departCity.setBounds(290, 275, 90, 30);

			} else if (firstDepartFlight[7].length() == 7) {
				
				departCity.setBounds(285, 275, 105, 30);
				
			} else if (firstDepartFlight[7].length() == 8) {
				
				departCity.setBounds(280, 275, 105, 30);
				
			} else if (firstDepartFlight[7].length() == 9) {

				departCity.setBounds(275, 275, 105, 30);

			} else if (firstDepartFlight[7].length() == 10) {

				departCity.setBounds(270, 275, 120, 30);

			} else {

				departCity.setBounds(260, 275, 130, 30);

			}

			frame.add(departCity);


			// Arrival City
			arrivalCity = new JLabel();
			arrivalCity.setText(firstDepartFlight[9]);
			arrivalCity.setFont(new Font("Open Sans", Font.BOLD, 18));
			arrivalCity.setForeground(Color.WHITE);

			if (firstDepartFlight[9].length() <= 5) {

				arrivalCity.setBounds(838, 275, 70, 30);

			} else if (firstDepartFlight[9].length() == 6) {

				arrivalCity.setBounds(830, 275, 90, 30);

			} else if (firstDepartFlight[9].length() == 7) {
				
				arrivalCity.setBounds(825, 275, 90, 30);
				
			} else if (firstDepartFlight[9].length() == 8) {
				
				arrivalCity.setBounds(820, 275, 90, 30);
				
			} else if (firstDepartFlight[9].length() == 9) {

				arrivalCity.setBounds(815, 275, 105, 30);

			} else if (firstDepartFlight[9].length() == 10) {

				arrivalCity.setBounds(810, 275, 120, 30);

			} else {

				arrivalCity.setBounds(800, 275, 130, 30);

			}

			frame.add(arrivalCity);


			// Departure Date
			departDate = new JLabel();
			departDate.setText(firstDepartFlight[0]);
			departDate.setFont(new Font("Open Sans", Font.BOLD, 14));
			departDate.setForeground(Color.WHITE);
			departDate.setBounds(287, 295, 100, 30);

			frame.add(departDate);


			// Arrival Date
			arrivalDate = new JLabel();

			int departHour = Integer.parseInt(departTime.getText().substring(0, 2));
			int departMin = Integer.parseInt(departTime.getText().substring(3, 5));

			int arrivalHour = Integer.parseInt(arrivalTime.getText().substring(0, 2));
			int arrivalMin = Integer.parseInt(arrivalTime.getText().substring(3, 5));

			// Validation of Arrival Date

			if (departHour < arrivalHour || (departHour == arrivalHour && departMin < arrivalMin)) {

				arrivalDate.setText(departDate.getText());

			} else if (departHour > arrivalHour || (departHour == arrivalHour && departMin >= arrivalMin)) {

				String departDay = departDate.getText().substring(0 ,2);
				String departMonth = departDate.getText().substring(3, 5);
				String departYear = departDate.getText().substring(6, 10);

				String arrivalDay;
				String arrivalMonth;

				if (departDay.equals("31")) {

					arrivalDay = "01";

					if (departMonth != "12") {

						if (departMonth != "10" && departMonth != "11") {

							arrivalMonth = "0" + (Integer.parseInt(departMonth) + 1);

						} else {

							arrivalMonth = (Integer.parseInt(departMonth) + 1) + "";

						}

					} else {

						arrivalMonth = "01";

					}

					arrivalDate.setText(arrivalDay + "/" + arrivalMonth + "/" + departYear);

				} else if (departDay.equals("30") && (departMonth.equals("01") 
						|| departMonth.equals("03") 
						|| departMonth.equals("05") 
						|| departMonth.equals("07")
						|| departMonth.equals("08")
						|| departMonth.equals("10")
						|| departMonth.equals("12"))) {

					arrivalDay = "31";

					arrivalDate.setText(arrivalDay + "/" + departMonth + "/" + departYear);

				} else if (departDay.equals("30") && !(departMonth.equals("01") 
						|| departMonth.equals("03") 
						|| departMonth.equals("05") 
						|| departMonth.equals("07")
						|| departMonth.equals("08")
						|| departMonth.equals("10")
						|| departMonth.equals("12"))) {

					arrivalDay = "01";

					if (departMonth != "11") {

						arrivalMonth = "0" + (Integer.parseInt(departMonth) + 1);

					} else {

						arrivalMonth = (Integer.parseInt(departMonth) + 1) + "";

					}

					arrivalDate.setText(arrivalDay + "/" + arrivalMonth + "/" + departYear);

				} else if (departDay == "28" && departMonth == "02") {

					arrivalDay = "01";
					arrivalMonth = "03";

					arrivalDate.setText(arrivalDay + "/" + arrivalMonth + "/" + departYear);

				} else {

					if (departDay.charAt(0) == '0') {

						arrivalDay = "0" + (Integer.parseInt(departDay) + 1);

					} else {

						arrivalDay = (Integer.parseInt(departDay) + 1) + "";

					}

					arrivalDate.setText(arrivalDay + "/" + departMonth + "/" + departYear);

				}

			}

			arrivalDate.setFont(new Font("Open Sans", Font.BOLD, 14));
			arrivalDate.setForeground(Color.WHITE);
			arrivalDate.setBounds(830, 295, 100, 30);

			frame.add(arrivalDate);


			// Departure Flight Line (Panel)
			departFlightLine = new JPanel();
			departFlightLine.setBackground(Color.WHITE);
			departFlightLine.setBounds(390, 290, 410, 3);

			frame.add(departFlightLine);


			// Departure Airport
			departAirport = new JLabel();
			departAirport.setText(firstDepartFlight[6]);
			departAirport.setFont(new Font("Open Sans", Font.BOLD, 14));
			departAirport.setForeground(Color.WHITE);
			departAirport.setBounds(390, 260, 45, 30);

			frame.add(departAirport);


			// Arrival Airport
			arrivalAirport = new JLabel();
			arrivalAirport.setText(firstDepartFlight[8]);
			arrivalAirport.setFont(new Font("Open Sans", Font.BOLD, 14));
			arrivalAirport.setForeground(Color.WHITE);
			arrivalAirport.setBounds(770, 260, 45, 30);

			frame.add(arrivalAirport);


			// Duration
			duration = new JLabel();
			duration.setText(firstDepartFlight[3] + " hours");
			duration.setFont(new Font("Open Sans", Font.BOLD, 14));
			duration.setForeground(Color.WHITE);
			duration.setBounds(390, 290, 100, 30);

			frame.add(duration);


			// Distance
			distance = new JLabel();
			distance.setText(firstDepartFlight[4] + " miles");
			distance.setFont(new Font("Open Sans", Font.BOLD, 14));
			distance.setForeground(Color.WHITE);
			distance.setBounds(550, 290, 120, 30);

			frame.add(distance);


			// Delay
			delay = new JLabel();
			delay.setText(firstDepartFlight[5] + " minutes");
			delay.setFont(new Font("Open Sans", Font.BOLD, 14));
			delay.setForeground(Color.WHITE);
			delay.setBounds(715, 290, 100, 30);

			if (firstDepartFlight[5].length() == 3) {

				delay.setBounds(715, 290, 100, 30);

			} else if (firstDepartFlight[5].length() == 2) {

				delay.setBounds(725, 290, 100, 30);

			} else if (firstDepartFlight[5].length() == 1) {

				delay.setBounds(735, 290, 100, 30);

			}

			frame.add(delay);

		}
		
		
		// Background of Ticket
		Color ticketColor = new Color(80, 107, 201);
		
		ticketBg = new JPanel();
		ticketBg.setBackground(ticketColor);
		ticketBg.setBounds(240, 120, 700, 350);
		
		frame.add(ticketBg);
		
		
		
		// Left Arrow (Label)
		
		ImageIcon leftArrowIcon = new ImageIcon("left-arrow.png");
		
		leftArrow = new JLabel();
		leftArrow.setIcon(leftArrowIcon);
		leftArrow.setBounds(50, 245, 100, 100);
		leftArrow.setVisible(false);
		
		leftArrow.addMouseListener(this);
		
		frame.add(leftArrow);
		
		
		// Right Arrow (Label)
		
		ImageIcon rightArrowIcon = new ImageIcon("right-arrow.png");
		
		rightArrow = new JLabel();
		rightArrow.setIcon(rightArrowIcon);
		rightArrow.setBounds(1100, 245, 100, 100);
		
		if ((userFlight.size() == 4 && foundFlights.size() == 2)
				|| (userFlight.size() == 3 && foundFlights.size() == 1)) {
			
			rightArrow.setVisible(false);
			
		}
		
		rightArrow.addMouseListener(this);
		
		frame.add(rightArrow);
		
		
		// Number of Tickets (Label)
		
		numOfTickets = new JLabel("Number of tickets:");
		numOfTickets.setFont(new Font("Open Sans", Font.BOLD, 20));
		numOfTickets.setForeground(Color.BLACK);
		numOfTickets.setBounds(60, 530, 400, 20);
		
		frame.add(numOfTickets);
		
		
		// Preparing Numbers of Tickets
		
		Integer numArr [] = new Integer [50];
		
		int startNum = 1;
		
		for (int i = 0; i < numArr.length; i++) {
			
			numArr[i] = startNum;
			startNum++;
			
		}
		
		ticketNums = new ArrayList <Integer> ();
		Collections.addAll(ticketNums, numArr);
		
		
		// Number of Tickets (ComboBox)
		
		numOfTicketsBox = new JComboBox();
		numOfTicketsBox.setFont(new Font("Open Sans", Font.BOLD, 14));
		numOfTicketsBox.setBackground(Color.WHITE);
		
		numOfTicketsBox.setEditable(true);
		((JLabel) numOfTicketsBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		numOfTicketsBox.setBounds(250, 528, 50, 30);
		
		DefaultComboBoxModel cbModel_nt = new DefaultComboBoxModel();
		cbModel_nt.addAll(ticketNums);
		numOfTicketsBox.setModel(cbModel_nt);
		numOfTicketsBox.setMaximumRowCount(4);
		
		numOfTicketsBox.getEditor().getEditorComponent().addKeyListener(this);
		
		frame.add(numOfTicketsBox);
		
		
		// Departing Seats (Label)
		
		departSeats = new JLabel("Departing seats:");
		departSeats.setFont(new Font("Open Sans", Font.BOLD, 20));
		departSeats.setForeground(Color.BLACK);
		departSeats.setBounds(510, 530, 400, 30);
		
		frame.add(departSeats);
		
		
		// Returning Seats (Label)
		
		returnSeats = new JLabel("Returning seats:");
		returnSeats.setFont(new Font("Open Sans", Font.BOLD, 20));
		returnSeats.setForeground(Color.BLACK);
		returnSeats.setBounds(510, 590, 400, 30);
		
		frame.add(returnSeats);
		
		
		
		// Seating Plan (Button)
		
		seatingPlan = new JButton();
		seatingPlan.setText("View Seating Plan");
		seatingPlan.setFont(new Font("Open Sans", Font.BOLD, 18));
		seatingPlan.setForeground(Color.WHITE);
		
		seatingPlan.setFocusable(false);
		seatingPlan.setBorder(BorderFactory.createEmptyBorder());
		
		btnColor = new Color(255, 121, 121);
		hoverColor = new Color(33, 235, 255);
		
		seatingPlan.setBackground(btnColor);
		seatingPlan.setBounds(900, 530, 199, 40);
		
		seatingPlan.addMouseListener(this);
		
		frame.add(seatingPlan);
		
		
		// Purchase (Button)
		
		purchase = new JButton();
		purchase.setText("Purchase");
		purchase.setFont(new Font("Open Sans", Font.BOLD, 18));
		purchase.setForeground(Color.WHITE);
		
		purchase.setFocusable(false);
		purchase.setBorder(BorderFactory.createEmptyBorder());
		
		purchase.setBackground(btnColor);
		purchase.setBounds(900, 590, 199, 40);
		
		purchase.addMouseListener(this);
		purchase.addActionListener(this);
		
		frame.add(purchase);
		
	}
	
	public static void main(String[] args) throws FontFormatException, IOException {
		
	}

	
	// Constructing a Ticket
	
	public void constructTicket(ArrayList <String> userFlight, ArrayList <String> foundFlights) {
		
		
		
	}
	
	
	// Auto Search for ComboBox (Number of Tickets ComboBox)

	@Override
	public void keyTyped(KeyEvent e) {
		
		if (e.getSource() == numOfTicketsBox.getEditor().getEditorComponent()) {
			
			JTextComponent editor = ((JTextComponent) ((JComboBox) ((Component) e.getSource()).getParent()).getEditor().getEditorComponent());
			String userRemainder = editor.getText();

			String userKey = (e.getKeyChar() + "");
			ArrayList <String> userNums = new ArrayList <String> ();

			String userNum = "";
			
			if (userRemainder.length() == 0) {
				
				userNum = userKey;
				
				if (userNum.contains("")) {
				
					userNum = "";
				
				}
				
			} else {
				
				userNum = userRemainder + userKey;
				
				if (userNum.contains("")) {
					
					userNum = userRemainder;
				
				}
				
			}
			
			for (int i = 0; i < ticketNums.size(); i++) {
				
				String num = ticketNums.get(i).toString();
				
				if (userNum.length() == 1) {
					
					if (userNum.charAt(0) == num.charAt(0)) {
						
						userNums.add(num);
						
					}
					
				} else if (userNum.length() > 1) {
					
					if (userNum.length() == num.length()) {
						
						int count = 0;
						
						for (int j = 0; j < userNum.length(); j++) {
							
							if (userNum.charAt(j) == num.charAt(j)) {
								
								count++;
								
								if (count == userNum.length()) {
									
									userNums.add(num);
									
								}
								
							}
							
						}
						
					}
					
				}
				
				
				if (i == ticketNums.size() - 1) {
					
					DefaultComboBoxModel cbModel_test = new DefaultComboBoxModel();
					cbModel_test.addAll(userNums);

					numOfTicketsBox.setModel(cbModel_test);
					numOfTicketsBox.showPopup();
					numOfTicketsBox.setMaximumRowCount(3);

					editor.setText(userRemainder);
					
				}
				
				
			}
			
			
			if (userNums.size() == 0) {
				
				DefaultComboBoxModel cbModel_test = new DefaultComboBoxModel();

				numOfTicketsBox.setModel(cbModel_test);
				numOfTicketsBox.showPopup();

				editor.setText(userRemainder);
				
				if (userNum.length() == 0) {
					
					cbModel_test.addAll(ticketNums);
					numOfTicketsBox.setMaximumRowCount(3);
					
				}
				
			}
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	
	
	// Hover Effect

	@Override
	public void mouseEntered(MouseEvent e) {
		
		if (e.getSource() == seatingPlan) {
			
			seatingPlan.setBackground(hoverColor);
			seatingPlan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
		}
		
		if (e.getSource() == purchase) {
			
			purchase.setBackground(hoverColor);
			purchase.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
		}
		
		if (e.getSource() == rightArrow) {
			
			rightArrow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
		}
		
		if (e.getSource() == leftArrow) {
			
			leftArrow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		if (e.getSource() == seatingPlan) {
			
			seatingPlan.setBackground(btnColor);
			
		}
		
		if (e.getSource() == purchase) {
			
			purchase.setBackground(btnColor);
			
		}
		
	}
	
	
	// Changing Contents of a Ticket
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (e.getSource() == rightArrow || e.getSource() == leftArrow) {
			
			if (userFlight.size() == 4) {
				
				// One Way is unchecked
				
				// Departure Flight

				if (countFlights <= foundFlights.size() - 2) {
					
					if (e.getSource() == rightArrow) {
						
						countFlights += 2;
						
					} else if (e.getSource() == leftArrow) {
						
						countFlights -= 2;
						
					}
					
					String departFlight [] = foundFlights.get(countFlights).split(",");


					// Airline
					airline.setText(departFlight[11]);


					// Flight ID
					flightID.setText(departFlight[10]);


					// Departure Time
					departTime.setText(departFlight[1]);


					// Arrival Time
					arrivalTime.setText(departFlight[2]);


					// Departure City
					departCity.setText(departFlight[7]);


					// Arrival City
					arrivalCity.setText(departFlight[9]);


					// Departure Date
					departDate.setText(departFlight[0]);


					// Arrival Date
					
					int departHour = Integer.parseInt(departTime.getText().substring(0, 2));
					int departMin = Integer.parseInt(departTime.getText().substring(3, 5));

					int arrivalHour = Integer.parseInt(arrivalTime.getText().substring(0, 2));
					int arrivalMin = Integer.parseInt(arrivalTime.getText().substring(3, 5));

					// Validation of Arrival Date

					if (departHour < arrivalHour || (departHour == arrivalHour && departMin < arrivalMin)) {

						arrivalDate.setText(departDate.getText());

					} else if (departHour > arrivalHour || (departHour == arrivalHour && departMin >= arrivalMin)) {

						String departDay = departDate.getText().substring(0 ,2);
						String departMonth = departDate.getText().substring(3, 5);
						String departYear = departDate.getText().substring(6, 10);

						String arrivalDay;
						String arrivalMonth;

						if (departDay.equals("31")) {

							arrivalDay = "01";

							if (departMonth != "12") {

								if (departMonth != "10" && departMonth != "11") {

									arrivalMonth = "0" + (Integer.parseInt(departMonth) + 1);

								} else {

									arrivalMonth = (Integer.parseInt(departMonth) + 1) + "";

								}

							} else {

								arrivalMonth = "01";

							}

							arrivalDate.setText(arrivalDay + "/" + arrivalMonth + "/" + departYear);

						} else if (departDay.equals("30") && (departMonth.equals("01") 
								|| departMonth.equals("03") 
								|| departMonth.equals("05") 
								|| departMonth.equals("07")
								|| departMonth.equals("08")
								|| departMonth.equals("10")
								|| departMonth.equals("12"))) {

							arrivalDay = "31";

							arrivalDate.setText(arrivalDay + "/" + departMonth + "/" + departYear);

						} else if (departDay.equals("30") && !(departMonth.equals("01") 
								|| departMonth.equals("03") 
								|| departMonth.equals("05") 
								|| departMonth.equals("07")
								|| departMonth.equals("08")
								|| departMonth.equals("10")
								|| departMonth.equals("12"))) {

							arrivalDay = "01";

							if (departMonth != "11") {

								arrivalMonth = "0" + (Integer.parseInt(departMonth) + 1);

							} else {

								arrivalMonth = (Integer.parseInt(departMonth) + 1) + "";

							}

							arrivalDate.setText(arrivalDay + "/" + arrivalMonth + "/" + departYear);

						} else if (departDay == "28" && departMonth == "02") {

							arrivalDay = "01";
							arrivalMonth = "03";

							arrivalDate.setText(arrivalDay + "/" + arrivalMonth + "/" + departYear);

						} else {

							if (departDay.charAt(0) == '0') {

								arrivalDay = "0" + (Integer.parseInt(departDay) + 1);

							} else {

								arrivalDay = (Integer.parseInt(departDay) + 1) + "";

							}

							arrivalDate.setText(arrivalDay + "/" + departMonth + "/" + departYear);

						}

					}


					// Departure Airport
					departAirport.setText(departFlight[6]);


					// Arrival Airport
					arrivalAirport.setText(departFlight[8]);


					// Duration
					duration.setText(departFlight[3] + " hours");


					// Distance
					distance.setText(departFlight[4] + " miles");


					// Delay
					delay.setText(departFlight[5] + " minutes");
					delay.setBounds(715, 230, 100, 30);

					if (departFlight[5].length() == 3) {

						delay.setBounds(715, 230, 100, 30);

					} else if (departFlight[5].length() == 2) {

						delay.setBounds(725, 230, 100, 30);

					} else if (departFlight[5].length() == 1) {

						delay.setBounds(735, 230, 100, 30);

					}


					// Return Flight

					String returnFlight [] = foundFlights.get(countFlights + 1).split(",");
					
					// Return Airline
					returnAirline.setText(returnFlight[11]);


					// Return Flight ID
					returnFlightID.setText(returnFlight[10]);


					// Return Departure Time
					returnDepartTime.setText(returnFlight[1]);


					// Return Arrival Time
					returnArrivalTime.setText(returnFlight[2]);


					// Return Departure City
					returnDepartCity.setText(returnFlight[7]);


					// Return Arrival City
					returnArrivalCity.setText(returnFlight[9]);


					// Return Departure Date
					returnDepartDate.setText(returnFlight[0]);


					// Return Arrival Date

					departHour = Integer.parseInt(returnDepartTime.getText().substring(0, 2));
					departMin = Integer.parseInt(returnDepartTime.getText().substring(3, 5));

					arrivalHour = Integer.parseInt(returnArrivalTime.getText().substring(0, 2));
					arrivalMin = Integer.parseInt(returnArrivalTime.getText().substring(3, 5));


					// Validation of Arrival Date

					if (departHour < arrivalHour || (departHour == arrivalHour && departMin < arrivalMin)) {

						returnArrivalDate.setText(returnDepartDate.getText());

					} else if (departHour > arrivalHour || (departHour == arrivalHour && departMin >= arrivalMin)) {

						String departDay = returnDepartDate.getText().substring(0 ,2);
						String departMonth = returnDepartDate.getText().substring(3, 5);
						String departYear = returnDepartDate.getText().substring(6, 10);

						String arrivalDay;
						String arrivalMonth;

						if (departDay.equals("31")) {

							arrivalDay = "01";

							if (departMonth != "12") {

								if (departMonth != "10" && departMonth != "11") {

									arrivalMonth = "0" + (Integer.parseInt(departMonth) + 1);

								} else {

									arrivalMonth = (Integer.parseInt(departMonth) + 1) + "";

								}

							} else {

								arrivalMonth = "01";

							}

							returnArrivalDate.setText(arrivalDay + "/" + arrivalMonth + "/" + departYear);

						} else if (departDay.equals("30") && (departMonth.equals("01") 
								|| departMonth.equals("03") 
								|| departMonth.equals("05") 
								|| departMonth.equals("07")
								|| departMonth.equals("08")
								|| departMonth.equals("10")
								|| departMonth.equals("12"))) {

							arrivalDay = "31";

							returnArrivalDate.setText(arrivalDay + "/" + departMonth + "/" + departYear);

						} else if (departDay.equals("30") && !(departMonth.equals("01") 
								|| departMonth.equals("03") 
								|| departMonth.equals("05") 
								|| departMonth.equals("07")
								|| departMonth.equals("08")
								|| departMonth.equals("10")
								|| departMonth.equals("12"))) {

							arrivalDay = "01";

							if (departMonth != "11") {

								arrivalMonth = "0" + (Integer.parseInt(departMonth) + 1);

							} else {

								arrivalMonth = (Integer.parseInt(departMonth) + 1) + "";

							}

							returnArrivalDate.setText(arrivalDay + "/" + arrivalMonth + "/" + departYear);

						} else if (departDay == "28" && departMonth == "02") {

							arrivalDay = "01";
							arrivalMonth = "03";

							returnArrivalDate.setText(arrivalDay + "/" + arrivalMonth + "/" + departYear);

						} else {

							if (departDay.charAt(0) == '0') {

								arrivalDay = "0" + (Integer.parseInt(departDay) + 1);

							} else {

								arrivalDay = (Integer.parseInt(departDay) + 1) + "";

							}

							returnArrivalDate.setText(arrivalDay + "/" + departMonth + "/" + departYear);

						}

					}

					// Return Departure Airport
					returnDepartAirport.setText(returnFlight[6]);


					// Return Arrival Airport
					returnArrivalAirport.setText(returnFlight[8]);


					// Return Duration
					returnDuration.setText(returnFlight[3] + " hours");


					// Return Distance
					returnDistance.setText(returnFlight[4] + " miles");


					// Delay
					returnDelay.setText(returnFlight[5] + " minutes");
					returnDelay.setBounds(715, 355, 100, 30);

					if (returnFlight[5].length() == 3) {

						returnDelay.setBounds(715, 355, 100, 30);

					} else if (returnFlight[5].length() == 2) {

						returnDelay.setBounds(725, 355, 100, 30);

					} else if (returnFlight[5].length() == 1) {

						returnDelay.setBounds(735, 355, 100, 30);

					}
					
					
					if (e.getSource() == rightArrow) {
						
						if (countFlights == foundFlights.size() - 2) {
							
							rightArrow.setVisible(false);
							
						} else {
							
							rightArrow.setVisible(true);
							
						}
						
						leftArrow.setVisible(true);
						
					}
					
					
					if (e.getSource() == leftArrow) {
						
						if (countFlights == 0) {
							
							leftArrow.setVisible(false);
							
						} else {
							
							leftArrow.setVisible(true);
							
						}
						
						rightArrow.setVisible(true);
						
					}
					
				}
				

			} else if (userFlight.size() == 3) {
				
				// One Way is checked
				
				// Departure Flight
				
				if (countOneWayFlights <= foundFlights.size() - 1) {
					
					if (e.getSource() == rightArrow) {
						
						countOneWayFlights++;
						
					} else if (e.getSource() == leftArrow) {
						
						countOneWayFlights--;
						
					}
					
					String departFlight [] = foundFlights.get(countOneWayFlights).split(",");


					// Airline
					airline.setText(departFlight[11]);


					// Flight ID
					flightID.setText(departFlight[10]);


					// Departure Time
					departTime.setText(departFlight[1]);


					// Arrival Time
					arrivalTime.setText(departFlight[2]);


					// Departure City
					departCity.setText(departFlight[7]);


					// Arrival City
					arrivalCity.setText(departFlight[9]);
					

					// Departure Date
					departDate.setText(departFlight[0]);


					// Arrival Date

					int departHour = Integer.parseInt(departTime.getText().substring(0, 2));
					int departMin = Integer.parseInt(departTime.getText().substring(3, 5));

					int arrivalHour = Integer.parseInt(arrivalTime.getText().substring(0, 2));
					int arrivalMin = Integer.parseInt(arrivalTime.getText().substring(3, 5));

					// Validation of Arrival Date

					if (departHour < arrivalHour || (departHour == arrivalHour && departMin < arrivalMin)) {

						arrivalDate.setText(departDate.getText());

					} else if (departHour > arrivalHour || (departHour == arrivalHour && departMin >= arrivalMin)) {

						String departDay = departDate.getText().substring(0 ,2);
						String departMonth = departDate.getText().substring(3, 5);
						String departYear = departDate.getText().substring(6, 10);

						String arrivalDay;
						String arrivalMonth;

						if (departDay.equals("31")) {

							arrivalDay = "01";

							if (departMonth != "12") {

								if (departMonth != "10" && departMonth != "11") {

									arrivalMonth = "0" + (Integer.parseInt(departMonth) + 1);

								} else {

									arrivalMonth = (Integer.parseInt(departMonth) + 1) + "";

								}

							} else {

								arrivalMonth = "01";

							}

							arrivalDate.setText(arrivalDay + "/" + arrivalMonth + "/" + departYear);

						} else if (departDay.equals("30") && (departMonth.equals("01") 
								|| departMonth.equals("03") 
								|| departMonth.equals("05") 
								|| departMonth.equals("07")
								|| departMonth.equals("08")
								|| departMonth.equals("10")
								|| departMonth.equals("12"))) {

							arrivalDay = "31";

							arrivalDate.setText(arrivalDay + "/" + departMonth + "/" + departYear);

						} else if (departDay.equals("30") && !(departMonth.equals("01") 
								|| departMonth.equals("03") 
								|| departMonth.equals("05") 
								|| departMonth.equals("07")
								|| departMonth.equals("08")
								|| departMonth.equals("10")
								|| departMonth.equals("12"))) {

							arrivalDay = "01";

							if (departMonth != "11") {

								arrivalMonth = "0" + (Integer.parseInt(departMonth) + 1);

							} else {

								arrivalMonth = (Integer.parseInt(departMonth) + 1) + "";

							}

							arrivalDate.setText(arrivalDay + "/" + arrivalMonth + "/" + departYear);

						} else if (departDay == "28" && departMonth == "02") {

							arrivalDay = "01";
							arrivalMonth = "03";

							arrivalDate.setText(arrivalDay + "/" + arrivalMonth + "/" + departYear);

						} else {

							if (departDay.charAt(0) == '0') {

								arrivalDay = "0" + (Integer.parseInt(departDay) + 1);

							} else {

								arrivalDay = (Integer.parseInt(departDay) + 1) + "";

							}

							arrivalDate.setText(arrivalDay + "/" + departMonth + "/" + departYear);

						}

					}


					// Departure Airport
					departAirport.setText(departFlight[6]);


					// Arrival Airport
					arrivalAirport.setText(departFlight[8]);


					// Duration
					duration.setText(departFlight[3] + " hours");


					// Distance
					distance.setText(departFlight[4] + " miles");


					// Delay
					delay.setText(departFlight[5] + " minutes");
					delay.setBounds(715, 290, 100, 30);

					if (departFlight[5].length() == 3) {

						delay.setBounds(715, 290, 100, 30);

					} else if (departFlight[5].length() == 2) {

						delay.setBounds(725, 290, 100, 30);

					} else if (departFlight[5].length() == 1) {

						delay.setBounds(735, 290, 100, 30);

					}
					
					
					if (e.getSource() == rightArrow) {
						
						if (countOneWayFlights == foundFlights.size() - 1) {
							
							rightArrow.setVisible(false);
							
						} else {
							
							rightArrow.setVisible(true);
							
						}
						
						leftArrow.setVisible(true);
						
					}
					
					
					if (e.getSource() == leftArrow) {
						
						if (countOneWayFlights == 0) {
							
							leftArrow.setVisible(false);
							
						} else {
							
							leftArrow.setVisible(true);
							
						}
						
						rightArrow.setVisible(true);
						
					}
					
					
				}
				

			}
			
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	
	// Saving Selected Flight Data
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		ArrayList <String> userSelectedFlight = new ArrayList <String> ();
		
		if (e.getSource() == purchase) {

			String departFlight = departDate.getText() + "," + departTime.getText() + "," + arrivalTime.getText() + ","
					+ duration.getText() + "," + distance.getText() + "," + delay.getText() + "," 
					+ departAirport.getText() + "," + departCity.getText() + "," + arrivalAirport.getText()
					+ arrivalCity.getText() + "," + flightID.getText() + "," + airline.getText();

			userSelectedFlight.add(departFlight);

			
			if (userFlight.size() == 4) {

				String returnFlight = returnDepartDate.getText() + "," + returnDepartTime.getText() + "," + returnArrivalTime.getText() + ","
						+ returnDuration.getText() + "," + returnDistance.getText() + "," + returnDelay.getText() + "," 
						+ returnDepartAirport.getText() + "," + returnDepartCity.getText() + "," + returnArrivalAirport.getText()
						+ returnArrivalCity.getText() + "," + returnFlightID.getText() + "," + returnAirline.getText();

				userSelectedFlight.add(returnFlight);

			}
			
			Booking booking = new Booking(userSelectedFlight);
			
			System.out.println(userSelectedFlight);

		}
		
	}

	
}
