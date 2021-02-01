/**************************************************

Program: Real Estate Application

Filename: AdminLoginController.Java

@author: © Oluwatosin Olubanjo

Course:  MSc Computing

Module: Virtual Object Software

Tutor: Suraj Ajit

@version: 1.1

Date: 16/01/21
**************************************************/

/**************************************************

Program: Java Graphics Screen Application

Filename: GraphicsJFrame.java

@author: ©  Suraj Ajit 

Course: MSc Computing

Module: Virtual Object Software

Tutor: Suraj Ajit

@version: 1.1

Modification History:
v1.01 Added centreWindow method


Date: 16/01/21

**************************************************/
/**************************************************

Program: Real Estate Application

Filename: AdminLoginController.Java

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
import javafx.scene.control.Alert;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;



public class PropertyAdminController {

	@FXML
    private Button submitNewPropertyBtn;
	
	@FXML
    private Button backToHomeBtn;
	
	@FXML
    private Button deletePropertyBtn;
	
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
    

	@FXML private TableView <Property> PropertyAdminTbl;
	
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
    
    private PropertyList newPropertyList;
    
    private AdminUser validAdminUser;
    
   	public void initData(AdminUser adminUser)
    {
   		validAdminUser = adminUser;
    }
    
    public void initialize() throws ClassNotFoundException, IOException
    {
    	//propertyChoiceBox.getItems().addAll("Detached","SemiDetached");
       // propertyChoiceBox.setValue("Detached");
    	    	
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
		
        
    }
    
    public void backToHomeBtnListner(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
     //Remove Selected rows on Delete 
    public void deletePropertyBtnListner() throws IOException
    {
        ObservableList<Property>  selectedRows, allProperty;
        allProperty = PropertyAdminTbl.getItems();
        
        //Selected Rows
        selectedRows = PropertyAdminTbl.getSelectionModel().getSelectedItems();
        
        //loop over the selected rows and remove the Person objects from the table
        for (Property property: selectedRows)
        {
        	allProperty.remove(property);
        }
        
        // Create a new Array List of Type Property
        newPropertyList = new PropertyList();
        
        // Populate the PropertyList Array by looping through the observable list
        for (int i =0; i<allProperty.size(); i++){
            newPropertyList.addProperty(allProperty.get(i));
        }

        DataHandler.writePropertyToFile(newPropertyList, filename);
    }
    
    
     //Add New Property Detail
    public void submitNewPropertyBtnListner() throws IOException
    {
    	//String propertyTypeValue= "";
		String avaiableOption = "";
		String buyOrRentOption = "";
			
		if (avaiableRadioBtn.isSelected())
			avaiableOption = "Available";	
		if (notAvaiableRadioBtn.isSelected())
			avaiableOption = "Not Available";
		
		if (buyRadioBtn.isSelected())
			buyOrRentOption = "Buy";	
		if (rentRadioBtn.isSelected())
			buyOrRentOption = "Rent";
		
		Property newProperty = new Property(); 
		newProperty.setPropertyType(propertyTypeField.getText());
		newProperty.setNoOfBedrooms(Integer.parseInt(noBedroomField.getText()));
		
		Double weeklyRate = Double.parseDouble(priceWeeklyField.getText());
		newProperty.setWeeklyRate(weeklyRate);
		
		Double monthlyRate =Double.parseDouble(priceMonthlyField.getText());
		newProperty.setMonthlyRate(monthlyRate);
		
		newProperty.setAddressLine1(address1Field.getText());
		newProperty.setAddressLine2(address2Field.getText());
		newProperty.setArea(areaField.getText());
		newProperty.setCity(cityField.getText());
		newProperty.setPostCode(postCodeField.getText());
		newProperty.setDateAdvertised(dateAdvertisedPicker.getValue());
		newProperty.setAgent(agentField.getText());
		newProperty.setAvailableDate(availableDatePicker.getValue());
		
		Double deposit = Double.parseDouble(depositField.getText());
		newProperty.setDeposit(deposit);
		
		newProperty.setDescription(descriptionArea.getText());
		newProperty.setHireStatus(avaiableOption);
		newProperty.setBuyOrRent(buyOrRentOption);
		
		//Deposit Rule - applies to to Rental Property
		if(buyOrRentOption.equalsIgnoreCase("Rent")) {
			if(deposit < (monthlyRate *3)) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Incorrect Deposit amount");
					alert.setHeaderText("");
					alert.setContentText("Deposit should be three time monthly rent");
					
					alert.showAndWait();
			}else {
				//Retrieve the Property List & add new Property Details
		        PropertyAdminTbl.getItems().add(newProperty);
		              
		        propertyList.addProperty(newProperty);
		      				
		      	DataHandler.writePropertyToFile(propertyList, filename);
			}
		}
		
		if(buyOrRentOption.equalsIgnoreCase("Buy")) {
			//Retrieve the Property List & add new Property Details
		
			PropertyAdminTbl.getItems().add(newProperty);
              
			propertyList.addProperty(newProperty);
      				
			DataHandler.writePropertyToFile(propertyList, filename);
		
		}
        
    }
    
    public ObservableList<Property> getProperty() throws ClassNotFoundException, IOException
    {
    	//JavFX Observable List
    	ObservableList<Property> propertyObsList = FXCollections.observableArrayList();
    	
    	propertyList = DataHandler.readPropertyList(filename); 
    	
    	// display list
    	if (propertyList.getProperty().size() > 0) {
    		System.out.println("Property in the list are: ");
    		for (int i = 0; i < propertyList.getProperty().size(); i++) {
    			int PropertyID = propertyList.getProperty().get(i).getPropertyID();
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