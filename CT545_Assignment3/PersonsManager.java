package assignment3;

import java.io.*;
import java.util.*;

public class PersonsManager {

	static List<PersonRecord> list = new ArrayList<PersonRecord>();

	class PersonRecord {

		private String foreName;
		private String surName;
		private String street;
		private String houseNumber;
		private String city;
		private String emailAddress;

		// Constructor
		public PersonRecord(String foreName, String surName, String street,
				String houseNumber, String city, String emailAddress) {
			super();
			this.foreName = foreName;
			this.surName = surName;
			this.street = street;
			this.houseNumber = houseNumber;
			this.city = city;
			this.emailAddress = emailAddress;
		}

		public String getForeName() {
			return foreName;
		}

		public void setForeName(String foreName) {
			this.foreName = foreName;
		}

		public String getSurName() {
			return surName;
		}

		public void setSurName(String surName) {
			this.surName = surName;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getHouseNumber() {
			return houseNumber;
		}

		public void setHouseNumber(String houseNumber) {
			this.houseNumber = houseNumber;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		public String toString() {
			return getForeName() + " " + getSurName() + " " + getHouseNumber()
					+ " " + getStreet() + " " + getCity() + " "
					+ getEmailAddress();
		}

	}

	public static void main(String[] inputFileName) throws Exception {
	
			
		SwingMenuBar b = new SwingMenuBar();
		b.setVisible(true);

       //b.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	// To display on the the list of persons on console
	public static void display() {

		// Enhanced for loop to print items in the list
		for (PersonRecord item : list)
			System.out.println(item);
	}

	/*
	 * Method to read the lines of CSV file and create a list of elements of
	 * type PersonRecord
	 */

	public static List<PersonRecord> readFromFile(File path) {
		
	
		String line = "";
		String cvsSplitBy = ",";
		try {

			BufferedReader br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) {
				// Error handling for empty lines in the csv file
				line.trim();
				if (line.isEmpty())
					continue;
				// Split lines using comma as separator so that empty attributes
				// can be handled here without errors
				String[] record = line.split(cvsSplitBy);
				// Inner class instantiation
				PersonsManager.PersonRecord d = new PersonsManager().new PersonRecord(
						record[0], record[1], record[2], record[3], record[4],
						record[5]);
				list.add(d);
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;

	}

}
