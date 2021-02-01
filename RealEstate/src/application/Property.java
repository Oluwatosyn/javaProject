/**************************************************

Program: Real Estate Application

Filename: Property.Java

@author: © Oluwatosin Olubanjo

Course:  MSc Computing

Module: Virtual Object Software

Tutor: Suraj Ajit

@version: 1.1

Date: 16/01/21
**************************************************/
package application;

import java.io.Serializable;
import java.time.LocalDate;



public class Property implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String propertyType;
	private String area;
	private int noOfBedrooms;
	private double weeklyRate;
	private double monthlyRate;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String postCode;
	private LocalDate dateAdvertised;
	private String agent;
	private LocalDate availableDate;
	private double deposit;
	private String description;
	private String hireStatus;
	private int propertyID;
	private String buyOrRent;
	private static int propertyCount = 0;
	
	public Property() {
		this.propertyType = "";
		this.area =  "";
		this.noOfBedrooms = 0;
		this.weeklyRate = 0;
		this.monthlyRate = 0;
		this.addressLine1 = "";
		this.addressLine2 = "";
		this.city = "";
		this.postCode = "";
		this.dateAdvertised= null;
		this.agent = "";
		this.availableDate= null;
		this.deposit = 0;
		this.description = "";
		this.propertyType = "";
		this.hireStatus =  "";
		this.buyOrRent = "";
		this.propertyID = propertyCount++;
	}
	
	
	public Property(String propertyType, String area,int noOfBedrooms, double weeklyRate, double monthlyRate, String addressLine1, String addressLine2, String city, String postCode, LocalDate dateAdvertised,
			String agent, LocalDate availableDate, double deposit, String description, String hireStatus, String buyOrRent) {
		this.propertyType = propertyType;
		this.area = area;
		this.noOfBedrooms = noOfBedrooms;
		this.weeklyRate = weeklyRate;
		this.monthlyRate = monthlyRate;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.postCode = postCode;
		this.dateAdvertised= dateAdvertised;
		this.agent = agent;
		this.availableDate= availableDate;
		this.deposit= deposit;
		this.description = description;
		this.hireStatus = hireStatus;
		this.buyOrRent = buyOrRent;
		this.propertyID = propertyCount++;
	}

	
	public int getPropertyID() {
		return propertyID;
	}
	

	public void setPropertyID(int propertyID) {
		this.propertyID = propertyID;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getNoOfBedrooms() {
		return noOfBedrooms;
	}
	
	public void setNoOfBedrooms(int noOfBedrooms) {
		this.noOfBedrooms = noOfBedrooms;
	}

	public double getWeeklyRate() {
		return weeklyRate;
	}

	public void setWeeklyRate(double weeklyRate) {
		this.weeklyRate = weeklyRate;
	}

	public double getMonthlyRate() {
		return monthlyRate;
	}

	public void setMonthlyRate(double monthlyRate) {
		this.monthlyRate = monthlyRate;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public LocalDate getDateAdvertised() {
		return dateAdvertised;
	}

	public void setDateAdvertised(LocalDate dateAdvertised) {
		this.dateAdvertised = dateAdvertised;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public LocalDate getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(LocalDate availableDate) {
		this.availableDate = availableDate;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHireStatus() {
		return hireStatus;
	}

	public void setHireStatus(String hireStatus) {
		this.hireStatus = hireStatus;
	}

	public int getId() {
		return propertyID;
	}

	public void setId(int id) {
		this.propertyID = id;
	}

	public String getBuyOrRent() {
		return buyOrRent;
	}


	public void setBuyOrRent(String buyOrRent) {
		this.buyOrRent = buyOrRent;
	}


	public static int getPropertyCount() {
		return propertyCount;
	}

	public static void setPropertyCount(int propertyCount) {
		Property.propertyCount = propertyCount;
	}

	
	@Override
	public String toString() {
		return "Property [propertyType=" + propertyType + ", area=" + area + ", noOfBedrooms=" + noOfBedrooms + ", weeklyRate="
				+ weeklyRate + ", monthlyRate=" + monthlyRate + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", postCode=" + postCode + ", dateAdvertised=" + dateAdvertised
				+ ", agent=" + agent + ", availableDate=" + availableDate + ", deposit=" + deposit + ", description="
				+ description + ", hireStatus=" + hireStatus + ", propertyID=" + propertyID + "]";
	}

	
}
