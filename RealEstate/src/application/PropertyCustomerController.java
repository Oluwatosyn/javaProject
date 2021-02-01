/**************************************************

Program: Real Estate Application

Filename: PropertyCustomerController.Java

@author: © Oluwatosin Olubanjo

Course:  MSc Computing

Module: Virtual Object Software

Tutor: Suraj Ajit

@version: 1.1

Date: 16/01/21
**************************************************/

package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;



public class PropertyCustomerController {

	@FXML
	private Button searchNewPropertyBtn;
	
	@FXML
	private Button buyOrRentDetailsBtn;
	
	@FXML
    private Button backToHomeBtn;
	
    @FXML
    private TextField propertyTypeField;
    
    @FXML
    private TextField noBedroomField;

    @FXML
    private TextField areaField;

    @FXML
    private TextField priceWeeklyField;
    
    @FXML
    private TextField priceMonthlyField;

    @FXML
    private TextField address1Field;

    @FXML
    private TextField address2Field;

    @FXML
    private TextField cityField;

    @FXML
    private TextField postCodeField;

    @FXML
    private DatePicker availableDatePicker;

    @FXML
    private TextField agentField;

    @FXML
    private DatePicker dateAdvertisedPicker;

    @FXML
    private TextField depositField;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private RadioButton avaiableRadioBtn;

    @FXML
    private RadioButton notAvaiableRadioBtn;
    
    @FXML
    private RadioButton rentRadioBtn;

    @FXML
    private RadioButton buyRadioBtn;
	
	@FXML 
	private TableView <Property> PropertyAdminTbl;
	
    @FXML
    private TableColumn<Property, Integer> propertyIDColumn;

    @FXML
    private TableColumn<Property,  String>  propertTypeColumn;

    @FXML
    private TableColumn<Property, String>  noOfBedroomColumn;

    @FXML
    private TableColumn<Property, String>  priceMonthlyColumn;

    @FXML
    private TableColumn<Property, String>  priceWeeklyColumn;

    @FXML
    private TableColumn<Property, String>  propertyAreaColumn;

    @FXML
    private TableColumn<Property, String>  addrs1Column;

    @FXML
    private TableColumn<Property, String>  addrs2Column;

    @FXML
    private TableColumn<Property, String>  cityColumn;

    @FXML
    private TableColumn<Property, String>  postCodeColumn;

    @FXML
    private TableColumn<Property, LocalDate>  avabDatepickerColumn;

    @FXML
    private TableColumn<Property, String>  agentColumn;

    @FXML
    private TableColumn<Property, String>  depositColumn;

    @FXML
    private TableColumn<Property, LocalDate>  dateAdvertColumn;

    @FXML
    private TableColumn<Property, String>  descriptionColumn;

    @FXML
    private TableColumn<Property, String>  hirStatusColumn;
   
    @FXML
    private TableColumn<Property, String> buyOrRentColumn;
    
    
    private String filename = "PropertyList.dat";
    
    private PropertyList propertyList;
    
    
    public void initialize() throws ClassNotFoundException, IOException
    {   	
    	propertyList = DataHandler.readPropertyList(filename); // read existing List
		Property.setPropertyCount(propertyList.getProperty().size());
		
        propertyIDColumn.setCellValueFactory(new PropertyValueFactory<Property, Integer>("propertyID"));
    	propertTypeColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("propertyType"));
    	noOfBedroomColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("noOfBedrooms"));
		priceMonthlyColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("monthlyRate"));
    	priceWeeklyColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("weeklyRate"));
    	propertyAreaColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("area"));
    	addrs1Column.setCellValueFactory(new PropertyValueFactory<Property, String>("addressLine1"));
    	addrs2Column.setCellValueFactory(new PropertyValueFactory<Property, String>("addressLine2"));
		cityColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("city"));
    	postCodeColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("postCode"));
		avabDatepickerColumn.setCellValueFactory(new PropertyValueFactory<Property, LocalDate>("availableDate"));
    	agentColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("agent"));
    	depositColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("deposit"));
		dateAdvertColumn.setCellValueFactory(new PropertyValueFactory<Property, LocalDate>("dateAdvertised"));
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("description"));
		hirStatusColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("hireStatus"));
		buyOrRentColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("buyOrRent"));
		
    	PropertyAdminTbl.setItems(getProperty());
    	        
        //This will allow the table to select multiple rows at once
        PropertyAdminTbl.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        //this.buyOrRentDetailsBtn.setDisable(true);
    }
    
    public void rowSelectedOnTable()
    {
    	this.buyOrRentDetailsBtn.setDisable(false);
    	
    	ObservableList<Property>  selectedRows;
        
        //Selected Rows
        selectedRows = PropertyAdminTbl.getSelectionModel().getSelectedItems();
        
        //loop over the selected rows and remove the Person objects from the table
        for (Property property: selectedRows)
        {
        	if(property.getBuyOrRent().equalsIgnoreCase("Rent"))
        	{
        		this.buyOrRentDetailsBtn.setText("Rent");
        	}
        	
        	else if(property.getBuyOrRent().equalsIgnoreCase("Buy"))
        	{
        		this.buyOrRentDetailsBtn.setText("Buy");
        	}
        }
    }
    
    public void backToHomeBtnListner(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
        
     //Add New Property Detail
    public void searchPropertyBtnListner(ActionEvent event) throws IOException, ClassNotFoundException
    {
    	String searchPropertyType = propertyTypeField.getText().toLowerCase();
    	Integer searchNoOfBedrooms = Integer.parseInt(noBedroomField.getText());
    	Double searchWeeklyRate = Double.parseDouble(priceWeeklyField.getText());
    	Double searchMonthlyRate = Double.parseDouble(priceMonthlyField.getText());
    	String searchPropertyArea = areaField.getText().toLowerCase();
    	String searchPostCode = postCodeField.getText().toLowerCase();
    	LocalDate searchDateAdvertised = dateAdvertisedPicker.getValue();
    	LocalDate searchAvailableDate = availableDatePicker.getValue();
    	String buyOrRentSearchOption = "";
    	
    	if (buyRadioBtn.isSelected())
    		buyOrRentSearchOption = "Buy";	
		if (rentRadioBtn.isSelected())
			buyOrRentSearchOption = "Rent";

    	PropertyAdminTbl.setItems(getFilteredProperty(searchPropertyType,  searchNoOfBedrooms, searchWeeklyRate, searchMonthlyRate, searchPropertyArea, searchPostCode, searchDateAdvertised, searchAvailableDate, buyOrRentSearchOption));	
    																	
    }		
    
    public void buyOrRentDetailsBtnListner(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SubmitLoginDetails.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
        
        //access the controller and call a method
        SubmitLoginDetailsController controller = loader.getController();
        controller.initData(PropertyAdminTbl.getSelectionModel().getSelectedItem());
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    public ObservableList<Property> getFilteredProperty(String searchPropertyType, Integer searchNoOfBedrooms, Double searchWeeklyRate, Double searchMonthlyRate, String searchPropertyArea, 
    		String searchPostCode, LocalDate searchDateAdvertised, LocalDate searchAvailableDate, String buyOrRentSearchOption) throws ClassNotFoundException, IOException
    {
    	boolean propertyMatch = false;
    	boolean weeklyRateMatch = false;
    	boolean monthlyRateMatch = false;
    	boolean rateMatch = false;
    	boolean dateMatch = false;
    	boolean noOfBedsmatch = false;
    	
    	//JavFX Observable List
    	ObservableList<Property> propertyObsList = FXCollections.observableArrayList();
    	
    	propertyList = DataHandler.readPropertyList(filename); 
   
    		// display list
    	
    		if (propertyList.getProperty().size() > 0) {
    		System.out.println("Property in the list are: ");
    		for (int i = 0; i < propertyList.getProperty().size(); i++) {
    			int propertyID = propertyList.getProperty().get(i).getPropertyID();
    			String propertyType = propertyList.getProperty().get(i).getPropertyType().toLowerCase();
    			String area  = propertyList.getProperty().get(i).getArea().toLowerCase();
    			Integer noOfBedrooms = propertyList.getProperty().get(i).getNoOfBedrooms();
    			Double weeklyRate = propertyList.getProperty().get(i).getWeeklyRate();
    			
    			Double monthlyRate = propertyList.getProperty().get(i).getMonthlyRate();
    			String addressLine1 = propertyList.getProperty().get(i).getAddressLine1();
    			String addressLine2 = propertyList.getProperty().get(i).getAddressLine2();
    			String city = propertyList.getProperty().get(i).getCity();
    			String postCode = propertyList.getProperty().get(i).getPostCode().toLowerCase();
    			LocalDate dateAdvertised  = propertyList.getProperty().get(i).getDateAdvertised();
    			String agent = propertyList.getProperty().get(i).getAgent();
    			LocalDate availableDate  = propertyList.getProperty().get(i).getAvailableDate();
    			Double deposit = propertyList.getProperty().get(i).getDeposit();
    			String description = propertyList.getProperty().get(i).getDescription();
    			String hireStatus = propertyList.getProperty().get(i).getHireStatus();
    			String buyOrRent = propertyList.getProperty().get(i).getBuyOrRent();
    			
    			if((propertyType.contains(searchPropertyType) &&  area.contains(searchPropertyArea) &&  postCode.contains(searchPostCode))){
    				propertyMatch = true;
    			}
    					
    			if(searchWeeklyRate != 0.00)
    			{
    				if (searchWeeklyRate  <= weeklyRate)
    					weeklyRateMatch = true;
    			}
    		
    			if(searchMonthlyRate != 0.00) {
    				if(searchMonthlyRate <= monthlyRate )
    					monthlyRateMatch = true;
    			}
    			
    			if(monthlyRateMatch || weeklyRateMatch) {
    				rateMatch = true;
    			}

    			if((searchDateAdvertised.compareTo(dateAdvertised) >= 0) && (searchAvailableDate.compareTo(availableDate) >= 0) )
    				dateMatch = true;

    		   if (noOfBedrooms == searchNoOfBedrooms) 
    			   noOfBedsmatch = true;
    			
    		   //System.out.println( buyOrRent +"\n"+buyOrRentSearchOption +"\n"+rateMatch +"\n"+propertyMatch);
    			if (propertyMatch && rateMatch && dateMatch && noOfBedsmatch && buyOrRent.equalsIgnoreCase(buyOrRentSearchOption)) { 
    				propertyObsList.add(new Property(propertyType, area, noOfBedrooms, weeklyRate, monthlyRate, addressLine1, addressLine2, city, postCode, dateAdvertised, agent, availableDate, deposit, description, hireStatus, buyOrRent));
    			}
			}
		}
       
    	return propertyObsList;
	}
    
    /***
     * Reference: httpGitHub
     * Initail Table view Binding
     * v1.1: Refactored to match Custom Table View ColumnsString fname
     */
    public ObservableList<Property> getProperty() throws ClassNotFoundException, IOException
    {
    	
    	//JavFX Observable List
    	ObservableList<Property> propertyObsList = FXCollections.observableArrayList();
    	
    	propertyList = DataHandler.readPropertyList(filename); 
    	
    	// display list
    	if (propertyList.getProperty().size() > 0) {
    		System.out.println("Property in the list are: ");
    		for (int i = 0; i < propertyList.getProperty().size(); i++) {
    			int propertyID = propertyList.getProperty().get(i).getPropertyID();
    			String propertyType = propertyList.getProperty().get(i).getPropertyType();
    			String area  = propertyList.getProperty().get(i).getArea();
    			Integer noOfBedrooms = propertyList.getProperty().get(i).getNoOfBedrooms();
    			Double weeklyRate = propertyList.getProperty().get(i).getWeeklyRate();
    			Double monthlyRate = propertyList.getProperty().get(i).getMonthlyRate();
    			String addressLine1 = propertyList.getProperty().get(i).getAddressLine1();
    			String addressLine2 = propertyList.getProperty().get(i).getAddressLine2();
    			String city = propertyList.getProperty().get(i).getCity();
    			String postCode = propertyList.getProperty().get(i).getPostCode();
    			LocalDate dateAdvertised  = propertyList.getProperty().get(i).getDateAdvertised();
    			String agent = propertyList.getProperty().get(i).getAgent();
    			LocalDate availableDate  = propertyList.getProperty().get(i).getAvailableDate();
    			Double deposit = propertyList.getProperty().get(i).getDeposit();
    			String description = propertyList.getProperty().get(i).getDescription();
    			String hireStatus = propertyList.getProperty().get(i).getHireStatus();
    			String buyOrRent = propertyList.getProperty().get(i).getBuyOrRent();
    			
    			propertyObsList.add(new Property(propertyType, area, noOfBedrooms, weeklyRate, monthlyRate, addressLine1, addressLine2, city, postCode, dateAdvertised, agent, availableDate, deposit, description, hireStatus, buyOrRent));
			}
		}
    	
    	return propertyObsList;
	}
}