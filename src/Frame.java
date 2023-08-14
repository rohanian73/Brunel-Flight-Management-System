import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;

public class Frame extends JFrame implements MouseListener, KeyListener, ItemListener, ActionListener {
	
	// Labels
	
	JLabel logo;
	JLabel title;
	JLabel shop;
	JLabel restaurant;
	JLabel finances;
	JLabel from;
	JLabel to;
	JLabel departDate;
	JLabel returnDate;
	JLabel logo_transcript;
	
	
	// ComboBoxes
	
	JComboBox departCity;
	JComboBox arrivalCity;
	JComboBox departDay;
	JComboBox departMonth;
	JComboBox departYear;
	JComboBox returnDay;
	JComboBox returnMonth;
	JComboBox returnYear;
	
	
	// ArrayLists
	
	ArrayList <String> departCities;
	ArrayList <String> arrivalCities;
	ArrayList <Integer> days;
	ArrayList <String> months;
	ArrayList <Integer> years;
	ArrayList <String> userFlight;
	ArrayList <String> foundFlights;
	
	
	// Colors
	
	Color hoverColor;
	Color btnColor;
	
	
	// CheckBox
	
	JCheckBox oneWay;
	
	
	// Button
	
	JButton searchBtn;
	
	
	// Panel
	
	JPanel underscore;
	
	
	// Flights (Class)
	
	Flights flights;
	
	
	public Frame() throws FontFormatException, IOException {
		
		setLayout(null);
		
		// Logo
		
		ImageIcon logoImage = new ImageIcon("brunel-logo.png");
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Lobster-Regular.ttf")));
		
		logo = new JLabel();
		logo.setIcon(logoImage);
		logo.setText("BFMS");
		
		logo.setFont(new Font("Lobster", Font.PLAIN, 60));
		logo.setForeground(Color.WHITE);
		logo.setIconTextGap(30);
		logo.setBounds(50, 0, 350, 150);
		
		add(logo);
		
		
		// Navigation
		
		hoverColor = new Color(33, 235, 255);
		
		underscore = new JPanel();
		underscore.setBackground(hoverColor);
		underscore.setVisible(false);
		
		add(underscore);
		
		// Shop
		shop = new JLabel("Shop");
		shop.setFont(new Font("Open Sans", Font.BOLD, 24));
		shop.setForeground(Color.WHITE);
		shop.setBounds(700, 50, 70, 50);
		
		shop.addMouseListener((MouseListener) this);
		
		add(shop);
		
		// Restaurant
		restaurant = new JLabel("Restaurant");
		restaurant.setFont(new Font("Open Sans", Font.BOLD, 24));
		restaurant.setForeground(Color.WHITE);
		restaurant.setBounds(820, 50, 140, 50);
		
		restaurant.addMouseListener((MouseListener) this);
		
		add(restaurant);
		
		// Finances
		finances = new JLabel("Finances");
		finances.setFont(new Font("Open Sans", Font.BOLD, 24));
		finances.setForeground(Color.WHITE);
		finances.setBounds(1010, 50, 110, 50);
		
		finances.addMouseListener((MouseListener) this);
		
		add(finances);
		
		
		// Entering cities
		
		// Getting Flights from Flights Class
		
		flights = new Flights();
		ArrayList <String> importedFlights = flights.getFlights();
		
		// From (Label)
		
		from = new JLabel("From");
		from.setFont(new Font("Open Sans", Font.BOLD, 16));
		from.setForeground(Color.WHITE);
		from.setBounds(230, 200, 50, 20);
		
		add(from);
		
		
		// Departure City (ComboBox)
		
		departCities = flights.getDepartCities(importedFlights);
		Collections.sort(departCities);
		
		departCity = new JComboBox();
		departCity.setFont(new Font("Open Sans", Font.BOLD, 16));
		departCity.setBackground(Color.WHITE);
		
		departCity.setEditable(true);
		((JLabel) departCity.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		departCity.setBounds(230, 230, 250, 40);
		
		DefaultComboBoxModel cbModel_dc = new DefaultComboBoxModel();
		cbModel_dc.addAll(departCities);
		departCity.setModel(cbModel_dc);
		
		departCity.getEditor().getEditorComponent().addKeyListener(this);
		
		add(departCity);
		
		
		// To (Label)
		
		to = new JLabel("To");
		to.setFont(new Font("Open Sans", Font.BOLD, 16));
		to.setForeground(Color.WHITE);
		to.setBounds(700, 200, 30, 20);
		
		add(to);
		
		
		// Arrival City (ComboBox)
		
		arrivalCities = flights.getArrivalCities(importedFlights);
		Collections.sort(arrivalCities);
		
		arrivalCity = new JComboBox();
		arrivalCity.setFont(new Font("Open Sans", Font.BOLD, 16));
		arrivalCity.setBackground(Color.WHITE);
		
		arrivalCity.setEditable(true);
		((JLabel) arrivalCity.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		arrivalCity.setBounds(700, 230, 250, 40);
		
		DefaultComboBoxModel cbModel_ac = new DefaultComboBoxModel();
		cbModel_ac.addAll(arrivalCities);
		arrivalCity.setModel(cbModel_ac);
		
		arrivalCity.getEditor().getEditorComponent().addKeyListener(this);
		
		add(arrivalCity);
		
		
		// Preparing Information about Dates (days, months, years)
		
		// Days
		Integer daysArr [] = new Integer [31];
		
		int startDay = 1;
		
		for (int i = 0; i < daysArr.length; i++) {
			
			daysArr[i] = startDay;
			startDay++;
			
		}
		
		days = new ArrayList <Integer> ();
		Collections.addAll(days, daysArr);
		
		
		// Months
		String monthsArr [] = new String [12];
		
		monthsArr[0] = "January";
		monthsArr[1] = "February";
		monthsArr[2] = "March";
		monthsArr[3] = "April";
		monthsArr[4] = "May";
		monthsArr[5] = "June";
		monthsArr[6] = "July";
		monthsArr[7] = "August";
		monthsArr[8] = "September";
		monthsArr[9] = "October";
		monthsArr[10] = "November";
		monthsArr[11] = "December";
		
		months = new ArrayList <String> ();
		Collections.addAll(months, monthsArr); 
		
		// Years
		Integer yearsArr [] = {2022, 2023};
		
		years = new ArrayList <Integer> ();
		Collections.addAll(years, yearsArr);
		
		
		// Entering dates
		
		// Departure Date (Label)
		
		departDate = new JLabel("Departure");
		departDate.setFont(new Font("Open Sans", Font.BOLD, 16));
		departDate.setForeground(Color.WHITE);
		departDate.setBounds(230, 320, 90, 20);
		
		add(departDate);
		
		
		// Departure Day (ComboBox)
		
		departDay = new JComboBox();
		departDay.setFont(new Font("Open Sans", Font.BOLD, 14));
		departDay.setBackground(Color.WHITE);
		
		departDay.setEditable(true);
		((JLabel) departDay.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		departDay.setBounds(230, 350, 50, 40);
		
		DefaultComboBoxModel cbModel_dd = new DefaultComboBoxModel();
		cbModel_dd.addAll(days);
		departDay.setModel(cbModel_dd);
		
		departDay.getEditor().getEditorComponent().addKeyListener(this);
		
		add(departDay);
		
		// Departure Month (ComboBox)
		
		departMonth = new JComboBox();
		departMonth.setFont(new Font("Open Sans", Font.BOLD, 14));
		departMonth.setBackground(Color.WHITE);
		
		departMonth.setEditable(true);
		((JLabel) departMonth.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		departMonth.setBounds(285, 350, 120, 40);
		
		DefaultComboBoxModel cbModel_dm = new DefaultComboBoxModel();
		cbModel_dm.addAll(months);
		departMonth.setModel(cbModel_dm);
		
		departMonth.getEditor().getEditorComponent().addKeyListener(this);
		
		add(departMonth);
		
		
		// Departure Year (ComboBox)
		
		departYear = new JComboBox();
		departYear.setFont(new Font("Open Sans", Font.BOLD, 14));
		departYear.setBackground(Color.WHITE);
		
		departYear.setEditable(true);
		((JLabel) departYear.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		departYear.setBounds(410, 350, 70, 40);
		
		DefaultComboBoxModel cbModel_dy = new DefaultComboBoxModel();
		cbModel_dy.addAll(years);
		departYear.setModel(cbModel_dy);
		
		departYear.getEditor().getEditorComponent().addKeyListener(this);

		add(departYear);
		
		
		// Return Date (Label)
		
		returnDate = new JLabel("Return");
		returnDate.setFont(new Font("Open Sans", Font.BOLD, 16));
		returnDate.setForeground(Color.WHITE);
		returnDate.setBounds(700, 320, 90, 20);
		
		add(returnDate);
		
		
		// Return Day (ComboBox)
		
		returnDay = new JComboBox();
		returnDay.setFont(new Font("Open Sans", Font.BOLD, 14));
		returnDay.setBackground(Color.WHITE);
		
		returnDay.setEditable(true);
		((JLabel) returnDay.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		returnDay.setBounds(700, 350, 50, 40);
		
		DefaultComboBoxModel cbModel_rd = new DefaultComboBoxModel();
		cbModel_rd.addAll(days);
		returnDay.setModel(cbModel_rd);
		
		returnDay.getEditor().getEditorComponent().addKeyListener(this);
		
		add(returnDay);
		
		
		// Return Month (ComboBox)
		
		returnMonth = new JComboBox();
		returnMonth.setFont(new Font("Open Sans", Font.BOLD, 14));
		returnMonth.setBackground(Color.WHITE);
		
		returnMonth.setEditable(true);
		((JLabel) returnMonth.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		returnMonth.setBounds(755, 350, 120, 40);
		
		DefaultComboBoxModel cbModel_rm = new DefaultComboBoxModel();
		cbModel_rm.addAll(months);
		returnMonth.setModel(cbModel_rm);
		
		returnMonth.getEditor().getEditorComponent().addKeyListener(this);
		
		add(returnMonth);
		
		
		// Return Year (ComboBox)
		
		returnYear = new JComboBox();
		returnYear.setFont(new Font("Open Sans", Font.BOLD, 14));
		returnYear.setBackground(Color.WHITE);
		
		returnYear.setEditable(true);
		((JLabel) returnYear.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		returnYear.setBounds(880, 350, 70, 40);
		
		DefaultComboBoxModel cbModel_ry = new DefaultComboBoxModel();
		cbModel_ry.addAll(years);
		returnYear.setModel(cbModel_ry);
		
		returnYear.getEditor().getEditorComponent().addKeyListener(this);
		
		add(returnYear);
		
		
		// One Way (CheckBox)
		
		ImageIcon rect = new ImageIcon("Ellipse 1.png");
		ImageIcon selected = new ImageIcon("Group 9.png");
		
		oneWay = new JCheckBox();
		oneWay.setText("One way");
		oneWay.setFont(new Font("Open Sans", Font.BOLD, 14));
		oneWay.setForeground(Color.WHITE);
		
		oneWay.setOpaque(false);
		oneWay.setFocusable(false);
		
		oneWay.setIcon(rect);
		oneWay.setSelectedIcon(selected);
		oneWay.setIconTextGap(10);
		oneWay.setBounds(230, 430, 100, 20);
		
		oneWay.addMouseListener(this);
		oneWay.addItemListener(this);
		
		add(oneWay);
		
		
		// Search (Button)
		
		searchBtn = new JButton();
		searchBtn.setText("Search");
		searchBtn.setFont(new Font("Open Sans", Font.BOLD, 22));
		searchBtn.setForeground(Color.WHITE);
		
		searchBtn.setFocusable(false);
		searchBtn.setBorder(BorderFactory.createEmptyBorder());
		
		btnColor = new Color(255, 121, 121);
		searchBtn.setBackground(btnColor);
		searchBtn.setBounds(515, 510, 150, 50);
		
		searchBtn.addMouseListener(this);
		searchBtn.addActionListener(this);
		
		add(searchBtn);
		
		
		// Logo Transcript (Label)
		
		logo_transcript = new JLabel("Brunel Flight Management System");
		logo_transcript.setFont(new Font("Open Sans", Font.BOLD, 12));
		logo_transcript.setForeground(Color.WHITE);
		logo_transcript.setBounds(490, 625, 200, 30);
		
		add(logo_transcript);
		
	}
	
	
	public static void main(String[] args) throws FontFormatException, IOException {
		
		JFrame Frame = new Frame();
		Frame.setTitle("Brunel Flight Management System");
		Frame.setVisible(true);
		Frame.setLocation(180, 50);
		Frame.setSize(1200, 700);
		Frame.setResizable(false);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Color bgcolor = new Color(80, 107, 201);
		Frame.getContentPane().setBackground(bgcolor);
		
		ImageIcon image = new ImageIcon("brunel-logo.png");
		Frame.setIconImage(image.getImage());

	}
	
	
	// Hover Effect
	
	@Override
	public void mouseEntered(MouseEvent e) {
		
		if (e.getSource() == shop) {
			
			shop.setForeground(hoverColor);
			shop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			underscore.setBounds(700, 95, 60, 5);
			underscore.setVisible(true);
			
		}
		
		if (e.getSource() == restaurant) {
			
			restaurant.setForeground(hoverColor);
			restaurant.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			underscore.setBounds(820, 95, 130, 5);
			underscore.setVisible(true);
			
		}
		
		if (e.getSource() == finances) {
			
			finances.setForeground(hoverColor);
			finances.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			underscore.setBounds(1010, 95, 105, 5);
			underscore.setVisible(true);
			
		}
		
		if (e.getSource() == oneWay) {
			
			oneWay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
		}
		
		if (e.getSource() == searchBtn) {
			
			searchBtn.setBackground(hoverColor);
			searchBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
		}
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		
		if (e.getSource() == shop) {
			
			shop.setForeground(Color.WHITE);
			underscore.setVisible(false);
			
		}
		
		if (e.getSource() == restaurant) {
			
			restaurant.setForeground(Color.WHITE);
			underscore.setVisible(false);
			
		}
		
		if (e.getSource() == finances) {
			
			finances.setForeground(Color.WHITE);
			underscore.setVisible(false);
			
		}
		
		if (e.getSource() == searchBtn) {
			
			searchBtn.setBackground(btnColor);
			
		}
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
	
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		
	}


	
	// Auto Search for ComboBoxes
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		// Cities
		
		if (e.getSource() == departCity.getEditor().getEditorComponent() 
				|| e.getSource() == arrivalCity.getEditor().getEditorComponent()) {
			
			JTextComponent editor = ((JTextComponent) ((JComboBox) ((Component) e.getSource()).getParent()).getEditor().getEditorComponent());
			String userRemainder = editor.getText();
			
			String userKey = (e.getKeyChar() + "").toUpperCase();
			ArrayList <String> userCities = new ArrayList <String> ();
			
			String userText = "";
			
			if (userRemainder.length() == 0) {
				
				userText = userKey;
				
				if (userText.contains("")) {
					
					userText = "";
					
				}
				
			} else {
				
				userKey = userKey.toLowerCase();
				
				String l1 = (userRemainder.charAt(0) + "").toUpperCase();
				userRemainder = l1 + userRemainder.substring(1, userRemainder.length());
				
				userText = userRemainder + userKey;
				
				if (userText.contains("")) {
					
					userText = userRemainder;
					
				}
				
			}
			
				
			for (int i = 0; i < departCities.size(); i++) {
				
				String city = departCities.get(i).toString();
				
				if (userText.length() == 1) {
					
					if (userText.charAt(0) == city.charAt(0)) {
						
						userCities.add(city);
						
					}
					
				} else if (userText.length() > 1) {
					
					if (userText.length() <= city.length()) {
						
						int count = 0;

						for (int j = 0; j < userText.length(); j++) {

							if (userText.charAt(j) == city.charAt(j)) {

								count++;

								if (count == userText.length()) {

									userCities.add(city);

								}

							}

						}

					}
					
				}
				
				if (i == departCities.size() - 1) {
					
					DefaultComboBoxModel cbModel_test = new DefaultComboBoxModel();
					cbModel_test.addAll(userCities);
					
					if (e.getSource() == departCity.getEditor().getEditorComponent()) {
						
						departCity.setModel(cbModel_test);
						departCity.showPopup();
						departCity.setMaximumRowCount(userCities.size());
						
					} else if (e.getSource() == arrivalCity.getEditor().getEditorComponent()) {
						
						arrivalCity.setModel(cbModel_test);
						arrivalCity.showPopup();
						arrivalCity.setMaximumRowCount(userCities.size());
						
					}

					
					editor.setText(userRemainder);
					
					
				}
					
			}
			
			if (userCities.size() == 0) {
				
				DefaultComboBoxModel cbModel_test = new DefaultComboBoxModel();
				
				if (e.getSource() == departCity.getEditor().getEditorComponent()) {
					
					departCity.setModel(cbModel_test);
					departCity.showPopup();
					
				} else if (e.getSource() == arrivalCity.getEditor().getEditorComponent()) {
					
					arrivalCity.setModel(cbModel_test);
					arrivalCity.showPopup();
					
				}
				
				editor.setText(userRemainder);
				
				if (userText.length() == 0) {
					
					cbModel_test.addAll(departCities);
					
					if (e.getSource() == departCity.getEditor().getEditorComponent()) {
						
						departCity.setMaximumRowCount(8);
						
					} else if (e.getSource() == arrivalCity.getEditor().getEditorComponent()) {
						
						arrivalCity.setMaximumRowCount(8);
						
					}
					
				}
				
			}
			
		}
		
		
		
		// Days
		
		if (e.getSource() == departDay.getEditor().getEditorComponent()
				|| e.getSource() == returnDay.getEditor().getEditorComponent()) {
			
			JTextComponent editor = ((JTextComponent) ((JComboBox) ((Component) e.getSource()).getParent()).getEditor().getEditorComponent());
			String userRemainder = editor.getText();

			String userKey = (e.getKeyChar() + "");
			ArrayList <String> userDays = new ArrayList <String> ();

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
			
			for (int i = 0; i < days.size(); i++) {
				
				String day = days.get(i).toString();
				
				if (userNum.length() == 1) {
					
					if (userNum.charAt(0) == day.charAt(0)) {
						
						userDays.add(day);
						
					}
					
				} else if (userNum.length() > 1) {
					
					if (userNum.length() == day.length()) {
						
						int count = 0;
						
						for (int j = 0; j < userNum.length(); j++) {
							
							if (userNum.charAt(j) == day.charAt(j)) {
								
								count++;
								
								if (count == userNum.length()) {
									
									userDays.add(day);
									
								}
								
							}
							
						}
						
					}
					
				}
				
				
				if (i == days.size() - 1) {
					
					DefaultComboBoxModel cbModel_test = new DefaultComboBoxModel();
					cbModel_test.addAll(userDays);
					
					if (e.getSource() == departDay.getEditor().getEditorComponent()) {
						
						departDay.setModel(cbModel_test);
						departDay.showPopup();
						departDay.setMaximumRowCount(userDays.size());
						
					} else if (e.getSource() == returnDay.getEditor().getEditorComponent()) {
						
						returnDay.setModel(cbModel_test);
						returnDay.showPopup();
						returnDay.setMaximumRowCount(userDays.size());
						
					}
					
					editor.setText(userRemainder);
					
				}
				
				
			}
			
			
			if (userDays.size() == 0) {
				
				DefaultComboBoxModel cbModel_test = new DefaultComboBoxModel();
				
				if (e.getSource() == departDay.getEditor().getEditorComponent()) {
					
					departDay.setModel(cbModel_test);
					departDay.showPopup();
					
				} else if (e.getSource() == returnDay.getEditor().getEditorComponent()) {
					
					returnDay.setModel(cbModel_test);
					returnDay.showPopup();
					
				}
				
				editor.setText(userRemainder);
				
				if (userNum.length() == 0) {
					
					cbModel_test.addAll(days);
					
					if (e.getSource() == departDay.getEditor().getEditorComponent()) {
						
						departDay.setMaximumRowCount(8);
						
					} else if (e.getSource() == returnDay.getEditor().getEditorComponent()) {
						
						returnDay.setMaximumRowCount(8);
						
					}
					
				}
				
			}
			
		}
		
		
		
		// Months
		
		if (e.getSource() == departMonth.getEditor().getEditorComponent()
				|| e.getSource() == returnMonth.getEditor().getEditorComponent()) {
			
			JTextComponent editor = ((JTextComponent) ((JComboBox) ((Component) e.getSource()).getParent()).getEditor().getEditorComponent());
			String userRemainder = editor.getText();
			
			String userKey = (e.getKeyChar() + "").toUpperCase();
			ArrayList <String> userMonths = new ArrayList <String> ();
			
			String userText = "";
			
			if (userRemainder.length() == 0) {
				
				userText = userKey;
				
				if (userText.contains("")) {
					
					userText = "";
					
				}
				
			} else {
					
				userKey = userKey.toLowerCase();
				
				String l1 = (userRemainder.charAt(0) + "").toUpperCase();
				userRemainder = l1 + userRemainder.substring(1, userRemainder.length());
				
				userText = userRemainder + userKey;
				
				if (userText.contains("")) {
					
					userText = userRemainder;
					
				}
				
			}
			
			for (int i = 0; i < months.size(); i++) {
				
				String month = months.get(i).toString();
				
				if (userText.length() == 1) {
					
					if (userText.charAt(0) == month.charAt(0)) {
						
						userMonths.add(month);
						
					}
					
				} else if (userText.length() > 1) {
					
					if (userText.length() <= month.length()) {
						
						int count = 0;
						
						for (int j = 0; j < userText.length(); j++) {
							
							if (userText.charAt(j) == month.charAt(j)) {
								
								count++;
								
								if (count == userText.length()) {
									
									userMonths.add(month);
									
								}
								
							}
							
						}
						
					}
					
				}
				
				if (i == months.size() - 1) {
					
					DefaultComboBoxModel cbModel_test = new DefaultComboBoxModel();
					cbModel_test.addAll(userMonths);
					
					if (e.getSource() == departMonth.getEditor().getEditorComponent()) {
						
						departMonth.setModel(cbModel_test);
						departMonth.showPopup();
						departMonth.setMaximumRowCount(userMonths.size());
						
					} else if (e.getSource() == returnMonth.getEditor().getEditorComponent()) {
						
						returnMonth.setModel(cbModel_test);
						returnMonth.showPopup();
						returnMonth.setMaximumRowCount(userMonths.size());
						
					}
					
					editor.setText(userRemainder);
					
					
				}
					
			}
			
			if (userMonths.size() == 0) {
				
				DefaultComboBoxModel cbModel_test = new DefaultComboBoxModel();
				
				if (e.getSource() == departMonth.getEditor().getEditorComponent()) {
					
					departMonth.setModel(cbModel_test);
					departMonth.showPopup();
					
				} else if (e.getSource() == returnMonth.getEditor().getEditorComponent()) {
					
					returnMonth.setModel(cbModel_test);
					returnMonth.showPopup();
					
				}
				
				editor.setText(userRemainder);
				
				if (userText.length() == 0) {
					
					cbModel_test.addAll(months);
					
					if (e.getSource() == departMonth.getEditor().getEditorComponent()) {
						
						departMonth.setMaximumRowCount(8);
						
					} else if (e.getSource() == returnMonth.getEditor().getEditorComponent()) {
						
						returnMonth.setMaximumRowCount(8);
						
					}
					
				}
				
			}
			
		}
		
		
		
		// Years
		
		if (e.getSource() == departYear.getEditor().getEditorComponent()
				|| e.getSource() == returnYear.getEditor().getEditorComponent()) {
			
			JTextComponent editor = ((JTextComponent) ((JComboBox) ((Component) e.getSource()).getParent()).getEditor().getEditorComponent());
			String userRemainder = editor.getText();

			String userKey = (e.getKeyChar() + "");
			ArrayList <String> userYears = new ArrayList <String> ();

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
			
			for (int i = 0; i < years.size(); i++) {
				
				String year = years.get(i).toString();
				
				if (userNum.length() == 1) {
					
					if (userNum.charAt(0) == year.charAt(0)) {
						
						userYears.add(year);
						
					}
					
				} else if (userNum.length() > 1) {
					
					if (userNum.length() <= year.length()) {

						int count = 0;
						
						for (int j = 0; j < userNum.length(); j++) {

							if (userNum.charAt(j) == year.charAt(j)) {

								count++;

								if (count == userNum.length()) {

									userYears.add(year);

								}

							}

						}
						
					}

				}
				
				
				if (i == years.size() - 1) {
					
					DefaultComboBoxModel cbModel_test = new DefaultComboBoxModel();
					cbModel_test.addAll(userYears);
					
					if (e.getSource() == departYear.getEditor().getEditorComponent()) {
						
						departYear.setModel(cbModel_test);
						departYear.showPopup();
						departYear.setMaximumRowCount(userYears.size());
						
					} else if (e.getSource() == returnYear.getEditor().getEditorComponent()) {
						
						returnYear.setModel(cbModel_test);
						returnYear.showPopup();
						returnYear.setMaximumRowCount(userYears.size());
						
					}
					
					editor.setText(userRemainder);
					
				}
				
				
			}
			
			
			if (userYears.size() == 0) {
				
				DefaultComboBoxModel cbModel_test = new DefaultComboBoxModel();
				
				if (e.getSource() == departYear.getEditor().getEditorComponent()) {
					
					departYear.setModel(cbModel_test);
					departYear.showPopup();
					
				} else if (e.getSource() == returnYear.getEditor().getEditorComponent()) {
					
					returnYear.setModel(cbModel_test);
					returnYear.showPopup();
					
				}
				
				editor.setText(userRemainder);
				
				if (userNum.length() == 0) {
					
					cbModel_test.addAll(years);
					
					if (e.getSource() == departYear.getEditor().getEditorComponent()) {
						
						departYear.setMaximumRowCount(8);
						
					} else if (e.getSource() == returnYear.getEditor().getEditorComponent()) {
						
						returnYear.setMaximumRowCount(8);
						
					}
					
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


	
	// Disabling Return Date (when One Way is checked)
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if (e.getSource() == oneWay) {
			
			if (e.getStateChange() == ItemEvent.SELECTED) {
				
				Color inabledColor = new Color(200, 200, 200);
				
				returnDate.setForeground(inabledColor);
				
				returnDay.setEnabled(false);
				returnDay.getEditor().getEditorComponent().setBackground(inabledColor);
				
				returnMonth.setEnabled(false);
				returnMonth.getEditor().getEditorComponent().setBackground(inabledColor);
				
				returnYear.setEnabled(false);
				returnYear.getEditor().getEditorComponent().setBackground(inabledColor);
				
			} else if (e.getStateChange() == ItemEvent.DESELECTED) {
				
				returnDate.setForeground(Color.WHITE);
				
				returnDay.setEnabled(true);
				returnDay.getEditor().getEditorComponent().setBackground(Color.WHITE);
				
				returnMonth.setEnabled(true);
				returnMonth.getEditor().getEditorComponent().setBackground(Color.WHITE);
				
				returnYear.setEnabled(true);
				returnYear.getEditor().getEditorComponent().setBackground(Color.WHITE);
				
			}
			
		}
		
	}


	// User Data Verification
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == searchBtn) {
			
			userFlight = new ArrayList <String> ();

			String userDepartCity = ((JTextField) departCity.getEditor().getEditorComponent()).getText();
			String userArrivalCity = ((JTextField) arrivalCity.getEditor().getEditorComponent()).getText();
			
			boolean departDateValidity = false;
			boolean returnDateValidity = false;
			
			// Checking Departure City
			
			if (userDepartCity.length() != 0 && userDepartCity.matches("[a-zA-Z ]+")) {
				
				for (int i = 0; i < departCities.size(); i++) {
					
					String dbDepartCity = departCities.get(i).toString();
					
					if (userDepartCity.equals(dbDepartCity)) {
										
						userFlight.add(userDepartCity);
						break;
						
					}
					
				}
				
				
				if (userFlight.size() != 1) {
					
					JOptionPane.showMessageDialog(title, "There is no such departure city in the Database. "
							+ "Please, try another one.");
					
				}
				
				
			} else {
				
				if (userDepartCity.length() == 0) {
					
					JOptionPane.showMessageDialog(title, "Please, enter a departure city.");
					
				} else if (!userDepartCity.matches("[a-zA-Z ]+")) {
					
					JOptionPane.showMessageDialog(title, "Please, do not use numbers and special characters "
							+ "when writing a departure city.");
					
				}	
				
			}
			
			
			// Checking Arrival City
			
			if (userFlight.size() == 1) {
				
				if (userArrivalCity.length() != 0 && userArrivalCity.matches("[a-zA-Z ]+")) {
					
					for (int i = 0; i < arrivalCities.size(); i++) {
						
						String dbArrivalCity = arrivalCities.get(i).toString();
						
						if (userArrivalCity.equals(dbArrivalCity)) {
											
							userFlight.add(userArrivalCity);
							break;
							
						}
							
					}
					
					
					if (userFlight.size() != 2) {
						
						JOptionPane.showMessageDialog(title, "There is no such arrival city in the Database. "
								+ "Please, try another one.");
						
					}
					
				} else {
					
					if (userArrivalCity.length() == 0) {
						
						JOptionPane.showMessageDialog(title, "Please, enter an arrival city.");
						
					} else if (!userArrivalCity.matches("[a-zA-Z ]+")) {
						
						JOptionPane.showMessageDialog(title, "Please, do not use numbers and special characters "
								+ "when writing an arrival city.");
						
					}	
					
				}
				
			}
			
			
			// Checking Departure Date
			
			if (userFlight.size() == 2 && !userFlight.get(0).equals(userFlight.get(1))) {
				
				String userDepartDay = ((JTextField) departDay.getEditor().getEditorComponent()).getText();
				String userDepartMonth = ((JTextField) departMonth.getEditor().getEditorComponent()).getText();
				String userDepartYear = ((JTextField) departYear.getEditor().getEditorComponent()).getText();
				
				if (userDepartDay.length() != 0
						&& userDepartMonth.length() != 0
						&& userDepartYear.length() != 0
						&& userDepartDay.matches("[0-9]+")
						&& userDepartMonth.matches("[a-zA-Z]+")
						&& userDepartYear.matches("[0-9]+")) {
					
					
					for (int i = 0; i < days.size(); i++) {
						
						if (userDepartDay.equals(days.get(i).toString())) {
							
							departDateValidity = true;
							break;
							
						}
						
					}
					
					
					int monthCount = 0;
					
					for (int i = 0; i < months.size(); i++) {
						
						if (userDepartMonth.equals(months.get(i))) {
							
							monthCount = 1;
							
						}
						
						if (i == months.size() - 1) {
							
							if (monthCount == 1 && departDateValidity == true) {
								
								departDateValidity = true;
								
							} else {
								
								departDateValidity = false;
								
							}
							
						}
						
					}
					
					
					int yearCount = 0;
					
					for (int i = 0; i < years.size(); i++) {
						
						if (userDepartYear.equals(years.get(i).toString())) {
							
							yearCount = 1;
							
						}
						
						if (i == years.size() - 1) {
							
							if (yearCount == 1 && departDateValidity == true) {
								
								departDateValidity = true;
								
							} else {
								
								departDateValidity = false;
								
							}
							
						}
						
					}
					
					
					if (departDateValidity == true) {
						
						if (userDepartDay.length() == 1) {
							
							userDepartDay = "0" + userDepartDay;
							
						}
						
						switch (userDepartMonth) {
						
						case "January": userDepartMonth = "01";
										break;
										
						case "February": userDepartMonth = "02";
										 break;
										
						case "March": userDepartMonth = "03";
									  break;
						
						case "April": userDepartMonth = "04";
									  break;
						
						case "May": userDepartMonth = "05";
									break;
						
						case "June": userDepartMonth = "06";
									 break;
						
						case "July": userDepartMonth = "07";
									 break;
						
						case "August": userDepartMonth = "08";
									   break;
						
						case "September": userDepartMonth = "09";
										  break;
						
						case "October": userDepartMonth = "10";
										break;
						
						case "November": userDepartMonth = "11";
										 break;
		
						case "December": userDepartMonth = "12";
										 break;
										 
						default: userDepartMonth = "-1";
								 break;
						
						}
						
						
						String currentDate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
						String currentDateArr [] = currentDate.split("/");
						
						if (Integer.parseInt(userDepartYear) == Integer.parseInt(currentDateArr[2])) {
							
							if (Integer.parseInt(userDepartMonth) < Integer.parseInt(currentDateArr[1])) {
								
								departDateValidity = false;
								
							} else if (Integer.parseInt(userDepartMonth) == Integer.parseInt(currentDateArr[1])) {
								
								if (Integer.parseInt(userDepartDay) < Integer.parseInt(currentDateArr[0])) {
									
									departDateValidity = false;
									
								}
								
							}
							
						} else if (Integer.parseInt(userDepartYear) < Integer.parseInt(currentDateArr[2])) {
							
							departDateValidity = false;
							
						}
						
						
						if (departDateValidity == true) {
							
							String userDepartDate = userDepartDay + "/" + userDepartMonth + "/" + userDepartYear;
							userFlight.add(userDepartDate);
							
						} else {
							
							JOptionPane.showMessageDialog(title, "Please, enter a departure date that "
									+ "has not passed yet.");
							
						}
						
					} else {
						
						JOptionPane.showMessageDialog(title, "There is no such departure date in the Database. "
								+ "Please, try another one.");
						
					}
					
					
				} else {
					
					if (userDepartDay.length() == 0
							|| userDepartMonth.length() == 0
							|| userDepartYear.length() == 0) {
						
						JOptionPane.showMessageDialog(title, "Please, enter a whole departure date.");
						
					} else if (!userDepartDay.matches("[0-9]+")
						|| !userDepartMonth.matches("[a-zA-Z]+")
						|| !userDepartYear.matches("[0-9]+")) {
						
						JOptionPane.showMessageDialog(title, "Please, use letters when entering months, and " 
								+ "use numbers when entering days and years.");
						
					}
					
				}
				
			} else {
				
				if (userFlight.get(0).equals(userFlight.get(1))) {
					
					JOptionPane.showMessageDialog(title, "Please, do not enter identical cities.");
					
				}
				
			}
			
			
			// Checking Return Date (If One Way is unchecked)
			
			if (returnDate.getForeground() == Color.WHITE && departDateValidity == true) {
				
				String userReturnDay = ((JTextField) returnDay.getEditor().getEditorComponent()).getText();
				String userReturnMonth = ((JTextField) returnMonth.getEditor().getEditorComponent()).getText();
				String userReturnYear = ((JTextField) returnYear.getEditor().getEditorComponent()).getText();
				
				if (userReturnDay.length() != 0
						&& userReturnMonth.length() != 0
						&& userReturnYear.length() != 0
						&& userReturnDay.matches("[0-9]+")
						&& userReturnMonth.matches("[a-zA-Z]+")
						&& userReturnYear.matches("[0-9]+")) {
					
					
					for (int i = 0; i < days.size(); i++) {
						
						if (userReturnDay.equals(days.get(i).toString())) {
							
							returnDateValidity = true;
							break;
							
						}
						
					}
					
					
					int monthCount = 0;
					
					for (int i = 0; i < months.size(); i++) {
						
						if (userReturnMonth.equals(months.get(i))) {
							
							monthCount = 1;
							
						}
						
						if (i == months.size() - 1) {
							
							if (monthCount == 1 && returnDateValidity == true) {
								
								returnDateValidity = true;
								
							} else {
								
								returnDateValidity = false;
								
							}
							
						}
						
					}
					
					
					int yearCount = 0;
					
					for (int i = 0; i < years.size(); i++) {
						
						if (userReturnYear.equals(years.get(i).toString())) {
							
							yearCount = 1;
							
						}
						
						if (i == years.size() - 1) {
							
							if (yearCount == 1 && returnDateValidity == true) {
								
								returnDateValidity = true;
								
							} else {
								
								returnDateValidity = false;
								
							}
							
						}
						
					}
					
					
					if (returnDateValidity == true) {
						
						if (userReturnDay.length() == 1) {
							
							userReturnDay = "0" + userReturnDay;

						}
						
						switch (userReturnMonth) {
						
						case "January": userReturnMonth = "01";
										break;
										
						case "February": userReturnMonth = "02";
										 break;
										
						case "March": userReturnMonth = "03";
									  break;
						
						case "April": userReturnMonth = "04";
									  break;
						
						case "May": userReturnMonth = "05";
									break;
						
						case "June": userReturnMonth = "06";
									 break;
						
						case "July": userReturnMonth = "07";
									 break;
						
						case "August": userReturnMonth = "08";
									   break;
						
						case "September": userReturnMonth = "09";
										  break;
						
						case "October": userReturnMonth = "10";
										break;
						
						case "November": userReturnMonth = "11";
										 break;
		
						case "December": userReturnMonth = "12";
										 break;
										 
						default: userReturnMonth = "-1";
								 break;
						
						}
						
						
						String currentDate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
						String currentDateArr [] = currentDate.split("/");
						
						if (Integer.parseInt(userReturnYear) == Integer.parseInt(currentDateArr[2])) {
							
							if (Integer.parseInt(userReturnMonth) < Integer.parseInt(currentDateArr[1])) {
								
								returnDateValidity = false;
								
							} else if (Integer.parseInt(userReturnMonth) == Integer.parseInt(currentDateArr[1])) {
								
								if (Integer.parseInt(userReturnDay) < Integer.parseInt(currentDateArr[0])) {
									
									returnDateValidity = false;
									
								}
								
							}
							
						} else if (Integer.parseInt(userReturnYear) < Integer.parseInt(currentDateArr[2])) {
							
							returnDateValidity = false;
							
						}
						
						
						if (returnDateValidity == true) {
							
							String userDepartDateArr [] = userFlight.get(2).split("/");
							
							if (Integer.parseInt(userDepartDateArr[2]) == Integer.parseInt(userReturnYear)) {
								
								if (Integer.parseInt(userDepartDateArr[1]) > Integer.parseInt(userReturnMonth)) {
									
									returnDateValidity = false;
									
								} else if (Integer.parseInt(userDepartDateArr[1]) == Integer.parseInt(userReturnMonth)) {
									
									if (Integer.parseInt(userDepartDateArr[0]) > Integer.parseInt(userReturnDay)) {
										
										returnDateValidity = false;
										
									}
									
								}
								
							} else if (Integer.parseInt(userDepartDateArr[2]) > Integer.parseInt(userReturnYear)) {
								
								returnDateValidity = false;
								
							}
							
							
							if (returnDateValidity == true) {
								
								String userReturnDate = userReturnDay + "/" + userReturnMonth + "/" + userReturnYear;
								userFlight.add(userReturnDate);
								
							} else {
								
								JOptionPane.showMessageDialog(title, "Please, enter a return date that "
										+ "is after a departure date.");
								
							}
							
							
						} else {
							
							JOptionPane.showMessageDialog(title, "Please, enter a return date that "
									+ "has not passed yet.");
							
						}
						
					} else {
						
						JOptionPane.showMessageDialog(title, "There is no such return date in the Database. "
								+ "Please, try another one.");
						
					}
					
					
				} else {
					
					if (userReturnDay.length() == 0
							|| userReturnMonth.length() == 0
							|| userReturnYear.length() == 0) {
						
						JOptionPane.showMessageDialog(title, "Please, enter a whole return date.");
						
					} else if (!userReturnDay.matches("[0-9]+")
						|| !userReturnMonth.matches("[a-zA-Z]+")
						|| !userReturnYear.matches("[0-9]+")) {
						
						JOptionPane.showMessageDialog(title, "Please, use letters when entering months, and " 
								+ "use numbers when entering days and years.");
						
					}
					
				}
				
			}
			
			
			
			// Launching Found Flights Page (if all User Data is verified successfully and there are Found Flights)
			
			if (userFlight.size() == 4
					|| (userFlight.size() == 3 && returnDate.getForeground() != Color.WHITE)) {
				
				foundFlights = flights.filterFlights(userFlight);
				
				if (foundFlights.size() != 0) {
					
					setVisible(false);
					FoundFlights ffpage = new FoundFlights(userFlight, foundFlights);
					
				} else {
					
					JOptionPane.showMessageDialog(title, "There are no such flights in the Database. "
							+ "Please, try to enter other data.");
					
				}
				
			}
			
		}
		
	}
	
}
