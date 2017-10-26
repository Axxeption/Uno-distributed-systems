/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author vulst
 */
public class UNO_UIController implements Initializable {

    ClientApplicationBackend clientapplicationbackend;
    Registry myRegistry;

    @FXML
    private Label label;

       @FXML
    private Label outputLabel;

    @FXML
    private TextField input_username;

    @FXML
    private TextField input_password;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void login(ActionEvent event) {
        try {
            connect();
            if (clientapplicationbackend.login(input_username.getText(), input_password.getText())) {
            outputLabel.setText("Succesfully logged in.");
        } else {
            outputLabel.setText("Wrong username or pass, try again!");
        }
        } catch (RemoteException ex) {
            System.out.println(ex);
        }

    }

    public void register(ActionEvent event) {
        try {
            connect();
             if(clientapplicationbackend.register(input_username.getText(), input_password.getText())){
            outputLabel.setText("Succesfully account created!");
        }
        else{
            outputLabel.setText("Sorry, something went wrong.");
        }
            
        } catch (RemoteException ex) {
            Logger.getLogger(UNO_UIController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void connect() {
        try {
            this.myRegistry = LocateRegistry.getRegistry("localhost", 1099);
            this.clientapplicationbackend = (ClientApplicationBackend) myRegistry.lookup("ClientApplicationService");
            System.out.println("TEST" + clientapplicationbackend);
        } catch (Exception e) {
            System.out.println("Error is: " + e);
        }
    }

}
