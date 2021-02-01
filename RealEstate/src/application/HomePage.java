/**************************************************

Program: Real Estate Application

Filename: HomePage.Java

@author: © Oluwatosin Olubanjo

Course:  MSc Computing

Module: Virtual Object Software

Tutor: Suraj Ajit

@version: 1.1

Date: 16/01/21
**************************************************/
package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomePage extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		  // Load the FXML file.
	      Parent parent = FXMLLoader.load(
	               getClass().getResource("HomePage.fxml")); 
	      
	      // Build the scene graph.
	      Scene scene = new Scene(parent); 
	      
	      // Display our window, using the scene graph.
	      stage.setTitle("Home Page"); 
	      stage.setScene(scene);
	      stage.show(); 

	}
	
	
}
