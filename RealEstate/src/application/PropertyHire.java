/**************************************************

Program: Real Estate Application

Filename: PropertyHire.Java

@author: © Oluwatosin Olubanjo

Course:  MSc Computing

Module: Virtual Object Software

Tutor: Suraj Ajit

@version: 1.1

Date: 16/01/21
**************************************************/
package application;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/*
 * creates a hire transaction
 */
public class PropertyHire implements Serializable {

	private static final long serialVersionUID = 1L;
	private Property property;
	private Customer customer;
	private LocalDate startdate;
	private LocalDate returndate;
	private int hireId;
	
	private static int hireCount = 0;
	
	public PropertyHire (Property property, Customer customer,LocalDate startdate, LocalDate returndate) {
		this.property= property;
		this.customer = customer;
		this.startdate = startdate;
		this.returndate = returndate;
		hireId = hireCount++;
	}

	public Property getProperty() {
		return property;
	}



	public void setProperty(Property property) {
		this.property = property;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public LocalDate getStartdate() {
		return startdate;
	}



	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}



	public LocalDate getReturndate() {
		return returndate;
	}



	public void setReturndate(LocalDate returndate) {
		this.returndate = returndate;
	}



	public int getHireId() {
		return hireId;
	}



	public void setHireId(int hireId) {
		this.hireId = hireId;
	}



	public static int getHireCount() {
		return hireCount;
	}



	public static void setHireCount(int hireCount) {
		PropertyHire.hireCount = hireCount;
	}
	
	@Override
	public String toString() {
		return "PropertyHire [property=" + property+ ", customer=" + customer + ", startdate=" + startdate + ", returndate="
				+ returndate + ", hireId=" + hireId + "]";
	}

	public String printInvoice() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		String str = "     HIRE INVOICE     \n";
		System.out.println("     HIRE INVOICE     ");
		str += "Hire Id: "+hireId +"\n";
		System.out.println("Hire Id: "+hireId);
		str += "Date: "+formatter.format(startdate) +"\n";
		System.out.println("Date: "+formatter.format(startdate));
		str += "Book Hired: "+ "\n";
		System.out.println("Book Hired: ");
		str += property.getPropertyType() + "\n";
		System.out.println(property.getPropertyType());
		str += property.getArea() + "\n";
		System.out.println(property.getArea());
		str += property.getCity() + "\n";
		System.out.println(property.getCity());
		str += property.getPostCode() + "\n";
		System.out.println(property.getPostCode());
		str += property.getNoOfBedrooms() + "\n";
		System.out.println(property.getNoOfBedrooms());
		str += "Due date: "+ formatter.format(returndate) + "\n";
		System.out.println("Due date: "+formatter.format(returndate));
		long diffInWeeks = ChronoUnit.WEEKS.between(startdate, returndate);
	    str += "Total number of weeks: "+ diffInWeeks + "\n";
		System.out.println("Total number of weeks: "+ diffInWeeks);
		double hireAmountDue = diffInWeeks * property.getWeeklyRate();
		str += "Cost of Hire: £"+ hireAmountDue + "\n";
		System.out.println("Cost of Hire: £"+ hireAmountDue);
		str += "Deposit: £"+ property.getDeposit() + "\n";
		System.out.println("Deposit: £"+ property.getDeposit());
		DecimalFormat format = new DecimalFormat("0.00");
		str +=  "Total amount to pay: £"+ format.format((property.getDeposit() + hireAmountDue)) + "\n";
		System.out.println("Total amount to pay: £"+ format.format((property.getDeposit() + hireAmountDue)));
		return str;
	}
	
	public double getTotalPayment() {
		long diffInWeeks = ChronoUnit.WEEKS.between(startdate, returndate);
		double hireAmountDue = diffInWeeks * property.getWeeklyRate();
		DecimalFormat format = new DecimalFormat("0.00");
		return Double.parseDouble(format.format((property.getDeposit() + hireAmountDue)));	
	}



}
