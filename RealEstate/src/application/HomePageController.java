/**************************************************

Program: Real Estate Application

Filename: HomePageController.Java

@author: © Oluwatosin Olubanjo

Course:  MSc Computing

Module: Virtual Object Software

Tutor: Suraj Ajit

@version: 1.1

Date: 16/01/21
**************************************************/
package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomePageController {
	

    @FXML
    private AnchorPane achorID;
    
    @FXML
    private Button searchPropertyBtn;
    
    @FXML
    private Button adminPropertyListBtn;
    
    @FXML
    private Button adminInvoiceDetailsBtn;
    
    @FXML
    private Button adminCustomerListBtn;
    
    @FXML
    private Button adminUserDetailsBtn;
    
    private String adminOptionClicked;
  
    
    
    public void searchPropertyBtnListener(ActionEvent e) throws IOException {
    	Parent parent = FXMLLoader.load(
	               getClass().getResource("PropertyCustomerView.fxml")); 
	      
	      // Build the scene graph.
	      Scene scene = new Scene(parent); 
	
	      Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
	      // Display our window, using the scene graph.
	      stage.setTitle("Search Property Listings"); 
	      stage.setScene(scene);
	      stage.show(); 
    }
    
    public void adminCustomerListBtnListener(ActionEvent event) throws IOException {
    	adminOptionClicked = "Admin-CustomerList";
  	  
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AdminLogin.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
        
        //access the controller and call a method
        AdminLoginController controller = loader.getController();
        controller.initData(adminOptionClicked);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show(); 
       
    }
    
    public void adminPropertyDetailsBtnListener(ActionEvent event) throws IOException {
    	adminOptionClicked = "Admin-PropertyDetails";
    	  
    	 FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("AdminLogin.fxml"));
         Parent tableViewParent = loader.load();
         
         Scene tableViewScene = new Scene(tableViewParent);
         
         //access the controller and call a method
         AdminLoginController controller = loader.getController();
         controller.initData(adminOptionClicked);
         
         //This line gets the Stage information
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
         
         window.setScene(tableViewScene);
         window.show(); 
      }

    public void adminInvoiceDetailsBtnListener(ActionEvent event) throws IOException {
    	adminOptionClicked = "Admin-InvoiceList";
    	  
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AdminLogin.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
        
        //access the controller and call a method
        AdminLoginController controller = loader.getController();
        controller.initData(adminOptionClicked);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();             
    }     
    
   /* public void adminUserDetailsBtnListner(ActionEvent e) throws IOException {
    	Parent parent = FXMLLoader.load(
    			getClass().getResource("AdminUserRegistration.fxml")); 
	      
	      // Build the scene graph.
	      Scene scene = new Scene(parent); 
	
	      Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
	      // Display our window, using the scene graph.
	      stage.setTitle("Admin - User Registration Page"); 
	      stage.setScene(scene);
	      stage.show(); 	            
    }  */  
    
     public void adminUserDetailsBtnListner(ActionEvent event) throws IOException {
	adminOptionClicked = "Admin-UserDetails";
	  
	FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("AdminLogin.fxml"));
    Parent tableViewParent = loader.load();
    
    Scene tableViewScene = new Scene(tableViewParent);
    
    //access the controller and call a method
    AdminLoginController controller = loader.getController();
    controller.initData(adminOptionClicked);
    
    //This line gets the Stage information
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    
    window.setScene(tableViewScene);
    window.show();             
}  
}
