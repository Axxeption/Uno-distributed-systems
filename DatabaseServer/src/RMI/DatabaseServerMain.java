package RMI;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vulst
 */
public class DatabaseServerMain {

    private void startServer() {
        try {
            // create on port 1099
            Registry registry = LocateRegistry.createRegistry(1098);
            // create a new service named CounterService
            registry.rebind("DatabaseService", new SQLiteControllerImpl());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Databse is ready");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        DatabaseServerMain databaseservermain = new DatabaseServerMain();
        databaseservermain.startServer();
                
    }
    
}
