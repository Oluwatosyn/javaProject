/**************************************************

Program: Real Estate Application

Filename: PropertyList.Java

@author: © Oluwatosin Olubanjo

Course:  MSc Computing

Module: Virtual Object Software

Tutor: Suraj Ajit

@version: 1.1

Date: 16/01/21
**************************************************/
package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PropertyList implements Serializable  {
	
private static final long serialVersionUID = 1L;
	
	private List<Property> propertyList;

	public PropertyList() {
		propertyList = new ArrayList<Property>();
	}

	public List<Property> getProperty() {
		return propertyList;
	}

	public void addProperty(Property p) {
		propertyList.add(p);
	}
	
	public void setPropertyList(List<Property> propertyList) {
		this.propertyList = propertyList;
	}
	

}
